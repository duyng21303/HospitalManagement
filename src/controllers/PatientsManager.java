/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;
import models.Nurses;
import models.Patients;

/**
 *
 * @author NguyenDuy
 */
public class PatientsManager extends Patients {

    private Scanner sc = new Scanner(System.in);
    public HashMap<String, Patients> hm = new HashMap<>();

    public PatientsManager() {
    }

    public void findNurses() {

        System.out.println("Input patient id: ");
        String staffID = sc.nextLine().toUpperCase();
        if (!hm.containsKey(staffID)) {
            System.out.println("Can't find infomation about " + staffID);
        } else {
            hm.get(staffID).printPatient();
        }
    }

    public Patients searchPatientID(String patientID) {
        if (hm.isEmpty()) {
            return null;
        }
        if (hm.containsKey(patientID)) {
            return hm.get(patientID);
        }
        return null;
    }

    public void addPatientsFromFile(String fPatient) {
        try {
            File f = new File(fPatient);
            if (!f.exists()) {
                return;
            }
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            String details;
            while ((details = bf.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer(details, ",");
                String patientsID = stk.nextToken().toUpperCase();
                new CheckValid().checkID(patientsID);
                String name = stk.nextToken().toUpperCase();
                int age = Integer.parseInt(stk.nextToken());
                String gender = stk.nextToken().toUpperCase();
                String address = stk.nextToken().toUpperCase();
                String phone = stk.nextToken().toUpperCase();
                new CheckValid().checkValidPhone(phone);
                String diagnosis = stk.nextToken().toUpperCase();
//                new CheckValid().checkDepartment(department);
                String dateString = stk.nextToken();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                LocalDate admissionDate = LocalDate.parse(dateString, formatter);
                LocalDate dischargeDate = LocalDate.parse(dateString, formatter);
                String staffID = stk.nextToken().toUpperCase();
                NursesManager nm = new NursesManager();
                String nurseAssigned = nm.hm.get(staffID).getName();
                Patients emp = new Patients(patientsID, diagnosis, admissionDate, dischargeDate, nurseAssigned, name, age, gender, address, phone);

                hm.put(patientsID, emp);
            }
            bf.close();
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void addPatients() {
        String patientsID, name, gender, address, phone, diagnosis, staffID;
        int age = 01;
        DateTimeFormatter formatter;
        LocalDate admissionDate, dischargeDate;
        String dateString, dateString2;
        do {
            System.out.println("Input patients ID: ");
            patientsID = sc.nextLine().toUpperCase();
        } while (!new CheckValid().checkIDPatientB(patientsID));
        System.out.println("Input patients name: ");
        name = sc.nextLine().toUpperCase();
        System.out.println("Input diagnosis name: ");
        diagnosis = sc.nextLine().toUpperCase();
        boolean check = false;
        do {
            try {
                System.out.println("Input age: ");
                age = Integer.parseInt(sc.nextLine());
                if (age < 0 || age > 150) {
                    throw new Exception("Something wrong!");
                } else {
                    check = false;
                }
            } catch (Exception e) {
                System.out.println("Something wrong!");
                check = true;
            }
        } while (check);
        System.out.println("Input gender: ");
        gender = sc.nextLine().toUpperCase();
        System.out.println("Input address: ");
        address = sc.nextLine().toUpperCase();
        do {
            System.out.println("Input phone: ");
            phone = sc.nextLine();
        } while (!new CheckValid().checkValidPhoneB(phone));

        do {
            System.out.println("Input admissionDate(yyyy/MM/dd)");
            dateString = sc.nextLine();
        } while (!new CheckValid().checkDateB(dateString));
        do {
            System.out.println("Input dischargeDate(yyyy/MM/dd)");
            dateString2 = sc.nextLine();
        } while (!new CheckValid().checkDateB(dateString2));
        formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        admissionDate = LocalDate.parse(dateString, formatter);
        dischargeDate = LocalDate.parse(dateString2, formatter);
        do {
            System.out.println("Input nurses id: ");
            staffID = sc.nextLine().toUpperCase();
        } while (!new CheckValid().checkIDB(staffID));
        String nurseAssigned = null;
        nurseAssigned = new NursesManager().hm.get(staffID).getName();
        Patients emp = new Patients(patientsID, diagnosis, admissionDate, dischargeDate, nurseAssigned, name, age, gender, address, phone);

        hm.put(staffID, emp);
    }

    public void addPatientsToFile(String fPatients) {
        if (hm.size() == 0) {
            System.out.println("Empty list");
            return;
        }
        try {
            File f = new File(fPatients);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for (Patients x : hm.values()) {
                pw.println(x.getPatientsID() + "," + x.getName() + "," + x.getAge() + "," + x.getGender() + "," + x.getAddress() + "," + x.getPhone() + "," + x.getDiagnosis() + "," + x.getAdmissionDate().format(DateTimeFormatter.ofPattern("yyyy/MM/dd")) + "," + x.getDischargeDate().format(DateTimeFormatter.ofPattern("yyyy/MM/dd")) + "," + x.getNurseAssigned());
            }
            pw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
