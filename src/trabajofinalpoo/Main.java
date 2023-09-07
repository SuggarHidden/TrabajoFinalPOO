
package trabajofinalpoo;
public class Main {
    public static void main(String[] args) {
        System.out.println("QUIERO DORMIR, yo también");

        Usuario usuario = new Universitario("Lorena", "Kim", "lorenakim@gmail.com",
                "holahola"
        );

        usuario.setCorredor("amarillo");
        System.out.println(usuario.getTarifaInicial());
    }
    
}
