/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validate;

/**
 *
 * @author dangd
 */
public class RegExType {
    public static String regexEmail(){
        return "\\w+(\\w{2,10})[ph|PH]\\d{5}\\@(\\w{0,5}\\.)+\\w{2,3}";
    }
    
    public static String regexPhoneNumber(){
        return "(84|0[3|5|7|8|9])+([0-9]{8})";
    }
}
