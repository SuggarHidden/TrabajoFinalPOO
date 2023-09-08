package trabajofinalpoo;

public class Universitario extends Usuario {
    private double descuento;
    private double tarifa;

    public Universitario (String nombre, String apellidos, String email, String password) {
        super(nombre, apellidos, email, password);
        this.descuento = 0.5;
    }
    @Override
    public void selectCorredor(String tipo) {
        setCorredor(tipo);
        tarifa = descuento*getTarifaInicial();
    }
    public double getTarifa() {
        return tarifa;
    }








}
