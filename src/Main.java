import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Manipulação de Matrizes");
        System.out.print("Linhas: ");
        int linhas = scanner.nextInt();
        System.out.print("Colunas: ");
        int colunas = scanner.nextInt();

        Matriz matriz = new Matriz(linhas, colunas);

        while (true) {
            System.out.println("\nMENU");
            System.out.println("1) Exibir matriz");
            System.out.println("2) Preencher matriz MANUAL");
            System.out.println("3) Preencher matriz AUTOMÁTICO [0..limite]");
            System.out.println("4) Alterar um elemento");
            System.out.println("5) Remover elemento (0)");
            System.out.println("6) Ordenar por LINHAS (1=Bubble, 2=Merge)");
            System.out.println("7) Ordenar por COLUNAS (1=Bubble, 2=Merge)");
            System.out.println("8) Ordenar MATRIZ COMPLETA (1=Bubble, 2=Merge)");
            System.out.println("9) Redefinir MATRIZ (apagar e criar nova)");
            System.out.println("0) Sair");
            System.out.print("Escolha: ");

            int opcao = scanner.nextInt();
            if (opcao == 0) {
                System.out.println("Encerrando...");
                break;
            }

            int linha, coluna, valor, escolha, limite;
            switch (opcao) {
                case 1 -> {
                    System.out.println("Matriz:");
                    matriz.exibirMatriz();
                }
                case 2 -> {
                    matriz.preenchimentoManual(scanner);
                    matriz.exibirMatriz();
                }
                case 3 -> {
                    System.out.print("limite: ");
                    limite = scanner.nextInt();
                    matriz.preencherAleatorio(limite);
                    matriz.exibirMatriz();
                }
                case 4 -> {
                    System.out.print("Linha: ");
                    linha = scanner.nextInt();
                    System.out.print("Coluna: ");
                    coluna = scanner.nextInt();
                    System.out.print("Valor: ");
                    valor = scanner.nextInt();
                    matriz.inserirElemento(linha, coluna, valor);
                    matriz.exibirMatriz();
                }
                case 5 -> {
                    System.out.print("Linha: ");
                    linha = scanner.nextInt();
                    System.out.print("Coluna: ");
                    coluna = scanner.nextInt();
                    matriz.removerElemento(linha, coluna);
                    matriz.exibirMatriz();
                }
                case 6 -> {
                    System.out.print("1=Bubble, 2=Merge: ");
                    escolha = scanner.nextInt();
                    System.out.println("Antes:");
                    matriz.exibirMatriz();
                    if (escolha == 1) matriz.ordenarPorLinhas(); else matriz.ordenarPorLinhasMerge();
                    System.out.println("Depois:");
                    matriz.exibirMatriz();
                }
                case 7 -> {
                    System.out.print("1=Bubble, 2=Merge: ");
                    escolha = scanner.nextInt();
                    System.out.println("Antes:");
                    matriz.exibirMatriz();
                    if (escolha == 1) matriz.ordenarPorColunas(); else matriz.ordenarPorColunasMerge();
                    System.out.println("Depois:");
                    matriz.exibirMatriz();
                }
                case 8 -> {
                    System.out.print("1=Bubble, 2=Merge: ");
                    escolha = scanner.nextInt();
                    System.out.println("Antes:");
                    matriz.exibirMatriz();
                    if (escolha == 1) matriz.ordenarMatrizCompletaBubble(); else matriz.ordenarMatrizCompleta();
                    System.out.println("Depois:");
                    matriz.exibirMatriz();
                }
                case 9 -> {
                    System.out.print("Confirmar recriação? (s/n): ");
                    String conf = scanner.next().trim();
                    if (!conf.equalsIgnoreCase("s")) {
                        System.out.println("Cancelado.");
                        break;
                    }
                    System.out.print("Novas linhas: ");
                    int novasLinhas = scanner.nextInt();
                    System.out.print("Novas colunas: ");
                    int novasColunas = scanner.nextInt();
                    matriz = new Matriz(novasLinhas, novasColunas);
                    System.out.println("Preencher agora? 1=Manual, 2=Automático, 3=Zerada");
                    int modo = scanner.nextInt();
                    if (modo == 1) {
                        matriz.preenchimentoManual(scanner);
                    } else if (modo == 2) {
                        System.out.print("limite: ");
                        limite = scanner.nextInt();
                        matriz.preencherAleatorio(limite);
                    }
                    System.out.println("Nova matriz:");
                    matriz.exibirMatriz();
                }
                default -> System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
}
