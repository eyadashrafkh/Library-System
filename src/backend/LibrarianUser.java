package backend;

public class LibrarianUser implements Record  {
    
    private final String librarianId;
    private final String name;
    private final String email;
    private final String address;
    private final String phoneNumber;

    public LibrarianUser(String librarianId, String name, String email, String address,String phoneNumber){
        this.librarianId = librarianId;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String lineRepresentation(){
        return librarianId+","+name+","+email+","+address+","+phoneNumber;    
    }
    
    @Override
    public String getSearchKey(){
        return librarianId;
    }

    @Override
    public String getpassword() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
