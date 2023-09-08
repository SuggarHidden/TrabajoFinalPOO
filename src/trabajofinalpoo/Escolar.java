package trabajofinalpoo;

public class Escolar extends Usuario {
    private double descuento;
    private double tarifa;
    public Escolar(String nombre, String apellidos, String email, String password) {
        super(nombre, apellidos, email, password);
        this.descuento = 0.5;
    }

    @Override
    public void selectCorredor(String tipo) {
        setCorredor(tipo);
        tarifa = descuento*getTarifaInicial();
    }


}
