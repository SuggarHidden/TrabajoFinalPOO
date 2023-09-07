package trabajofinalpoo;

public class Escolar extends Usuario {
    private double descuento;
    public Escolar(String nombre, String apellidos, String email, String contraseña) {
        super(nombre, apellidos, email, contraseña);
        this.descuento = 0.5;
    }


}
