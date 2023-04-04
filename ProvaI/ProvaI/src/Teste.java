public class Teste {
    public static void main(String[] args) {
        ListaEncadeada<String> lista = new ListaEncadeada<>();
        lista.inserir("L");
        lista.inserir("M");
        lista.inserir("A");
        lista.inserir("B");
        lista.inserir("M");
        lista.inserir("N");
        lista.inserir("O");
        lista.inserir("P");
        lista.inserir("P");
        
        
        System.out.println(lista.ultimoIndiceDe("M"));
        System.out.println(lista.ultimoIndiceDe("P"));
        System.out.println(lista.ultimoIndiceDe("K"));
        System.out.println("==================");
        ListaEncadeada<String> lista2 = new ListaEncadeada<>();
        lista2.inserir("A");
        lista2.inserir("B");
        lista2.inserir("C");
        lista2.inserir("C");
        lista2.inserir("L");
        ListaEncadeada<String> lista3 = new ListaEncadeada<>();
        lista3.inserir("D");
        lista3.inserir("E");
        lista3.inserir("F");

        ListaEncadeada<String> listaIntercalada = lista2.intercala(lista3);
        System.out.println(listaIntercalada.exibir());
        System.out.println(listaIntercalada.getTamanho());
        System.out.println((lista2.getTamanho() + lista3.getTamanho()));
    }
}
