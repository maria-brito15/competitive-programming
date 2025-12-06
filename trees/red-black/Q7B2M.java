// VERIFICADOR DE ÁRVORE ALVINEGRA PARA CONDIÇÃO DE COMPRIMENTO DE CAMINHO

public boolean verificaArvore() {
    if (this.raiz == null) return true;
    return isCondicao(this.raiz);
}

private int caminhoMaisLongo(NoAN no) {
    if (no == null) return -1; 
    return 1 + Math.max(caminhoMaisLongo(no.esq), caminhoMaisLongo(no.dir));
}

private int caminhoMaisCurto(NoAN no) {
    if (no == null) return -1; 
    return 1 + Math.min(caminhoMaisCurto(no.esq), caminhoMaisCurto(no.dir));
}

public boolean isCondicao(NoAN no) {
    if (no == null) return true;

    int caminhoMaisLongo = caminhoMaisLongo(no);
    int caminhoMaisCurto = caminhoMaisCurto(no);

    if (caminhoMaisLongo > caminhoMaisCurto * 2) return false;

    boolean esqValida = isCondicao(no.esq);
    boolean dirValida = isCondicao(no.dir);

    return esqValida && dirValida;
}