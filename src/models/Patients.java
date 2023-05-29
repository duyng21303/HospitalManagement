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
public class Patients extends Person{
    protected String patientsID;
    protected String diagnosis;
    protected LocalDate admissionDate;
    protected LocalDate dischargeDate;
    protected String nurseAssigned;

    public Patients() {
    }

    public Patients(String patientsID, String diagnosis, LocalDate admissionDate, LocalDate dischargeDate, String nurseAssigned, String name, int age, String gender, String address, String phone) {
        super(name, age, gender, address, phone);
        this.patientsID = patientsID;
        this.diagnosis = diagnosis;
        this.admissionDate = admissionDate;
        this.dischargeDate = dischargeDate;
        this.nurseAssigned = nurseAssigned;
    }

    public String getPatientsID() {
        return patientsID;
    }

    public void setPatientsID(String patientsID) {
        this.patientsID = patientsID;
    }

    
    

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }

    public LocalDate getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(LocalDate dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public String getNurseAssigned() {
        return nurseAssigned;
    }

    public void setNurseAssigned(String nurseAssigned) {
        this.nurseAssigned = nurseAssigned;
    }

    @Override
    public String toString() {
        return "Patients{" + "diagnosis=" + diagnosis + ", admissionDate=" + admissionDate + ", dischargeDate=" + dischargeDate + ", nurseAssigned=" + nurseAssigned + '}';
    }
    public void printPatient(){
        System.out.printf("#%15s#%15s#%20s#%15s#%20s#\n", patientsID, admissionDate, name, phone, diagnosis);
    }
    
}
