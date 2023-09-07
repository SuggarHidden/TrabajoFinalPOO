package trabajofinalpoo;

public class General extends Usuario {
    private double descuento;

    public General(String nombre, String apellidos, String email, String contraseña) {
        super(nombre, apellidos, email, contraseña);
        this.descuento = 1;
    }

    

}
