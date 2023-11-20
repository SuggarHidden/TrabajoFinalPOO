package trabajofinalpoo.gui;

import trabajofinalpoo.users.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuForm extends JFrame {
    private JLabel mensajeBienvenida, saldoLabel, saldo,
            tarjetaLabel, tarjeta;
    private JPanel panel, panelRecarga;
    private Color botonesColor;
    private Font font;
    private Color fontColor, fondoMenu;

    private JButton buttonRecargar, buttonViaje, buttonHistorial, buttonCerrarSesion;
    public MenuForm(Usuario usuario) {
        build();

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

        botonesColor = new Color(26, 12, 147);

        panel = new JPanel();
        panel.setBackground(new Color(7, 51, 105));
        panel.setBounds(0, 190, 500, 300);
        panel.setLayout(null);

        ImageIcon iconPath1 = new ImageIcon(getClass().getResource("dinero.png"));
        Image iconScaled1 = iconPath1.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon icon1 = new ImageIcon(iconScaled1);
        buttonRecargar = new JButton("Añadir saldo", icon1);
        buttonRecargar.setFont(font);
        buttonRecargar.setBounds(30, 10, 250, 60);
        buttonRecargar.setHorizontalTextPosition(JButton.RIGHT);
        buttonRecargar.setHorizontalAlignment(JButton.LEFT);
        buttonRecargar.setFocusable(false);
        buttonRecargar.setBackground(botonesColor);
        buttonRecargar.setBorderPainted(false);
        buttonRecargar.setForeground(Color.WHITE);

        ImageIcon iconPath2 = new ImageIcon(getClass().getResource("bus.png"));
        Image iconScaled2 = iconPath2.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        ImageIcon icon2 = new ImageIcon(iconScaled2);
        buttonViaje = new JButton("Viaje", icon2);
        buttonViaje.setFont(font);
        buttonViaje.setBounds(30, 80, 250, 60);
        buttonViaje.setHorizontalTextPosition(JButton.RIGHT);
        buttonViaje.setHorizontalAlignment(JButton.LEFT);
        buttonViaje.setFocusable(false);
        buttonViaje.setBackground(botonesColor);
        buttonViaje.setBorderPainted(false);
        buttonViaje.setForeground(Color.WHITE);


        ImageIcon iconPath3 = new ImageIcon(getClass().getResource("historial.png"));
        Image iconScaled3 = iconPath3.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        ImageIcon icon3 = new ImageIcon(iconScaled3);
        buttonHistorial = new JButton(" Historial", icon3);
        buttonHistorial.setFont(font);
        buttonHistorial.setBounds(30, 150, 250, 60);
        buttonHistorial.setHorizontalTextPosition(JButton.RIGHT);
        buttonHistorial.setHorizontalAlignment(JButton.LEFT);
        buttonHistorial.setFocusable(false);
        buttonHistorial.setBackground(botonesColor);
        buttonHistorial.setBorderPainted(false);
        buttonHistorial.setForeground(Color.WHITE);


        ImageIcon iconPath4 = new ImageIcon(getClass().getResource("user.png"));
        Image iconScaled4 = iconPath4.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        ImageIcon icon4 = new ImageIcon(iconScaled4);
        buttonCerrarSesion = new JButton("Cerrar sesión", icon4);
        buttonCerrarSesion.setFont(font);
        buttonCerrarSesion.setBounds(30, 220, 250, 60);
        buttonCerrarSesion.setHorizontalTextPosition(JButton.RIGHT);
        buttonCerrarSesion.setHorizontalAlignment(JButton.LEFT);
        buttonCerrarSesion.setFocusable(false);
        buttonCerrarSesion.setBackground(botonesColor);
        buttonCerrarSesion.setBorderPainted(false);
        buttonCerrarSesion.setForeground(Color.WHITE);


        panel.add(buttonRecargar);
        panel.add(buttonViaje);
        panel.add(buttonHistorial);
        panel.add(buttonCerrarSesion);
        super.add(panel);
        super.add(mensajeBienvenida);
        super.add(saldo);
        super.add(saldoLabel);
        super.add(tarjeta);
        super.add(tarjetaLabel);
        listeners();
        super.setVisible(true);
    }
    public void build() {
        ImageIcon icono = new ImageIcon(getClass().getResource("logo.png"));
        fondoMenu = new Color(7, 51, 105);
        fontColor = new Color(246, 243, 243);
        font = new Font("Monospaced", Font.PLAIN, 16);
        super.setTitle("Nombre de la app");
        super.setSize(500, 720);
        super.setResizable(false);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setIconImage(icono.getImage());
        super.getContentPane().setBackground(fondoMenu);
        super.setLayout(null);

    }

    public void listeners() {
        buttonRecargar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                panelRecarga = new JPanel();
                panelRecarga.setBackground(new Color(6, 65, 138));
                panelRecarga.setBounds(0, 190, 500, 300);
                panelRecarga.setLayout(null);

                JLabel labelRecarga = new JLabel("Monto a recargar:");
                labelRecarga.setFont(font);
                labelRecarga.setBounds(30, 10, 250, 60);
                labelRecarga.setForeground(Color.WHITE);

                JTextField montoRecarga = new JTextField();
                montoRecarga.setFont(font);
                montoRecarga.setBounds(30, 80, 250, 40);
                montoRecarga.setBackground(Color.WHITE);

                JButton buttonRecargar = new JButton("Recargar");
                buttonRecargar.setFont(font);
                buttonRecargar.setBounds(30, 150, 250, 60);
                buttonRecargar.setHorizontalTextPosition(JButton.RIGHT);
                buttonRecargar.setHorizontalAlignment(JButton.LEFT);
                buttonRecargar.setFocusable(false);
                buttonRecargar.setBackground(botonesColor);
                buttonRecargar.setBorderPainted(false);
                buttonRecargar.setForeground(Color.WHITE);

                JButton buttonCancelar = new JButton("Cancelar");
                buttonCancelar.setFont(font);
                buttonCancelar.setBounds(30, 220, 250, 60);
                buttonCancelar.setHorizontalTextPosition(JButton.RIGHT);
                buttonCancelar.setHorizontalAlignment(JButton.LEFT);
                buttonCancelar.setFocusable(false);
                buttonCancelar.setBackground(botonesColor);
                buttonCancelar.setBorderPainted(false);
                buttonCancelar.setForeground(Color.WHITE);

                panelRecarga.add(montoRecarga);
                panelRecarga.add(labelRecarga);
                panelRecarga.add(buttonRecargar);
                panelRecarga.add(buttonCancelar);
                MenuForm.super.add(panelRecarga);
                panelRecarga.setVisible(true);
            }
        });

        buttonViaje.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        buttonHistorial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        buttonCerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int resultado = JOptionPane.showConfirmDialog(null, "¿Estás seguro de cerrar sesión?", "Cerrar sesión", JOptionPane.YES_NO_OPTION);
                if (resultado == JOptionPane.YES_OPTION) {
                    MenuForm.super.dispose();
                    new LoginForm();
                } else {
                }
            }
        });

    }

}
