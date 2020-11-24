package exercicios;

import java.util.Scanner;

public class Exercicio_4 {
	public static void main(String[] args) {
	
		int numero_dia = inserirNumeroDia();
		String nomeDia = verificarNomeDia(numero_dia);
		
		System.out.println("O dia da semana é: " + nomeDia);
	}

	private static int inserirNumeroDia() {
		Scanner input = new Scanner(System.in);
		int dia = -1;
		
		try {
			while(dia < 1 || dia > 7) {
				System.out.print("Introduza o número do dia: ");
				dia = input.nextInt();
				
				if(dia < 1 || dia > 7) {	
					System.out.println("O número deve situar-se entre 1 e 7. Tente de novo...");
				}
			}
			
			
		} catch(Exception e) {
			System.out.println("Por favor, insira um número!");
                        dia = inserirNumeroDia();
		}
		
		return dia;
	}
	
	private static String verificarNomeDia(int numero_dia) {
		String nomes[] = {"Domingo", "Segunda feira", "Terça feira", "Quarta feira", "Quinta feira", "Sexta feira", "Sábado"};
		String nomeDia = "";
		
		for(int i = 0; i < nomes.length; i++) {
			if(numero_dia-1 == i) {
				nomeDia = nomes[i];
			}
		}
		return nomeDia;
	}
}