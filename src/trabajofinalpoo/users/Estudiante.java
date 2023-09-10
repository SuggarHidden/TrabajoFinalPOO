package trabajofinalpoo.users;

public class Estudiante extends General {
    private double discount;

    public Estudiante(String name, String lastname, String email, String password) {
        super(name, lastname, email, password);
        this.discount = 0.5;
    }

    public double getDiscount() {
        return discount;
    }

    @Override
    public String toString() {
        return super.toString()+"\n discount = " + discount;
    }
}
