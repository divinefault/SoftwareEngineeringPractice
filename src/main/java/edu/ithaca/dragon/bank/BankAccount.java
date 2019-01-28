package edu.ithaca.dragon.bank;

public class BankAccount {

    private String email;
    private double balance;

    /**
     * @throws IllegalArgumentException if email is invalid
     */
    public BankAccount(String email, double startingBalance){
        if (isEmailValid(email)){
            this.email = email;
            this.balance = startingBalance;
        }
        else {
            throw new IllegalArgumentException("Email address: " + email + " is invalid, cannot create account");
        }
    }

    public double getBalance(){
        return balance;
    }

    public String getEmail(){
        return email;
    }

    /**
     * @post reduces the balance by amount if amount is non-negative and smaller than balance
     */
    public void withdraw (double amount)  {
        balance -= amount;

    }

    /**
     * Checks input string and returns if it's a valid email address or not.
     * An example of a valid email is as follows: example@domain.name.
     * The "example" part of the string being limited to uppercase and lowercase latin letter (a-z), digits (0-9), hyphens (-), underscores (_), and periods (.). Note that the string may not begin or end with the hyphen, underscore, or period.
     * followed by an address sign (@), followed by a domain name.
     * The email string may not contain special any extra special characters (!,@,#,$,%,^,&,*)
     * @param email - string being checked for validity
     * @return boolean - validity status
     */
    public static boolean isEmailValid(String email){
        if (email.indexOf('@') == -1){
            return false;
        }
        else {
            return true;
        }
    }
}
