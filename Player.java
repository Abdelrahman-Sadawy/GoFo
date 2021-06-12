package gofo;

import gofo.Playground.playgroundStatus;
import java.util.ArrayList;

/**
 *
 * @author Salma Mohamed
 * @version 1.0
 */
public class Player extends User {

    public ArrayList<Playground> bookedPlaygrounds;

    /**
     * parameterized constructor setting the player's information
     *
     * @param firstName player's first name
     * @param lastName player's last name
     * @param email player's email
     * @param password player's password
     * @param phone player's phone number
     * @param location player's location
     */
    public Player(String firstName, String lastName, String email, String password, String phone, String location) {
        super(firstName, lastName, email, password, phone, location);
        bookedPlaygrounds = new ArrayList<>();
    }

    /**
     * Booking a specific time slot from a specific playground
     *
     * @param groundName playground's name
     * @param month month in which player is booking
     * @param day day on which player's booking
     * @param hour hour at which player is booking
     * @param playgrounds list of available playgrounds to search in for chosen
     * playground and time slots
     */
    public void bookPlayground(String groundName, int month, int day, int hour, ArrayList<Playground> playgrounds) {
        boolean check = false;

        for (int i = 0; i < playgrounds.size(); i++) {
            if (playgrounds.get(i).getGroundName().equalsIgnoreCase(groundName) && playgrounds.get(i).getTimeSlots(month-1, day-1, hour) == playgroundStatus.AVAILABLE) {

                playgrounds.get(i).BookSpecificTimeSlot(month, day, hour);
                playgrounds.get(i).setStatus(Playground.playgroundStatus.BOOKED);

                System.out.println("Booked successfully!");
                bookedPlaygrounds.add(playgrounds.get(i));

                check = true;
                break;
            }
        }
        if (check == false) {
            System.out.println("This playground isn't available at that time");
        }
    }

    /**
     * Cancel booking at specific time slot
     *
     * @param groundName playground name which was booked and is about to be
     * canceled
     * @param month month in which player booked
     * @param day day on which player booked
     * @param hour hour at which player booked
     * @param playgrounds list of playgrounds to search for that playground and
     * change its status to be available
     */
    public void cancelBooking(String groundName, int month, int day, int hour, ArrayList<Playground> playgrounds) {
        boolean check = false;
        for (Playground playground : playgrounds) {
            if (playground.getGroundName().equalsIgnoreCase(groundName) && playground.getTimeSlots(month-1, day-1, hour) == playgroundStatus.BOOKED) {

                playground.cancelSpecifiTimmeSlot(month, day, hour);
                playground.setStatus(Playground.playgroundStatus.AVAILABLE);

                System.out.println("Cancelled booking successfully!");
                bookedPlaygrounds.remove(playground);

                check = true;
                break;
            }
        }
        if (check == false) {
            System.out.println("This playground was not booked");
        }
    }

    /**
     * Viewing all playgrounds that a player booked
     *
     * @return booked playgrounds
     */
    public ArrayList<Playground> viewBooking() {
        return bookedPlaygrounds;
    }

}
