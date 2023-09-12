
package trabajofinalpoo;

import trabajofinalpoo.enums.Corredor;
import trabajofinalpoo.gui.Gui;
import trabajofinalpoo.users.Estudiante;
import trabajofinalpoo.users.General;

import java.util.HashMap;

public class Main {
    private static HashMap<Corredor, Double> fees = new HashMap<>(4);
    public static void main(String[] args) {
        initFees();
        new Gui();
        Estudiante newUser = new Estudiante("pepito", "vertiz", "pepitoVertiz@gmail.com", "pepito123");
        System.out.println(newUser.toString());

        General newUser2 = new General("sara", "Ola", "sara@gmail.com, ", "sara123", 70);
        System.out.println(newUser2.toString());

        General newUser3 = new General("Pepita", "Perez", "pepitaperez@gmail.com", "pepitaperez");
        System.out.println(newUser3.toString());

        newUser3.getCard().addBalance(20);

        System.out.println(newUser3.toString());

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


