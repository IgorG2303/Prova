import java.util.Scanner;

public class Questao03 {
    public static void main(String[] args) {
        new Questao03();
    }

    private Questao03() {
        int opcao = 0;
        int[] vet = new int[5];
        String[] nome = new String[5];
        int posicao = 0;
        int[] pesoTotal = { 0 };
        Scanner teclado = new Scanner(System.in);

        do {
            System.out.println("Insira o que deseja fazer com a mochila;");
            System.out.println("1 - Inserir item");
            System.out.println("2 - Imprimir a mochila");
            System.out.println("3 - Mostrar o valor mais pesado da mochila");
            System.out.println("4 - Ordenar a mochila");
            System.out.println("5 - Excluir um item da mochila");
            System.out.println("6 - Sair da mochila");
            opcao = teclado.nextInt();
            System.out.println("Opção digitada: " + opcao);

            switch (opcao) {
                case 1:
                    posicao = inserirItem(vet, nome, posicao, teclado, pesoTotal);
                    break;
                case 2:
                    mostrarItem(vet, nome, posicao);
                    break;
                case 3:
                    valorPesado(vet, nome, posicao);
                    break;
                case 4:
                    ordenarValor(vet, posicao, nome);
                    break;
                case 5:
                    excluirItem(vet, nome, posicao, teclado);
                    break;
                case 6:
                    System.out.println("Saindo da mochila...");
                    break;
            }
        } while (opcao != 6);
    }

    public int inserirItem(int[] vet, String[] nome, int posicao, Scanner teclado, int[] pesoTotal) {
        System.out.println("Insira o nome do item");
        String item = teclado.next();

        System.out.println("Insira o peso");
        int numero = teclado.nextInt();

        if (verificacao(numero, pesoTotal[0])) {
            if (posicao < vet.length) {
                vet[posicao] = numero;
                nome[posicao] = item;
                pesoTotal[0] += numero;
                System.out.println(item + " Adicionado à mochila");
                System.out.println("A mochila agora ganhou mais " + numero + "Kg");
            } else {
                System.out.println("Mochila cheia");
            }
        } else {
            System.out.println("Peso excedido");
        }

        return posicao + 1;
    }

    private void mostrarItem(int[] vet, String[] nome, int posicao) {
        for (int i = posicao; i >= 0; i--) {
            System.out.println("O item da posição [" + i + "] é " + nome[i]);
            System.out.println("O peso do(a) " + nome[i] + " é " + vet[i]);
        }
    }

    public boolean verificacao(int numero, int pesoTotal) {
        return (numero + pesoTotal) <= 15;
    }

    private void valorPesado(int[] vet, String[] nome, int posicao) {
        String itemMaisPesado = null;
        int valorMaisPesado = 0;
        for (int i = 1; i < posicao; i++) {
            if (vet[i] > valorMaisPesado) {
                valorMaisPesado = vet[i];
                itemMaisPesado = nome[i];
            }
        }
        System.out.println("O item mais pesado é " + itemMaisPesado);
        System.out.println("o valor mais pesado é " + valorMaisPesado);

    }

    private void ordenarValor(int[] vet, int posicao, String[] nome) {
        for (int i = 0; i < posicao - 1; i++) {
            for (int j = 0; j < posicao - 1 - i; j++) {
                if (vet[j] > vet[j + 1]) {

                    int tempPeso = vet[j];
                    vet[j] = vet[j + 1];
                    vet[j + 1] = tempPeso;

                    String tempNome = nome[j];
                    nome[j] = nome[j + 1];
                    nome[j + 1] = tempNome;
                }
            }
        }

        System.out.println("Itens da mochila ordenados por peso:");
        for (int i = 0; i < posicao; i++) {
            System.out.println("Item: " + nome[i] + ", Peso: " + vet[i] + "Kg");
        }
    }

    private int pesquisarValor(int[] vet, Scanner teclado, String[] nome) {

        int numeroDigitado = teclado.nextInt();
        for (int i = 0; i < vet.length; i++) {
            if (vet[i] == numeroDigitado) {
                return i;
            }

        }
        System.out.println("Item de peso " + numeroDigitado + " não encontrado");
        return -1;
    }

    private int excluirItem(int[] vet, String[] nome, int posicao, Scanner teclado) {
        System.out.println("Insira o peso do item que deseja apagar");
        int indice = pesquisarValor(vet, teclado, nome);
        if (indice != -1) {
            for (int i = indice; i < (posicao - 1); i++) {
                vet[i] = vet[i + 1];

            }
            System.out.println("item excluido com sucesso da mochila");
        }
        return posicao--;

    }
}
