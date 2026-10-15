package trabalho;

import java.util.ArrayList;

public class Catalogo {
    private ArrayList<Filme> filmes;

    public Catalogo() {
        filmes = new ArrayList<>();
    }

    // CREATE - cadastra um filme
    public void cadastrarFilme(Filme filme) {
        filmes.add(filme);
    }

    // READ - busca um filme pelo título
    public Filme buscarFilme(String titulo) {
        for (Filme filme : filmes) {
            if (filme.getTitulo().equalsIgnoreCase(titulo)) {
                return filme;
            }
        }
        return null;
    }

    // SOBRECARGA - busca um filme pelo ano
    public Filme buscarFilme(int ano) {
        for (Filme filme : filmes) {
            if (filme.getAno() == ano) {
                return filme;
            }
        }
        return null;
    }

    // READ - lista todos os filmes
    public void listarFilmes() {
        if (filmes.isEmpty()) {
            System.out.println("Nenhum filme cadastrado.");
            return;
        }

        for (Filme filme : filmes) {
            filme.exibirInformacoes();
            System.out.println("-------------------------");
        }
    }

    // UPDATE - atualiza os dados de um filme
    public boolean atualizarFilme(String titulo, String novoTitulo, int novoAno,
                                  int novaDuracao, String novoDiretor) {
        Filme filme = buscarFilme(titulo);

        if (filme != null) {
            filme.setTitulo(novoTitulo);
            filme.setAno(novoAno);
            filme.setDuracao(novaDuracao);
            filme.setDiretor(novoDiretor);
            return true;
        }

        return false;
    }

    // DELETE - remove um filme
    public boolean removerFilme(String titulo) {
        Filme filme = buscarFilme(titulo);

        if (filme != null) {
            filmes.remove(filme);
            return true;
        }

        return false;
    }
}
