package exercicios;

import java.util.Scanner;

public class ex_10 {
	public static void main(String[] args) {
		String texto = insTexto();
		boolean palindromo = checkPalindromo(texto);
		
		if(palindromo) {
			System.out.println(texto + "\n… um palindromo");
		} else {
			System.out.println(texto + "\nNao È um palindromo");
		}
	}
	
	private static String insTexto() {
		Scanner input = new Scanner(System.in).useDelimiter("\n");		
	
		System.out.print("Insira o texto ou palavra: ");
		String texto = input.next(); input.close();
	
		return texto;
	}
	
	private static boolean checkPalindromo(String texto) {
		boolean palindromo = false;
		int tamanho = texto.length();
		
		for(int i = 0, j = tamanho-2; i < (tamanho/2); i++, j--) {
			if(texto.charAt(i) == texto.charAt(j)) {
				palindromo = true;
				break;
			}
		}
		return palindromo;
	}
}