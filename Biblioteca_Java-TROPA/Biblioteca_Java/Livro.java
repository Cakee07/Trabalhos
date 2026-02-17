public class Livro {
    private String titulo;
    private String autor;
    private long isbn;
    private int qtd;
    private int emprestado;

    public Livro(String titulo, String autor, long isbn, int qtd) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.qtd = qtd;
    }

    public boolean isDisponivel() {
        return qtd > 0;
    }

    public void emprestarLivro() {
        if (qtd > 0) {
            qtd--;
            emprestado++;
        }
    }

    public void devolverLivro() {
        qtd++;
        emprestado--;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public long getIsbn() {
        return isbn;
    }

    public int getQtd() {
        return qtd;
    }

    public int getEmprestado() {
        return emprestado;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public void setEmprestado(int emprestado) {
        this.emprestado = emprestado;
    }

    @Override
    public String toString() {
        return qtd + " unidade(s) do livro: " + titulo  + " de " + autor;
    }
}