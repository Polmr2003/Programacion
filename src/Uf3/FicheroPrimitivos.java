/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Uf3;

import java.io.IOException;

/**
 *
 * @author pomo6989
 */
public class FicheroPrimitivos {

    public static void main(String[] args) {
        // write information to file.
        writeInfo();
        // read information from file.
        readAndShowInfo();
        // write array to file
//        writeList();
        // read array from file
//        readAndShowList();
    }

    private static void writeInfo() {
        int age = 30;
        double Salary = 1000.0;
        String name = "Peter";
        System.out.println("Writing to file ...");
        try {
            FicheroEscrituraPrimitivo dos = new FicheroEscrituraPrimitivo("Ficheros\\FicheroPrimitivos.txt");
            // do some stuff with the file.
            dos.escribirEntero(age);
            dos.escribirDouble(Salary);
            dos.escribirString(name);
            // close the file.
            dos.cerrarFichero();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void readAndShowInfo() {
        System.out.println("Reading from file ...");
        try {
            FicheroLecturaPrimitivo dis = new FicheroLecturaPrimitivo("Ficheros\\FicheroPrimitivos.txt");
            // read data from file.
            int age = dis.LeerInt();
            double salary = dis.Leerdouble();
            String name = dis.LeerString();
            // show data to console.
            System.out.format("age=%d\n", age);
            System.out.format("salary=%f\n", salary);
            System.out.format("name=%s\n", name);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void writeList() {

    }

    private static void readAndShowList() {

    }

}
