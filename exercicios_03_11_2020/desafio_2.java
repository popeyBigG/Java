package exercicios_03_11_2020;

public class desafio_2 {
	public static void main(String[] args) {
		// Cada valor abaixo representa a altura em unidades do grafico
		double torres[] = {3, 2, 3.5, 5, 4, 6, 7, 5.5, 7.5, 8.5, 8, 10, 9.3, 10.5, 11.2, 12.4, 12, 13, 17.5, 13.5};
		int torresEspeciais = contarEspeciais(torres);
		System.out.println(torresEspeciais);
	}
	
	private static int contarEspeciais(double torres[]) {
		int numeroEspeciais = 0;
		
		for(int i = 1; i < torres.length; i++) {
			if(torres[i] != 0 && i != torres.length-1) {
				if(torres[i] < torres[i+1] && torres[i] > torres[i-1]) {
					numeroEspeciais++;
				}
			}
		}
		
		return numeroEspeciais;
	}
}
