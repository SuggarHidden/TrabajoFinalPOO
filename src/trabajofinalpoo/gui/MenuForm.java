package trabajofinalpoo.gui;

import trabajofinalpoo.enums.Corredor;
import trabajofinalpoo.users.General;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static trabajofinalpoo.UserManager.updateUser;

public class MenuForm extends JFrame {
    private JLabel mensajeBienvenida, saldoLabel, saldo,
            tarjetaLabel, tarjeta;
    private JPanel panel, panelRecarga, panelBus, panelViaje, panelHistorial;
    private Color botonesColor;
    private Font font;
    private Color fontColor, fondoMenu;
    private General usuario;
    private JButton buttonRecargar, buttonViaje, buttonHistorial, buttonCerrarSesion;
    private ImageIcon busIcon;
    public MenuForm(General usuario) {
        this.usuario = usuario;
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
        Color panelBackGround = new Color(6, 65, 138);

        ImageIcon iconPath5 = new ImageIcon(getClass().getResource("bus.png"));
        Image iconScaled5 = iconPath5.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        busIcon = new ImageIcon(iconScaled5);

        panelRecarga = new JPanel();
        panelRecarga.setBackground(panelBackGround);
        panelRecarga.setBounds(0, 190, 500, 300);
        panelRecarga.setLayout(null);

        panelBus = new JPanel();
        panelBus.setBackground(panelBackGround);
        panelBus.setLayout(null);
        panelBus.setBounds(0, 190, 500, 400);

        panelHistorial = new JPanel();
        panelHistorial.setBackground(panelBackGround);
        panelHistorial.setBounds(0, 190, 500, 400);
        panelHistorial.setLayout(null);

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

                buttonCancelar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        panelRecarga.setVisible(false);
                        panel.setVisible(true);
                    }
                });

                buttonRecargar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            double cantidad = Double.parseDouble(montoRecarga.getText());
                            usuario.getCard().addBalance(cantidad);
                            updateUser(usuario);
                            JOptionPane.showMessageDialog(null, "Saldo actualizado exitosamente.");
                            saldoLabel.setText(String.valueOf(usuario.getCard().getBalance()));
                            panelRecarga.setVisible(false);
                            panel.setVisible(true);

                        } catch (RuntimeException re) {
                            JOptionPane.showMessageDialog(null, re.getMessage());
                            System.out.println(re.getMessage());
                        }


                    }
                });

            }
        });

        buttonViaje.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);

                JButton busAzul = new JButton();
                busAzul.setName("AZUL");
                busAzul.setBackground(new Color(22, 32, 215));
                busAzul.setBounds(0, 0, 250, 150);
                busAzul.setIcon(busIcon);
                busAzul.setFocusable(false);
                busAzul.setBorderPainted(false);

                JButton busRojo = new JButton();
                busRojo.setName("ROJO");
                busRojo.setBackground(new Color(239, 16, 16));
                busRojo.setBounds(250,0, 250,150);
                busRojo.setIcon(busIcon);
                busRojo.setFocusable(false);
                busRojo.setBorderPainted(false);

                JButton busAmarillo = new JButton();
                busAmarillo.setName("AMARILLO");
                busAmarillo.setBackground(new Color(224, 250, 14));
                busAmarillo.setBounds(0,150, 250,150);
                busAmarillo.setIcon(busIcon);
                busAmarillo.setFocusable(false);
                busAmarillo.setBorderPainted(false);

                JButton busMorado = new JButton();
                busMorado.setName("MORADO");
                busMorado.setBackground(new Color(122, 0, 227));
                busMorado.setBounds(250,150, 250,150);
                busMorado.setIcon(busIcon);
                busMorado.setFocusable(false);
                busMorado.setBorderPainted(false);


                JButton cancelarBoton = new JButton("Cancelar");
                cancelarBoton.setFont(font);
                cancelarBoton.setHorizontalTextPosition(JButton.RIGHT);
                cancelarBoton.setHorizontalAlignment(JButton.LEFT);
                cancelarBoton.setFocusable(false);
                cancelarBoton.setBackground(botonesColor);
                cancelarBoton.setBorderPainted(false);
                cancelarBoton.setForeground(Color.WHITE);
                cancelarBoton.setBounds(0, 320, 250, 60);
                cancelarBoton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        panelBus.setVisible(false);
                        panel.setVisible(true);
                    }
                });

                ActionListener boton = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        try {
                            JButton botonClickeado = (JButton) e.getSource();
                            String nombreBoton = botonClickeado.getName();
                            System.out.println(nombreBoton);
                            usuario.getCard().hacerPago(Corredor.valueOf(nombreBoton));
                            updateUser(usuario);
                            saldoLabel.setText(String.valueOf(usuario.getCard().getBalance()));
                            JOptionPane.showMessageDialog(null, "Viaje pagado exitosamente.");
                            panelBus.setVisible(false);
                            panel.setVisible(true);
                        } catch (RuntimeException re) {
                            JOptionPane.showMessageDialog(null, re.getMessage());
                        }
                    }
                };

                busAzul.addActionListener(boton);
                busMorado.addActionListener(boton);
                busAmarillo.addActionListener(boton);
                busRojo.addActionListener(boton);


                panelBus.add(busAzul);
                panelBus.add(busRojo);
                panelBus.add(busAmarillo);
                panelBus.add(busMorado);
                panelBus.add(cancelarBoton);
                MenuForm.super.add(panelBus);
                panelBus.setVisible(true);



            }
        });

        buttonHistorial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                DefaultListModel<Object> modelo = new DefaultListModel<>();
                JList<Object> list = new JList<>(modelo);
                list.setBounds(0, 0, 500, 300);
                list.setFont(font);
                list.setBackground(new Color(131, 186, 255));
                list.setForeground(Color.WHITE);

                // simulación
                modelo.add(0, "Viaje: Azul");
                modelo.add(1, "Viaje: Morado");
                modelo.add(2, "Viaje: Amarillo");
                modelo.add(3, "Viaje: Rojo");
                modelo.add(4, "Viaje: Azul");

                /*
                int n = 0;
                usuario.getHistorial().forEach((bus, costo, fecha) -> {
                    modelo.add(n, bus + " " + costo + " " + fecha);
                    n++;
                 */

                JScrollPane scrollLista = new JScrollPane(list);
                scrollLista.setBounds(0, 0, 500, 300);
                scrollLista.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                scrollLista.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);


                JButton buttonRetroceder = new JButton("Retroceder");
                buttonRetroceder.setFont(font);
                buttonRetroceder.setBounds(0, 320, 250, 60);
                buttonRetroceder.setHorizontalTextPosition(JButton.RIGHT);
                buttonRetroceder.setHorizontalAlignment(JButton.LEFT);
                buttonRetroceder.setFocusable(false);
                buttonRetroceder.setBackground(botonesColor);
                buttonRetroceder.setBorderPainted(false);
                buttonRetroceder.setForeground(Color.WHITE);

                buttonRetroceder.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        panelHistorial.setVisible(false);
                        panel.setVisible(true);
                    }
                });

                panelHistorial.add(list);
                panelHistorial.add(scrollLista);
                panelHistorial.add(buttonRetroceder);
                MenuForm.super.add(panelHistorial);
                panelHistorial.setVisible(true);
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
