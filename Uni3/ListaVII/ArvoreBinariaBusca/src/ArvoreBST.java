public class ArvoreBST<T extends Comparable<T>> extends ArvoreBinariaAbstract<T>{
    public ArvoreBST(){
    }

    public void inserir(T info){
        NoArvoreBST<T> no = new NoArvoreBST<T>(info);
        if(this.vazia()){
            this.setRaiz(no);
        } else {
            NoArvoreBST<T> raiz = ((NoArvoreBST<T>)this.getRaiz());
            raiz.inserir(info);
        }
    }

    public NoArvoreBST<T> buscar(T info){
        if(this.vazia()){
            return null;
        } else {
            return ((NoArvoreBST<T>)this.getRaiz()).buscar(info);
        }
    }

    public void retirar(T info){
        NoArvoreBST<T> remover;
        if(info.equals(this.getRaiz().getInfo())){
            if(this.getRaiz().getDir() != null && this.getRaiz().getEsq() != null){
                //dois filhos
                remover = (NoArvoreBST<T>)this.getRaiz().getDir();
                
            }
        }
    }
}
