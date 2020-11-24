package exercicios;

import java.util.Scanner;

public class Exercicio_4 {
	public static void main(String[] args) {
	
		int numero_dia = inserirNumeroDia();
		String nomeDia = verificarNomeDia(numero_dia);
		
		System.out.println("O dia da semana �: " + nomeDia);
	}

	private static int inserirNumeroDia() {
		Scanner input = new Scanner(System.in);
		int dia = -1;
		
		try {
			while(dia < 1 || dia > 7) {
				System.out.print("Introduza o n�mero do dia: ");
				dia = input.nextInt();
				
				if(dia < 1 || dia > 7) {	
					System.out.println("O n�mero deve situar-se entre 1 e 7. Tente de novo...");
				}
			}
			
			
		} catch(Exception e) {
			System.out.println("Por favor, insira um n�mero!");
                        dia = inserirNumeroDia();
		}
		
		return dia;
	}
	
	private static String verificarNomeDia(int numero_dia) {
		String nomes[] = {"Domingo", "Segunda feira", "Ter�a feira", "Quarta feira", "Quinta feira", "Sexta feira", "S�bado"};
		String nomeDia = "";
		
		for(int i = 0; i < nomes.length; i++) {
			if(numero_dia-1 == i) {
				nomeDia = nomes[i];
			}
		}
		return nomeDia;
	}
}