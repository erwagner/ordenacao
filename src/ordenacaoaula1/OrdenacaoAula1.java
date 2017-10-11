package ordenacaoaula1;

public class OrdenacaoAula1 {

    public static void main(String[] args) {

        int N = 100000;

        int vetOriginal[] = new int[N];

        for (int i = 0; i < N; i++) {
            vetOriginal[i] = N-i;//(int) (Math.random() * N * 5);
        }

        int vetBubbleBurro[] = vetOriginal.clone();
        int vetBubbleBao[] = vetOriginal.clone();
        int vetMenorMaior[] = vetOriginal.clone();

        //exibe(vetOriginal, N);
        long tempoInicial;

        tempoInicial = System.currentTimeMillis();
         bubbleBurro(vetBubbleBurro, N);
        System.out.println("Bubble Burro: " + (System.currentTimeMillis() - tempoInicial));

        tempoInicial = System.currentTimeMillis();
         bubbleBao(vetBubbleBao, N);
        System.out.println("Bubble Bao: " + (System.currentTimeMillis() - tempoInicial));

        tempoInicial = System.currentTimeMillis();
        menorMaior(vetMenorMaior, N);
        System.out.println("Maior Menor: " + (System.currentTimeMillis() - tempoInicial));
        
    }

    public static void bubbleBurro(int[] vet, int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < (N - 1); j++) {
                if (vet[j] > vet[j + 1]) {
                    int aux = vet[j];
                    vet[j] = vet[j + 1];
                    vet[j + 1] = aux;
                }
            }
        }
    }

    public static void bubbleBao(int[] vet, int N) {
        boolean trocou = true;
        int i = 1;
        while (trocou) {
            trocou = false;

            for (int j = 0; j < (N - i); j++) {
                if (vet[j] > vet[j + 1]) {
                    int aux = vet[j];
                    vet[j] = vet[j + 1];
                    vet[j + 1] = aux;
                    trocou = true;
                }
            }
            i++;
        }
    }

    public static void menorMaior(int[] vet, int N) {

        for (int indiceMenor = 0, indiceMaior = (N - 1); indiceMenor < indiceMaior; indiceMenor++, indiceMaior--) {
            int Menor = indiceMenor;
            int Maior = indiceMaior;
            for (int i = indiceMenor; i <= indiceMaior; i++) {
                if (vet[i] < vet[Menor]) {
                    Menor = i;
                }
                if (vet[i] > vet[Maior]) {
                    Maior = i;
                }
            }

            if ((Maior == indiceMenor) && (Menor == indiceMaior)) {
                troca(vet, Maior, indiceMaior);
            } else {
                if (Maior == indiceMenor) {
                    troca(vet, Maior, indiceMaior);
                    troca(vet, Menor, indiceMenor);
                } else {
                    troca(vet, Menor, indiceMenor);
                    troca(vet, Maior, indiceMaior);

                }
            }
        }
    }

    public static void troca(int[] vet, int x, int y) {
        // System.out.println("Trocando " + vet[x] + " por " + vet[y]);
        int aux = vet[x];
        vet[x] = vet[y];
        vet[y] = aux;
    }

    public static void exibe(int[] vet, int N) {
        System.out.println("---");
        for (int i = 0; i < N; i++) {
            System.out.println(vet[i]);
        }
    }

}
