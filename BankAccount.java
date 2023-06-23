/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
    public class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Saldo tidak mencukupi.");// Exception jika saldo tidak mencukupi
        }

        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount("123456789", 1000.0); // Membuat objek akun dengan nomor akun "123456789" dan saldo awal 1000.0

        try {
            account.deposit(500.0);// Melakukan deposit sebesar 500.0 ke akun
            System.out.println("Saldo setelah deposit: " + account.getBalance());// Menampilkan saldo setelah deposit

            account.withdraw(2000.0);// Melakukan penarikan sebesar 2000.0 dari akun
            System.out.println("Saldo setelah penarikan: " + account.getBalance());// Menampilkan saldo setelah penarikan
        } catch (InsufficientBalanceException e) {
            System.out.println("Exception: " + e.getMessage()); // Menangkap pengecualian InsufficientBalanceException dan menampilkan pesan kesalahan
        }
    }
}

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

