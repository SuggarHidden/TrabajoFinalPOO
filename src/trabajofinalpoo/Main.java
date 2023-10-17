
package trabajofinalpoo;

import trabajofinalpoo.gui.LoginForm;

public class Main {
    public static void main(String[] args) {
        UserManager.initFees();
        UserManager.loadUsers();
        UserManager.getUsers().forEach( (s, u) -> System.out.println(s+" info "+u));
        new LoginForm();

    }
}


