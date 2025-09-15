#include <stdio.h>
#include <stdbool.h>

int main() {
    int saida = -1;
    char placa[10];
    
    scanf("%s", placa);

    if (!ehAntigoPadraoBrasileiro(placa)) saida = 1;
    if (!ehNovoPadraoMercosul(placa)) saida = 2;
    if (ehPlacaFalsificada(placa)) saida = 0;
    
    printf("%d\n", saida);

    return 0;
}

// VERIFICAÇÕES

bool ehAntigoPadraoBrasileiro(char* placa) {
    int tam = tamanho(placa);
    bool eh = true;

    if (tam != 8) return false;

    for (int i = 0; i < tam; i++) {
        if (i >= 0 && i <= 2 && !ehLetraMaiuscula(placa[i])) eh = false;
        if (i == 3 && placa[i] != '-') eh = false;
        if (i >= 4 && i <= 7 && !ehDigito(placa[i])) eh = false;
    }
    
    return eh;
}

bool ehNovoPadraoMercosul(char* placa) {
    int tam = tamanho(placa);
    bool eh = true;

    if (tam != 7) return false;

    for (int i = 0; i < tam; i++) {
        if (i >= 0 && i <= 2 && !ehLetraMaiuscula(placa[i])) eh = false;
        if (i == 3 && !ehDigito(placa[i])) eh = false;
        if (i == 4 && !ehLetraMaiuscula(placa[i])) eh = false;
        if (i >= 5 && i <= 6 && !ehDigito(placa[i])) eh = false;
    }

    return eh;
}

bool ehPlacaFalsificada(char* placa) {
    return !(ehAntigoPadraoBrasileiro(placa) || ehNovoPadraoMercosul(placa));
}

// FUNÇÕES AUXILIARES

int tamanho(char* str) {
    int i = 0;
    while (str[i] != '\0') i++;
    return i;
}

bool ehLetraMaiuscula(char c) {
    return (c >= 'A' && c <= 'Z');
}

bool ehDigito(char c) {
    return (c >= '0' && c <= '9');
}
