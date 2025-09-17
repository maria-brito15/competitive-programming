import java.util.Scanner;

class Pais {
    // atributos
    private String nome;
    private Integer ouro;
    private Integer prata;
    private Integer bronze;

    // construtor
    public Pais(String nome, Integer ouro,
            Integer prata, Integer bronze) {
        this.nome = nome;
        this.ouro = ouro;
        this.prata = prata;
        this.bronze = bronze;
    }

    // getters
    public String getNome() { return nome; }
    public int getOuro() { return ouro; }
    public int getPrata() { return prata; }
    public int getBronze() { return bronze; }
}

public class QuadroMedalhas {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numPaises = scan.nextInt();
        Pais paises[] = new Pais[numPaises];

        // input + preenchimento de array
        for (int i = 0; i < numPaises; i++) {
            String nome = scan.next();
            int ouro = scan.nextInt();
            int prata = scan.nextInt();
            int bronze = scan.nextInt();

            Pais novo = new Pais(nome, ouro, prata, bronze);
            paises[i] = novo;
        }

        // selection sort
        for (int i = 0; i < numPaises; i++) {
            int minIndex = i;

            for (int m = i + 1; m < numPaises; m++) {
                if (paises[m].getOuro() < paises[minIndex].getOuro()) {
                    minIndex = m;
                } else if (paises[m].getOuro() == paises[minIndex].getOuro()) {
                    if (paises[m].getPrata() < paises[minIndex].getPrata()) {
                        minIndex = m;
                    } else if (paises[m].getPrata() == paises[minIndex].getPrata()) {
                        if (paises[m].getBronze() < paises[minIndex].getBronze()) {
                            minIndex = m;
                        } else if (paises[m].getBronze() == paises[minIndex].getBronze()) {
                            if (paises[m].getNome().charAt(0) > paises[minIndex].getNome().charAt(0)) {
                                minIndex = m;
                            }
                        }
                    }
                }

                Pais temp = paises[minIndex];
                paises[minIndex] = paises[m];
                paises[m] = temp;
            }
        }

        // output
        for (int i = 0; i < numPaises; i++) {
            String nomeAtual = paises[i].getNome();
            Integer ouroAtual = paises[i].getOuro();
            Integer prataAtual = paises[i].getPrata();
            Integer bronzeAtual = paises[i].getBronze();

            System.out.println(nomeAtual + " " + ouroAtual + " " + prataAtual + " " + bronzeAtual);
        }

        scan.close();
    }
}