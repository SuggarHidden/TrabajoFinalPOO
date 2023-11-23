package trabajofinalpoo.users;

import java.util.UUID;

public class General extends Usuario {
    public General(UUID id, String name, String lastname, String email, String password) {
        super(id, name, lastname, email, password);
    }
    public General(UUID id, String name, String lastname, String email, String password, double balance) {
        super(id, name, lastname, email, password, balance);
    }
}
