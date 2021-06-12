package gofo;

/**
 *
 * @author Abdelrahman Sadawy
 */
public class Playground {

    private String ownerName;
    private String groundName;
    private String location;
    private double size;
    private playgroundStatus timeSlots[][][] = new playgroundStatus[12][30][24];
    private double pricePerHour;
    private int cancellationPeriod;
    private playgroundStatus status;
    
    /**
     * A enumeration class for saving the playgrounds statuses
     */
    public enum playgroundStatus {
        BOOKED,
        AVAILABLE,
        SUSBENDED,
        DELETED;
    }

    public Playground() {
    }

    public Playground(String ownerName, String groundName, String location, double size, double pricePerHour, int cancellationPeriod) {
        this.ownerName = ownerName;
        this.groundName = groundName;
        this.location = location;
        this.size = size;
        this.pricePerHour = pricePerHour;
        this.cancellationPeriod = cancellationPeriod;
    }
    
    /**
     * A getter for owner name
     * @return owner name
     */
    public String getOwnerName() {
        return ownerName;
    }

    /**
     * A setter for owner name
     * @param ownerName to assign the owner name of the playground
     */
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
    
    /**
     * A getter for ground name
     * @return ground name
     */
    public String getGroundName() {
        return groundName;
    }
    
    /**
     * A setter for ground name
     * @param groundName to assign the ground name of the playground
     */
    public void setGroundName(String groundName) {
        this.groundName = groundName;
    }
    
    /**
     * A getter for location
     * @return location
     */
    public String getLocation() {
        return location;
    }
    
    /**
     * A setter for location
     * @param location to assign the location of the playground
     */
    public void setLocation(String location) {
        this.location = location;
    }
    
    /**
     * A getter for size
     * @return size
     */
    public double getSize() {
        return size;
    }
    
    /**
     * A setter for size
     * @param size to assign the size of the playground
     */
    public void setSize(double size) {
        this.size = size;
    }
    
    /**
     * A getter for getting the hour price of the playground
     * @return price
     */
    public double getPricePerHour() {
        return pricePerHour;
    }
    
    /**
     * A setter for hour price
     * @param pricePerHour to assign the hour price of the playground
     */
    public void setPricePerHour(double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }
    
    /**
     * A getter for cancellation period of the playground
     * @return cancellation period
     */
    public double getCancellationPeriod() {
        return cancellationPeriod;
    }
    
    /**
     * A setter for cancellation period
     * @param cancellationPeriod to assign cancellation period of the playground
     */
    public void setCancellationPeriod(int cancellationPeriod) {
        this.cancellationPeriod = cancellationPeriod;
    }
    
    /**
     * A getter for the status of the playground
     * @return status
     */
    public playgroundStatus getStatus() {
        return status;
    }
    
    /**
     * A setter for status
     * @param status to assign the status of the playground  
     */
    public void setStatus(playgroundStatus status) {
        this.status = status;
    }
    
    /**
     * A function to set time slots of the playground 
     * @param startHour to assign the first hour at the time slot
     * @param endHour to assign the last hour at the time slot
     */
    public void setTimeSlots(int startHour, int endHour) {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 30; j++) {
                for (int k = startHour; k < endHour; k++) {
                    timeSlots[i][j][k] = playgroundStatus.AVAILABLE;
                    status = playgroundStatus.AVAILABLE;
                }

            }
        }
    }
    /**
     * 
     * @param month
     * @param day
     * @param hour
     * @return 
     */
    public playgroundStatus getTimeSlots(int month, int day, int hour) {
        return timeSlots[month][day][hour];
    }
    
    /**
     * A function to display available time slots to be booked
     * @param month to use it in the 3D array to access to the month
     * @param day  to use it in the 3D to access the day
     */
    public void displayAvailableTimeSlots(int month, int day) {
        boolean checker = false;
        System.out.println("Playground Name: " + groundName);
        for (int i = 0; i < 24; i++) {
            if(timeSlots[month-1][day-1][i] == playgroundStatus.AVAILABLE) {
                System.out.println("From: " + (i) + " " + "to: " + (i+1));
                checker = true;
            }
        }
        if (checker == false) {
            System.out.println("The all playgrounds on this day is booked");
        } else {
            System.out.println();
        }
    }
    
    public void BookSpecificTimeSlot(int month, int day, int hour) {
        timeSlots[month-1][day-1][hour] = playgroundStatus.BOOKED;
    }
    
    public void cancelSpecifiTimmeSlot(int month, int day, int hour){
        timeSlots[month-1][day-1][hour] = playgroundStatus.AVAILABLE;        
    }
    /**
     * A function to display playground information
     */
    public void dispalyPlaygroundInfo() {
        System.out.println("Playground's Owner: " + ownerName);
        System.out.println("Playground's name: " + groundName);
        System.out.println("Playground's location: " + location);
        System.out.println("Playground's Cancelation Period: " + cancellationPeriod);
        System.out.println("Playground's Status: " + status);

    }
    
    @Override
    public String toString() {
        return "\nPlayground's Owner: " + ownerName + "\nPlayground's name: " + groundName + "\nPlayground's location: " + groundName + "\nPlayground's Cancelation Period: " + cancellationPeriod + "\nPlayground's Status: " + status + "\n";
    }
}
