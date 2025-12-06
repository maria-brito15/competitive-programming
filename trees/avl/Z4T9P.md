## Z4T9P - Enunciado

Considere uma estrutura de dados representada por nós, representados pela classe No, conforme a estrutura apresentada abaixo. A árvore é composta por nós, implementada pela classe Arvore. Implemente, em Java, o método contarNosNaoBalanceados na classe Arvore. Esse método deve retornar um número inteiro que representa a quantidade de nós na árvore cujo fator de balanceamento não atende ao critério de balanceamento de uma árvore AVL. Não é permitido adicionar novos atributos às classes existentes.

```java
class Arvore {
    private No raiz;
    public int contarNosNaoBalanceados() {
        // IMPLEMENTAR
    }
}

class No {
    public int elemento;
    public No esq, dir;
}
```