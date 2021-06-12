package gofo;

/**
 *
 * @author Abdelrahman Sadawy
 */
public class PlaygroundOwner extends User {
    
    public PlaygroundOwner() {
    }

    /**
     * A parameterized constructor to assign values to the super class User
     * @param firstName to assign first name of the owner
     * @param lastName to assign last name of the owner
     * @param email to assign email of the owner
     * @param password to assign password
     * @param phone to assign phone
     * @param location to assign location
     */
    public PlaygroundOwner(String firstName, String lastName, String email, String password, String phone, String location) {
        super(firstName, lastName, email, password, phone, location);
    }
    
    /**
     * A function to add playground information
     * @param playground to be entered its information then it will be available for booking
     */
    public void addPlayground(Playground playground) {
        playground.setOwnerName(getFirstName());
    }
    /**
     * A function to change the time slots of the playground
     * @param playground to assign the playground's which we want to change its slots
     * @param startHour to assign the new start hour
     * @param endHour to assign the new end hour
     */
    public void changeTimeSlots(Playground playground,int startHour, int endHour) {
        playground.setTimeSlots(startHour, endHour);
    }
}
