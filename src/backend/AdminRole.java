package backend;

import constants.FileNames;
import java.util.ArrayList;

public class AdminRole {
    
    private final LibrarianUserDatabase database = new LibrarianUserDatabase(FileNames.LIBRARIANS_FILENAME);

    public AdminRole() {

    }
    
    public LibrarianUserDatabase getDatabase(){
        return this.database;
    }
    
    public void addLibrarian(String librarianId, String name, String email, String address, String phoneNumber){
        LibrarianUser L1= new LibrarianUser(librarianId, name, email, address, phoneNumber);
        database.insertRecord(L1);
    }
    
    public ArrayList<Record> getListOfLibrarians(){
        return database.returnAllRecords();
    }
    
    public void removeLibrarian (String key){
        database.deleteRecord(key);
    }
    
    public void logout(){
        database.saveToFile();
    }
}
