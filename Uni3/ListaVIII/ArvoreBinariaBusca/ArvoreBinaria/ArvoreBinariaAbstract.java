public abstract class ArvoreBinariaAbstract<T> {
    private NoArvoreBinaria<T> raiz;

    public ArvoreBinariaAbstract() {
    }

    protected void setRaiz(NoArvoreBinaria<T> no) {
        if (no == null)
            throw new NullPointerException("Nó não pode ser null");
        this.raiz = no;
    }

    protected NoArvoreBinaria<T> getRaiz(){
        return this.raiz;
    }

    public boolean vazia() {
        return this.raiz == null;
    }

    public NoArvoreBinaria<T> pertence(T info) {
        if(this.vazia()){
            return null;
        }
        NoArvoreBinaria<T> no = this.raiz;
        if (no.getInfo().equals(no)) {
            return no;
        }

       return this.raiz.pertence(info); 
    }

    public String toString() {
        if(vazia()){
            return "<>";
        }

        return raiz.imprimePre();
    }
}
