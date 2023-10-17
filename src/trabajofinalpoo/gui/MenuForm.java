package trabajofinalpoo.gui;

import trabajofinalpoo.UserManager;
import trabajofinalpoo.users.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuForm extends JFrame {
    private JLabel mensajeBienvenida, saldoLabel, saldo,
            tarjetaLabel, tarjeta;

    private JButton bottonMagico;
    public MenuForm(Usuario usuario) {
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

        mensajeBienvenida = new JLabel("¡Bienvenido de vuelta, " +
                usuario.getName()+"! ");
        mensajeBienvenida.setFont(new Font("Arial", Font.BOLD, 25));
        mensajeBienvenida.setForeground(new Color(222, 219, 219));
        mensajeBienvenida.setBounds(30, 5, 400, 60);

        saldo = new JLabel("Saldo: ");
        saldoLabel = new JLabel(String.valueOf(usuario.getCard().getBalance()));
        saldo.setFont(font);
        saldoLabel.setFont(font);
        saldo.setBounds(30, 60, 100, 30);
        saldoLabel.setBounds(100, 60, 100, 30);
        saldo.setForeground(fontColor);
        saldoLabel.setForeground(fontColor);

        tarjeta = new JLabel("Tarjeta: ");
        tarjetaLabel = new JLabel(usuario.getClass().getSimpleName());
        tarjeta.setFont(font);
        tarjetaLabel.setFont(font);
        tarjeta.setBounds(30, 90, 100, 30);
        tarjetaLabel.setBounds(120, 90, 220, 30);
        tarjeta.setForeground(fontColor);
        tarjetaLabel.setForeground(fontColor);

        bottonMagico = new JButton("Botón mágico");
        bottonMagico.setFont(font);
        bottonMagico.setBounds(30, 130, 150, 30);
        bottonMagico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Usuario persona = UserManager.getUser(usuario.getEmail(), usuario.getPassword());
                    persona.getCard().addBalance(10);
                    saldoLabel.setText(String.valueOf(usuario.getCard().getBalance()));

                } catch (RuntimeException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });



        super.add(mensajeBienvenida);
        super.add(saldo);
        super.add(saldoLabel);
        super.add(tarjeta);
        super.add(tarjetaLabel);
        super.add(bottonMagico);
        super.setVisible(true);


    }

}
