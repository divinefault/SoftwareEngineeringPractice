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
     * This function reduces the balance by a valid amount.
     * An invalid amount would be a negative amount or an amount greater than the balance
     * @param amount - The amount desired to be withdrawn
     * @post reduces the balance by amount if amount is non-negative and smaller than balance
     */
    public void withdraw (double amount)  {
        if(amount < 0){
            throw new IllegalArgumentException("You can't withdraw an amount less than 0");
        }
        else if (amount > balance){
            throw new IllegalArgumentException("You can't withdraw an amount more than the account balance");
        }
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
    public static boolean isEmailValid(String email) {


        //checks that the email address doesn't contain a space
        if (email.contains(" ")) {
            return false;
        }

        //splits email at the @
        String[] emailSections = email.split("@");

        //ensures that there are two email sections
        if (emailSections.length != 2) {
            return false;
        }

        //String before @
        String first = emailSections[0];
        //String after @
        String second = emailSections[1];
        //Characters that shall not be used
        String charsNotToUse = "!@#$%^&*";
        //Characters that can be used but not at the beginning or end of the string
        String charsThatMayBeUsed = "-._";

        //checks that there is something in the first section of the email isn't empty
        if (first.length() <= 0) {
            return false;
        }

        //checks that the second half of the email is at least 3 characters long
        else if (second.length() <= 3) {
            return false;
        }

        //makes sure that the first string does not contain a special character
        for (int i = 0; i < first.length(); i++) {
            if (charsNotToUse.indexOf(first.charAt(i)) != -1) {
                return false;
            }
        }

        //checks that the second string doesn't contain special characters
        for (int i = 0; i < second.length(); i++) {
            if (charsNotToUse.indexOf(second.charAt(i)) != -1) {
                return false;
            }
        }


        // makes sure that first string does not begin or end with a "-._"
        for (int i = 0; i < charsThatMayBeUsed.length(); i++) {
            if (first.charAt(0) == charsThatMayBeUsed.charAt(i) || first.charAt(first.length()-1) == charsThatMayBeUsed.charAt(i)) {
                return false;
            }
        }

        //checks that the second string contains but does not begin or end with a period
        if (second.contains(".")) {
            if (second.startsWith(".") || second.endsWith(".")) {
                return false;
            }

        }

        return true;
    }

    /**
     * Checks that the amoutn given is valid. The amount is valid if it has no more than 2 decimal places
     * and is not a negative amount
     * @param amount - amount being checked for validity
     * @return boolean - validity status
     */
    public static boolean isAmountValid(double amount){
        String strAmount = Double.toString(amount);
        if (strAmount.substring(strAmount.indexOf("."),strAmount.length()).length() > 2){
            return false;
        }

        if(amount < 0 ){
            return false;
        }
        return true;
    }

}
