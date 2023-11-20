package trabajofinalpoo.users;

import trabajofinalpoo.Tarjeta;

public abstract class Usuario {
    private String name, lastname, email, password;
    private Tarjeta tarjeta;
    // private List <String> historial;
    public Usuario(String name, String lastname, String email, String password) {
            this.name = name;
            this.lastname = lastname;
            this.email = email;
            this.password = password;
        }
    public Usuario(String name, String lastname, String email, String password, double balance) {
      this(name, lastname, email, password);
        this.tarjeta = new Tarjeta(balance);
    }

    @Override
    public String toString() {
        return  "Nombre: '" + name + '\'' +
                ", Apellido: '" + lastname + '\'' +
                ", Correo: '" + email + '\'' +
                ", Contraseña: '" + password + '\'' +
                ", Saldo: " + tarjeta.getBalance();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Tarjeta getCard() {
        return tarjeta;
    }

    public void setCard(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }
}
