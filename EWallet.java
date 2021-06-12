package gofo;

/**
 *
 * @author Mohamed Abdelreda
 */
public class EWallet {

    protected double wallet = 0;
    protected String email;
    
    /**
     * A function to create EWallet account using user email 
     * @param email 
     */
    public void ewalletAccount(String email) {
        this.email = email;
    }
    
    /**
     * A function to add money to the wallet
     * @param amount  to deposit an amount of money to wallet
     */
    public void addMoney(double amount) {
        wallet += amount;
    }
    
    /**
     * Function to return the wallet information
     * @return wallet
     */
    public double checkMoney() {
        return wallet;
    }
    
    /**
     * 
     * @param amount to withdraw an amount money from wallet
     */
    public void payMoney(double amount) {
        wallet -= amount;
    }
}
