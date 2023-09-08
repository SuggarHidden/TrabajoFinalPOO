package trabajofinalpoo.gui;

import javax.swing.*;
import java.awt.*;

public class FrameMain extends JFrame {
    public FrameMain() {
        ImageIcon icono = new ImageIcon(getClass().getResource("logo.png"));
        Color fondoMenu = new Color(5, 56, 119);
            super.setTitle("Nombre de la app");
            super.setSize(500, 720);
            super.setResizable(false);
            super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            super.setIconImage(icono.getImage());
            super.getContentPane().setBackground(fondoMenu);

            super.setVisible(true);


    }

}
