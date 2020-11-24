package exercicios;

import java.util.Arrays; 
import java.util.Scanner;
import java.io.IOException;
import java.util.Collections; 
import java.util.concurrent.TimeUnit;


class Aluno { 
	int numero_disponivel = 1;
	int numero[] = new int[20];
	int idade[] = new int[20];
	String primeiroNome[] = new String[20];
	String ultimoNome[] = new String[20];
	String freguesia[] = new String[20];
	String conselho[] = new String[20];
}

public class ex_11d {
	
	static Scanner input = new Scanner(System.in);
	
	// Conseguir acessar a classe contendo os dados dos alunos
	static Aluno aluno = new Aluno();

	public static void main(String[] args) {
			
		boolean sair = false;
		int escolha;
		
		do {
			
			escolha = getEscolha();
			
			
			switch(escolha) {
				case 1:
					System.out.println("Opção inscrever aluno selecionada!");
					executarDelay(1);
					clearConsole();
					criarAluno();
					break;
				case 2:
					System.out.println("Opção consultar alunos selecionada!");
					executarDelay(1);
					clearConsole();
					consultarAluno();
					break;
				case 3: 
					System.out.println("Opção listar alunos selecionada!");
					executarDelay(1);
					clearConsole();
					listarAlunos();
					break;
				case 4:
					sair = true;
					clearConsole();
					sairPrograma();
					break;	
				default: {System.out.println("Opcao invalida! Por favor, selecione uma opcao valida."); 
						  executarDelay(2); 
						  escolha = getEscolha(); }
			}
		} while (sair == false);
	}
	
	// Funcoes para as escolhas
	private static void criarAluno() {
		int i = aluno.numero_disponivel - 1;		
			
			// Pergunta e insere o primeiro/ultimo nome do aluno
			System.out.print("Primeiro nome: ");
			input.nextLine();
			aluno.primeiroNome[i] = input.nextLine();
			
			System.out.print("Ultimo nome: ");
			aluno.ultimoNome[i] = input.nextLine();
			
			// Pergunta e insere a idade do aluno
			System.out.print("Idade: ");
			try {
				aluno.idade[i] = input.nextInt();
				
			} catch (Exception error) {
				System.out.println("Dados invalidos! Por favor, insira novamente o aluno.");
				executarDelay(4);
				clearConsole();
				criarAluno();	
			}
			input.nextLine();
			
			// Pergunta e insere a freguesia de residencia do aluno
			System.out.print("Freguesia de residencia: ");
			aluno.freguesia[i] = input.nextLine();
			
			// Pergunta e insere o conselho  de residência do aluno
			System.out.print("Conselho de residencia: ");
			aluno.conselho[i] = input.nextLine();
			
			// Output final dizendo que foi criado com sucesso
			System.out.print("Criado o aluno número " + (i+1) + " com o nome " + aluno.primeiroNome[i] + " " + aluno.ultimoNome[i] + ", residente em " + aluno.freguesia[i] + " - " + aluno.conselho[i] +".");
			
			// Define o numero do aluno com o numero disponivel
			aluno.numero[i] = aluno.numero_disponivel;
			
			// Incrementa o numero disponivel para o proximo aluno ja obter o numero diferente
			aluno.numero_disponivel++; 
			
			executarDelay(2);
	}
	
	private static void consultarAluno() {
		System.out.print("Insira o numero do aluno: ");
		int numA = input.nextInt() - 1;
		
		if(aluno.numero[numA] == 0) {
			System.out.println("Aluno inexistente!");
			executarDelay(1);
		} else {
		clearConsole();
		System.out.println("\nAluno n. - " + aluno.numero[numA] + "\r\n"
						   + "\r\n"
						   + "Nome: " + aluno.primeiroNome[numA] + " " + aluno.ultimoNome[numA] + "\r\n"
						   + "\r\n"
						   + "Idade: " + aluno.idade[numA] + "\r\n"
						   + "\r\n"
						   + "Freguesia:" + aluno.freguesia[numA] + "\r\n"
						   + "\r\n"
						   + "Concelho: " + aluno.conselho[numA]);
		}
		pressContinuar();
	}
	
	// Funçao que ordena os nomes maiores em decrescente e faz um output com a lista dos alunos
	private static void listarAlunos() {
		int qtdAlunos = qtdAlunos();
		String tempNome;
		String nomesOrdenados[] = new String[qtdAlunos];
		Integer numerosOrdenados[] = new Integer[qtdAlunos];
	
	
		String leftAlignFormat = "| %-4d | %-25s | %-6d | %-20s | %-20s |%n";
		
		for(int i = 0; i < qtdAlunos; i++) {
			nomesOrdenados[i] = aluno.primeiroNome[i] + " " + aluno.ultimoNome[i];
		}
		
		Arrays.sort(nomesOrdenados, Collections.reverseOrder()); 
		
	
		for(int x = 0; x < qtdAlunos; x++) {
			tempNome = aluno.primeiroNome[x] + " " + aluno.ultimoNome[x];
			for(int y = 0; y < qtdAlunos; y++) {
				if(tempNome.length() == nomesOrdenados[y].length()) {
					numerosOrdenados[x] = y;
				}
			}
		}
	
		
		System.out.format("+------+---------------------------+--------+----------------------+----------------------+%n");
		System.out.format("| Num  | Nome                      | Idade  | Freguesia            | Conselho             |%n");
		System.out.format("+------+---------------------------+--------+----------------------+----------------------+%n");
		for(int i = 0; i < qtdAlunos; i++) {
		    System.out.format(leftAlignFormat, aluno.numero[numerosOrdenados[i]], aluno.primeiroNome[numerosOrdenados[i]] + " " + aluno.ultimoNome[numerosOrdenados[i]], aluno.idade[numerosOrdenados[i]], aluno.freguesia[numerosOrdenados[i]], aluno.conselho[numerosOrdenados[i]]);
		}
		System.out.format("+------+---------------------------+--------+----------------------+----------------------+%n");
		
		pressContinuar();
	}
	
	// Funcao para retornar a quantidade de alunos que foram inseridos
	private static int qtdAlunos() {
		int qtdNumeros = 0;
		for(int i = 0; i < aluno.numero.length; i++) {
			if(aluno.primeiroNome[i] != null) {
				qtdNumeros++;
			}
		}
		return qtdNumeros;
	}
	
	// Funcoes principais para decisoes
	private static int getEscolha() {
		clearConsole();
		
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
				+ "4 - Sair\r\n");
		System.out.print("Escolher opção (1-4): ");
		int escolha = input.nextInt();
		
		return escolha;
	}
	
	private static void sairPrograma() {
		System.out.println("Terminado...");
		System.exit(1);
	}
	
	private static void pressContinuar() {
		System.out.println("\nPressione qualquer tecla e pressione ENTER para continuar...");
		input.next();
	}
	
	private static void executarDelay(int segundos) {
		try {
			TimeUnit.SECONDS.sleep(segundos);
		} catch (InterruptedException error) {
			error.printStackTrace();
		}
	}
	
	private final static void clearConsole() {
	    try {
	        final String os = System.getProperty("os.name");

	        if (os.contains("Windows")) {
	            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	        } else {
	            Runtime.getRuntime().exec("clear");
	        }

	    } catch (final Exception e) {
	    	System.out.println("Ocorreu um problema ao limpar o console: " + e);
	    	sairPrograma();
	    }
	}
}
