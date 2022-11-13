package backend;

public class Book implements Record{
    
    private final String bookName;
    private int bookQuantity;
    private final String bookPublisher;
    private final String bookAuthorName;
    private final String bookid;

    public Book(String id, String title, String authorName, String publisherName, int quantity){
        this.bookid = id;
        this.bookName = title;
        this.bookAuthorName = authorName;
        this.bookPublisher = publisherName;
        this.bookQuantity = quantity;
    }

    public int getBookQuantity() {
        return bookQuantity;
    }

    public void setBookQuantity(int bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

    @Override
    public String lineRepresentation(){
        return bookid+","+bookName+","+bookAuthorName+","+bookPublisher+","+bookQuantity;
    }

    @Override
    public String getSearchKey(){
        return bookid;
    }

    @Override
    public String getpassword() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}