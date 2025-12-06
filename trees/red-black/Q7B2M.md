## Q7B2M - Enunciado

Considere as classes abaixo que representam uma Árvore Alvinegra (Rubro-Negra). Você deve implementar o método boolean verificaArvore() na classe ArvoreAlvinegra, que demonstra que o caminho mais longo a partir de um nó $x$ em uma árvore Alvinegra até uma folha descendente tem comprimento no máximo duas vezes o comprimento do caminho mais curto a partir do nó $x$ até uma folha descendente. Faça a análise de complexidade da sua função.

```java
class NoAN {
    public boolean cor;
    public int elemento;
    public NoAN esq, dir;
}

public class ArvoreAlvinegra {
    private NoAN raiz;
    public boolean verificaArvore() {
        // Implemente o método aqui
    }
}
```