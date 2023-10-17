package trabajofinalpoo.users;

public class General extends Usuario {
    public General(String name, String lastname, String email, String password) {
        super(name, lastname, email, password);
    }
    public General(String name, String lastname, String email, String password, double balance) {
        super(name, lastname, email, password, balance);
    }
}
