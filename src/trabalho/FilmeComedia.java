package trabalho;

public class FilmeComedia extends Filme {
    private String classificacaoHumor;

    public FilmeComedia(String titulo, int ano, int duracao, String diretor, String classificacaoHumor) {
        super(titulo, ano, duracao, diretor);
        this.classificacaoHumor = classificacaoHumor;
    }

    public String getClassificacaoHumor() {
        return classificacaoHumor;
    }

    public void setClassificacaoHumor(String classificacaoHumor) {
        this.classificacaoHumor = classificacaoHumor;
    }

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("Tipo de humor: " + classificacaoHumor);
    }
}
