## Hash com Lista Encadeada

Você foi contratado para criar um sistema de consulta rápida de veículos para um pátio de apreensões. O sistema deve usar uma **Tabela Hash** para garantir que as consultas sejam (em média) muito rápidas.

A primeira linha da entrada será um número inteiro $N$ que representa o tamanho da tabela hash. Você deverá implementar uma tabela hash com **tratamento de colisão por lista encadeada** (cada posição da tabela é uma lista de carros).

A função de hash para mapear a placa a uma posição na tabela fica a seu critério (uma sugestão é somar os valores ASCII dos caracteres da placa e aplicar o resto da divisão por $N$).

Primeiro, leia os dados dos veículos e insira-os na tabela hash. A inserção termina com a palavra **FIM**. Em seguida, leia uma série de placas para consulta. Para cada placa consultada:

  * Se o veículo for encontrado, imprima seus dados completos.
  * Se não for encontrado, imprima **VEICULO NAO CADASTRADO**.

A fase de consulta termina com a palavra-chave **FIM\_CONSULTA**.

### Entrada

1.  Uma linha com um inteiro $N$ (tamanho da tabela hash).
2.  Várias linhas com dados de carros, no formato: `placa,modelo,tipo,chassi`
3.  Uma linha contendo: **FIM** indicando o fim da fase de inserção.
4.  Várias linhas com placas para consulta (uma placa por linha).
5.  Uma linha contendo: **FIM\_CONSULTA** indicando o fim da fase de consultas.

### Saída

  * Para cada busca bem-sucedida (veículo encontrado na tabela hash), imprima: `[placa] [modelo] [tipo] [chassi]`
  * Para cada busca sem sucesso (veículo não encontrado), imprima: **VEICULO NAO CADASTRADO**

### Classe Carro (em Java)

```java
class Carro {
    String placa, modelo, tipo, chassi;

    void ler(String linha) {
        String[] partes = linha.split(",");
        placa = partes[0];
        modelo = partes[1];
        tipo = partes[2];
        chassi = partes[3];
    }

    void imprimir() {
        System.out.println(placa + " " + modelo + " " + tipo + " " + chassi);
    }
}
```