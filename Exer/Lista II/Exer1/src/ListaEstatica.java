public class ListaEstatica<T> implements Lista<T> {
    private T[] info;
    private int tamanho;

    public ListaEstatica() {
        info = (T[]) new Object[10];
        tamanho = 0;
    }

    @Override
    public void inserir(T valor) {
        if (tamanho == info.length) {
            this.redimensionar();
        }
        info[tamanho] = valor;
        tamanho++;
    }

    private void redimensionar() {
        T[] novo = (T[]) new Object[info.length + 10];
        for (int i = 0; i < info.length; i++) {
            novo[i] = info[i];
        }
        this.info = novo;
    }

    @Override
    public int buscar(T valor) {
        for (int i = 0; i < tamanho; i++) {
            if (info[i].equals(valor)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean estaVazia() {
        return (tamanho == 0);
    }

    @Override
    public void retirar(T valor) {
        int pos = this.buscar(valor);
        if (pos != -1) { // encontrou o valor
            for (int i = pos; i < tamanho - 1; i++) {
                info[i] = info[i + 1];
            }
            this.tamanho--;
        }
    }

    @Override
    public String exibir() {
        String str = "[";
        for (int i = 0; i < tamanho; i++) {
            str += info[i] + ", ";
        }
        return str + "]";
    }

    @Override
    public Lista copiar() { // contribuição Maria Clara
        Lista outra = new ListaEstatica();
        for (int i = 0; i < this.tamanho; i++) {
            outra.inserir(this.info[i]);
        }

        return outra;
    }

    @Override
    public Lista dividir() {
        int metade = this.tamanho / 2;
        Lista outra = new ListaEstatica();
        for (int i = metade; i < this.tamanho; i++) {
            outra.inserir(this.info[i]);
        }
        this.tamanho = metade;
        return outra;
    }

    @Override
    public int getTamanho() {
        return this.tamanho;
    }

    @Override
    public void concatenar(Lista<T> outraLista) {
        for (int i = 0; i < outraLista.getTamanho(); i++) {
            this.inserir(outraLista.pegar(i));
        }
    }

    @Override
    public T pegar(int pos) {
        if (pos >= this.tamanho) {
            throw new IndexOutOfBoundsException("Pos=" + pos + ". Length=" + tamanho);
        }
        return this.info[pos];
    }

    @Override
    public void inserir(T valor, int pos) {
        if (pos < 0 || pos > this.tamanho) {
            throw new IndexOutOfBoundsException();
        }
        if (pos == this.tamanho) {
            this.inserir(valor);
        } else {
            if (tamanho == info.length) {
                this.redimensionar();
            }
            for (int i = this.tamanho; i > pos; i--) {
                this.info[i] = this.info[i - 1];
            }
            this.info[pos] = valor;
            this.tamanho++;
        }
    }

}