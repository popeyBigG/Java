import java.util.Scanner;

public class ex_5 {

	public static void main(String[] args) {
		// Declara��o das Variaveis
		String paridade;
		int numero;
		
		
		numero = insNumero();
		paridade = getParidade(numero);
		
		System.out.println("\nO n�mero " + numero + " � " + paridade);
	}
	
	private static int insNumero() {
		// Declara��o das Variaveis
		Scanner scanner = new Scanner(System.in);
		int numero;
		
		System.out.print("Insira um n�mero: ");
		numero = scanner.nextInt();
		
		return numero;
	}
	
	private static String getParidade(int numero) {
		// Declara��o das Variaveis
		String paridade;
		
		if(numero % 2 == 0) {
			paridade = "PAR";
		} else {
			paridade = "IMPAR";
		}
		return paridade;
	}
}
