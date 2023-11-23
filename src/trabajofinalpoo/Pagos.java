package trabajofinalpoo;

import trabajofinalpoo.enums.Corredor;

public interface Pagos {
    boolean verificarPago(Corredor corredor);
    boolean verificarPago(Corredor corredor, double discount);
    double hacerPago(Corredor corredor);
    double hacerPago(Corredor corredor, double discount);
}
