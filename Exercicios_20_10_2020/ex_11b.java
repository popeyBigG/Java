package exercicios;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;



public class ex_11b {
	
	static Scanner input = new Scanner(System.in);
	static Aluno aluno = new Aluno();

	public static void main(String[] args) {
		boolean sair = false;
		int escolha;
		
		// Conseguir acessar a classe contendo os dados dos alunos
		Aluno aluno = new Aluno();
		
		do {
			escolha = getEscolha();

			switch(escolha) {
				case 1:
					System.out.println("Opção inscrever aluno selecionada!");
					executarDelay(2);
					criarAluno();
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
				default: {System.out.println("Opcao invalida! Por favor, selecione uma opcao valida"); 
						  executarDelay(2); 
						  escolha = getEscolha(); }
			}
		} while (sair == false);
	}
	
	// Funcoes para as escolhas
	private static void criarAluno() {
		int i = aluno.numero_disponivel - 1;
		System.out.println(i);
			// Define o numero do aluno com o numero disponivel
			aluno.numero[i] = aluno.numero_disponivel;
			
			// Pergunta e insere o primeiro/ultimo nome do aluno
			System.out.print("Primeiro nome: ");
			input.nextLine();
			aluno.primeiroNome[i] = input.nextLine();
			
			System.out.print("Ultimo nome: ");
			aluno.ultimoNome[i] = input.nextLine();
			
			// Pergunta e insere a idade do aluno
			System.out.print("Idade: ");
			aluno.idade[i] = input.nextInt();
			input.nextLine();
			
			// Pergunta e insere a freguesia de residencia do aluno
			System.out.print("Freguesia de residencia: ");
			aluno.freguesia[i] = input.nextLine();
			
			// Pergunta e insere o conselho  de residência do aluno
			System.out.print("Conselho de residencia: ");
			aluno.conselho[i] = input.nextLine();
			
			// Output final dizendo que foi criado com sucesso
			System.out.print("Criado o aluno número " + (i+1) + " com o nome " + aluno.primeiroNome[i] + " " + aluno.ultimoNome[i] + ", residente em " + aluno.freguesia[i] + " - " + aluno.conselho[i] +".");
			
			// Incrementa o numero disponivel para o proximo aluno ja obter o numero diferente
			aluno.numero_disponivel++; 
			
			executarDelay(2);
	}
	
	private static void consultarAluno() {
		System.out.print("");
	}
	
	// Funcoes principais para decisoes
	private static int getEscolha() {
		
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
