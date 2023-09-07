package trabajofinalpoo;

public class Universitario extends Usuario {
    private double descuento;
    private double tarifa;

    public Universitario (String nombre, String apellidos, String email, String contraseña) {
        super(nombre, apellidos, email, contraseña);
        this.descuento = 0.5;
    }








}
