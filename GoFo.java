/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gofo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Abdelrahman Sadawy
 * @author Salma Mohamed
 */
public class GoFo {

    public static PlaygroundOwner owner;
    public static Playground playground;
    public static Player player;
    public static ArrayList<PlaygroundOwner> owners = new ArrayList<>();
    public static ArrayList<Playground> grounds = new ArrayList<>();
    public static ArrayList<Player> players = new ArrayList<>();

    public static void registerPlaygroundOwner() { // function for registering a playground owner attributes 

        Scanner input = new Scanner(System.in);

        System.out.print("Please Enter Your Frist Name: ");
        String fristName = input.next();

        System.out.print("Please Enter Your Last Name: ");
        String lastName = input.next();

        System.out.print("Please Enter Your Email: ");
        String email = input.next();

        System.out.print("Please Enter Your Password: ");
        String password = input.next();

        System.out.print("Please Enter Your Phone: ");
        String phone = input.next();

        System.out.print("Please Enter Your Location: ");
        String location = input.next();
        System.out.println();

        owner = new PlaygroundOwner(fristName, lastName, email, password, phone, location);
        owners.add(owner);

    }

    public static void registerPlayer() { // function for registering a player attributes 

        Scanner input = new Scanner(System.in);

        System.out.print("Please Enter Your Frist Name: ");
        String fristName = input.next();

        System.out.print("Please Enter Your Last Name: ");
        String lastName = input.next();

        System.out.print("Please Enter Your Email: ");
        String email = input.next();

        System.out.print("Please Enter Your Password: ");
        String password = input.next();

        System.out.print("Please Enter Your Phone: ");
        String phone = input.next();

        System.out.print("Please Enter Your Location: ");
        String location = input.next();
        System.out.println();

        player = new Player(fristName, lastName, email, password, phone, location);
        players.add(player);

    }

    public static void registeringPlayground() { // A function to add playground for the owner
        Scanner input = new Scanner(System.in);
        System.out.print("Please Enter Your Playground Name: ");
        String groundName = input.next();

        System.out.print("Please Enter Your Playground Location: ");
        String location = input.next();

        System.out.print("Please Enter Your Playground size: ");
        double size = input.nextDouble();

        System.out.print("Please Enter Price Per Hour: ");
        double price = input.nextDouble();

        System.out.print("Please Enter Cancellation Period: ");
        int period = input.nextInt();

        playground = new Playground("", groundName, location, size, price, period);

        System.out.print("Plese Enter your start hour: ");
        int startHour = input.nextInt();

        System.out.print("Plese Enter your last hour: ");
        int lastHour = input.nextInt();

        playground.setTimeSlots(startHour, lastHour);
    }

    public static void playgroundBooking() { // a function to book a playground for player
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter month you wanna book in: ");
        int month = scan.nextInt();

        System.out.print("Enter day you wanna book on: ");
        int day = scan.nextInt();

        System.out.println("Available slots in month " + month + " and day " + day);

        for (int i = 0; i < grounds.size(); i++) {
            grounds.get(i).displayAvailableTimeSlots(month, day);
        }

        System.out.print("Enter playground name you would like to book: ");
        String groundName = scan.next();

        System.out.print("Enter hour you wanna book at: ");
        int hour = scan.nextInt();

        player.bookPlayground(groundName, month, day, hour, grounds);

    }

    public static void cancelBooking() { // a function for cancellation a book of playground 
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter Playground Name that you want to cancel booking");
        String groundName = scan.next();

        System.out.print("Enter month you booked in: ");
        int month = scan.nextInt();

        System.out.print("Enter day you booked on: ");
        int day = scan.nextInt();

        System.out.print("Enter hour you booked at: ");
        int hour = scan.nextInt();

        player.cancelBooking(groundName, month, day, hour, grounds);
    }

    public static void viewBooking() { // display player bookings
        System.out.println(player.viewBooking());
    }

    public static void main(String[] args) { // a normal UI to check el functions
        int choice;
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("1-Register Playground-Owner\n2-Register Player\n3-Exit");
            choice = input.nextInt();
            if (choice == 1) {
                while (true) {
                    System.out.println("\n1-Add New Owner\n2-Registering Playground\n3-Change Time Slots\n4-Exit");
                    int option = input.nextInt();

                    if (option == 1) {
                        registerPlaygroundOwner();
                        owner.displayInfo();
                    } else if (option == 2) {
                        registeringPlayground();
                        owner.addPlayground(playground);
                        grounds.add(playground);
                    } else if (option == 3) {
                        int startHour, endHour;
                        System.out.print("Please Enter The New Time Slots From: ");
                        startHour = input.nextInt();
                        System.out.print("To: ");
                        endHour = input.nextInt();

                        owner.changeTimeSlots(playground, startHour, endHour);
                        

                    } else if (option == 4) {
                        System.out.println();
                        break;                       
                    }
                }

            } else if (choice == 2) {
                while (true) {
                    System.out.println("\n1-Add New Player\n2-Booking Playground\n3-Cancel Booking\n4-View Booking\n5-Exit");
                    int option = input.nextInt();

                    if (option == 1) {
                        registerPlayer();
                        player.displayInfo();
                    } else if (option == 2) {
                        playgroundBooking();
                    } else if (option == 3) {
                        cancelBooking();
                    } else if (option == 4) {
                        viewBooking();
                    } else if (option == 5) {
                        System.out.println();
                        break;
                    }

                }
            } else if (choice == 3) {
                break;
            }
        }

    }

}
