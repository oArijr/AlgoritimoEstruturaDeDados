public class NoArvoreBinaria<T> {
    private T info;
    private NoArvoreBinaria<T> esq;
    private NoArvoreBinaria<T> dir;

    public NoArvoreBinaria(T info) {
        setInfo(info);
    }

    public NoArvoreBinaria(T info, NoArvoreBinaria<T> esq, NoArvoreBinaria<T> dir) {
        setInfo(info);
        setEsq(esq);
        setDir(dir);
    }

    public NoArvoreBinaria<T> pertence(T info) {
        if (this.info.equals(info)) {
            return this;
        } else {
            NoArvoreBinaria<T> esq = this.getEsq();
            NoArvoreBinaria<T> dir = this.getDir();
            if(esq != null){
                esq.pertence(info);
            } else if (dir != null){
                dir.pertence(info);
            }
            return null; 
        }
    }

    public String imprimePre() {
        String str = "";

		str += "<" + this.info.toString();
		str += this.esq != null ? this.esq.imprimePre() : "<>";
		str += this.dir != null ? this.dir.imprimePre() : "<>";

		return str + ">";
    }

    public String imprimeEmOrdem(){
        String str = "";

		str += this.esq != null ? this.esq.imprimePre() : "";
        str += "<" + this.info.toString();
		str += this.dir != null ? this.dir.imprimePre() : "";

		return str;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public NoArvoreBinaria<T> getEsq() {
        return esq;
    }

    public void setEsq(NoArvoreBinaria<T> esq) {
        this.esq = esq;
    }

    public NoArvoreBinaria<T> getDir() {
        return dir;
    }

    public void setDir(NoArvoreBinaria<T> dir) {
        this.dir = dir;
    }

 

}
