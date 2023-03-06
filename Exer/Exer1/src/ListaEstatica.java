public class ListaEstatica {
    private int[] info;
    private int tamanho;

    public ListaEstatica() {
        info = new int[10];
        tamanho = 0;
    }

    public int[] getInfo() {
        return info;
    }
    
    public void setInfo(int[] info) {
        this.info = info;
    }
    public int getTamanho() {
        return tamanho;
    }
    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    private void redimensionar(){
        int[] f = getInfo();
        int[] novoVetor = new int[f.length + 10];
        for (int i = 0; i < f.length; i++){
            novoVetor[i] = f[i];
        }
        setInfo(novoVetor);
    }

    public void inserir(int valor){
        int tamanho = getTamanho();
        if(tamanho == getInfo().length){
            this.redimensionar();
        }
        info[getTamanho()] = valor;
        tamanho++;
        setTamanho(tamanho);
    }

    public void exibir(){

    }

    public int buscar(int valor){
        int[] f = getInfo();
        for(int i = 0; i < getTamanho(); i++){
            if(f[i] == valor){
                return i;
            }
        }
        return -1;
    }
    
    public void retirar(int valor){
        int[] f = getInfo();
        tamanho = getTamanho();
        int pos = this.buscar(valor);
        if (pos != -1){
            for(int i = 0; i < (getTamanho() - 1); i++){
                f[i] = f[i+1];
            }
            tamanho--;
            setInfo(f);
            setTamanho(tamanho);
        }
    }
    
    public boolean estaVazia(){
        if(getTamanho() == 0){
            return true;
        }
        return false;
    }
}
