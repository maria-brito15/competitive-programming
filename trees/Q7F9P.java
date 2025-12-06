public boolean isMax(double valor) {
    Armazenador armazenador = new Armazenador();
    
    int altura = altura(this.raiz, armazenador);
    int qntdNos = armazenador.getQntdNos();
    
    double log2 = Math.log(qntdNos) / Math.log(2);

    return altura <= valor * log2;
}

public int altura(No raiz, Armazenador armazenador) {
    if (raiz == null) return -1;
    
    armazenador.addQntdNos();
    
    int altureEsquerda = altura(raiz.esq, armazenador);
    int alturaDireita = altura(raiz.dir, armazenador);
    
    return 1 + Math.max(altureEsquerda, alturaDireita);
}

class Armazenador {
    private int qntdNos = 0;

    public int getQntdNos() { return qntdNos; }
    public void addQntdNos() { qntdNos++; }
}

// altura(): O(n) 
// isMax(): altura O(n) + operações O(1)
// Total: O(n)