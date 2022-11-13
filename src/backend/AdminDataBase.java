/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author eyada
 */
public final class AdminDataBase extends Database{

    private final String filename;
    
    public AdminDataBase( String filename) {
        super(filename);
        this.filename = filename;
        readFromFile();
    }

    @Override
    public void readFromFile() {
        try {
            File file = new File(filename);
            try(Scanner sc = new Scanner(file)){
                String str;
                while (sc.hasNextLine()){
                    str = sc.nextLine();
                    Record rTemp = createRecordFrom(str);
                    records.add(rTemp);
                }
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("ERROR IN OPENING FILE AND TRYING TO MODIFY IN IT");
        }
    }

    @Override
    public Record createRecordFrom(String line) {
        String[] tokens = line.split(",");
        return new Admin(tokens[0], tokens[1]);
    }
}