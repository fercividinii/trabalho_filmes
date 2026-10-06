package trabalho;

public class Main {
    public static void main(String[] args) {
        Catalogo catalogo = new Catalogo();

        FilmeAcao acao = new FilmeAcao(
                "Velozes e Furiosos",
                2001,
                106,
                "Rob Cohen",
                "Alto"
        );

        FilmeComedia comedia = new FilmeComedia(
                "As Branquelas",
                2004,
                109,
                "Keenen Ivory Wayans",
                "Comédia"
        );

        FilmeTerror terror = new FilmeTerror(
                "O Exorcista",
                1973,
                132,
                "William Friedkin",
                "Alto"
        );

        // CREATE
        catalogo.cadastrarFilme(acao);
        catalogo.cadastrarFilme(comedia);
        catalogo.cadastrarFilme(terror);

        // READ
        System.out.println("=== FILMES CADASTRADOS ===");
        catalogo.listarFilmes();

        // BUSCA
        System.out.println("=== BUSCA ===");
        Filme filmeEncontrado = catalogo.buscarFilme("As Branquelas");

        if (filmeEncontrado != null) {
            filmeEncontrado.exibirInformacoes();
        }

        // UPDATE
        System.out.println("\n=== ATUALIZAÇÃO ===");
        boolean atualizado = catalogo.atualizarFilme(
                "As Branquelas",
                "As Branquelas 2",
                2026,
                115,
                "Keenen Ivory Wayans"
        );

        System.out.println("Filme atualizado: " + atualizado);

        // DELETE
        System.out.println("\n=== REMOÇÃO ===");
        boolean removido = catalogo.removerFilme("O Exorcista");
        System.out.println("Filme removido: " + removido);

        // LISTA FINAL
        System.out.println("\n=== LISTA FINAL ===");
        catalogo.listarFilmes();
    }
}
