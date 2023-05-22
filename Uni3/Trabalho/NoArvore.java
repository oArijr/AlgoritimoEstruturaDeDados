// Ari Elias da Silva Júnior e Luigi Mar
public class NoArvore<T> {
    private T info;
    private NoArvore<T> filho;
    private NoArvore<T> irmao;

    public NoArvore(T info) {
        this.info = info;
        this.filho = null;
        this.irmao = null;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public String imprimePre() {
        String str = "<";
        str += this.info.toString();
        str += this.filho != null ? this.filho.imprimePre() : "";
        str += ">";
        str += this.irmao != null ? this.irmao.imprimePre() : "";
        return str;
    }

    public void inserirFilho(NoArvore<T> filhoNo) {
        filhoNo.irmao = this.filho;
        this.filho = filhoNo;
    }

    public NoArvore<T> pertence(T info) {
        if (this.info.equals(info)) {
            return this;
        } else {
            NoArvore<T> noEncontrado = null;
            if (this.filho != null) {
                noEncontrado = this.filho.pertence(info);
            }
            if (noEncontrado == null && this.irmao != null) {
                noEncontrado = this.irmao.pertence(info);
            }
            return noEncontrado;
        }
    }

    public int getAltura() {
        int cont = 0;
        if (this.filho == null && this.irmao == null) {
            return cont;
        } else {
            NoArvore<T> irmao = this.irmao;
            if (this.filho != null) {
                cont += filho.getAltura() + 1;
            }
            if (irmao != null) {
                int cont2 = 0;
                cont2 += irmao.getAltura();
                if (cont2 > cont) {
                    cont = cont2;
                }
            }
            return cont;
        }
    }

    public int getNivel(T info) {
        int nivel = 0;
        int nivel2 = 0;
        if (info.equals(this.info)) {
            return 1;
        } else {
            if (this.filho != null) {
                nivel += filho.getNivel(info);
                if (nivel > nivel2) {
                    nivel2 = nivel + 1;
                }
            }
            if (this.irmao != null && nivel == 0) {
                nivel2 = irmao.getNivel(info);
            }
            return nivel2;
        }
    }

    public boolean isBalanceada() {
        NoArvore<T> atual = this;
        NoArvore<T> irmao = this.irmao;
        boolean balanceada = true;
        while (irmao != null) {
            if ((atual.getAlturaSub() - irmao.getAlturaSub()) > 1
                    || (irmao.getAlturaSub() - atual.getAlturaSub()) > 1) {
                return false;
            }
            irmao = irmao.getIrmao();
        }
        if (this.filho != null) {
            balanceada = this.filho.isBalanceada();
        }
        if (this.irmao != null) {
            balanceada = this.irmao.isBalanceada();
        }
        return balanceada;
    }

    protected NoArvore<T> getIrmao() {
        return this.irmao;
    }

    protected int getAlturaSub() {
        int cont = 0;
        if (this.filho == null && this.irmao == null) {
            return cont;
        } else {
            if (this.filho != null) {
                cont += filho.getAltura() + 1;
            }
            return cont;
        }
    }

}

