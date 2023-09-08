package trabajofinalpoo.gui;

import javax.swing.*;
import java.awt.*;

public class Gui {
    public Gui() {
        FrameMain frame = new FrameMain();
        JLabel titulo = new JLabel();

        ImageIcon icono = new ImageIcon(getClass().getResource("logoatu.png"));
        Image iconoScaled = icono.getImage().getScaledInstance(204, 118, Image.SCALE_DEFAULT);
        icono = new ImageIcon(iconoScaled);
        titulo.setIcon(icono);

        titulo.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 70));
        titulo.setForeground(new Color(222, 219, 219));
        titulo.setText("ATU");
        titulo.setHorizontalTextPosition(JLabel.CENTER);
        /*
        titulo.setOpaque(true);
        titulo.setBackground(new Color(231, 235, 238));
        titulo.setBounds(0, 0, 0, 0);
        */
        titulo.setHorizontalAlignment(JLabel.CENTER);
        titulo.setVerticalAlignment(JLabel.TOP);
        titulo.setBorder(BorderFactory.createLineBorder(new Color(231, 235, 238), 2));

        frame.add(titulo);
        frame.setVisible(true);
    }

}
