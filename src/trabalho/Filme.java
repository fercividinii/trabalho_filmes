package trabalho;

public class Filme {
    private String titulo;
    private int ano;
    private int duracao;
    private String diretor;

    public Filme(String titulo, int ano, int duracao, String diretor) {
        this.titulo = titulo;
        this.ano = ano;
        this.duracao = duracao;
        this.diretor = diretor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public void exibirInformacoes() {
        System.out.println("Título: " + titulo);
        System.out.println("Ano: " + ano);
        System.out.println("Duração: " + duracao + " minutos");
        System.out.println("Diretor: " + diretor);
    }
}
