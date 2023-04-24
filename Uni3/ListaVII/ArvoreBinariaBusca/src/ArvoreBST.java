public class ArvoreBST<T extends Comparable<T>> extends ArvoreBinariaAbstract<T> {
    public ArvoreBST() {
    }

    public void inserir(T info) {
        NoArvoreBST<T> no = new NoArvoreBST<T>(info);
        if (this.vazia()) {
            this.setRaiz(no);
        } else {
            NoArvoreBST<T> raiz = ((NoArvoreBST<T>) this.getRaiz());
            raiz.inserir(info);
        }
    }

    public NoArvoreBST<T> buscar(T info) {
        if (this.vazia()) {
            return null;
        } else {
            return ((NoArvoreBST<T>) this.getRaiz()).buscar(info);
        }
    }

    public void retirar(T info) {
        NoArvoreBST<T> noRemover = this.buscar(info);
        if (noRemover != null) {
            this.remover(noRemover);
        }
    }

    private void remover(NoArvoreBST<T> noRemover) {
        NoArvoreBST<T> noPai = this.buscarPai(noRemover);
        if (noRemover.getGrau() == 0) { // é folha
            if (noPai == null) { // noRemover é raiz da arvore
                this.setRaiz(null);
            }
            if (noPai.getEsq() == noRemover) {
                noPai.setEsq(null);
            } else {
                noPai.setDir(null);
            }
        } else if (noRemover.getGrau() == 1) { // tem apenas um filho
            NoArvoreBST<T> noFilho = noRemover.buscarFilhoUnico();
            if (noPai == null) { // noRemover é raiz da arvore
                this.setRaiz(noFilho);
            }
            if (noPai.getEsq() == noRemover) {
                noPai.setEsq(noFilho);
            } else {
                noPai.setDir(noFilho);
            }
        } else { // tem dois filhos
            NoArvoreBST<T> noSucessor = this.buscarSucessor(noRemover);
            T infoSucessor = noSucessor.getInfo();
            this.remover(noSucessor);
            noRemover.setInfo(infoSucessor);
        }
    }

    private NoArvoreBST<T> buscarSucessor(NoArvoreBST<T> no) {
        NoArvoreBST<T> noSucessor = (NoArvoreBST<T>) no.getDir();
        while (noSucessor.getEsq() != null) {
            noSucessor = (NoArvoreBST<T>) noSucessor.getEsq();
        }
        return noSucessor;
    }

    private NoArvoreBST<T> buscarPai(NoArvoreBST<T> noProcurar) {
        if (noProcurar == this.getRaiz()) {
            return null;
        } else {
            NoArvoreBST<T> noPai = (NoArvoreBST<T>) this.getRaiz();
            if (noPai.getEsq() != noProcurar && noPai.getDir() != noProcurar) {

                if (noProcurar.getInfo().compareTo(noPai.getInfo()) < 0) {
                    noPai = (NoArvoreBST<T>) noPai.getEsq();
                } else {
                    noPai = (NoArvoreBST<T>) noPai.getDir();
                }
            }
            return noPai;
        }
    }

}
