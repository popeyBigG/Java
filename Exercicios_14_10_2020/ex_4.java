import java.util.Scanner;

public class ex_4 {

	public static void main(String[] args) {
		
		// Declara��o de variaveis
		int numero, dobro;
		
		
		numero = insNumero();
		dobro = getDobro(numero);
		
		System.out.println("\nO dobro do n�mero " + numero + " � " + dobro);
	}
	
	private static int insNumero() {
		
		Scanner scanner = new Scanner(System.in);
		int numero;
		
		System.out.print("Insira um n�mero: ");
		numero = scanner.nextInt();
		
		return numero;
	}
	
	private static int getDobro(int numero) {
		return (numero * 2);
	}
}
