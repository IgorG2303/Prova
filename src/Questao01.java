public class Questao01 {
    public static void main(String[] args) {
        new Questao01();
    }
    private Questao01() {
        int[] vetor = new int[5];
        int valor = 4;
        int vetorPos = 4;
        vetorPesquisa(vetor, valor, vetorPos);
    }
    private boolean vetorPesquisa(int vetor[], int valor, int vetorPos) {
        for (int i = 0; i < vetorPos; i++) {
            if(valor == vetor[i]) {
                return true;
                
            }
        }
        System.out.println("Fim do metodo");
                return false;
    }
}
