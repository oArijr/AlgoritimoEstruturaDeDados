public class AlgoritmoBusca<T extends Comparable<T>> {

    public int buscaLinear(T[] vetor, T chave) {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i].equals(chave)) {
                return i;
            }
        }
        return -1;
    }

    public int buscaBinaria(T[] vetor, T chave) {
        int inicio = 0;
        int fim = vetor.length - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;

            if (vetor[meio].compareTo(chave) > 0) {
                inicio = meio + 1;
            } else if (vetor[meio].compareTo(chave) < 0) {
                fim = meio - 1;
            } else {
                return meio;
            }
        }
        return -1;
    }

}