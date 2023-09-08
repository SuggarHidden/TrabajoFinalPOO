package trabajofinalpoo;
public abstract class Usuario {
    private String nombre;
    private String apellidos;
    private String email;
    private String contraseña;
    private double tarifaInicial;
    private Corredor corredor;
    public Usuario(String nombre, String apellidos, String email, String contraseña) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.contraseña = contraseña;
    }

    public void setCorredor(String tipo) {
        corredor = new Corredor(tipo);
        switch (tipo) {
            case "rojo":
                tarifaInicial = 2.20;
                break;
            case "azul":
                tarifaInicial = 2.20;
                break;
            case "morado":
                tarifaInicial = 2.30;
                break;
            case "amarillo":
                tarifaInicial = 2.50;
                break;
        }
    }
    public String getCorredor() {
        return corredor.getTipo();
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getContraseña() {
        return contraseña;
    }
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public double getTarifaInicial() {
        return tarifaInicial;
    }
    public abstract void selectCorredor(String tipo);
}
