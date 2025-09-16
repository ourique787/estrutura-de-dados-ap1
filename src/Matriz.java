import java.util.Random;
import java.util.Scanner;

public class Matriz {
    private int[][] matriz;
    private int numeroLinhas;
    private int numeroColunas;

    public Matriz(int linhas, int colunas) {
        if (linhas <= 0 || colunas <= 0) {
            linhas = 1;
            colunas = 1;
        }
        this.numeroLinhas = linhas;
        this.numeroColunas = colunas;
        this.matriz = new int[linhas][colunas];
    }

    public void preenchimentoManual(Scanner entrada) {
        for (int i = 0; i < numeroLinhas; i++) {
            for (int j = 0; j < numeroColunas; j++) {
                System.out.printf("Valor [%d][%d]: ", i, j);
                matriz[i][j] = entrada.nextInt();
            }
        }
        System.out.println("Preenchida manualmente.");
    }

    public void preencherAleatorio(int limite) {
        if (limite < 0) limite = 0;
        Random random = new Random();
        for (int i = 0; i < numeroLinhas; i++) {
            for (int j = 0; j < numeroColunas; j++) {
                matriz[i][j] = random.nextInt(limite + 1);
            }
        }
        System.out.println("Preenchida automaticamente com valores em [0.." + limite + "].");
    }

    public void inserirElemento(int linha, int coluna, int valor) {
        if (linha < 0 || linha >= numeroLinhas || coluna < 0 || coluna >= numeroColunas) {
            System.out.println("Posição inválida.");
            return;
        }
        matriz[linha][coluna] = valor;
        System.out.println("Valor inserido.");
    }

    public void removerElemento(int linha, int coluna) {
        if (linha < 0 || linha >= numeroLinhas || coluna < 0 || coluna >= numeroColunas) {
            System.out.println("Posição inválida.");
            return;
        }
        matriz[linha][coluna] = 0;
        System.out.println("Removido.");
    }

    public void exibirMatriz() {
        for (int i = 0; i < numeroLinhas; i++) {
            for (int j = 0; j < numeroColunas; j++) {
                System.out.print(matriz[i][j]);
                if (j < numeroColunas - 1) System.out.print("  |  ");
            }
            System.out.println();
        }
    }

    public void ordenarPorLinhas() {
        for (int i = 0; i < numeroLinhas; i++) {
            Ordenacao.bubbleSort(matriz[i]);
        }
    }

    public void ordenarPorLinhasMerge() {
        for (int i = 0; i < numeroLinhas; i++) {
            Ordenacao.mergeSort(matriz[i], 0, matriz[i].length - 1);
        }
    }

    public void ordenarPorColunas() {
        for (int j = 0; j < numeroColunas; j++) {
            int[] coluna = new int[numeroLinhas];
            for (int i = 0; i < numeroLinhas; i++) coluna[i] = matriz[i][j];
            Ordenacao.bubbleSort(coluna);
            for (int i = 0; i < numeroLinhas; i++) matriz[i][j] = coluna[i];
        }
    }

    public void ordenarPorColunasMerge() {
        for (int j = 0; j < numeroColunas; j++) {
            int[] coluna = new int[numeroLinhas];
            for (int i = 0; i < numeroLinhas; i++) coluna[i] = matriz[i][j];
            Ordenacao.mergeSort(coluna, 0, coluna.length - 1);
            for (int i = 0; i < numeroLinhas; i++) matriz[i][j] = coluna[i];
        }
    }

    public void ordenarMatrizCompleta() {
        int n = numeroLinhas * numeroColunas;
        int[] vetor = new int[n];
        int k = 0;
        for (int i = 0; i < numeroLinhas; i++) {
            for (int j = 0; j < numeroColunas; j++) {
                vetor[k++] = matriz[i][j];
            }
        }
        Ordenacao.mergeSort(vetor, 0, vetor.length - 1);
        k = 0;
        for (int i = 0; i < numeroLinhas; i++) {
            for (int j = 0; j < numeroColunas; j++) {
                matriz[i][j] = vetor[k++];
            }
        }
    }

    public void ordenarMatrizCompletaBubble() {
        int n = numeroLinhas * numeroColunas;
        int[] vetor = new int[n];
        int k = 0;
        for (int i = 0; i < numeroLinhas; i++) {
            for (int j = 0; j < numeroColunas; j++) {
                vetor[k++] = matriz[i][j];
            }
        }
        Ordenacao.bubbleSort(vetor);
        k = 0;
        for (int i = 0; i < numeroLinhas; i++) {
            for (int j = 0; j < numeroColunas; j++) {
                matriz[i][j] = vetor[k++];
            }
        }
    }
}
