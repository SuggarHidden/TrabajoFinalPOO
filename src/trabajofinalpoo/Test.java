package trabajofinalpoo;

import trabajofinalpoo.gui.MenuForm;

public class Test {
    public static void main(String[] args) {
        UserManager.setTarifas();
        UserManager.cargarUsuarios();
        MenuForm loginForm = new MenuForm(UserManager.getUser("admin", "admin"));

    }
}
