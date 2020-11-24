package exercicios;

import java.util.Scanner;

public class ex_9 {
	public static void main(String[] args) {
		String binario = insBin();
		int decimal = convertBinario(binario);
		
		System.out.println("\n" + binario + " = " + decimal);
	}
	
	// Fazer input do numero binario e retornar o input
	private static String insBin() {
		Scanner input = new Scanner(System.in);		
		
		System.out.print("Insira o numero em binario: ");
		String bin = input.next(); input.close();
		
		return bin;
	}
	
	// Recebe a String do numero binario inserido, começa a checar o numero binario ao contrario e se o bit for = 1, ele calcula o valor decimal do bit conforme a sua posição na String 
	private static int convertBinario(String binario) {
		int tamanho = binario.length();
		int decimal = 0;
		
		for(int i = 0; i < tamanho; i++) {
			char bit = binario.charAt((tamanho-1) - i);
			if(bit == '1') { 
				// Irá fazer potencia de 2^posicao(i) e retornar o valor decimal do bit, adicionando dentro do int decimal
				decimal += calculateBit(i); 
			}
		}
		
		return decimal;
	}
	
	// Recebe a posição do bit 1, faz a potencia de 2 em cima daquela posição e retorna o valor
	private static int calculateBit(int posicao) {
		return (int) Math.pow(2, posicao);
	}
}
