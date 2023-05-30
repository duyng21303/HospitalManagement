/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import controllers.NursesManager;
import controllers.PatientsManager;
import java.util.Scanner;
import models.Patients;

/**
 *
 * @author NguyenDuy
 */
public class HospitalManager {

    public static void main(String[] args) {
        int choise = 0;
        int superchoise = 0;
        boolean check = false;
        Scanner sc = new Scanner(System.in);
        NursesManager nm = new NursesManager();
        nm.addNursesFromFile("nurses.txt");
        PatientsManager pm = new PatientsManager();
        pm.addPatientsFromFile("patients.txt");
        do {
            System.out.println("1.	Nurse’s management \n"
                    + "1.1	Create a nurse\n"
                    + "1.2	Find the nurse\n"
                    + "1.3	Update the nurse\n"
                    + "1.4	Delete the nurse\n"
                    + "2.	Patient’s management\n"
                    + "2.1	Add a patient\n"
                    + "2.2	List patients\n"
                    + "2.3	Sort the patients list\n"
                    + "2.4	Save data\n"
                    + "2.5	Load data\n"
                    + "Others – Quit.");

            do {
                try {
                    System.out.println("Choise 1 or 2:");

                    superchoise = Integer.parseInt(sc.nextLine());
                    if (choise < 0 || superchoise > 2) {
                        throw new Exception("Something wrong!");
                    } else {
                        check = false;
                    }
                } catch (Exception e) {
                    System.out.println("Something wrong!");
                    check = true;
                }
            } while (check);

            switch (superchoise) {
                case 1:
                    do {
                        System.out.println("1 - Create a nurse");
                        System.out.println("2 - Find the nurse");
                        System.out.println("3 - Update the nurse");
                        System.out.println("4 - Delete the nurse");
                        System.out.println("Orther: Quit");

                        do {
                            try {
                                System.out.println("Enter your choise");

                                choise = Integer.parseInt(sc.nextLine());
                                if (choise < 0) {
                                    throw new Exception("Something wrong!");
                                } else {
                                    check = false;
                                }
                            } catch (Exception e) {
                                System.out.println("Something wrong!");
                                check = true;
                            }
                        } while (check);
                        switch (choise) {
                            case 1:
                                while (true) {

                                    nm.addNurses();
                                    nm.addNursesToFile("nurses.txt");
                                    String choiseMore;
                                    do {
                                        System.out.println("Do you want add more?(Y/N): ");
                                        choiseMore = sc.nextLine();

                                    } while (!choiseMore.equalsIgnoreCase("N") && !choiseMore.equalsIgnoreCase("Y"));
                                    if (choiseMore.equalsIgnoreCase("N")) {
                                        break;
                                    }
                                }
                                break;
                            case 2:
                                nm.findNurses();
                                break;
                            case 3:
                                nm.updateNurse("nurses.txt");
                                nm.addNursesToFile("nurses.txt");
                                break;
                            case 4:
                                nm.deleteNurses();
                                nm.addNursesToFile("nurses.txt");
                                break;
                            default:
                                System.out.println("Input error!!!");
                        }
                    } while (choise > 0 && choise < 5);
                    break;
                case 2:
                    do {
                        System.out.println("1 - Add a patient");
                        System.out.println("2 - List patients");
                        System.out.println("3 - Sort the patients list");
                        System.out.println("4 - Save data");
                        System.out.println("5 - Load data");
                        System.out.println("Orther: Quit");

                        do {
                            try {
                                System.out.println("Enter your choise");

                                choise = Integer.parseInt(sc.nextLine());
                                if (choise < 0) {
                                    throw new Exception("Something wrong!");
                                } else {
                                    check = false;
                                }
                            } catch (Exception e) {
                                System.out.println("Something wrong!");
                                check = true;
                            }
                        } while (check);
                        switch (choise) {
                            case 1:
                                while (true) {

                                    pm.addPatients();
                                    pm.addPatientsToFile("patients.txt");
                                    String choiseMore;
                                    do {
                                        System.out.println("Do you want add more?(Y/N): ");
                                        choiseMore = sc.nextLine();

                                    } while (!choiseMore.equalsIgnoreCase("N") && !choiseMore.equalsIgnoreCase("Y"));
                                    if (choiseMore.equalsIgnoreCase("N")) {
                                        break;
                                    }
                                }
                                break;
                            case 2:
                                pm.printList();
                                break;
                            case 3:
                                pm.printListSort();
                                break;
                            case 4:
                                nm.addNursesToFile("nurses.txt");
                                pm.addPatientsToFile("patients.txt");
                                break;
                            case 5:
                                pm.addPatientsFromFile("patients.txt");
                                nm.addNursesFromFile("nurses.txt");
                                break;
                            default:
                                System.out.println("Input error!!!");
                        }

                    } while (choise > 0 && choise < 5);
                    break;
                default:
                    System.out.println("Input error!");
            }

        } while (choise > 0 && choise < 2);

    }
}
