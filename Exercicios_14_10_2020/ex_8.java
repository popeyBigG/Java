// 19/10/2020

import java.util.Scanner;

public class ex_8 {
    public static void main(String[] args) {
        int decimal = insNumero();

        System.out.print("O valor binario de " + decimal + " é ");
        getBinario(decimal);
    }

    private static int insNumero() {
        Scanner input = new Scanner(System.in);
        int numero;

        System.out.print("Insira o número desejado para converter em binário: ");
        numero = input.nextInt();

        return numero;
    }

    private static void getBinario(int decimal) {
        int binario[] = new int[40];
        int resto = decimal;
        int vezes = 0;

        while (resto > 0) {
            binario[vezes] = (resto % 2);
            resto = (resto / 2);
            vezes++;
        }

        for(int k = vezes - 1; k >= 0; k--) {
            System.out.print(binario[k]);
        }
    }
}

