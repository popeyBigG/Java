import java.util.Scanner; 


public class ex_2 {
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
		float maior = getMaior(numeros);
		float menor = getMenor(numeros);
		
		// Output final para mostrar ao utilizador os resultados das opera��es acima
		System.out.println("\nA m�dia � dos n�meros � de " + media + "\n"
						 + "O maior n�mero inserido foi: " + maior + "\n"
						 + "O menor n�mero inserido foi: " + menor + "\n");	 
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
