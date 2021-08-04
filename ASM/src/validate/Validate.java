/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validate;

import Service.STUDENTDAO;
import Service.GRADEDAO;
import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import Class.*;

/**
 *
 * @author dangd
 */
public class Validate {

    public static boolean checkEmty(JTextField txtField, StringBuilder sb, String messenger) {
        if (txtField.getText().isEmpty()) {
            sb.append(messenger).append("\n");
            txtField.setBorder(new LineBorder(Color.RED));
            return false;
        } else {
            txtField.setBorder(new LineBorder(Color.GREEN));
        }
        return true;
    }

    public static boolean checkPassword(JPasswordField pass, StringBuilder sb, String messenger) {
        try {
            if (pass.getText().isEmpty()) {
                sb.append(messenger).append("\n");
                pass.setBorder(new LineBorder(Color.RED));
                return false;
            } else {
                pass.setBorder(new LineBorder(Color.GREEN));
            }
        } catch (Exception e) {
        }
        return true;
    }

    public static boolean checkEmtylbl(JLabel lbl, StringBuilder sb, String messenger) {
        try {
            if (lbl.getText().isEmpty()) {
                sb.append(messenger).append("\n");
                lbl.setBorder(new LineBorder(Color.RED));
                return false;
            } else {
                lbl.setBorder(new LineBorder(Color.GREEN));
            }
        } catch (Exception e) {
        }
        return true;
    }

    public static boolean checkPoin(JTextField field, StringBuilder sb) {
        boolean check = true;
        if (!checkEmty(field, sb, "Điểm chưa nhập!!!")) {
            return false;
        }
        try {
            double poin = Double.parseDouble(field.getText());
            if (poin > 10 || poin < 0) {
                sb.append("Điểm không hợp lệ");
                field.setBorder(new LineBorder(Color.RED));
                check = false;
            }
        } catch (Exception e) {
            sb.append("Điểm không được nhập chữ!!!\n");
            field.setBorder(new LineBorder(Color.RED));
            check = false;
        }
        if (check == true) {
            field.setBorder(new LineBorder(Color.GREEN));
        }
        return check;
    }

    public static boolean checkEmail(JTextField field, StringBuilder sb) {
        boolean flag = true;
        if (!checkEmty(field, sb, "Email Chưa Nhập\n")) {
            return false;
        }
        Pattern pattern = Pattern.compile("\\w+@\\w+(\\.\\w+){1,2}");
        Matcher matcher = pattern.matcher(field.getText());
        if (!matcher.find()) {
            sb.append("Email không hợp lệ không hợp lệ\n");
            field.setBorder(new LineBorder(Color.RED));
            flag = false;
        }
        if (flag) {
            field.setBorder(new LineBorder(Color.GREEN));
        }
        return flag;
    }

    public static boolean checkPhoneNumber(JTextField field, StringBuilder sb) {
        Pattern pattern = Pattern.compile("^0\\d{9,10}");
        Matcher matcher = pattern.matcher(field.getText());
        boolean flag = true;
        if (!checkEmty(field, sb, "Số điện thoại Chưa Nhập\n")) {
            return false;
        } else if (!matcher.find()) {
            sb.append("Số điện thoại nhập không hợp lệ!!!");
            field.setBorder(new LineBorder(Color.RED));
            flag = false;
        }
        if (flag) {
            field.setBorder(new LineBorder(Color.GREEN));
        }
        return flag;
    }

    public static boolean checkTrungGrade(String codeID) {
        try {
            GRADEDAO gradedao = new GRADEDAO();
            GRADE grade = gradedao.FindID(codeID);
            if (grade.getCodeStudent().equalsIgnoreCase(codeID)) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean checkTrungStudent(String codeID) {
        try {
            STUDENTDAO studentdao = new STUDENTDAO();
            STUDENT student = studentdao.FindByID(codeID);
            if (student.getCodeStuden().equalsIgnoreCase(codeID)) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
