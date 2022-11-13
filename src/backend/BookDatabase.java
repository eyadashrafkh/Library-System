package backend;

import java.io.*;
import java.util.Scanner;

public final class BookDatabase extends Database{

    private final String filename;

    public BookDatabase(String filename) {
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
    public Book createRecordFrom(String line){
        String[] tokens = line.split(",");
        return new Book(tokens[0], tokens[1], tokens[2], tokens[3], Integer.parseInt(tokens[4]));
    }
}
