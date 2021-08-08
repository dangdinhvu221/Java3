/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;

/**
 *
 * @author dangd
 */
public class STUDENT {

    private String codeStuden, Fullname, Email, PhoneNumber, Gender, Address, images;

    public STUDENT() {
    }

    public STUDENT(String codeStuden, String Fullname, String Email, String PhoneNumber, String Gender, String Address, String images) {
        this.codeStuden = codeStuden;
        this.Fullname = Fullname;
        this.Email = Email;
        this.PhoneNumber = PhoneNumber;
        this.Gender = Gender;
        this.Address = Address;
        this.images = images;
    }

    public String getCodeStuden() {
        return codeStuden;
    }

    public void setCodeStuden(String codeStuden) {
        this.codeStuden = codeStuden;
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String Fullname) {
        this.Fullname = Fullname;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    
}
