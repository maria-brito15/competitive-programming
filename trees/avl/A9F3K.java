// VERIFICADOR DE ÁRVORE BINÁRIA DE BUSCA + AVL

public boolean isAVL() {
    if (!isBST(this.raiz, Integer.MIN_VALUE, Integer.MAX_VALUE)) return false;
    return verificarAVL(raiz) != -2;
}

public int verificarAVL(No no) {
    if (no == null) return -1;

    int alturaEsquerda = verificarAVL(no.esquerda);
    if (alturaEsquerda == -2) return -2;

    int alturaDireita = verificarAVL(no.direita);
    if (alturaDireita == -2) return -2;

    int fatorBalanceamento = alturaEsquerda - alturaDireita;
    
    if (fatorBalanceamento >= -1 && fatorBalanceamento <= 1) {
        return 1 + Math.max(alturaEsquerda, alturaDireita);
    } else {
        return -2;
    }
}

public boolean isBST(No no, int min, int max) {
    if (no == null) return true;
    
    if (no.elemento < min || no.elemento > max) return false;
    
    boolean isEsq = isBST(no.esq, min, no.elemento);
    boolean isDir = isBST(no.dir, no.elemento, max);
    
    return isEsq && isDir;
}