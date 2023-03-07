public class ListaEstatica {
    private int[] info;
    private int tamanho;

    public ListaEstatica() {
        this.info = new int[10];
        this.tamanho = 0;
    }

    public ListaEstatica(int tamanho) {
        this.info = new int[tamanho];
        this.tamanho = 0;
    }

    private int[] getInfo() {
        return info;
    }

    public void setInfo(int[] info) {
        this.info = info;
    }

    public int getTamanho() {
        return this.tamanho;
    }

    private void redimensionar() {
        int[] f = getInfo();
        int[] novoVetor = new int[f.length + 10];
        for (int i = 0; i < f.length; i++) {
            novoVetor[i] = f[i];
        }
        setInfo(novoVetor);
    }

    public void inserir(int valor) {
        if (tamanho == getInfo().length) {
            this.redimensionar();
        }
        info[getTamanho()] = valor;
        this.tamanho++;
    }

    public String exibir() {
        String str = "[ ";
        for (int i = 0; i < this.tamanho; i++) {
            str += this.info[i];
            str += ", ";
        }
        return str + " ]";
    }

    public int buscar(int valor) {
        int[] f = getInfo();
        for (int i = 0; i < getTamanho(); i++) {
            if (f[i] == valor) {
                return i;
            }
        }
        return -1;
    }

    public int pegar(int pos) {
        if (pos >= this.tamanho) {
            throw new IndexOutOfBoundsException("posição: " + pos + " não existe!");
        }
        return this.info[pos];
    }

    public void concatenar(ListaEstatica outra) {
        for (int i = 0; i < outra.getTamanho(); i++) {
            this.inserir(outra.pegar(i));
        }

    }

    public ListaEstatica dividir() {
        int metade = this.getTamanho() / 2;
        ListaEstatica outra = new ListaEstatica();
        for (int i = metade; i < this.getTamanho(); i++) {
            outra.inserir(this.info[i]);
        }
        this.tamanho = metade;
        return outra;
    }

    public ListaEstatica copiar() {
        ListaEstatica copia = new ListaEstatica();
        for (int i = 0; i < this.getTamanho(); i++) {
            copia.inserir(this.getInfo()[i]);
        }
        return copia;
    }

    public void retirar(int valor) {
        int[] f = getInfo();
        int pos = this.buscar(valor);
        if (pos != -1) {
            for (int i = 0; i < (getTamanho() - 1); i++) {
                f[i] = f[i + 1];
            }
            tamanho--;
            setInfo(f);
        }
    }

    public boolean estaVazia() {
        if (getTamanho() == 0) {
            return true;
        }
        return false;
    }
}
