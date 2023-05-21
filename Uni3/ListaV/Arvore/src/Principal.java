public class Principal {
    public static void main(String[] args) {
        NoArvoreBinaria<Integer> a = new NoArvoreBinaria<Integer>(1); 
        ArvoreBinaria<Integer> arv = new ArvoreBinaria<>();
        arv.setRaiz(a);
        NoArvoreBinaria<Integer> i = new NoArvoreBinaria<Integer>(7); 
        NoArvoreBinaria<Integer> d = new NoArvoreBinaria<Integer>(4); 
        NoArvoreBinaria<Integer> f = new NoArvoreBinaria<Integer>(8); 
        NoArvoreBinaria<Integer> g = new NoArvoreBinaria<Integer>(9); 
        NoArvoreBinaria<Integer> h = new NoArvoreBinaria<Integer>(6); 
        NoArvoreBinaria<Integer> e = new NoArvoreBinaria<Integer>(5); 
        NoArvoreBinaria<Integer> c = new NoArvoreBinaria<Integer>(3); 
        NoArvoreBinaria<Integer> b = new NoArvoreBinaria<Integer>(2); 
        NoArvoreBinaria<Integer> test = arv.pertence(1); 
        System.out.println(test.getInfo());
    }
}
