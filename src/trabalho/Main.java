package trabalho;

import java.util.Scanner;

public class Main {
    private static final Scanner entrada = new Scanner(System.in);
    private static final Catalogo catalogo = new Catalogo();

    public static void main(String[] args) {
        // Exemplos iniciais para a versão beta
        catalogo.cadastrarFilme(new FilmeAcao("Velozes e Furiosos", 2001, 106, "Rob Cohen", "Alto"));
        catalogo.cadastrarFilme(new FilmeComedia("As Branquelas", 2004, 109, "Keenen Ivory Wayans", "Comédia"));
        catalogo.cadastrarFilme(new FilmeTerror("O Exorcista", 1973, 132, "William Friedkin", "Alto"));

        int opcao;
        do {
            exibirMenu();
            opcao = lerInteiro("Escolha uma opção: ");

            switch (opcao) {
                case 1 -> cadastrarFilme();
                case 2 -> catalogo.listarFilmes();
                case 3 -> buscarPorTitulo();
                case 4 -> buscarPorAno();
                case 5 -> atualizarFilme();
                case 6 -> removerFilme();
                case 0 -> System.out.println("Encerrando o sistema. Até mais!");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        entrada.close();
    }

    private static void exibirMenu() {
        System.out.println("\n========== CATÁLOGO DE FILMES ==========");
        System.out.println("1 - Cadastrar filme");
        System.out.println("2 - Listar todos os filmes");
        System.out.println("3 - Buscar filme pelo título");
        System.out.println("4 - Buscar filme pelo ano");
        System.out.println("5 - Atualizar filme");
        System.out.println("6 - Remover filme");
        System.out.println("0 - Sair");
        System.out.println("========================================");
    }

    private static void cadastrarFilme() {
        System.out.println("\nTipo de filme: 1-Ação | 2-Comédia | 3-Terror | 4-Outro");
        int tipo = lerInteiro("Escolha o tipo: ");
        String titulo = lerTexto("Título: ");
        int ano = lerInteiro("Ano de lançamento: ");
        int duracao = lerInteiro("Duração em minutos: ");
        String diretor = lerTexto("Diretor: ");

        Filme filme;
        switch (tipo) {
            case 1 -> filme = new FilmeAcao(titulo, ano, duracao, diretor,
                    lerTexto("Nível de ação (ex.: Alto/Médio/Baixo): "));
            case 2 -> filme = new FilmeComedia(titulo, ano, duracao, diretor,
                    lerTexto("Tipo de humor: "));
            case 3 -> filme = new FilmeTerror(titulo, ano, duracao, diretor,
                    lerTexto("Nível de terror (ex.: Alto/Médio/Baixo): "));
            case 4 -> filme = new Filme(titulo, ano, duracao, diretor);
            default -> {
                System.out.println("Tipo inválido. Cadastro cancelado.");
                return;
            }
        }
        catalogo.cadastrarFilme(filme);
        System.out.println("Filme cadastrado com sucesso!");
    }

    private static void buscarPorTitulo() {
        String titulo = lerTexto("Digite o título: ");
        Filme filme = catalogo.buscarFilme(titulo);
        exibirResultado(filme);
    }

    private static void buscarPorAno() {
        int ano = lerInteiro("Digite o ano: ");
        Filme filme = catalogo.buscarFilme(ano);
        exibirResultado(filme);
    }

    private static void atualizarFilme() {
        String titulo = lerTexto("Título do filme que deseja atualizar: ");
        String novoTitulo = lerTexto("Novo título: ");
        int novoAno = lerInteiro("Novo ano: ");
        int novaDuracao = lerInteiro("Nova duração em minutos: ");
        String novoDiretor = lerTexto("Novo diretor: ");
        boolean atualizado = catalogo.atualizarFilme(titulo, novoTitulo, novoAno, novaDuracao, novoDiretor);
        System.out.println(atualizado ? "Filme atualizado com sucesso!" : "Filme não encontrado.");
    }

    private static void removerFilme() {
        String titulo = lerTexto("Título do filme que deseja remover: ");
        boolean removido = catalogo.removerFilme(titulo);
        System.out.println(removido ? "Filme removido com sucesso!" : "Filme não encontrado.");
    }

    private static void exibirResultado(Filme filme) {
        if (filme != null) {
            filme.exibirInformacoes();
        } else {
            System.out.println("Nenhum filme encontrado.");
        }
    }

    private static String lerTexto(String mensagem) {
        System.out.print(mensagem);
        return entrada.nextLine();
    }

    private static int lerInteiro(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String valor = entrada.nextLine();
            try {
                return Integer.parseInt(valor);
            } catch (NumberFormatException e) {
                System.out.println("Digite um número inteiro válido.");
            }
        }
    }
}
