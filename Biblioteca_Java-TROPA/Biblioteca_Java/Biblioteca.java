import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Livro> livros = new ArrayList<>();
    private ArrayList<Leitor> leitores = new ArrayList<>();

    public void addLivro(Livro livro) {
        livros.add(livro);
    }

    public void addLeitor(Leitor leitor) {
        leitores.add(leitor);
    }

    public Livro pesquisarLivro(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro;
            }
        }
        return null;
    }

    public Leitor pesquisarLeitor(String nome) {
        for (Leitor leitor : leitores) {
            if (leitor.getUsuario().equalsIgnoreCase(nome)) {
                return leitor;
            }
        }
        return null;
    }

    public Leitor pesquisarLeitorPorID(int id) {
        for (Leitor leitor : leitores) {
            if (leitor.getID() == id) {
                return leitor;
            }
        }
        return null;
    }

    public ArrayList<Livro> getLivros() {
        return livros;
    }

    public ArrayList<Leitor> getLeitores() {
        return leitores;
    }

    public void gerarRelatorioLivrosEmprestados() {
        System.out.println("Livros emprestados:");
        for (Leitor leitor : leitores) {
            for (Livro livro : leitor.getLivrosAlugados()) {
                System.out.println(leitor.getUsuario() + " está com o livro: " + livro.getTitulo());
            }
        }
    }

    public void gerarRelatorioUsuariosAtivos() {
        System.out.println("Usuários com livros:");
        for (Leitor leitor : leitores) {
            if (!leitor.getLivrosAlugados().isEmpty()) {
                System.out.println(leitor);
            }
        }
    }
}