
package trabajofinalpoo;

import trabajofinalpoo.gui.LoginForm;

public class Main {
    public static void main(String[] args) {
        UserManager.setTarifas();
        UserManager.cargarUsuarios();
        UserManager.getUsers().forEach( (s, u) -> System.out.println("\u001B[36m"+ s+"\u001B[31m - \u001B[33m"+u));
        new LoginForm();
    }
}


