/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import modal.STUDENT;
import DatabaseHelper.DatabaseHalper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import messageHelper.MessageDialogHelper;

/**
 *
 * @author dangd
 */
public class STUDENTDAO {

    private List<STUDENT> list = new ArrayList<>();

    public List<STUDENT> FindByAll() {
        String sql = "SELECT * FROM STUDENT";
        try ( Connection conn = DatabaseHalper.openConnection();  PreparedStatement pstmt = conn.prepareStatement(sql);) {
            ResultSet rs = pstmt.executeQuery();
            list.clear();
            while (rs.next()) {
                STUDENT student = createStudent(rs);
                list.add(student);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public STUDENT FindByID(String CodeId) {
        String sql = "SELECT * FROM STUDENT WHERE [CodeStudent] = ?";
        try ( Connection conn = DatabaseHalper.openConnection();  PreparedStatement pstmt = conn.prepareStatement(sql);) {

            pstmt.setString(1, CodeId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                STUDENT student = createStudent(rs);
                return student;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private STUDENT createStudent(ResultSet rs) throws SQLException {
        STUDENT student = new STUDENT();
        student.setCodeStuden(rs.getString("CodeStudent"));
        student.setFullname(rs.getString("Fullname"));
        student.setEmail(rs.getString("Email"));
        student.setPhoneNumber(rs.getString("PhoneNumber"));
        student.setGender(rs.getString("Gender"));
        student.setAddress(rs.getString("Address"));
        student.setImages(rs.getString("Images"));
        return student;
    }

    public STUDENT Insert(STUDENT student) throws Exception{
        String sql = "INSERT INTO STUDENT(CodeStudent, Fullname, Email, PhoneNumber, Gender, Address, Images)"
                + "VALUES (?,?,?,?,?,?,?)";
        try ( Connection conn = DatabaseHalper.openConnection();  PreparedStatement pstmt = conn.prepareStatement(sql);) {

            pstmt.setString(1, student.getCodeStuden());
            pstmt.setString(2, student.getFullname());
            pstmt.setString(3, student.getEmail());
            pstmt.setString(4, student.getPhoneNumber());
            pstmt.setString(5, student.getGender());
            pstmt.setString(6, student.getAddress());
            pstmt.setString(7, student.getImages());
            int kq = pstmt.executeUpdate();
            list.add(student);
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }

    public int Update(STUDENT student) throws Exception{
        String sql = "UPDATE dbo.STUDENT SET [Fullname] = ?, [Email] = ?, [PhoneNumber] = ?, [Gender] = ?, [Address] = ?, [Images] = ? "
                + "WHERE [CodeStudent] = ?";

        try ( Connection conn = DatabaseHalper.openConnection();  PreparedStatement pstmt = conn.prepareStatement(sql);) {

            pstmt.setString(7, student.getCodeStuden());
            pstmt.setString(1, student.getFullname());
            pstmt.setString(2, student.getEmail());
            pstmt.setString(3, student.getPhoneNumber());
            pstmt.setString(4, student.getGender());
            pstmt.setString(5, student.getAddress());
            pstmt.setString(6, student.getImages());
            int kq = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int Delete(String codeID) throws Exception {
        String sql = "EXEC dbo.Delete_SV_GR @codeStudent = ?";

        Connection conn = DatabaseHalper.openConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, codeID);
        int kq = pstmt.executeUpdate();
        conn.close();

        return 0;
    }
}
