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

    public double makePayment(Corredor corredor) {
        if (canPay(corredor)) {
            double newBalance = getBalance() - Main.getFees(corredor);
            this.balance = newBalance;
            return newBalance;
        }
        else throw new RuntimeException("No tienes saldo suficiente para pagar el pasaje");
    }

    public double makePayment(Corredor corredor, double discount) {
        if (canPay(corredor, discount)) {
            double newBalance = getBalance() - (Main.getFees(corredor)*discount);
            this.balance = newBalance;
            return newBalance;
        } else throw new RuntimeException("No tienes saldo suficiente para pagar el pasaje");
    }
    public double getBalance() {
        return balance;
    }

    public void addBalance(double balance) {
        if (getBalance() + balance > 100.0) throw new RuntimeException("El limite maximo de saldo en una tarjeta es de S/100");
        this.balance = getBalance() + balance;
    }
}


