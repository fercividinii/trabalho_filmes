package trabalho;

public class FilmeAcao extends Filme {
    private String nivelAcao;

    public FilmeAcao(String titulo, int ano, int duracao, String diretor, String nivelAcao) {
        super(titulo, ano, duracao, diretor);
        this.nivelAcao = nivelAcao;
    }

    public String getNivelAcao() {
        return nivelAcao;
    }

    public void setNivelAcao(String nivelAcao) {
        this.nivelAcao = nivelAcao;
    }

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("Nível de ação: " + nivelAcao);
    }
}
