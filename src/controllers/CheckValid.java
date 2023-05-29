/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import models.Nurses;

/**
 *
 * @author NguyenDuy
 */
public class CheckValid {

    public void checkID(String id) throws Exception {
        NursesManager xxx = (NursesManager) new NursesManager().searchNursesId(id);
        if (xxx == null) {

        } else {
            throw new Exception("Duplicated id.Try with another one");
        }
    }
    public void checkIDPatient(String id) throws Exception {
        PatientsManager xxx = (PatientsManager) new PatientsManager().searchPatientID(id);
        if (xxx == null) {

        } else {
            throw new Exception("Duplicated id.Try with another one");
        }
    }

    public void checkValidPhone(String phone) throws Exception {
        if (phone.length() >= 5 && phone.length() <= 10 && phone.matches("\\d++")) {

        } else {
            throw new Exception("Invalid phone number!");
        }
    }

    public void checkDepartment(String department) throws Exception {
        if (department.length() >= 3 && department.length() <= 50) {

        } else {
            throw new Exception("The length of the department field must be from 3 to 50 characters!");
        }
    }

    public boolean checkIDB(String id) {
        NursesManager xxx = new NursesManager();
        xxx.addNursesFromFile("nurses.txt");
//        Nurses yyy = xxx.searchNursesId(id);
        if (!xxx.hm.containsKey(id)) {
            return true;
        } else {
            System.out.println("Duplicated id.Try with another one");
            return false;
        }
    }
    public boolean checkIDPatientB(String id) {
        PatientsManager xxx = new PatientsManager();
        xxx.addPatientsFromFile("patients.txt");
//        Nurses yyy = xxx.searchNursesId(id);
        if (!xxx.hm.containsKey(id)) {
            return true;
        } else {
            System.out.println("Duplicated id.Try with another one");
            return false;
        }
    }

    public boolean checkValidPhoneB(String phone) {
        if (phone.length() >= 5 && phone.length() <= 10 && phone.matches("\\d++")) {
            return true;
        } else {
            System.out.println("Invalid phone number!");
            return false;
        }
    }

    public boolean checkDepartmentB(String department) {
        if (department.length() >= 3 && department.length() <= 50) {
            return true;
        } else {
            System.out.println("The length of the department field must be from 3 to 50 characters!");
            return false;
        }
    }

    public boolean checkDateB(String shift) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        try {
            LocalDate date = LocalDate.parse(shift, formatter);
            return true;
        } catch (DateTimeParseException e) {
            System.out.println("Wrong format! Try again.");
            return false;
        }
    }
//    public boolean checkAgeB(int age){
//        if(age)
//    }

}
