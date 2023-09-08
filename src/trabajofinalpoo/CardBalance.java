package trabajofinalpoo;

import trabajofinalpoo.enums.Corredor;


public class CardBalance {
    private double balance;
    public CardBalance() {
        this(0.0);
    }
    public CardBalance(double balance) {
        this.balance = balance;
    }

    public boolean canPay(Corredor corredor){
        return getBalance() - Main.getFees(corredor) > 0.0;
    }

    public boolean canPay(Corredor corredor, double discount){
        return getBalance() - (Main.getFees(corredor)*discount) > 0.0;
    }

    public double makePayment(Corredor corredor){
        double newBalance = getBalance() - Main.getFees(corredor);
        this.balance = newBalance;
        return newBalance;
    }

    public double makePayment(Corredor corredor, double discount){
        double newBalance = getBalance() - (Main.getFees(corredor)*discount);
        this.balance = newBalance;
        return newBalance;
    }
    public double getBalance() {
        return balance;
    }

    public void addBalance(double balance) throws Exception {
        if (getBalance() + balance > 100.0) throw new Exception("El limite maximo de saldo en una tarjeta es de S/100");
        this.balance = getBalance() + balance;
    }
}
