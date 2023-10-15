package trabajofinalpoo.gui;

import javax.swing.*;
import java.awt.*;

public class MenuForm extends JFrame {

    public MenuForm() {
        ImageIcon icono = new ImageIcon(getClass().getResource("logo.png"));
        Color fondoMenu = new Color(6, 65, 138);
        Color fontColor = new Color(246, 243, 243);
        Font font = new Font("Monospaced", Font.PLAIN, 16);
        super.setTitle("Nombre de la app");
        super.setSize(500, 720);
        super.setResizable(false);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setIconImage(icono.getImage());
        super.getContentPane().setBackground(fondoMenu);
        super.setLayout(null);

        super.setVisible(true);


    }

}
