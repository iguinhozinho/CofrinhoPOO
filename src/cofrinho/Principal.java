package cofrinho;

import java.util.Locale;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        // apresenta os valores com virgula
        Locale.setDefault(new Locale("pt", "BR"));
        Cofrinho cofrinho = new Cofrinho();
        Scanner teclado = new Scanner(System.in);
        int opcao;

        System.out.println("Bem-vindo ao Cofrinho de Moedas!");
        System.out.println("Cotações didaticas: US$ 1 = R$ 5,00 e € 1 = R$ 5,61.");

        do {
            mostrarMenu();
            opcao = lerInteiro(teclado, "Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    cofrinho.adicionar(solicitarMoeda(teclado));
                    System.out.println("Moeda adicionada com sucesso!");
                    break;
                case 2:
                    Moeda moedaParaRemover = solicitarMoeda(teclado);
                    if (cofrinho.remover(moedaParaRemover)) {
                        System.out.println("Moeda removida com sucesso!");
                    } else {
                        System.out.println("Essa moeda não foi encontrada no cofrinho.");
                    }
                    break;
                case 3:
                    cofrinho.listagemMoedas();
                    break;
                case 4:
                    System.out.printf("Total convertido em reais: R$ %.2f%n",
                            cofrinho.totalConvertido());
                    break;
                case 0:
                    System.out.println("Até a próxima!");
                    break;
                default:
                    System.out.println("Opção invalida. Escolha um numero do menu.");
                    break;
            }
        } while (opcao != 0);

        teclado.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n===== MENU DO COFRINHO =====");
        System.out.println("1 - Adicionar moeda");
        System.out.println("2 - Remover moeda");
        System.out.println("3 - Listar moedas");
        System.out.println("4 - Calcular total em reais");
        System.out.println("0 - Sair");
    }

    private static Moeda solicitarMoeda(Scanner teclado) {
        int tipo;
        do {
            System.out.println("\nQual é o tipo da moeda?");
            System.out.println("1 - Real");
            System.out.println("2 - Dólar");
            System.out.println("3 - Euro");
            tipo = lerInteiro(teclado, "Tipo: ");
            if (tipo < 1 || tipo > 3) {
                System.out.println("Tipo invalido. Escolha 1, 2 ou 3.");
            }
        } while (tipo < 1 || tipo > 3);

        double valor = lerValorPositivo(teclado);
        switch (tipo) {
            case 1:
                return new Real(valor);
            case 2:
                return new Dolar(valor);
            default:
                return new Euro(valor);
        }
    }

    private static int lerInteiro(Scanner teclado, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String texto = teclado.nextLine().trim();
            try {
                return Integer.parseInt(texto);
            } catch (NumberFormatException erro) {
                System.out.println("Digite um numero inteiro valido.");
            }
        }
    }

    // aceita virgula, ponto e só valores positivos
    private static double lerValorPositivo(Scanner teclado) {
        while (true) {
            System.out.print("Valor da moeda: ");
            String texto = teclado.nextLine().trim().replace(',', '.');
            try {
                double valor = Double.parseDouble(texto);
                if (!Double.isNaN(valor) && !Double.isInfinite(valor) && valor > 0) {
                    return valor;
                }
            } catch (NumberFormatException erro) {
                // se não for numero, pede novamente
            }
            System.out.println("Valor invalido. Informe um numero maior que zero.");
        }
    }
}
