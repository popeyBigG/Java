import java.util.Scanner; 


public class ex_1 {
	public static void main(String[] args) {
		
		// Declara��o de variaveis
		Scanner input = new Scanner(System.in);
		
		final int qtdNumeros = 5;
		float numeros[] = new float[qtdNumeros];
		
		
		// Loop para o utilizador inserir os n�meros conforme a quantidade de n�meros atribuidos na constante (final) qtdNumeros
		for(int i = 0; i < numeros.length; i++) {
			System.out.print("Introduza o " + (i + 1) + "� numero: ");
			numeros[i] = input.nextFloat();
		}
		
		// Declara��o e atribui��o de opera��es matem�ticas
		float media = calcMedia(numeros);
		
		// Output final para mostrar ao utilizador os resultados das opera��es acima
		System.out.println("\nA m�dia � dos n�meros � de " + media);
						 
	}
	
	private static float calcMedia(float numeros[]) {
		
		float media = 0;
		
		for(int i = 0; i < numeros.length; i++) {
			media += numeros[i];
		}
		
		return media = (media / numeros.length);
	}
}
