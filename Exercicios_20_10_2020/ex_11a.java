package exercicios;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ex_11a {
	public static void main(String[] args) {
		boolean sair = false;
		int escolha;
		
		do {
			escolha = getEscolha();
			
			switch(escolha) {
				case 1:
					System.out.println("Opção inscrever aluno selecionada!");
					executarDelay(2);
					break;
				case 2:
					System.out.println("Opção consultar alunos selecionada!");
					executarDelay(2);
					break;
				case 3: 
					System.out.println("Opção listar alunos selecionada!");
					executarDelay(2);
					break;
				case 4:
					sair = true;
					sairPrograma();
					break;	
				default: {executarDelay(2); 
						  System.out.println("Opcao invalida! Por favor, selecione uma opcao valida"); 
						  escolha = getEscolha(); }
			}
		} while (sair == false);
	}
	
	private static int getEscolha() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("\n*********************\r\n"
				+ "\r\n"
				+ "*  GESTÃO DE ALUNOS  *\r\n"
				+ "\r\n"
				+ "*********************\r\n"
				+ "\r\n"
				+ "1 - Inscrever aluno\r\n"
				+ "\r\n"
				+ "2 - Consultar alunos\r\n"
				+ "\r\n"
				+ "3 - Listar alunos\r\n"
				+ "\r\n"
				+ "4 - Sair\r\n"
				+ "\r\n");
		System.out.print("Escolher opção (1-4): ");
		int escolha = input.nextInt();
		
		return escolha;
	}
	
	private static void sairPrograma() {
		System.out.println("Terminado...");
		System.exit(1);
	}
	
	private static void executarDelay(int segundos) {
		try {
			TimeUnit.SECONDS.sleep(segundos);
		} catch (InterruptedException error) {
			error.printStackTrace();
		}
	}
}
