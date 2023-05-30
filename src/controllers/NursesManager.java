package controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import models.Nurses;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author NguyenDuy
 */
public class NursesManager extends Nurses {

//    protected List<Nurses> arr = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    public HashMap<String, Nurses> hm = new HashMap<>();

    public NursesManager() {
    }

    public void findNurses() {
        System.out.println("Input staff id: ");
        String staffID = sc.nextLine().toUpperCase();
        if (!hm.containsKey(staffID)) {
            System.out.println("Can't find infomation about " + staffID);
        } else {
            hm.get(staffID).printNurses();
        }
    }

    public Nurses searchNursesId(String staffID) {
        if (hm.isEmpty()) {
            return null;
        }
        if (hm.containsKey(staffID)) {
            return hm.get(staffID);
        }
        return null;
    }

    public void addNursesFromFile(String fNurses) {
        try {
            File f = new File(fNurses);
            if (!f.exists()) {
                return;
            }
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            String details;
            while ((details = bf.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer(details, ",");
                String staffID = stk.nextToken().toUpperCase();
                new CheckValid().checkID(staffID);
                String name = stk.nextToken().toUpperCase();
                int age = Integer.parseInt(stk.nextToken());
                String gender = stk.nextToken().toUpperCase();
                String address = stk.nextToken().toUpperCase();
                String phone = stk.nextToken().toUpperCase();
                new CheckValid().checkValidPhone(phone);
                String department = stk.nextToken().toUpperCase();
                new CheckValid().checkDepartment(department);
                String dateString = stk.nextToken();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                LocalDate shift = LocalDate.parse(dateString, formatter);
                double salary = Double.parseDouble(stk.nextToken());
                Nurses emp = new Nurses(staffID, department, shift, salary, name, age, gender, address, phone);
//                arr.add(emp);
                hm.put(staffID, emp);
            }
            bf.close();
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void addNurses() {
        String staffID, name, gender, address, phone, department;
        int age = 01;
        DateTimeFormatter formatter;
        String dateString;
        LocalDate shift;
        double salary;
        do {
            System.out.println("Input staff ID: ");
            staffID = sc.nextLine().toUpperCase();
        } while (!new CheckValid().checkIDB(staffID));
        System.out.println("Input nurses name: ");
        name = sc.nextLine().toUpperCase();

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
            System.out.println("Input department: ");
            department = sc.nextLine().toUpperCase();
        } while (!new CheckValid().checkDepartmentB(department));
        do {
            System.out.println("Input date(yyyy/MM/dd)");
            dateString = sc.nextLine();
        } while (!new CheckValid().checkDateB(dateString));
        formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        shift = LocalDate.parse(dateString, formatter);
        System.out.println("Input salary: ");
        salary = Double.parseDouble(sc.nextLine());
        Nurses emp = new Nurses(staffID, department, shift, salary, name, age, gender, address, phone);
//        arr.add(emp);
        hm.put(staffID, emp);
    }

    public void addNursesToFile(String fNurses) {
        if (hm.size() == 0) {
            System.out.println("Empty list");
            return;
        }
        try {
            File f = new File(fNurses);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for (Nurses x : hm.values()) {
                pw.println(x.getStaffID() + "," + x.getName() + "," + x.getAge() + "," + x.getGender() + "," + x.getAddress() + "," + x.getPhone() + "," + x.getDepartment() + "," + x.getShift().format(DateTimeFormatter.ofPattern("yyyy/MM/dd")) + "," + x.getSalary());
            }
            pw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateNurse(String fNurses) {
        String staffID, name, gender, address, phone, department;
        int age = 01;
        double salary;
        DateTimeFormatter formatter;
        String dateString;
        LocalDate shift;
        System.out.println("Input staff id of nurses want to update: ");
        staffID = sc.nextLine().toUpperCase();
        if (!hm.containsKey(staffID)) {
            System.out.println("The nurse does not exist");
        } else {
            System.out.println("Find nurses!");
            hm.get(staffID).printNurses();
            System.out.println("Input nurses name you want to update: ");
            name = sc.nextLine().toUpperCase();

            boolean check = false;
            do {
                try {
                    System.out.println("Input age you want to update: ");
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
            System.out.println("Input gender you want to update: ");
            gender = sc.nextLine().toUpperCase();
            System.out.println("Input address you want to update: ");
            address = sc.nextLine().toUpperCase();
            do {
                System.out.println("Input phone you want to update: ");
                phone = sc.nextLine();
            } while (!new CheckValid().checkValidPhoneB(phone));
            do {
                System.out.println("Input department you want to update: ");
                department = sc.nextLine().toUpperCase();
            } while (!new CheckValid().checkDepartmentB(department));
            do {
                System.out.println("Input date(yyyy/MM/dd) you want to update: ");
                dateString = sc.nextLine();
            } while (!new CheckValid().checkDateB(dateString));
            formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            shift = LocalDate.parse(dateString, formatter);
            System.out.println("Input salary you want to update: ");
            salary = Double.parseDouble(sc.nextLine());
            Nurses emp = new Nurses(staffID, department, shift, salary, name, age, gender, address, phone);
            hm.put(staffID, emp);
//            new NursesManager().addNursesToFile(fNurses);
            System.out.println("Update successfully!!");
        }
    }

    public void deleteNurses() {
        String staffID;
        System.out.println("Input staff id of nurses want to delete: ");
        staffID = sc.nextLine().toUpperCase();
        if (!hm.containsKey(staffID)) {
            System.out.println("The nurse does not exist");
        } else {
            System.out.println("Find the nurses:");
            hm.get(staffID).printNurses();
            String choiseMore;
            do {
                System.out.println("Do you ready delete?(Y/N): ");
                choiseMore = sc.nextLine();

            } while (!choiseMore.equalsIgnoreCase("N") && !choiseMore.equalsIgnoreCase("Y"));
            if (choiseMore.equalsIgnoreCase("N")) {
                return;
            }else{
                hm.remove(staffID);
            }
        }
    }
}
