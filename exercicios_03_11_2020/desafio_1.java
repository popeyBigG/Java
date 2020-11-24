package exercicios_03_11_2020;

public class desafio_1 {
	public static void main(String[] args) {
		String nuvemVista[] = {"0", "1", "1", "1", "0"};
		String tempoPrevisto = mensagemProvavel(nuvemVista);
		
		System.out.println("O clima mais provável é " + tempoPrevisto);
	}
	
	
	private static String mensagemProvavel(String nuvemVista[]) {
		// 0 = nuvem pequena | 1 = nuvem grande
		String padraoClimas[][] = {
				{"tempestade", "1", "1", "1", "1", "1"},
				{"chuva",	   "1", "0", "1", "0", "0"},
				{"nublado",	   "0", "1", "0", "1", "0"},
				{"sol", 	   "0", "0", "0", "0", "1"}
		};
		
		int iguais[][] = new int[padraoClimas.length][1];
		
		// Realiza comparação das nuvens "vistas" com os padroes de nuvens e contaquantas igualdades em cada clima padrao
		for(int i = 0; i < padraoClimas.length; i++) {
			for(int x = 1; x < padraoClimas[i].length; x++) {
				if(padraoClimas[i][x] == nuvemVista[x-1]) {
					iguais[i][0]++;
				}
			}
		}
		
		int maiorIgualdade = iguais[0][0];
		String clima = padraoClimas[0][0];
		
		// Checa qual dos climas tem maior igualdades e define o clima
		for(int l = 0; l < iguais.length; l++) {
			if(iguais[l][0] == 5) {
				clima = padraoClimas[l][0];
			} else if (iguais[l][0] > maiorIgualdade) {
				maiorIgualdade = iguais[l][0];
				clima = padraoClimas[l][0];
			}
		}
		
		return clima;
	}
}
