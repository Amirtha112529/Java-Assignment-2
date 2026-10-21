/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hospitalmanagement;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

class InvalidPatientException extends Exception {
    InvalidPatientException(String message) {
        super(message);
    }
}

public class HospitalManagement {
 public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
    try {
        System.out.print("Enter Patient ID: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Enter Patient Name: ");
        String name = sc.nextLine();
    
        if (name.trim().isEmpty()) {
           
    throw new InvalidPatientException("Patient name cannot be empty!");
            }

            System.out.print("Enter Patient Age: ");
            int age = Integer.parseInt(sc.nextLine());

            if (age <= 0 || age > 120) {
                throw new InvalidPatientException("Age must be between 1 and 120!");
            }

            System.out.print("Enter Appointment Date: ");
            String date = sc.nextLine();
            System.out.print("Enter Doctor Name: ");
            String doctor = sc.nextLine();

            if (date.trim().isEmpty() ||
                doctor.trim().isEmpty()) {
     throw new InvalidPatientException("Date and doctor name are required!");
            }

           
    try (FileWriter fw =new FileWriter("patients.txt", true)) {

        fw.write("Patient ID: " + id + "\n");
        fw.write("Patient Name: " + name + "\n");
        fw.write("Age: " + age + "\n");
        fw.write("Appointment Date: " + date + "\n");
        fw.write("Doctor Name: " + doctor + "\n");
        fw.write("----------------------\n");
    }

            System.out.println( "\nAppointment booked successfully!");
            System.out.println("\nSaved Patient Records:");

    try (BufferedReader br =
        new BufferedReader(new FileReader("patients.txt"))) {
        String line;

        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }

} 
    catch (NumberFormatException e) {
        System.out.println("Error: Please enter a valid number.");

    }
    catch (InvalidPatientException e) {
        System.out.println("Error: " + e.getMessage());

    } catch (IOException e) {
        System.out.println("File error: " + e.getMessage());

    }
    finally {
        sc.close();
        System.out.println("\nProgram ended.");
        }
    }
}