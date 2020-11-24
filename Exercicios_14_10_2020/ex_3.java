import java.util.Scanner;

public class ex_3 {

	public static void main(String[] args) {
		
		final int qtdNomes = 5;
		final String nomes[] = introduzirNomes(qtdNomes);
		final String nomesLista[] = {
									"Joana",
									"Jacinto"
									};
		
		String nomesCorrespondentes[] = verificarNomes(nomes, nomesLista);
		
		
		 mostrarNomes(nomes);
		 mostrarNomesCorrespondentes(nomesCorrespondentes);
	}
	
	// Methods
	private static String[] introduzirNomes(int qtdNomes) {
		
		Scanner input = new Scanner(System.in);
		String nomes[] = new String[qtdNomes];
		

		for(int i = 0; i < nomes.length; i++) {
			System.out.print("Introduza o " + (i + 1) + "º nome: ");
			nomes[i] = input.next();
		}
		
		return nomes;
	}
	
	private static String[] verificarNomes(String nomes[], String nomesLista[]) {
		
		String nomesExistentes[] = new String[nomesLista.length];
		int posicaoArray_nomesExistentes = 0;
		
		for(int i = 0; i < nomes.length; i++) {
			for(int k = 0; k < nomesLista.length; k++) {
				if(nomes[i].equals(nomesLista[k])) {
					nomesExistentes[posicaoArray_nomesExistentes] = nomes[i];
					posicaoArray_nomesExistentes++;
				}
			}
		}
	return nomesExistentes;
	}
	
	private static void mostrarNomes(String nomes[]) {
		
		 System.out.println("\nNomes inseridos: ");
		
		for(int i = 0; i < nomes.length; i++) {
			System.out.println((i+1) + "º nome: " + nomes[i]);
		}
	}
	
	private static void mostrarNomesCorrespondentes(String nomesCorrespondentes[]) {
		
		 System.out.println("\nOs nomes inseridos que correspondem à lista são: ");
		 
		 for(int i = 0; i < nomesCorrespondentes.length; i++) {
			 if(nomesCorrespondentes[i] != null) {
				 System.out.println("- " + nomesCorrespondentes[i]);
			 } 
		 }
	}
}