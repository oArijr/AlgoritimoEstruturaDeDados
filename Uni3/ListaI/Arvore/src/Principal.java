public class Principal {
    public static void main(String[] args) {
        ArvoreBinaria<Integer> arv = new ArvoreBinaria<>();
        NoArvoreBinaria<Integer> i = new NoArvoreBinaria<Integer>(7); 
        NoArvoreBinaria<Integer> d = new NoArvoreBinaria<Integer>(4); 
        NoArvoreBinaria<Integer> f = new NoArvoreBinaria<Integer>(8); 
        NoArvoreBinaria<Integer> g = new NoArvoreBinaria<Integer>(9); 
        NoArvoreBinaria<Integer> h = new NoArvoreBinaria<Integer>(6, i, null); 
        NoArvoreBinaria<Integer> e = new NoArvoreBinaria<Integer>(5, f, g); 
        NoArvoreBinaria<Integer> c = new NoArvoreBinaria<Integer>(3, null, h); 
        NoArvoreBinaria<Integer> b = new NoArvoreBinaria<Integer>(2, d, e); 
        NoArvoreBinaria<Integer> a = new NoArvoreBinaria<Integer>(1, b, c); 
        arv.setRaiz(a);
        NoArvoreBinaria<Integer> test = arv.pertence(6); 
        System.out.println(test.getInfo());
    }
}
