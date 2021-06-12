package gofo;

/**
 *
 * @author Mohamed Abdelreda
 */
public class User {
    private static int id = 0;
    protected String firstName, lastName, email, password, phone, location;
    protected int ID;
    protected EWallet wallet;
    
    /**
     * A default constructor for creating a unique id every time the user creates object of class User
     */
    public User() {
        id++;
        this.ID = id;
    }
    
    /**
     * 
     * @param firstName
     * @param lastName
     * @param email
     * @param password
     * @param phone
     * @param location 
     */
    public User(String firstName, String lastName, String email, String password, String phone, String location) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.location = location;
        id++;
        this.ID = id;
        
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public EWallet getWallet() {
        return wallet;
    }

    public void setWallet(EWallet wallet) {
        this.wallet = wallet;
    }
    
    public void displayInfo() {
        System.out.println("Name: " + firstName + " " + lastName );
        System.out.println("ID: " + ID);
        System.out.println("Email: " + email);
        System.out.println();
    }
    
}
