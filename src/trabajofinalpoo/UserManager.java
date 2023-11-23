package trabajofinalpoo;

import trabajofinalpoo.enums.Corredor;
import trabajofinalpoo.users.Estudiante;
import trabajofinalpoo.users.General;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserManager {
    private static HashMap<Corredor, Double> fees = new HashMap<>(4);
    private static HashMap<String, General> users = new HashMap<>();

    private static final List<String> universidadesPermitidas = Arrays.asList("utp.edu.pe", "upc.edu.pe", "utec.edu.pe");

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
            // Crear el archivo si no existe
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] info = line.split(" ");
                if(info[0].equals("estudiante") ){
                    Estudiante sdt = new Estudiante(UUID.fromString(info[1]), info[2], info[3], info[4], info[5], Double.valueOf(info[6]));
                    sdt.deserializar( "src/trabajofinalpoo/data/"+sdt.getId()+".txt");
                    users.put(info[4],sdt );
                }
                if(info[0].equals("general") ){
                    General gnrl = new General(UUID.fromString(info[1]), info[2], info[3], info[4], info[5], Double.valueOf(info[6]));
                    gnrl.deserializar("src/trabajofinalpoo/data/"+gnrl.getId()+".txt");
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
        String dataPath = "src/trabajofinalpoo/data/";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dataPath+general.getId()+".txt"))) {
            oos.writeObject(general.getHistorial());
        } catch (FileNotFoundException f){
            new File(dataPath).mkdirs();
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dataPath + general.getId() + ".txt"))) {
                oos.writeObject(general.getHistorial());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(general instanceof Estudiante);
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

    public static boolean registerUser(String nombre, String apellido, String correo, String pass, String confirmPass){
        if (nombre.isEmpty() || apellido.isEmpty() || correo.isEmpty() || pass.isEmpty() || confirmPass.isEmpty()) throw new RuntimeException("Hay campos sin llenar");
        if (!correo.contains("@")|| correo.indexOf('@') == correo.length() - 1) throw new RuntimeException("Por favor ingresa un correo valido!");
        if (users.containsKey(correo)) throw new RuntimeException("Este usuario con ese correo ya existe!");
        if (!pass.equals(confirmPass))  throw new RuntimeException("Las contraseñas no coinciden.");
        String dominioUni = correo.split("@")[1];
        if (universidadesPermitidas.contains(dominioUni)){
            UserManager.updateUser(new Estudiante(UUID.randomUUID(), nombre, apellido, correo, pass, 0));
            return true;
        }
        UserManager.updateUser(new General(UUID.randomUUID(), nombre, apellido, correo, pass, 0));
        return true;
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
