public class NoArvore<T> {
    private T info;
    private NoArvore<T> filho;
    private NoArvore<T> irmao;

    public NoArvore(T info) {
        this.setInfo(info);
    }

    public String imprimePre() {
        String str = "<";

        str += this.info.toString();
        str += this.filho != null ? filho.imprimePre() : "";
        str += ">";
        str += this.irmao != null ? irmao.imprimePre() : "";
        return str;
    }

    public void inserirFilho(NoArvore<T> no) {
        if (no == null) {
            throw new NullPointerException("Nó não pode ser nulo");
        }
        no.setIrmao(filho);
        this.setFilho(no);

    }

    public NoArvore<T> pertence(T info) {
        if (this.getInfo().equals(info)) {
            return this;
        } else {
            NoArvore<T> noEncontrado = null;
            if (this.filho != null) {
                noEncontrado = this.filho.pertence(info);
            } 
            if(noEncontrado == null && irmao != null){
                noEncontrado = this.irmao.pertence(info);
            }
            return noEncontrado;
        }
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public NoArvore<T> getFilho() {
        return filho;
    }

    public void setFilho(NoArvore<T> filho) {
        this.filho = filho;
    }

    public NoArvore<T> getIrmao() {
        return irmao;
    }

    public void setIrmao(NoArvore<T> irmao) {
        this.irmao = irmao;
    }
}
