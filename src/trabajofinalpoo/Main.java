
package trabajofinalpoo;

import trabajofinalpoo.enums.Corredor;
import trabajofinalpoo.gui.LoginForm;
import trabajofinalpoo.users.Estudiante;
import trabajofinalpoo.users.General;

import java.io.*;
import java.util.HashMap;

public class Main {
    private static HashMap<Corredor, Double> fees = new HashMap<>(4);
    private static HashMap<String, General> users = new HashMap<>();
    public static void main(String[] args) {
        initFees();
        loadUsers();
        new LoginForm();

    }
    private static void initFees(){
        fees.put(Corredor.AZUL, 2.20);
        fees.put(Corredor.ROJO, 2.20);
        fees.put(Corredor.MORADO, 2.30);
        fees.put(Corredor.AMARILLO, 2.50);
    }
    public static double getFees(Corredor corredor){
        return fees.get(corredor);
    }

    public static void loadUsers() {
        try {
            String packageName = Main.class.getPackageName();
            File file = new File(packageName + "/src/" + packageName + "/users.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] info = line.split(" ");
                if(info[0].equals("estudiante") ){
                    users.put(info[3], new Estudiante(info[1], info[2], info[3], info[4], Double.valueOf(info[5])));
                } else {
                    users.put(info[3], new General(info[1], info[2], info[3], info[4], Double.valueOf(info[5])));
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addUser(General general){
        if (users.containsKey(general.getEmail())){
            throw new RuntimeException("El usuario ya existe");
        } else {
            users.put(general.getEmail(), general);
            String packageName = Main.class.getPackage().getName();
            String filePath = packageName + "/src/"+packageName+"/users.txt";
            File file = new File(filePath);
            try {
                System.out.println("añadiendo nueva linea");
                BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
                String userInfo = "general " + general.getName() + " " + general.getLastname() + " " + general.getEmail() + " "
                        + general.getPassword() + " " + general.getCard().getBalance();
                writer.write(userInfo);
                writer.newLine();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("usuario añadido");
    }

    public static General getUser(String correo, String contrasena){
        if(users.containsKey(correo)){
            General general = users.get(correo);
            if(!(general.getPassword().equals(contrasena))){
                throw new RuntimeException("Contraseña incorrecta");
            }
            return general;
        } else if (correo.isEmpty() || contrasena.isEmpty()){
            throw new RuntimeException("Hay campos sin llenar");
        } else {
            throw new RuntimeException("Usuario no encontrado");
        }
    }

    public static void saveUser(General general) {

    }



}


