
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
        new LoginForm();
        loadUsers();
        users.forEach((s, general) -> {
            if(general instanceof Estudiante) general.getCard().addBalance(20.0);
        });
        saveUsers();
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

    public static void loadUsers(){
        try {
            String packageName = Main.class.getPackage().getName();
            String filePath = packageName.replace(".", "/") + "/users.txt";
            InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(filePath);

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void saveUsers(){
        try {
            String packageName = Main.class.getPackage().getName();
            String filePath = packageName.replace(".", "/") + "/src/"+packageName+"/users.txt";
            File file = new File(filePath);

            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            users.forEach((s, general) -> {
                try {
                    String userInfo = "general " + general.getName() + " " + general.getLastname() + " "
                            + general.getEmail() + " " + general.getPassword() + " " + general.getCard().getBalance();
                    if(general instanceof Estudiante){
                        userInfo = "estudiante " + general.getName() + " " + general.getLastname()
                                + " " + general.getEmail() + " " + general.getPassword() + " " + general.getCard().getBalance();
                    }
                    writer.write(userInfo);
                    writer.newLine();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addUser(General general){
        users.put(general.getEmail(), general);

        String packageName = Main.class.getPackage().getName();
        String filePath = packageName.replace(".", "/") + "/src/"+packageName+"/users.txt";
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
        System.out.println("usuario añadido");


    }


}


