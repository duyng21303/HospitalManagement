/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.time.LocalDate;

/**
 *
 * @author NguyenDuy
 */
public class Nurses extends Person{
    private String staffID;
    
    protected String department;
    protected LocalDate shift;
    protected double salary;
    
    public Nurses() {
    }

    public Nurses(String staffID, String department, LocalDate shift, double salary, String name, int age, String gender, String address, String phone) {
        super(name, age, gender, address, phone);
        this.staffID = staffID;
        this.department = department;
        this.shift = shift;
        this.salary = salary;
    }
    

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public LocalDate getShift() {
        return shift;
    }

    public void setShift(LocalDate shift) {
        this.shift = shift;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Nurses{" + "staffID=" + staffID + ", department=" + department + ", shift=" + shift + ", salary=" + salary + '}';
    }
    public void printNurses(){
        System.out.printf("#%10s#%15s#%5d#%10s#%20s#%11s#%15s#%20s#5f#\n", staffID, name, age, gender, address, phone, department, shift, salary);
    }
}
