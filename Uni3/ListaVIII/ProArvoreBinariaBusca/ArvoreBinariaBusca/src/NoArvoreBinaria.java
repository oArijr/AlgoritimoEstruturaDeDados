

public class NoArvoreBinaria<T> { // contribui��o Maria Clara
	private T info;
	private NoArvoreBinaria<T> esq;
	private NoArvoreBinaria<T> dir;

	public NoArvoreBinaria(T info) {
		this.info = info;
		this.esq = null;
		this.dir = null;
	}

	public NoArvoreBinaria(T info, NoArvoreBinaria<T> esq, NoArvoreBinaria<T> dir) {
		this.info = info;
		this.esq = esq;
		this.dir = dir;
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

	public T getInfo() {
		return this.info;
	}
	
	public void setInfo(T info) {
		this.info = info;
	}

	public NoArvoreBinaria<T> pertence(T info) {

		if (this.info.equals(info)) {
			return this;
		} else {
			NoArvoreBinaria<T> noEncontrado = null;

			if (this.esq != null) {
				noEncontrado = this.esq.pertence(info);
			}

			if (noEncontrado == null && this.dir != null) {
				noEncontrado = this.dir.pertence(info);
			}

			return noEncontrado;
		}
	}


	public String imprimePre() {
		String str = "";

		str += "<" + this.info.toString();
		str += this.esq != null ? this.esq.imprimePre() : "<>";
		str += this.dir != null ? this.dir.imprimePre() : "<>";

		return str + ">";
	}

	public String imprimeEmOrdem() {
		String str = "";
		str += this.esq != null ? this.esq.imprimeEmOrdem() : "";
		str += " " + this.info.toString();
		str += this.dir != null ? this.dir.imprimeEmOrdem() : "";
		return str ;
	}
	
}