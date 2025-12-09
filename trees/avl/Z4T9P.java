// QUANTIDADE DE NÓS NÃO BALANCEADOS

class Contador {
    private int qntd = 0;

    public int getQntd() { return qntd; }
    public void addQntd() { qntd++; }
}

public int contarNosNaoBalanceados() {
    Contador contador = new Contador();
    verificarAVL(this.raiz, contador);
    return contador.getQntd();
}

public int verificarAVL(No no, Contador contador) {
    if (no == null) return 0;

    int alturaEsquerda = verificarAVL(no.esquerda, contador); 
    int alturaDireita = verificarAVL(no.direita, contador);
    int fatorBalanceamento = alturaEsquerda - alturaDireita;

    if (!(fatorBalanceamento >= -1 && fatorBalanceamento <= 1)) {
        contador.addQntd();
    }

    return 1 + Math.max(alturaEsquerda, alturaDireita);
}
