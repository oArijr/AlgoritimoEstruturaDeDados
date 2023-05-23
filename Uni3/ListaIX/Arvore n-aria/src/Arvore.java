public class Arvore<T> {
    private NoArvore<T> raiz;

    public NoArvore<T> pertence(T info) {
        if (this.vazia()) {
            return null;
        } else {
            if (raiz.getInfo().equals(info)) {
                return raiz;
            }
            return raiz.getFilho().pertence(info);
        }
    }

    public boolean vazia() {
        return this.raiz == null;
    }

    public String toString() {
        if(this.vazia()){
            return "<>";
        }

        return raiz.imprimePre();
    }

    public void setRaiz(NoArvore<T> raiz) {
        this.raiz = raiz;
    }

    public NoArvore<T> getRaiz() {
        return this.raiz;
    }
}
