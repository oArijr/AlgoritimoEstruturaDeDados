

public class ArvoreBST<T extends Comparable<T>> extends ArvoreBinariaAbstract<T> {

	public void inserir(T info) {
		if (this.vazia()) {
			this.setRaiz(new NoArvoreBST<T>(info));
		} else {
			((NoArvoreBST<T>) this.getRaiz()).inserir(info);
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
		NoArvoreBST<T> noARemover = this.buscar(info);
		if (noARemover != null) {
			this.remover(noARemover);
		}
	}

	private void remover(NoArvoreBST<T> noARemover) {
		NoArvoreBST<T> noPai = this.buscarPai(noARemover);
		if (noARemover.getGrau() == 0) { // � folha
			if (noPai == null) { // noARemover � raiz da �rvore
				this.setRaiz(null);
			} else {
				if (noPai.getEsq() == noARemover) {
					noPai.setEsq(null);
				} else {
					noPai.setDir(null);
				}
			}
		} else {
			if (noARemover.getGrau() == 1) { // tem apenas um filho
				NoArvoreBST<T> noFilho = noARemover.buscarFilhoUnico();
				if (noPai == null) { // noARemover � raiz da �rvore
					this.setRaiz(noFilho);
				} else {
					if (noPai.getEsq() == noARemover) {
						noPai.setEsq(noFilho);
					} else {
						noPai.setDir(noFilho);
					}
				}
			} else { // tem 2 filhos
				NoArvoreBST<T> noSucessor = this.buscarSucessor(noARemover);
				T infoSucessor = noSucessor.getInfo();
				this.remover(noSucessor);
				noARemover.setInfo(infoSucessor);
			}
		}
	}

	private NoArvoreBST<T> buscarPai(NoArvoreBST<T> noFilho) {
		if (noFilho == this.getRaiz()) {
			return null;
		}
		NoArvoreBST<T> noPai = (NoArvoreBST<T>) this.getRaiz();
		while (noPai.getEsq() != noFilho && noPai.getDir() != noFilho) {
			if (noFilho.getInfo().compareTo(noPai.getInfo()) < 0) {
				noPai = (NoArvoreBST<T>) noPai.getEsq();
			} else {
				noPai = (NoArvoreBST<T>) noPai.getDir();
			}
		}
		return noPai;
	}

	public NoArvoreBST<T> buscarSucessor(NoArvoreBST<T> no) {
		NoArvoreBST<T> noSucessor = (NoArvoreBST<T>) no.getDir();
		while (noSucessor.getEsq() != null) {
			noSucessor = (NoArvoreBST<T>) noSucessor.getEsq();
		}
		return noSucessor;
	}

	public T buscarMenor() { // contribui��o do Ivo
		if (this.vazia()) {
			return null;
		} else {
			return (((NoArvoreBST<T>) this.getRaiz()).buscarMenor()).getInfo();
		}
	}

	public T buscarMaior() {
		if (this.vazia()) {
			return null;
		} else {
			return (((NoArvoreBST<T>) this.getRaiz()).buscarMaior()).getInfo();
		}
	}

	public NoArvoreBST<T> getAntecessor(T info) {  // contribui��o do Jonathan
		NoArvoreBST<T> no = this.buscar(info);
		if (no == null || info.equals(this.buscarMenor())) {
			return null;
		}
		if (no.getEsq() != null) {  // pode descer?
			return buscarAntecessor(no);
		} else { // ent�o vai subir
			NoArvoreBST<T> pai = this.buscarPai(no);
			while (no == pai.getEsq()) {
				no = pai;
				pai = this.buscarPai(no);
			}
			return pai;
		}
	}

	private NoArvoreBST<T> buscarAntecessor(NoArvoreBinaria<T> no) {
		NoArvoreBST<T> max = (NoArvoreBST<T>) no.getEsq();
		while (max.getDir() != null) {
			max = (NoArvoreBST<T>) max.getDir();
		}
		return max;
	}
	
	public NoArvoreBST<T> getSucessor(T info) {  
		NoArvoreBST<T> no = this.buscar(info);
		if (no == null || info.equals(this.buscarMaior())) {
			return null;
		}
		if (no.getDir() != null) {  // pode descer?
			return buscarSucessor(no);
		} else { // ent�o vai subir
			NoArvoreBST<T> pai = this.buscarPai(no);
			while (no == pai.getDir()) {
				no = pai;
				pai = this.buscarPai(no);
			}
			return pai;
		}
	}
	
	public String toStringOrdered() {   
		if (this.vazia()) {
			return "<>";
		}
		return this.getRaiz().imprimeEmOrdem();
    }
    
}
