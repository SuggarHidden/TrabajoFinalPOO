package trabajofinalpoo;

import trabajofinalpoo.gui.MenuForm;

public class Test {
    public static void main(String[] args) {
        UserManager.setTarifas();
        UserManager.cargarUsuarios();
        new MenuForm(UserManager.getUser("test2@utp.edu.pe", "password"));
    }
}
