package trabalho;

public class FilmeTerror extends Filme {
    private String nivelTerror;

    public FilmeTerror(String titulo, int ano, int duracao, String diretor, String nivelTerror) {
        super(titulo, ano, duracao, diretor);
        this.nivelTerror = nivelTerror;
    }

    public String getNivelTerror() {
        return nivelTerror;
    }

    public void setNivelTerror(String nivelTerror) {
        this.nivelTerror = nivelTerror;
    }

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("Nível de terror: " + nivelTerror);
    }
}
