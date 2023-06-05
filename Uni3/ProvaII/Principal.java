public class Principal {
    public static void main(String[] args) {
        NoArvore<Integer> n13 = new NoArvore<Integer>(13);
        NoArvore<Integer> n12 = new NoArvore<Integer>(12);
        NoArvore<Integer> n11 = new NoArvore<Integer>(11);
        NoArvore<Integer> n10 = new NoArvore<Integer>(10);
        NoArvore<Integer> n4 = new NoArvore<Integer>(4);
        NoArvore<Integer> n8 = new NoArvore<Integer>(8);
        NoArvore<Integer> n9 = new NoArvore<Integer>(9);
        n9.inserirFilho(n13);
        n9.inserirFilho(n12);
        n9.inserirFilho(n11);
        n9.inserirFilho(n10);
        NoArvore<Integer> n3 = new NoArvore<Integer>(3);
        n3.inserirFilho(n4);
        NoArvore<Integer> n5 = new NoArvore<Integer>(5);
        NoArvore<Integer> n6 = new NoArvore<Integer>(6);
        NoArvore<Integer> n7 = new NoArvore<Integer>(7);
        n7.inserirFilho(n8);
        n7.inserirFilho(n9);
        NoArvore<Integer> n2 = new NoArvore<Integer>(2);
        n2.inserirFilho(n5);
        n2.inserirFilho(n3);
        NoArvore<Integer> n1 = new NoArvore<Integer>(1);
        n1.inserirFilho(n7);
        n1.inserirFilho(n6);
        n1.inserirFilho(n2);
        Arvore<Integer> arvore = new Arvore<>();
        arvore.setRaiz(n1);
        System.out.println(arvore);
        System.out.println(arvore.pertence(2).getInfo());
        System.out.println(arvore.pertence(3).getInfo());
        System.out.println(arvore.pertence(11).getInfo());
        System.out.println(arvore.pertence(8).getInfo());
        System.out.println(arvore.pertence(6).getInfo());
        System.out.println(arvore.caminho(5));
        System.out.println(arvore.caminho(9));
        System.out.println(arvore.caminho(8));
        System.out.println(arvore.caminho(6));
        System.out.println(arvore.caminho(150));
        System.out.println(arvore.getGrau());
    }
}
