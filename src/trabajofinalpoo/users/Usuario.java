package trabajofinalpoo.users;

import trabajofinalpoo.Tarjeta;
import trabajofinalpoo.enums.Corredor;
import trabajofinalpoo.enums.HistorialActionType;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public abstract class Usuario {
    private UUID id;
    private String name, lastname, email, password;
    private Tarjeta tarjeta;
    private List<String> historial = new ArrayList<>();
    public Usuario(UUID id, String name, String lastname, String email, String password) {
        this.id = id;
            this.name = name;
            this.lastname = lastname;
            this.email = email;
            this.password = password;
        }
    public Usuario(UUID id, String name, String lastname, String email, String password, double balance) {
      this(id, name, lastname, email, password);
        this.tarjeta = new Tarjeta(balance);
    }

    @Override
    public String toString() {
        return  "Nombre: '" + name + '\'' +
                ", Apellido: '" + lastname + '\'' +
                ", Correo: '" + email + '\'' +
                ", Contraseña: '" + password + '\'' +
                ", ID: '" + id + '\'' +
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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<String> getHistorial() {
        return historial;
    }

    public void setHistorial(List<String> historial) {
        this.historial = historial;
    }

    public void deserializar(String file) {
        List<String> listaDeserializada = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            listaDeserializada = (List<String>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            setHistorial(listaDeserializada);
        }
        setHistorial(listaDeserializada);
    }

    public void addHistorial(HistorialActionType type, String extra){
        getHistorial().add(type.toString() + "-" + new Date().toString() + "-" +  extra);
    }
    public void setCard(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }
}
