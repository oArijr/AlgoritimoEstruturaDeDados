public class ListaEncadeada implements Lista {
    protected NoLista primeiro;
    protected NoLista ultimo;
    protected int qtdeElementos;

    public ListaEncadeada() {
    }

    @Override
    public void inserir(int valor) {
        NoLista novo = new NoLista();
        novo.setInfo(valor);
        if (this.estaVazia()) {
            this.primeiro = novo;
        } else {
            this.ultimo.setProx(novo);
        }
        this.ultimo = novo;
        this.qtdeElementos++;
    }

    @Override
    public int buscar(int valor) {
        NoLista p = primeiro;
        int cont = 0;
        while (p != null) {
            if (p.getInfo() == valor) {
                return cont;
            }
        }

        return -1;

    }

    @Override
    public boolean estaVazia() {
        if (primeiro == null) {
            return true;
        }
        return false;
    }

    @Override
    public void retirar(int valor) {
        NoLista p = primeiro;
        NoLista a = null;
        while (p != null && p.getInfo() != valor) {
            a = p;
            p = p.getProx();
        }
        if (p != null) {
            if (this.ultimo == p) {
                this.ultimo = a;
            } else if (a == null) {
                this.primeiro = p.getProx();
            } else {
                a.setProx(p.getProx());
            }
            this.qtdeElementos--;

        }
    }

    @Override
    public String exibir() {
        NoLista p = primeiro;
        String str = "[";
        while (p != null) {
            str += p.getInfo() + ", ";
            p = p.getProx();
        }
        return str += " ]";
    }

    @Override
    public Lista copiar() {
        Lista copia = new ListaEncadeada();
        for (NoLista p = primeiro; p != null; p = p.getProx()) {
            copia.inserir(p.getInfo());
        }
        return copia;

    }

    @Override
    public Lista dividir() {
        ListaEncadeada outra = new ListaEncadeada();
        int divisao = getTamanho()/2;
        NoLista anterior = null;
        NoLista atual = primeiro;
        for(int i = 0; i < divisao; i++){
            anterior = atual;
            atual = atual.getProx();
        }
        anterior.setProx(null);
        this.ultimo = anterior;
        this.qtdeElementos = divisao;
        outra.primeiro = atual;
        outra.ultimo = this.ultimo;
        outra.qtdeElementos = getTamanho()-(getTamanho() / 2);
        return outra;
    }

    @Override
    public int getTamanho() {
        return this.qtdeElementos;
    }

    @Override
    public void concatenar(Lista outraLista) {
        for(int i = 0; i < outraLista.getTamanho(); i++){
            this.inserir(outraLista.pegar(i));
        }
    }

    @Override
    public int pegar(int pos) {
        if (pos < 0 || pos > this.qtdeElementos) {
            throw new IndexOutOfBoundsException("posição:" + pos + " não existe!");
        }
        NoLista p = primeiro;
        int cont = 0;
        while (p != null) {
            if (cont == pos) {
                return p.getInfo();
            }
            cont++;
            p = p.getProx();
        }
        return -1;

    }

    @Override
    public void inserir(int valor, int pos) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'inserir'");
    }

}
