import java.util.*;

public class TorneioTenis {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int qntdJogos = 6;
        int vitorias = 0;

        for (int i = 0; i < qntdJogos; i++) {
            String resultado = scan.next();
            if ("V".equals(resultado)) vitorias++;
        }

        int grupoColocado;
        int[] grupos = {1, 1, 2, 2, 3, 3};
        
        if (vitorias == 0) {
            grupoColocado = -1;
        } else {
            grupoColocado = grupos[vitorias - 1];
        }

        System.out.println(grupoColocado);
        scan.close();
    }
}
