

// Ari Elias da Silva Júnior
public class Arvore<T> {  // contribui��o do Jonathan

	private NoArvore<T> raiz;

	public void setRaiz(NoArvore<T> noRaiz) {
		this.raiz = noRaiz;
	}

	public NoArvore<T> getRaiz() {
		return this.raiz;
	}

	public String toString() {
		if (this.vazia()) {
			return "<>";
		}
		return this.raiz.imprimePre();
	}

	public boolean vazia() {
		return this.raiz == null;
	}

	public NoArvore<T> pertence(T info) {
		if (this.vazia()) {
			return null;
		}
		return this.raiz.pertence(info);
	}

	public int getAltura(){
		if(vazia()){
			return -1;
		}
		return this.raiz.getAltura();
	}

	public int getNivel(T info){
		if(this.pertence(info) == null){
			return -1;
		} else {
			if(raiz.getInfo().equals(info)){
				return 0;
			}
			return raiz.getNivel(info) - 1;
		}
	}

	public boolean isBalanceada(){
		if(vazia()){
			return true;
		}
		if(this.raiz.getAltura() == 0){
			return true;
		}
		return this.raiz.isBalanceada();
	}

	public String caminho(T procurado){
		if(vazia() || pertence(procurado) == null){
			return null;
		}
		return this.raiz.caminho(procurado);
	}

	public int getGrau(){
		if(vazia()){
			return -1;
		}

		return this.raiz.getGrau();
	}
}
