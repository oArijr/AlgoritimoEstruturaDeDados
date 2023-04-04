//Ari Elias da Silva Júnior
public class ListaEncadeada<T> implements Lista<T> {

	private NoLista<T> primeiro;
	private NoLista<T> ultimo;
	private int qtdElementos;

	@Override
	public void inserir(T valor) {
		NoLista<T> novo = new NoLista<>();
		novo.setInfo(valor);
		if (this.estaVazia()) {
			primeiro = novo;
		} else {
			ultimo.setProximo(novo);
		}
		ultimo = novo;
		qtdElementos++;
	}

	@Override
	public void inserir(T valor, int pos) {
		// TODO Auto-generated method stub

	}

	public ListaEncadeada<T> intercala(ListaEncadeada<T> outra) {
		if(outra.estaVazia() || outra == null){
			throw new NullPointerException("A lista inserida está vazia!");
		}
		ListaEncadeada<T> nova = new ListaEncadeada<>();
		int tamanho = this.getTamanho() + outra.getTamanho();
		int j = 0;
		int k = 0;
		while((j + k) != tamanho){
			if(j != this.getTamanho()){
				nova.inserir(this.pegar(j));
				j++;
			}
			if(k != outra.getTamanho()){
				nova.inserir(outra.pegar(k));
				k++;
			}
		}
		return nova;
	}

	public int ultimoIndiceDe(T x) {
		// NoLista<T> buscando = new NoLista<>();
		// buscando.setInfo(x);
		if (x == null) {
			throw new NullPointerException("Valor não pode ser nulo");
		}
		NoLista<T> p = this.primeiro;
		int indice = -1;
		int cont = 0;
		while (p != null) {
			if (x.equals(p.getInfo())) { // if(buscando.getInfo.equals(p.getInfo()))
				indice = cont;
			}
			p = p.getProximo();
			cont++;
		}
		return indice;
	}

	@Override
	public int buscar(T valor) { // contribuição da Maria Julia
		NoLista<T> p = primeiro;
		int cont = 0;
		while (p != null) {
			if (p.getInfo().equals(valor)) {
				return cont;
			}
			p = p.getProximo();
			cont++;
		}
		return -1;
	}

	@Override
	public boolean estaVazia() {
		return (primeiro == null);
	}

	@Override
	public void retirar(T valor) { // contribuição do Carlos
		NoLista<T> before = null;
		NoLista<T> current = this.primeiro;
		while (current != null && !current.getInfo().equals(valor)) {
			before = current;
			current = current.getProximo();
		}

		if (current != null) {
			if (before == null) {
				this.primeiro = this.primeiro.getProximo();
			} else {
				before.setProximo(current.getProximo());
			}
			if (this.ultimo == current) {
				this.ultimo = before;
			}
			this.qtdElementos--;
		}
	}

	@Override
	public String exibir() { // contribuição do Jonathan
		NoLista<T> p = primeiro;
		String str = "[";
		while (p != null) {
			str += p.getInfo() + ", ";
			p = p.getProximo();
		}
		return str + "]";
	}

	@Override
	public Lista<T> copiar() { // contribuição do Rodrigo
		ListaEncadeada<T> novaLista = new ListaEncadeada<>();
		for (NoLista<T> no = this.primeiro; no != null; no = no.getProximo()) {
			novaLista.inserir(no.getInfo());
		}
		return novaLista;
	}

	@Override
	public Lista<T> dividir() { // contribuição do Jonathan
		ListaEncadeada<T> downNova = new ListaEncadeada<>();
		NoLista<T> atual = this.primeiro;
		NoLista<T> anterior = null;
		for (int i = 0; i < this.getTamanho() / 2; i++) {
			anterior = atual;
			atual = atual.getProximo();
		}
		downNova.primeiro = atual;
		downNova.ultimo = this.ultimo;
		this.ultimo = anterior;
		anterior.setProximo(null);
		downNova.qtdElementos = this.getTamanho() - (this.getTamanho() / 2);
		this.qtdElementos = this.getTamanho() / 2;

		return downNova;
	}

	@Override
	public int getTamanho() {
		return this.qtdElementos;
	}

	@Override
	public void concatenar(Lista<T> outraLista) {
		for (int i = 0; i < outraLista.getTamanho(); i++) {
			this.inserir(outraLista.pegar(i));
		}
	}

	@Override
	public T pegar(int pos) {
		if (pos < 0 || pos >= this.qtdElementos) {
			throw new IndexOutOfBoundsException("Pos=" + pos);
		}
		NoLista<T> p = this.primeiro;
		int posicao = 0;
		while (p != null) {
			if (posicao == pos) {
				return p.getInfo();
			}
			posicao++;
			p = p.getProximo();
		}
		return null; // nunca deveria chegar aqui
	}
}