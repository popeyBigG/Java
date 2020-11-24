import java.util.Scanner; 


public class ex_2 {
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
		float maior = getMaior(numeros);
		float menor = getMenor(numeros);
		
		// Output final para mostrar ao utilizador os resultados das operações acima
		System.out.println("\nA média é dos números é de " + media + "\n"
						 + "O maior número inserido foi: " + maior + "\n"
						 + "O menor número inserido foi: " + menor + "\n");	 
	}
	
	private static float calcMedia(float numeros[]) {
		
		float media = 0;
		
		for(int i = 0; i < numeros.length; i++) {
			media += numeros[i];
		}
		
		return media = (media / numeros.length);
	}
	
	private static float getMenor(float numeros[]) {
		
		float menor = numeros[0];
		
		for(int i = 0; i < numeros.length; i++) {
			menor = Math.min(menor, numeros[i]);
		}
		
		return menor;
	}
	
	private static float getMaior(float numeros[]) {
		
		float maior = numeros[0];
		
		for(int i = 0; i < numeros.length; i++) {
			maior = Math.max(maior, numeros[i]);
		}
		
		return maior;
	}
}
