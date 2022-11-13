package backend;

import constants.FileNames;
import java.util.ArrayList;
import java.time.LocalDate;

public class LibrarianRole {

    private final BookDatabase booksDatabase = new BookDatabase(FileNames.BOOKS_FILENAME);
    private final StudentBookDatabase sBDatabase = new StudentBookDatabase(FileNames.STUDENTSBOOKS_FILENAME);

    public LibrarianRole(){

    }
    
    public BookDatabase getBookDatabase(){
        return this.booksDatabase;
    }
    
    public StudentBookDatabase getStudentBookDatabase(){
        return this.sBDatabase;
    }

    public void addBook(String id, String title, String authorName, String publisherName, int quantity){
            Book b = new Book(id, title, authorName, publisherName, quantity);
            booksDatabase.insertRecord(b);
    }

    public ArrayList<Record> getListOfBooks(){
        return booksDatabase.returnAllRecords();
    }

    public ArrayList<Record> getListOfBorrowingOperations(){
        return sBDatabase.returnAllRecords();
    }

    public int borrowBook(String studentId, String bookId, LocalDate borrowDate){
        if(booksDatabase.contains(bookId)==false )
            return 0;
        else{
            Book tempB1 =  (Book) booksDatabase.getRecord(bookId);
            if(tempB1.getBookQuantity()==0)
                 return 0;
            else if(sBDatabase.contains(studentId+","+bookId)==true)
                return 1;
            else{
                tempB1.setBookQuantity(tempB1.getBookQuantity()-1);
                sBDatabase.insertRecord(sBDatabase.createRecordFrom(studentId+","+bookId+","+borrowDate));
                return 2;
            }
        }
    }

    public double returnBookFees(String studentId, String bookId, LocalDate returnDate){
        if (sBDatabase.contains(studentId+","+bookId)==false)
        return 0;
        else{
            booksDatabase.insertRecord(booksDatabase.getRecord(bookId));
            StudentBook SBTemp1=(StudentBook) sBDatabase.getRecord(studentId+","+bookId);
            Book tempB1 = (Book) booksDatabase.getRecord(bookId);
            tempB1.setBookQuantity(tempB1.getBookQuantity()+1);
            if (returnDate.getDayOfYear()-SBTemp1.getBorrowDate().getDayOfYear() > 7){    
                sBDatabase.deleteRecord(studentId+","+bookId);
                return (returnDate.getDayOfYear() -SBTemp1.getBorrowDate().getDayOfYear() - 7) * 0.5;    
            }
            else{
                sBDatabase.deleteRecord(studentId+","+bookId);
                return 0;
            }
        }
    }

    public void logout(){
        booksDatabase.saveToFile();
        sBDatabase.saveToFile();
    }
}