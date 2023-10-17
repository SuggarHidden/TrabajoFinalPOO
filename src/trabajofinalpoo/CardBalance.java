package trabajofinalpoo;

import trabajofinalpoo.enums.Corredor;

public interface CardBalance {
    boolean canPay(Corredor corredor);
    boolean canPay(Corredor corredor, double discount);
    double makePayment(Corredor corredor);
    double makePayment(Corredor corredor, double discount);
    double getBalance();
    void addBalance(double balance);

}
