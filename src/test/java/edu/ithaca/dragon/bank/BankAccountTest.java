package edu.ithaca.dragon.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void getBalanceTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals(200, bankAccount.getBalance());
    }

    @Test
    void withdrawTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);
        bankAccount.withdraw(100);

        assertEquals(100, bankAccount.getBalance());
        assertThrows(IllegalArgumentException.class, ()->{bankAccount.withdraw(-10);});
        assertThrows(IllegalArgumentException.class, ()->{bankAccount.withdraw(200.10);});
        assertThrows(IllegalArgumentException.class, ()->{bankAccount.withdraw(200.00001);});

    }

    @Test
    void isEmailValidTest(){
        assertTrue(BankAccount.isEmailValid( "a@b.com"));
        assertFalse( BankAccount.isEmailValid( "-a@b.com"));
        assertFalse( BankAccount.isEmailValid("a.@b.com"));
        assertFalse( BankAccount.isEmailValid("-a@b.com"));
        assertFalse( BankAccount.isEmailValid("a-@b.com"));
        assertFalse( BankAccount.isEmailValid("_a@b.com"));
        assertFalse( BankAccount.isEmailValid("a_@b.com"));
        assertFalse( BankAccount.isEmailValid("@@b.com"));
        assertFalse( BankAccount.isEmailValid("@b.com"));
        assertFalse( BankAccount.isEmailValid(""));
    }

    @Test
    void isAmountValidTest(){
        assertTrue(BankAccount.isAmountValid(200.00));
        assertFalse(BankAccount.isAmountValid(-10.00));
        assertFalse(BankAccount.isAmountValid(200.001));
    }

    @Test
    void constructorTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals("a@b.com", bankAccount.getEmail());
        assertEquals(200, bankAccount.getBalance());
        //check for exception thrown correctly
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("", 100));
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("a@b.com", 200.00001));
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("a@b.com", -100));

    }

}