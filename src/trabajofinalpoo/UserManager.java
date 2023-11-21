package trabajofinalpoo;

import trabajofinalpoo.enums.Corredor;
import trabajofinalpoo.users.Estudiante;
import trabajofinalpoo.users.General;

import java.io.*;
import java.util.HashMap;
import java.util.UUID;

public class UserManager {
    private static HashMap<Corredor, Double> fees = new HashMap<>(4);
    private static HashMap<String, General> users = new HashMap<>();

    static void setTarifas(){
        fees.put(Corredor.AZUL, 2.20);
        fees.put(Corredor.ROJO, 2.20);
        fees.put(Corredor.MORADO, 2.30);
        fees.put(Corredor.AMARILLO, 2.50);
    }
    public static double getTarifas(Corredor corredor) {
        return fees.get(corredor);
    }

    public static void cargarUsuarios() {
        try {
            String packageName = UserManager.class.getPackageName();
            File file = new File("src/trabajofinalpoo", "users.txt");
            System.out.println(file);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] info = line.split(" ");
                if(info[0].equals("estudiante") ){
                    Estudiante sdt = new Estudiante(UUID.fromString(info[1]), info[2], info[3], info[4], info[5], Double.valueOf(info[6]));
                    String historialFile = "src/trabajofinalpoo/data/"+sdt.getId()+".txt";
                    sdt.deserializar(historialFile);
                    users.put(info[4],sdt );
                    System.out.println(sdt.getId() + "adsa");
                }
                if(info[0].equals("general") ){
                    General gnrl = new General(UUID.fromString(info[1]), info[2], info[3], info[4], info[5], Double.valueOf(info[6]));
                    String historialFile = packageName + "/src/" + packageName + "data/"+gnrl.getId()+".txt";
                    gnrl.deserializar(historialFile);
                    users.put(info[4],gnrl);
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void updateUser(General general){
        boolean appendToFile = !users.containsKey(general.getEmail());
        users.put(general.getEmail(), general);
        File file = new File("src/trabajofinalpoo", "users.txt");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/trabajofinalpoo/data/"+general.getId()+".txt"))) {
            oos.writeObject(general.getHistorial());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, appendToFile));
            if (appendToFile){
                System.out.println("Añadiendo nuevo usuario al archivo.");
                String userInfo = "general " +  general.getId() + " " + general.getName() + " " + general.getLastname() + " " +
                        general.getEmail() + " "
                        + general.getPassword() + " " + general.getCard().getBalance();
                if (general instanceof Estudiante)
                    userInfo = "estudiante " +general.getId() + " " + general.getName() + " " + general.getLastname() + " " +
                            general.getEmail() + " " + general.getPassword() + " " + general.getCard()
                            .getBalance();
                writer.write(userInfo);
                writer.newLine();
                writer.close();
            } else {
                System.out.println("Guardando todos los usuarios a la lista.");
                users.forEach((s, g) -> {
                    try {
                        String userInfo = "general " + g.getId() + " " + g.getName() + " " + g.getLastname() + " " + g.getEmail() + " " +
                                g.getPassword() + " " + g.getCard().getBalance();
                        if(g instanceof Estudiante){
                            userInfo = "estudiante " + g.getId() + " " +  g.getName() + " " + g.getLastname() + " " + g.getEmail() + " "
                                    + g.getPassword() + " " + g.getCard().getBalance();
                        }
                        writer.write(userInfo);
                        writer.newLine();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static General getUser(String correo, String contrasena){
        if(users.containsKey(correo)){
            General usuario = users.get(correo);
            if(!(usuario.getPassword().equals(contrasena))){
                throw new RuntimeException("Contraseña incorrecta");
            }
            return usuario;
        } else if (correo.isEmpty() || contrasena.isEmpty()){
            throw new RuntimeException("Hay campos sin llenar");
        } else {
            throw new RuntimeException("Usuario no encontrado");
        }
    }

    public static HashMap<String, General> getUsers() {
        return users;
    }
}
