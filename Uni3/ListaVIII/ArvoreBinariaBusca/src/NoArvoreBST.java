public class NoArvoreBST<T extends Comparable<T>> extends NoArvoreBinaria<T> {

    public NoArvoreBST(T info) {
        super(info);
    }

    public void inserir(T info){
        if(info.compareTo(this.getInfo()) < 0){
            if(this.getEsq() == null){
                this.setEsq(new NoArvoreBST<T>(info));
            } else {
                ((NoArvoreBST<T>)this.getEsq()).inserir(info);
            }
        } else {
            if(this.getDir() == null){
                this.setEsq(new NoArvoreBST<T>(info));
            } else {
                ((NoArvoreBST<T>)this.getDir()).inserir(info);
            }
        }
    }   
    
    public NoArvoreBST<T> buscar(T info){
        if(info.equals(this.getInfo())){
            return this;
        } else {
            if(info.compareTo(this.getInfo()) < 0){
                //esquerda
                if(this.getEsq() == null){
                    return null;
                } else {
                    return ((NoArvoreBST<T>)this.getEsq()).buscar(info);
                }
            } else {
                //direita
                if(this.getDir() == null){
                    return null;
                } else {
                    return ((NoArvoreBST<T>)this.getDir()).buscar(info);
                }
            }
        }
    }

   
    public NoArvoreBST<T> buscarFilhoUnico() {
        if(this.getEsq() != null){
            return (NoArvoreBST<T>) this.getEsq();
        } else {
            return (NoArvoreBST<T>) this.getDir();
        }
    }

    public int getGrau() {
        int grau = 0;
        if(this.getEsq() != null){
            grau++;
        }
        if(this.getDir() != null){
            grau++;
        }

        return grau;
    }

    public NoArvoreBST<T> encontraMenorElemento(){
        if(this.getEsq() != null){
            return ((NoArvoreBST<T>) this.getEsq()).encontraMenorElemento();
        }
        return this;
    }

    public NoArvoreBST<T> encontraMaiorElemento(){
        if(this.getDir() != null){
            return ((NoArvoreBST<T>) this.getDir()).encontraMaiorElemento();
        }
        return this;
    }

    public NoArvoreBST<T> encontraAntecessor(){
        if(this.getDir() != null){
            return ((NoArvoreBST<T>) this.getDir()).encontraAntecessor();
        }
        return this;
    }

    public NoArvoreBST<T> encontraSucessor() {
        if(this.getEsq() != null){
            return ((NoArvoreBST<T>) this.getEsq()).encontraSucessor();
        }
        return this;
    }

    public NoArvoreBST<T> buscarPai() {
       
    }
}
