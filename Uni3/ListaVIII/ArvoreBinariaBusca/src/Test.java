public class Test {
    public static void main(String[] args) {
        Veiculo a = new Veiculo("MJT-7432", "Fusca", 1912, "Pedro");
        Veiculo b = new Veiculo("MIT-8008", "Celta", 1999, "Douglas");
        Veiculo c = new Veiculo("MEI-4665", "Gol", 2002, "Carlos");
        Veiculo d = new Veiculo("MIO-6668", "Fusca", 1915, "Aline");
        Veiculo e = new Veiculo("DIO-3333", "Celta", 1999, "Fausto");
        Veiculo f = new Veiculo("PAO-6472", "C3", 2007, "Carolina");
        Veiculo g = new Veiculo("CAO-2890", "C4", 2012, "Kelvin");
        Veiculo h = new Veiculo("UVA-3939", "BMW", 2015, "Zé");
        Veiculo i = new Veiculo("OVO-0000", "Gol", 2000, "Joshua");
        Veiculo j = new Veiculo("ABC-1234", "Ferrari", 2015, "Marta");
        
        ArvoreBST<Veiculo> avr = new ArvoreBST<>();
        avr.inserir(a);
        avr.inserir(b);
        avr.inserir(c);
        avr.inserir(d);
        avr.inserir(e);
        avr.inserir(f);
        avr.inserir(g);
        avr.inserir(h);
        avr.inserir(i);
        avr.inserir(j);

        System.out.println(avr.toString());
    }
}
