package estm.dsic.jee;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Main {
    public final static int AMOUNT = 10;

    public static void main(String[] args) {
        try {
            String url = "rmi://" + InetAddress.getLocalHost().getHostAddress() + ":52369/BankAccount";
            BankAccount bankAccount = (BankAccount) Naming.lookup(url);
            System.out.println("Current amount in the bank account " + bankAccount.getBalance());
            System.out.println("Deposit --> " + AMOUNT);
            bankAccount.deposit(AMOUNT);
            System.out.println("Amount after de deposit:" + bankAccount.getBalance());
            bankAccount.withdraw(3);
            System.out.println("Withdraw ....");
            System.out.println("Amount after de withdraw: " + bankAccount.getBalance());
        } catch (UnknownHostException | NotBoundException | MalformedURLException | RemoteException e) {
            e.printStackTrace();
            System.out.println("Error while trying to access the server remotly ");
        }
    }
}