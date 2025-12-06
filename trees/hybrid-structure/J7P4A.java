// t1.pesquisar(palavra)
public boolean pesquisar(String palavra) {
    boolean achou = false;
    
    int indiceT1 = this.hashT1(palavra.length(), TAM1);
    if (pesquisarEmT1(this, indiceT1, palavra)) return true;
    
    int hashVirtual = hashVirtual(palavra.charAt(0));
    if (hashVirtual == 0) {
        achou = pesquisarEmMatriz(palavra, this.L, this.C, this.inicio);
        
    } else if (hashVirtual == 1) {
        T2 t2 = this.t2;
        
        int indiceT2 = t2.hashT2(palavra.charAt(2));
        if (pesquisarEmT2(t2, indiceT2, palavra)) return true;
        
        int novoIndiceT2 = t2.rehashT2(palavra.charAt(2));
        if (pesquisarEmT2(t2, novoIndiceT2, palavra)) return true;
        
        achou = pesquisarEmListaT2(t2.inicio, palavra);
    }
    
    return achou;
}

public boolean pesquisarEmT1(T1 t1, int pos, String palavra) {
    return t1.palavras[pos] != null && t1.palavras[pos].equals(palavra); 
}

public boolean pesquisarEmT2(T2 t2, int pos, String palavra) {
    return t2.palavra[pos] != null && t2.palavra[pos].equals(palavra);
}

public boolean pesquisarEmListaT2(Celula2 inicio, String palavra) {
    Celula2 atual = incio;
    
    while (atual != null) {
        if (atual.palavra.equals(palavra)) {
            return true;
        }
        
        atual = atual.prox;
    }
    
    return false;
}

public boolean pesquisarEmMatriz(String palavra, int LINHAS, int COLUNAS, CelulaMat inicio) {
    char ultimo = palavra.length - 1;
    char penultimo = palavra.length - 2;
    
    int indiceLinha = hashLinha(ultimo, LINHAS);
    int indiceColuna = hashColuna(penultimo, COLUNAS);
    
    CelulaMat atual = inicio;
    
    for (int i = 0; i < indiceLinha && atual != null; i++) {
        if (atual != null) atual = atual.inf;
    }
    
    for (int i = 0; i < indiceColuna && atual != null; i++) {
        if (atual != null) atual = atual.dir;
    }
    
    Celula inicio = atual.primeiro;
    return pesquisarEmListaMatriz(inicio, palavra);
}

public boolean pesquisarEmListaMatriz(Celula inicio, String palavra) {
    Celula atual = incio;
    
    while (atual != null) {
        if (atual.palavra.equals(palavra)) {
            return true;
        }
        
        atual = atual.prox;
    }
    
    return false;
}
