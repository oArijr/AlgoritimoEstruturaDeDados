public class Principal {
    public static void main(String[] args) {
        //Criando Arvore
        Arvore<Integer> avr = new Arvore<>();
        // Adicionando Raiz
        NoArvore<Integer> no1 = new NoArvore<Integer>(1);
        avr.setRaiz(no1);
        // Adicionando filhos na Raiz
        NoArvore<Integer> no2 = new NoArvore<Integer>(2);
        NoArvore<Integer> no3 = new NoArvore<Integer>(3);
        NoArvore<Integer> no4 = new NoArvore<Integer>(4);
        no1.inserirFilho(no2);
        no1.inserirFilho(no3);
        no1.inserirFilho(no4);
        // Adicionado filhos no no2
        NoArvore<Integer> no5 = new NoArvore<Integer>(5);
        NoArvore<Integer> no6 = new NoArvore<Integer>(6);
        no2.inserirFilho(no5);
        no2.inserirFilho(no6);
        // Adicionando filho no no4
        NoArvore<Integer> no7 = new NoArvore<Integer>(7);
        no4.inserirFilho(no7);

        System.out.println(avr.toString());
        System.out.println(avr.pertence(7).getInfo());
        System.out.println(avr.pertence(6).getInfo());
        System.out.println(avr.pertence(3).getInfo());

    }
}
