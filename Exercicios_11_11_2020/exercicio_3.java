package exercicios;

import java.util.Scanner;

public class exercicio_3 {
	public static void main(String[] args) {
		int numero = inserirNumeroPositivo();
		String numero_extenso = numeroExtenso(numero);
		
		System.out.println("Número " + numero + " por extenso: " + numero_extenso);
	}

	private static int inserirNumeroPositivo() {
		Scanner input = new Scanner(System.in);
		int numero = -1;
		
		try {
			// Sempre que o numero for menor que 0 (nao for positivo), o programa ira pedir para introduzir até que o mesmo seja
			while(numero < 0) {
				System.out.print("Introduza um número positivo: ");
				numero = input.nextInt();
				
				if(numero < 0) {
					System.out.println("O número deve ser positivo. Tente de novo...");
				}
			}
			
		} catch(Exception e) {
			// Toda a vez que o utilizaor inserir um input que não seja um numero, o programa ira avisar e pedir para inserir de novo
			System.out.println("Por favor, insira um número!");
			numero = inserirNumeroPositivo();
		}
		return numero;
	}
	
	private static String numeroExtenso(int numero) {
		String[] algarismos = {"zero", "um", "dois", "três", "quatro", "cinco", "seis", "sete", "oito", "nove"};
		String numeroString = Integer.toString(numero);	// Converte a int numero para String, assim para poder utilizar a propriedade String charAt()
		String numeroExtenso = "";
		int length = String.valueOf(numero).length();	// Retorna o length da variavel numero e insere na variavel length
		
		for(int i = 0; i < length; i++) {
			for(int k = 0; k < 10; k++) {	
				// Se o valor da posicao i do numero for igual a k, ele adicionara na string numeroExtenso o algarismo que o k 
				// corresponde ex: 123 > charAt(1) = 1 entao se charAt(1) == k (1) adicionará na string o algarismo[1]
				if(Character.getNumericValue(numeroString.charAt(i)) == k) {	
					numeroExtenso+= algarismos[k] + " ";
				}
			}
		}
		return numeroExtenso;
	}
}