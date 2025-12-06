## Q7F9P - Enunciado

Considere as classes abaixo que representam uma Árvore Binária. Você deve implementar o método `boolean isMax(double valor)` na classe Arvore, que verifica se a árvore tem **altura** de, no máximo, o valor passado como parâmetro multiplicado pelo **Log₂** da **quantidade de nós**.

Por exemplo, se o usuário passar como parâmetro o valor **1.4**, o método retorna **TRUE** se a **altura da árvore** for, no máximo, **1.4 * Log₂(quantidadeNós)**.

NÃO estão implementados métodos para obter altura ou quantidade de nós. Faça a **análise de complexidade** da sua solução.

```java
class No {
    public int elemento;
    public No esq, dir;
}

public class Arvore {
    private No raiz;

    public boolean isMax(double valor) {
        // Implemente o método aqui
    }
}
```