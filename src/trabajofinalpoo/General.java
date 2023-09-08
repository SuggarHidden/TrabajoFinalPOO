package trabajofinalpoo;

public class General extends Usuario {
    private double descuento;
    private double tarifa;

    public General(String nombre, String apellidos, String email, String password) {
        super(nombre, apellidos, email, password);
        this.descuento = 1;
    }
    @Override
    public void selectCorredor(String tipo) {
        setCorredor(tipo);
        tarifa = descuento*getTarifaInicial();
    }

}
