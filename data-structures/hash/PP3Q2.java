import java.util.Scanner;

class Carro {
    String placa, modelo, tipo, chassi;
    
    public Carro() {}
    
    void ler(String linha) {
        String[] partes = linha.split(",");
        this.placa = partes[0];
        this.modelo = partes[1];
        this.tipo = partes[2];
        this.chassi = partes[3];
    }
    
    void imprimir() {
        System.out.println("[" + placa + "] [" + modelo + "] [" + tipo + "] [" + chassi + "]");
    }
}

class Entrada {
    String chave;
    Carro valor;
    Entrada proximo;
    
    public Entrada(String chave, Carro valor) {
        this.chave = chave;
        this.valor = valor;
        this.proximo = null;
    }
}

class TabelaHash {
    private Entrada[] baldes;
    private int capacidade;
    
    public TabelaHash(int capacidade) {
        this.capacidade = capacidade;
        this.baldes = new Entrada[capacidade];
    }
    
    private int calcularHash(String chave) {
        int soma = 0;
        for (int i = 0; i < chave.length(); i++) {
            soma += chave.charAt(i);
        }
        return soma % capacidade;
    }
    
    public void inserir(String chave, Carro valor) {
        int indice = calcularHash(chave);
        Entrada atual = baldes[indice];
        
        while (atual != null) {
            if (atual.chave.equals(chave)) {
                atual.valor = valor;
                return;
            }
            
            atual = atual.proximo;
        }
        
        Entrada novo = new Entrada(chave, valor);
        novo.proximo = baldes[indice];
        baldes[indice] = novo;
    }
    
    public Carro buscar(String chave) {
        int indice = calcularHash(chave);
        Entrada atual = baldes[indice];
        
        while (atual != null) {
            if (atual.chave.equals(chave)) {
                return atual.valor;
            }
            
            atual = atual.proximo;
        }
        
        return null;
    }
}

public class PP3Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            scanner.nextLine();
            
            TabelaHash tabela = new TabelaHash(n);
            boolean inserindo = true;
            
            while (inserindo) {
                String linha = scanner.nextLine();
                
                if (linha.equals("FIM")) {
                    inserindo = false;
                } else {
                    Carro c = new Carro();
                    c.ler(linha);
                    tabela.inserir(c.placa, c);
                }
            }
            
            boolean consultando = true;
            
            while (consultando) {
                String linha = scanner.nextLine();
                
                if (linha.equals("FIM_CONSULTA")) {
                    consultando = false;
                } else {
                    Carro encontrado = tabela.buscar(linha);
                    
                    if (encontrado != null) {
                        encontrado.imprimir();
                    } else {
                        System.out.println("VEICULO NAO CADASTRADO");
                    }
                }
            }
        }
        
        scanner.close();
    }
}