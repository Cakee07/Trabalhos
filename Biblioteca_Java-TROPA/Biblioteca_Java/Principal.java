import javax.swing.*;
import java.awt.*;

public class Principal extends JFrame {

    public Principal(Biblioteca biblioteca, Leitor leitor) {
        super("Biblioteca Yoshikage Kira");

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(100, 150, 100, 150));

        JButton btnAlugar = new JButton("Alugar Livro");
        JButton btnDevolver = new JButton("Devolver Livro");
        JButton btnCatalogo = new JButton("Mostrar Catálogo");
        JButton btnRelatorios = new JButton("Relatórios");

        Dimension buttonSize = new Dimension(400, 40);

        btnAlugar.setMaximumSize(buttonSize);
        btnAlugar.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnDevolver.setMaximumSize(buttonSize);
        btnDevolver.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnCatalogo.setMaximumSize(buttonSize);
        btnCatalogo.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnRelatorios.setMaximumSize(buttonSize);
        btnRelatorios.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnAlugar.addActionListener(e -> {
            String titulo = JOptionPane.showInputDialog(this, "Título do livro:");
            if (titulo != null && !titulo.isBlank()) {
                Livro livro = biblioteca.pesquisarLivro(titulo);
                if (livro != null) {
                    leitor.emprestarLivro(livro);
                } else {
                    JOptionPane.showMessageDialog(this, "Livro não encontrado.");
                }
            }
        });

       btnDevolver.addActionListener(e -> {
            if (leitor.getLivrosAlugados().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Você não tem livros para devolver.");
            return;
        }

        String[] opcoes = leitor.getLivrosAlugados().stream()
            .map(Livro::getTitulo)
            .toArray(String[]::new);

        String livroEscolhido = (String) JOptionPane.showInputDialog(this,
            "Qual livro deseja devolver?", "Devolver Livro",
            JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

    if (livroEscolhido != null) {
        boolean devolveu = leitor.devolverLivro(livroEscolhido);
        if (devolveu) {
            JOptionPane.showMessageDialog(this, "Livro devolvido com sucesso.");
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao devolver o livro.");
        }
    }
});


        btnCatalogo.addActionListener(e -> {
            StringBuilder sb = new StringBuilder("Catálogo de Livros:\n");
            for (Livro l : biblioteca.getLivros()) {
                sb.append(l.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(this, sb.toString());
        });

        btnRelatorios.addActionListener(e -> {
            biblioteca.gerarRelatorioLivrosEmprestados();
            biblioteca.gerarRelatorioUsuariosAtivos();
        });

        panel.add(btnAlugar);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(btnDevolver);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(btnCatalogo);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(btnRelatorios);

        add(panel);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
