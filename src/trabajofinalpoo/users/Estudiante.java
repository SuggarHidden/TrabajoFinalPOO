package trabajofinalpoo.users;

import java.util.UUID;

public class Estudiante extends General {
    private double discount;

    public Estudiante (UUID id, String name, String lastName, String email, String password) {
        super(id, name, lastName, email, password);
        this.discount = 0.5;
    }
    public Estudiante(UUID id, String name, String lastname, String email, String password, double balance) {
        super(id, name, lastname, email, password, balance);
        this.discount = 0.5;
    }


    public double getDiscount() {
        return discount;
    }

    @Override
    public String toString() {
        return super.toString() + " discount = " + discount;
    }

}


