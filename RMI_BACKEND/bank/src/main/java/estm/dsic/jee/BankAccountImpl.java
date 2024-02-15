package estm.dsic.jee;

import java.rmi.RemoteException;

public class BankAccountImpl implements BankAccount{

    private double balance = 60; // Initial balance set to 50

    @Override
    public void deposit(int amount) throws RemoteException {
        // Check if the amount is positive
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        // Increase the balance by the deposit amount
        balance += amount; 
    }

    @Override
    public void withdraw(int amount) throws RemoteException {
        // Check if the amount is positive
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        // Check if the balance is sufficient for withdrawal
        if (balance < amount) {
            throw new IllegalStateException("Insufficient funds");
        }
        // Decrease the balance by the withdrawal amount
        balance -= amount;
    }

    @Override
    public double getBalance() throws RemoteException {
        // Return the current balance
        return balance;
    }


}
