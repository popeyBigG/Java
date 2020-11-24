import java.util.Scanner;

public class ex_5 {

	public static void main(String[] args) {
		// Declaração das Variaveis
		String paridade;
		int numero;
		
		
		numero = insNumero();
		paridade = getParidade(numero);
		
		System.out.println("\nO número " + numero + " é " + paridade);
	}
	
	private static int insNumero() {
		// Declaração das Variaveis
		Scanner scanner = new Scanner(System.in);
		int numero;
		
		System.out.print("Insira um número: ");
		numero = scanner.nextInt();
		
		return numero;
	}
	
	private static String getParidade(int numero) {
		// Declaração das Variaveis
		String paridade;
		
		if(numero % 2 == 0) {
			paridade = "PAR";
		} else {
			paridade = "IMPAR";
		}
		return paridade;
	}
}
