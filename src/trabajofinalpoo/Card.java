package trabajofinalpoo;

import trabajofinalpoo.enums.Corredor;

public class Card implements CardBalance {
    private double balance;
    public Card() {
        this(0.0);
    }
    public Card(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean canPay(Corredor corredor){
        return getBalance() - UserManager.getFees(corredor) > 0.0;
    }
    @Override
    public boolean canPay(Corredor corredor, double discount){
        return getBalance() - (UserManager.getFees(corredor)*discount) > 0.0;
    }
    @Override
    public double makePayment(Corredor corredor) {
        if (canPay(corredor)) {
            double newBalance = getBalance() - UserManager.getFees(corredor);
            this.balance = newBalance;
            return newBalance;
        }
        else throw new RuntimeException("No tienes saldo suficiente para pagar el pasaje");
    }

    @Override
    public double makePayment(Corredor corredor, double discount) {
        if (canPay(corredor, discount)) {
            double newBalance = getBalance() - (UserManager.getFees(corredor)*discount);
            this.balance = newBalance;
            return newBalance;
        } else throw new RuntimeException("No tienes saldo suficiente para pagar el pasaje");
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void addBalance(double balance) {
        if (getBalance() + balance > 100.0) throw new RuntimeException("El limite maximo de saldo en una tarjeta es de S/100");
        this.balance = getBalance() + balance;
    }
}


