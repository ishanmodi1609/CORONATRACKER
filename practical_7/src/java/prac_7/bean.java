/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prac_7;

import java.beans.*;
import java.io.Serializable;
/**
 *
 * @author ISHAN
 */
public class bean implements Serializable {
    
    private String name;
    private String email;
    private String phone_no;
    private String age;

    public String Email() {
        return email;
    }

    public String Age() {
        return age;
    }

    public String Name() {
        return name;
    }

    public String Phone_no() {
        return phone_no;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public void setEmail(String Email) {
        this.email = Email;
    }

    public void setAge(String Age) {
        this.age = Age;
    }

    public void setPhone_no(String Phone_no) {
        this.phone_no = Phone_no;
    }
}

