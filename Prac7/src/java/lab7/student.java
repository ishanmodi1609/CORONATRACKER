/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7;

import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author Neel
 */
public class student implements Serializable {
    
    private String name;
    private String rollno;
    private String branch;
    private int year;

    public String getBranch() {
        return branch;
    }

    public String getName() {
        return name;
    }

    public String getRollno() {
        return rollno;
    }

    public int getYear() {
        return year;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }

    public void setYear(int year) {
        this.year = year;
    }

    
    
}
