
package trabajofinalpoo;

import trabajofinalpoo.enums.Corredor;
import trabajofinalpoo.gui.Gui;
import trabajofinalpoo.users.Estudiante;

import java.util.HashMap;

public class Main {

    private static final HashMap<Corredor, Double> fees = new HashMap<>(4);
    public static void main(String[] args) {
        initFees();
        new Gui();
        Estudiante newUser = new Estudiante("pepito", "vertiz", "pepitoVertiz@gmail.com", "pepito123");
        System.out.println(newUser.toString());
    }

    private static void initFees(){
        fees.put(Corredor.AZUL, 2.20);
        fees.put(Corredor.ROJO, 2.20);
        fees.put(Corredor.MORADO, 2.30);
        fees.put(Corredor.AMARILLO, 2.50);
    }
    public static double getFees(Corredor corredor){
        return fees.get(corredor);
    }
}


