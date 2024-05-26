import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Práctica 51. Interfaz Gráfica");
        frame.setSize(700, 430);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.BLACK);
        frame.add(panel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Etiqueta y campo de texto para el usuario
        JLabel userLabel = new JLabel("Usuario:");
        userLabel.setForeground(Color.WHITE); // Cambiar color del texto de la etiqueta
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(userLabel, gbc);

        JTextField userText = new JTextField(20);
        userText.setForeground(Color.GREEN); // Cambiar color del texto
        userText.setBackground(Color.DARK_GRAY); // Asegurar el fondo sea compatible
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(userText, gbc);

        // Etiqueta y campo de texto para la contraseña
        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setForeground(Color.WHITE); // Cambiar color del texto de la etiqueta
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(passwordLabel, gbc);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setForeground(Color.GREEN);
        passwordText.setEchoChar('*'); 
        passwordText.setBackground(Color.DARK_GRAY);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        panel.add(passwordText, gbc);

        // Etiqueta y selector de rol
        JLabel roleLabel = new JLabel("Rol:");
        roleLabel.setForeground(Color.WHITE); 
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(roleLabel, gbc);

        String[] roles = { "Administrador", "Usuario", "Invitado" };
        JComboBox<String> roleComboBox = new JComboBox<>(roles);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel.add(roleComboBox, gbc);

        // Botón de Login
        JButton loginButton = new JButton("Login");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        loginButton.setBackground(Color.BLUE);
        loginButton.setForeground(Color.WHITE);
        panel.add(loginButton, gbc);

        // Espacio entre botones
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        panel.add(Box.createRigidArea(new Dimension(20, 0)), gbc);

        // Botón de Reset
        JButton resetButton = new JButton("Reset");
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        resetButton.setBackground(Color.RED);
        resetButton.setForeground(Color.WHITE);
        panel.add(resetButton, gbc);

        // Acción del botón de Login
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = userText.getText();
                String contraseña = new String(passwordText.getPassword());
                String rol = (String) roleComboBox.getSelectedItem();

                if (!usuario.isEmpty() && !contraseña.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Sesión iniciada con éxito\nUsuario: " + usuario + "\nRol: " + rol);
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese todos los datos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Acción del botón de Reset
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userText.setText("");
                passwordText.setText("");
                roleComboBox.setSelectedIndex(0);
            }
        });

        frame.setVisible(true);
    }
}
