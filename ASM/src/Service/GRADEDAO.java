/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Class.GRADE;
import DatabaseHelper.DatabaseHalper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dangd
 */
public class GRADEDAO {

    private List<GRADE> list = new ArrayList<>();

    public List<GRADE> FinTop(int top) {
        String sql = "SELECT DISTINCT TOP " + top + " *, (English + Informationtics + GDTC)/3 "
                + "AS DiemTB FROM dbo.GRADE ORDER BY DiemTB DESC";

        try ( Connection conn = DatabaseHalper.openConnection();  PreparedStatement pstmt = conn.prepareStatement(sql);) {
            ResultSet rs = pstmt.executeQuery();
            list.clear();
            while (rs.next()) {
                GRADE gr = createGRADE(rs);
                list.add(gr);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public GRADE FindID(String CodeId) {
        String sql = "SELECT * FROM dbo.GRADE WHERE [CodeStudent] = ?";

        try ( Connection conn = DatabaseHalper.openConnection();  PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, CodeId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                GRADE gr = createGRADE(rs);
                return gr;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private GRADE createGRADE(ResultSet rs) throws SQLException {
        GRADE gr = new GRADE();
        gr.setCodeStudent(rs.getString("CodeStudent"));
        gr.setFullName(rs.getString("Fullname"));
        gr.setEnglish(rs.getFloat("English"));
        gr.setInformationtics(rs.getFloat("Informationtics"));
        gr.setGDTC(rs.getFloat("GDTC"));
        gr.setAvg(rs.getFloat("DTB"));
        return gr;
    }

    public GRADE Insert(GRADE grade) {
        String sql = "INSERT dbo.GRADE( CodeStudent, Fullname , English, Informationtics, GDTC, DTB)"
                + "VALUES(?,?,?,?,?,?)";
        try ( Connection conn = DatabaseHalper.openConnection();  PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, grade.getCodeStudent());
            pstmt.setString(2, grade.getFullName());
            pstmt.setFloat(3, grade.getEnglish());
            pstmt.setFloat(4, grade.getInformationtics());
            pstmt.setFloat(5, grade.getGDTC());
            pstmt.setFloat(6, grade.getAvg());
            list.add(grade);
            int kq = pstmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return grade;
    }

    public int Update(GRADE grade) {
        String sql = "UPDATE dbo.GRADE SET [English] = ?, [Informationtics] = ?, [GDTC] = ?, [DTB] = ? "
                + "WHERE [CodeStudent] = ?";

        try ( Connection conn = DatabaseHalper.openConnection();  PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(5, grade.getCodeStudent());
            pstmt.setFloat(1, grade.getEnglish());
            pstmt.setFloat(2, grade.getInformationtics());
            pstmt.setFloat(3, grade.getGDTC());
            pstmt.setFloat(4, grade.getAvg());

            int kq = pstmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int Delete(String codeID) {
        String sql = "DELETE FROM dbo.GRADE WHERE [CodeStudent] = ?";
        try ( Connection conn = DatabaseHalper.openConnection();  PreparedStatement pstmt = conn.prepareStatement(sql);) {

            pstmt.setString(1, codeID);
            int kq = pstmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
