#include <stdio.h>
#include <stdbool.h>

int main() {
    bool ehSubSA = false;

    // input de quantidade
    int a = 0, b = 0;
    scanf("%i %i", &a, &b);

    // input da sequencia de a
    int seqA[a];
    for (int i = 0; i < a; i++) {
        int x = 0;
        scanf("%i ", &x);
        seqA[i] = x;
    }

    // input da sequencia de b
    int seqB[b];
    for (int i = 0; i < b; i++) {
        int x = 0;
        scanf("%i ", &x);
        seqB[i] = x;
    }

    // verificação da subsequencia
    int qntdSub = 0;
    for (int m = 0; m < b; m++) {
        int numSeqB = seqB[m];

        for (int k = 0; k < a; k++) {
            int numSeqA = seqA[k];

            if (numSeqB == numSeqA) qntdSub++;
        }
    }

    if (qntdSub == b) ehSubSA = true;

    char resp;
    if (ehSubSA) {
        resp = 'S';
    } else {
        resp = 'N';
    }

    printf(" %c\n", resp);

    return 0;
}
