package trabajofinalpoo;

import trabajofinalpoo.enums.Corredor;

public class Tarjeta implements Pagos {
    private double balance;
    public Tarjeta() {
        this(0.0);
    }
    public Tarjeta(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean verificarPago(Corredor corredor){
        return getBalance() - UserManager.getTarifas(corredor) > 0.0;
    }
    @Override
    public boolean verificarPago(Corredor corredor, double discount){
        return getBalance() - (UserManager.getTarifas(corredor)*discount) > 0.0;
    }
    @Override
    public double hacerPago(Corredor corredor) {
        if (verificarPago(corredor)) {
            double newBalance = getBalance() - UserManager.getTarifas(corredor);
            this.balance = newBalance;
            return newBalance;
        }
        else throw new RuntimeException("No tienes saldo suficiente para pagar el pasaje");
    }

    @Override
    public double hacerPago(Corredor corredor, double discount) {
        if (verificarPago(corredor, discount)) {
            double newBalance = getBalance() - (UserManager.getTarifas(corredor)*discount);
            this.balance = newBalance;
            return newBalance;
        } else throw new RuntimeException("No tienes saldo suficiente para pagar el pasaje");
    }

    public double getBalance() {
        return balance;
    }

    public void addBalance(double balance) {
        if (getBalance() + balance > 100.0) throw new RuntimeException("El limite maximo de saldo en una tarjeta es de S/100");
        System.out.println("aqui estoy");
        this.balance = getBalance() + balance;
    }
}


