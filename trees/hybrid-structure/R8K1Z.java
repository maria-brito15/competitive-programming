public boolean pesquisar(String nome) {
    No noEncontrado = buscarNaArvore(nome.charAt(0));
    
    if (noEncontrado == null) {
        return false;
    }
    
    if (pesquisarEmT1(noEncontrado.t1, nome)) {
        return true;
    }
    
    return pesquisarEmT2(noEncontrado.t1, nome);
}

private No buscarNaArvore(char caractere) {
    No atual = raiz;
    boolean encontrado = false;
    
    while (atual != null && !encontrado) {
        if (atual.caracter == caractere) {
            encontrado = true;
        } else if (caractere < atual.caracter) {
            atual = atual.esq;
        } else {
            atual = atual.dir;
        }
    }
    
    return atual;
}

private boolean pesquisarEmT1(T1 t1, String nome) {
    char ultimoChar = nome.charAt(nome.length() - 1);
    int tam = t1.palavras.length;
    int indice = hashT1(ultimoChar, tam);
    
    int tentativas = 0;
    boolean posicaoValida = true;
    boolean encontrado = false;
    
    while (tentativas < tam && posicaoValida && !encontrado) {
        String palavraAtual = t1.palavras[indice];
        
        if (palavraAtual == null) {
            posicaoValida = false;
        } else if (palavraAtual.equals(nome)) {
            encontrado = true;
        } else {
            indice = rehashT1(ultimoChar, tam);
            ultimoChar++;
            tentativas++;
        }
    }
    
    return encontrado;
}

private boolean pesquisarEmT2(T1 t1, String nome) {
    if (t1.t2 == null) {
        return false;
    }
    
    int tamanho = nome.length();
    int tam = t1.t2.celulasT2.length;
    int indice = hashT2(tamanho, tam);
    
    CelulaT2 celulaT2 = t1.t2.celulasT2[indice];
    
    if (celulaT2 == null || celulaT2.inicio == null) {
        return false;
    }
    
    return pesquisarNaLista(celulaT2.inicio, nome);
}

private boolean pesquisarNaLista(Celula inicio, String nome) {
    Celula atual = inicio;
    boolean encontrado = false;
    
    while (atual != null && !encontrado) {
        if (atual.palavra.equals(nome)) {
            encontrado = true;
        } else {
            atual = atual.prox;
        }
    }
    
    return encontrado;
}

private int hashT1(char c, int tam) {
    return c % tam;
}

private int rehashT1(char c, int tam) {
    return ++c % tam;
}

private int hashT2(int tamanho, int tam) {
    return tamanho % tam;
}