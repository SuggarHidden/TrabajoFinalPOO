package trabajofinalpoo.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {
    private JLabel titulo, emailLabel, passwordLabel, forgotPasswordLabel;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton, registerButton;

    public LoginForm() {
        ImageIcon icono = new ImageIcon(getClass().getResource("logo.png"));
        Color fondoMenu = new Color(10, 118, 255);
        Font font = new Font("Monospaced", Font.PLAIN, 16);
            super.setTitle("Nombre de la app");
            super.setSize(500, 720);
            super.setResizable(false);
            super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            super.setIconImage(icono.getImage());
            super.getContentPane().setBackground(fondoMenu);
            super.setLayout(null);

            int x = 500;
            int y = 720;
            titulo = new JLabel();

            ImageIcon icono2 = new ImageIcon(getClass().getResource("logoatu.png"));
            Image iconoScaled = icono2.getImage().getScaledInstance(204, 118, Image.SCALE_DEFAULT);
            icono2 = new ImageIcon(iconoScaled);

            titulo.setIcon(icono2);
            titulo.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 70));
            titulo.setForeground(new Color(222, 219, 219));
            titulo.setText("ATU");
            titulo.setHorizontalTextPosition(JLabel.CENTER);

            titulo.setLayout(null);
            titulo.setBounds(x/4, 15, 400, 200);

            int width = 300;

            emailField = new JTextField();
            passwordField = new JPasswordField();
            loginButton = new JButton("Iniciar sesión");
            registerButton = new JButton("Registrarse");
            emailLabel = new JLabel("Correo electrónico:");
            passwordLabel = new JLabel("Contraseña:");
            forgotPasswordLabel = new JLabel("¿Olvidaste tu contraseña?");

            emailLabel.setBounds(x/6, 230, 300, 20);
            emailField.setBounds(x/6, 250, 300, 40);
            passwordLabel.setBounds(x/6, 300, 300, 20);
            passwordField.setBounds(x/6, 320, 300, 40);
            forgotPasswordLabel.setBounds(x/6, 365, 300, 20);

            loginButton.setBounds(width-150, 420, 150, 40);
            registerButton.setBounds(width-150, 475, 150, 40);
            loginButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });
            registerButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    LoginForm.super.dispose();
                    new RegisterForm();
                }
            });
            emailField.setFont(font);
            passwordField.setFont(font);


            super.add(titulo);
            super.add(emailField);
            super.add(passwordField);
            super.add(loginButton);
            super.add(registerButton);
            super.add(emailLabel);
            super.add(passwordLabel);
            super.add(forgotPasswordLabel);

            super.setVisible(true);


    }

}


