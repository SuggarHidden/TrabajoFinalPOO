package trabajofinalpoo;

public class Tests {
    public static void main(String[] args) {
        Universitario usuario = new Universitario("Lorena", "Kim", "lorenakim@gmail.com",
                "holahola"
        );

        usuario.selectCorredor("rojo");
        System.out.println(usuario.getTarifa());
        System.out.println(usuario.getCorredor());
    }
}
