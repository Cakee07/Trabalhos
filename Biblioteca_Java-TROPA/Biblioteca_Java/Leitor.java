import java.util.ArrayList;

public class Leitor {
    private String usuario;
    private int ID;
    private ArrayList<Livro> livrosAlugados = new ArrayList<>();

    public Leitor(String usuario, int ID) {
        this.usuario = usuario;
        this.ID = ID;
    }

    public void emprestarLivro(Livro livro) {
        if (livro.isDisponivel()) {
            livro.emprestarLivro();
            livrosAlugados.add(livro);
            System.out.println("Livro: " + livro.getTitulo() + " alugado por " + usuario);
        } else {
            System.out.println("Livro indisponível.");
        }
    }

   public boolean devolverLivro(String titulo) {
    for (int i = 0; i < livrosAlugados.size(); i++) {
        if (livrosAlugados.get(i).getTitulo().equalsIgnoreCase(titulo)) {
            Livro livro = livrosAlugados.remove(i);
            livro.devolverLivro();
            return true;
        }
    }
    return false;
    }



    public ArrayList<Livro> getLivrosAlugados() {
        return livrosAlugados;
    }

    public String getUsuario() {
        return usuario;
    }

    public int getID() {
        return ID;
    }

    @Override
    public String toString() {
        return "Leitor: " + usuario + " (ID: " + ID + ")";
    }
}