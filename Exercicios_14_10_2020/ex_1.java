import java.util.Scanner; 


public class ex_1 {
	public static void main(String[] args) {
		
		// Declaração de variaveis
		Scanner input = new Scanner(System.in);
		
		final int qtdNumeros = 5;
		float numeros[] = new float[qtdNumeros];
		
		
		// Loop para o utilizador inserir os números conforme a quantidade de números atribuidos na constante (final) qtdNumeros
		for(int i = 0; i < numeros.length; i++) {
			System.out.print("Introduza o " + (i + 1) + "º numero: ");
			numeros[i] = input.nextFloat();
		}
		
		// Declaração e atribuição de operações matemáticas
		float media = calcMedia(numeros);
		
		// Output final para mostrar ao utilizador os resultados das operações acima
		System.out.println("\nA média é dos números é de " + media);
						 
	}
	
	private static float calcMedia(float numeros[]) {
		
		float media = 0;
		
		for(int i = 0; i < numeros.length; i++) {
			media += numeros[i];
		}
		
		return media = (media / numeros.length);
	}
}
