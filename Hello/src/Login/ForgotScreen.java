package Login;

import javax.swing.*;
import java.awt.*;

public class ForgotScreen extends JLogin {

    private static final long serialVersionUID = 1L;
    private JPasswordField confirmPasswordField;

    public ForgotScreen(String title) {
        super(title);
        
        ImageIcon backIcon = new ImageIcon(getClass().getResource("/icons/seta-left-icon.png"));
        Image backImg = backIcon.getImage();
        Image scaledBackImg = backImg.getScaledInstance(20, 20, Image.SCALE_SMOOTH); // Redimensiona para 30x30
        backIcon = new ImageIcon(scaledBackImg);

        JButton backButton = new JButton();
        backButton.setIcon(backIcon);
        backButton.setFocusPainted(false);
        backButton.setContentAreaFilled(false); // Remove o fundo do botão
        backButton.setBorderPainted(false); // Remove as bordas do botão
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cursor de mão ao passar sobre o botão

        // Adiciona o botão ao topo da janela
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST; // Alinha o botão à esquerda
        getContentPane().add(backButton, gbc);

        // Evento de clique para voltar à tela de login
        backButton.addActionListener(e -> {
            dispose(); // Fecha a tela de "Esqueci senha"
            JLogin loginFrame = new JLogin("Login");
            loginFrame.setVisible(true); // Reabre a tela de login
        });

        // Modifica o layout para adicionar o campo de confirmação de senha
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        getContentPane().add(new JLabel("Confirm Password:"), gbc);

        confirmPasswordField = new JPasswordField(15);
        confirmPasswordField.setFont(new Font("Arial", Font.PLAIN, 14));
        confirmPasswordField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        getContentPane().add(confirmPasswordField, gbc);

        // Modifica o texto do botão de login para "Reset Password"
        JButton btnReset = new JButton("Reset Password");
        btnReset.setFocusPainted(false);
        btnReset.setBackground(new Color(51, 153, 255));
        btnReset.setForeground(Color.WHITE);
        btnReset.setFont(new Font("Arial", Font.BOLD, 14));
        btnReset.setCursor(new Cursor(Cursor.HAND_CURSOR));

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        getContentPane().add(btnReset, gbc);

        //Remove os campos desnecessários
        getContentPane().remove(6);
        getContentPane().remove(5);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ForgotScreen frame = new ForgotScreen("Forgot Password");
            frame.setVisible(true);
        });
    }
}