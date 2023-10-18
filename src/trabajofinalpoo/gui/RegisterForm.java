package trabajofinalpoo.gui;

import trabajofinalpoo.UserManager;
import trabajofinalpoo.users.General;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterForm extends JFrame {
    private JLabel nombre, apellido, correo, contrasena, confirmarContrasena, titulo;
    private JTextField nombreField, apellidoField, correoField;
    private JPasswordField contrasenaField, confirmarContrasenaField;
    private JButton registerButton, atrasButton;
    public RegisterForm () {
        ImageIcon icono = new ImageIcon(getClass().getResource("logo.png"));
        Color fondoMenu = new Color(6, 65, 138);
        Font font = new Font("Arial", Font.BOLD, 14);
        super.setTitle("Nombre de la app");
        super.setSize(500, 620);
        super.setResizable(false);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setIconImage(icono.getImage());
        super.getContentPane().setBackground(fondoMenu);
        super.setLayout(null);
        build();
        registerButton = new JButton("Registrarse");
        registerButton.setFont(font);
        registerButton.setBounds(50, 420, 150, 30);
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!nombreField.getText().isEmpty() && !apellidoField.getText().isEmpty() &&
                            !correoField.getText().isEmpty() && !contrasenaField.getText().isEmpty() &&
                            !confirmarContrasenaField.getText().isEmpty()) {
                        if (contrasenaField.getText().equals(confirmarContrasenaField.getText())) {
                            UserManager.updateUser(new General(nombreField.getText(), apellidoField.getText(), correoField.getText(), contrasenaField.getText(), 0));
                            JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente");
                            RegisterForm.super.dispose();
                            new LoginForm();
                        } else {
                            JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden)");
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Campos sin llenar");
                    }
                }
                catch (RuntimeException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }

            }
        });

        atrasButton = new JButton("Retroceder");
        atrasButton.setFont(font);
        atrasButton.setBounds(250, 420, 150, 30);
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegisterForm.super.dispose();
                new LoginForm();
            }
        });


        super.add(nombre);
        super.add(apellido);
        super.add(correo);
        super.add(contrasena);
        super.add(confirmarContrasena);
        super.add(nombreField);
        super.add(correoField);
        super.add(apellidoField);
        super.add(contrasenaField);
        super.add(confirmarContrasenaField);
        super.add(titulo);
        super.add(registerButton);
        super.add(atrasButton);
        super.setVisible(true);

    }

    public void build() {
        Font font = new Font("Arial", Font.BOLD, 14);

        Color fontColor = new Color(246, 243, 243);
        titulo = new JLabel("Regístrate");
        titulo.setFont(new Font("Arial", Font.BOLD , 35));
        titulo.setBounds(50, 5, 400, 100);
        titulo.setForeground(fontColor);
        nombre = new JLabel("Nombre");
        nombre.setFont(font);
        nombre.setBounds(50, 100, 100, 30);
        nombre.setForeground(fontColor);
        nombreField = new JTextField();
        nombreField.setBounds(50, 130, 300, 30);


        apellido = new JLabel("Apellido");
        apellido.setFont(font);
        apellido.setBounds(50, 160, 100, 30);
        apellido.setForeground(fontColor);
        apellidoField = new JTextField();
        apellidoField.setBounds(50, 190, 300, 30);

        correo = new JLabel("Correo");
        correo.setFont(font);
        correo.setBounds(50, 220, 100, 30);
        correo.setForeground(fontColor);
        correoField = new JTextField();
        correoField.setBounds(50, 250, 300, 30);

        contrasena = new JLabel("Contraseña");
        contrasena.setFont(font);
        contrasena.setBounds(50, 280, 100, 30);
        contrasena.setForeground(fontColor);
        contrasenaField = new JPasswordField();
        contrasenaField.setBounds(50, 310, 300, 30);
        confirmarContrasena = new JLabel("Confirmar contraseña");
        confirmarContrasena.setFont(font);
        confirmarContrasena.setBounds(50, 340, 200, 30);
        confirmarContrasena.setForeground(fontColor);
        confirmarContrasenaField = new JPasswordField();
        confirmarContrasenaField.setBounds(50, 370, 300, 30);

    }

}

