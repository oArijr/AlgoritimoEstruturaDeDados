
public interface Lista<T> {

	void inserir(T valor);
	
	void inserir(T valor, int pos);
	
	int buscar(T valor);

	boolean estaVazia();

	void retirar(T valor);

	String exibir();

	Lista<T> copiar();

	Lista<T> dividir();

	int getTamanho();

	void concatenar(Lista<T> outraLista);

	T pegar(int pos);

}
