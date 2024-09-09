package Login;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class JLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
    private JPasswordField passwordField;

    public JLogin(String title) {
        super(title);

        // Configurações da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 350); // Tamanho da janela
        setResizable(false);
        setLocationRelativeTo(null); // Centraliza a janela na tela

        // Configura o contentPane com GridBagLayout para centralização
        JPanel contentPane = new JPanel(new GridBagLayout());
        contentPane.setBackground(new Color(245, 245, 245)); // Cor de fundo suave
        contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
        setContentPane(contentPane);

        // GridBagConstraints para centralizar o painel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Espaçamento entre componentes

        // Centralizando a logo
        JLabel logoLabel = new JLabel();
        ImageIcon logoIcon = new ImageIcon(getClass().getResource("/icons/eagle-logo.png"));
        Image img = logoIcon.getImage();
        Image scaledImage = img.getScaledInstance(120, 80, Image.SCALE_SMOOTH); // Escala o ícone
        logoIcon = new ImageIcon(scaledImage);
        logoLabel.setIcon(logoIcon);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Ocupa duas colunas
        gbc.anchor = GridBagConstraints.CENTER; // Centraliza
        gbc.fill = GridBagConstraints.NONE; // Não expande o componente
        contentPane.add(logoLabel, gbc);

        // Campo de usuário
        gbc.gridwidth = 1; // Define uma coluna
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST; // Alinha à direita
        contentPane.add(new JLabel("User:"), gbc);

        textField = new JTextField(15);
        textField.setFont(new Font("Arial", Font.PLAIN, 14)); // Fonte personalizada
        textField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1)); // Borda leve

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST; // Alinha à esquerda
        contentPane.add(textField, gbc);

        // Campo de senha
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST; // Alinha à direita
        contentPane.add(new JLabel("Password:"), gbc);

        passwordField = new JPasswordField(15);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 14)); // Fonte personalizada
        passwordField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1)); // Borda leve

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST; // Alinha à esquerda
        contentPane.add(passwordField, gbc);

        // "Esqueci minha senha" como um JLabel
        JLabel forgotPasswordLabel = new JLabel("Forgot password?");
        forgotPasswordLabel.setForeground(Color.BLUE.darker());
        forgotPasswordLabel.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Muda o cursor ao passar
        forgotPasswordLabel.setFont(new Font("Arial", Font.PLAIN, 12));

        // Evento de clique no "Esqueci minha senha"
        forgotPasswordLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                dispose();
            	JLogin forgot = new ForgotScreen("Forgot Password");
            	forgot.setVisible(true);
            }

            public void mouseEntered(java.awt.event.MouseEvent e) {
                forgotPasswordLabel.setForeground(Color.BLUE); // Destaca o texto ao passar o mouse
            }

            public void mouseExited(java.awt.event.MouseEvent e) {
                forgotPasswordLabel.setForeground(Color.BLUE.darker()); // Volta ao normal quando o mouse sai
            }
        });

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST; // Alinha à esquerda
        contentPane.add(forgotPasswordLabel, gbc);

        // Botão de login
        JButton btnLogin = new JButton("Enter");
        btnLogin.setFocusPainted(false); // Remove o destaque ao clicar
        btnLogin.setBackground(new Color(51, 153, 255)); // Cor do botão
        btnLogin.setForeground(Color.WHITE); // Cor do texto
        btnLogin.setFont(new Font("Arial", Font.BOLD, 14)); // Fonte do botão
        btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cursor ao passar sobre o botão

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.CENTER; // Centraliza o botão
        contentPane.add(btnLogin, gbc);
        
        ImageIcon appIcon = new ImageIcon(getClass().getResource("/icons/eagle-logo.png")); // Caminho do ícone
        setIconImage(appIcon.getImage());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JLogin frame = new JLogin("Login");
            frame.setVisible(true);
        });
    }
}
 