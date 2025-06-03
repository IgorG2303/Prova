public class Questao02 {
    public static void main(String[] args) {
        new Questao02();
    }
    private Questao02() {
        int[] vetor = new int[5];
        int tamanho = 10;
        int numero = 0;
        teste(vetor, tamanho, numero);
    }
    public void teste(int vetor[], int tamanho, int numero) {
        int aux = 0;
        for (int i = 0; i < tamanho; i++) {
            for(int j = 0; j < i; j++) {
            aux = vetor[i];
            vetor[i] = vetor[j];
            vetor[j] = aux;
            }
            numero++;
        }
        System.out.println(numero);
    }
    public void construtor() {
        int[] vetor = {10, 5, 3, 8, 9};
        int numero = vetor.length;
        teste(vetor, 5, numero);
    }
}
