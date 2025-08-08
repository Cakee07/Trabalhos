import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {

    private JTextField txtUsuario;
    private JTextField txtID;
    private JButton btnLogin;
    private Biblioteca biblioteca;

    public Login() {
        super("Login da Biblioteca");

        biblioteca = new Biblioteca(); // Criação da biblioteca
        carregarLivrosExemplo();

        JLabel lblUsuario = new JLabel("Nome:");
        txtUsuario = new JTextField(15);

        JLabel lblID = new JLabel("ID:");
        txtID = new JTextField(15);

        btnLogin = new JButton("Entrar");
        btnLogin.addActionListener(e -> fazerLogin());

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.add(lblUsuario);
        panel.add(txtUsuario);
        panel.add(lblID);
        panel.add(txtID);
        panel.add(new JLabel());
        panel.add(btnLogin);

        add(panel);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void fazerLogin() {
        String nome = txtUsuario.getText().trim();
        String idText = txtID.getText().trim();

        if (nome.isEmpty() || idText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos.");
            return;
        }

        int id;
        try {
            id = Integer.parseInt(idText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID deve ser um número.");
            return;
        }

        Leitor leitor = biblioteca.pesquisarLeitor(nome);
        if (leitor == null) {
            leitor = new Leitor(nome, id);
            biblioteca.addLeitor(leitor);
        }

        dispose(); // Fecha a tela de login
        new Principal(biblioteca, leitor); // Abre o sistema principal
    }

    private void carregarLivrosExemplo() {
        biblioteca.addLivro(new Livro("Dom Casmurro", "Machado de Assis", 1234567890L, 3));
        biblioteca.addLivro(new Livro("O Hobbit", "J.R.R. Tolkien", 9876543210L, 5));
        biblioteca.addLivro(new Livro("1984", "George Orwell", 1111111111L, 4));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Login());
    }
}
