package exercicio_1;

import java.awt.SystemTray;
import java.io.*;
import java.sql.*;
import java.util.InputMismatchException;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
	// Objetos globais
	private static Scanner input = new Scanner(System.in);
	private static Properties p = new Properties();
	private static Connection conn = connection(p);
	
	public static void main(String[] args) throws SQLException {
		
		exibirMenu();
		
		
		conn.close();
	}

	
	
	
	
	
	// Methods
	private static void exibirMenu() {
		int escolha = 0;
		String menu = "GESALUNOS - SISTEMA DE INSCRIÇÃO DE ALUNOS"
				+ "\n1-Criar nova turma"
				+ "\n2-Inscrever novo aluno numa turma"
				+ "\n3-Consultar turmas existentes"
				+ "\n4-Listar todos os alunos de uma turma"
				+ "\n5-Terminar"
				+ "\nEscolha uma operação (1-5):";
		
		System.out.println(menu);
		while(escolha == 0) {
			try {
				escolha = input.nextInt();
				
				switch(escolha) {
				case 1:
					System.out.println("Opcao 1 escolhida!");
					inserirTurma(criarNovaTurma());
					executarDelay(3);
					exibirMenu();
					break;
				case 2:
					
					break;
				case 3:
					
					break;
				case 4:
					
					break;
				case 5:
					terminarPrograma();
					break;
				}
				
				if(escolha < 1 || escolha > 5) {
					System.out.println("Opcao invalida! Por favor, escolha uma opcao de 1 a 5");
					escolha = 0;
				}
			} catch(InputMismatchException e) {
				System.out.println("Por favor, insira apenas números!");
				escolha = 0;
			}
		}
	}
	
	private static Turma criarNovaTurma() {
		clearConsole();
		
		// Declaracao de objetos
		Turma novaTurma = new Turma();
		
		String curso = "";
		int anoCurso;
		
		input.nextLine();  // Usado para desbugar o programa (se retirar o programa pula o input de inserir o nome do curso)
		
		// Receber dados do utilizador
		System.out.print("Nome do curso: ");
		curso += input.nextLine();
		
		System.out.print("Ano do curso (xxxx): ");
		anoCurso = input.nextInt();
		
		// Inserir no objeto Turma
		novaTurma.setCurso(curso);
		novaTurma.setAnoCurso(anoCurso);
		
		return novaTurma;
	}
	
	private static Aluno criarNovoAluno() {
		clearConsole();
		
		// Declaracao de objetos
		Aluno novoAluno = new Aluno();
		
		String curso = "";
		int anoCurso;
		
		input.nextLine();  // Usado para desbugar o programa (se retirar o programa pula o input de inserir o nome do curso)
		
		// Receber dados do utilizador
		System.out.print("Nome do curso: ");
		curso += input.nextLine();
		
		System.out.print("Ano do curso (xxxx): ");
		anoCurso = input.nextInt();
		
		// Inserir no objeto Turma
		novoAluno.setCurso(curso);
		novoAluno.setAnoCurso(anoCurso);
		
		return novoAluno;
	}
	
	private static void terminarPrograma() {
		clearConsole();
		System.out.println("Terminando programa...");
		try {
			System.exit(1);
		} catch(Exception e) {
			System.out.println("Ocorreu um erro ao tentar finalizar o programa!\n" + e.getLocalizedMessage());
		}
	}
	
	// Secondary methods
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
	    	terminarPrograma();
	    }
	}
	
	// Database methods
	public static Connection connection(Properties p) {
		Connection connection = null;
		
		try {
			FileInputStream ficheiro_configuracoes = new FileInputStream("C:\\Users\\ENTA.LABINF2-PC12\\eclipse-workspace\\exercicios_02_12_2020\\src\\exercicio_1\\dbConnection.properties");
			p.load(ficheiro_configuracoes);

		
			connection = DriverManager.getConnection(p.getProperty("url"), p.getProperty("username"), p.getProperty("password"));
			System.out.println("Conectado..."); 
			
		} catch (SQLException | IOException e) {
			System.out.println("Ocorreu um erro ao estabelecer uma conexao... " + e.getLocalizedMessage());
		}
		
		return connection;
	}
	
	public static void inserirTurma(Turma novaTurma) {
		String queryInsTurma = "INSERT INTO turmas (curso, anoCurso) VALUES (?, ?)";
		
		try {
			PreparedStatement pstm = conn.prepareStatement(queryInsTurma);
			
			// Inserir os dados do alunos dentro dos ? presentes dentro da string que tem a query
			pstm.setString(1, novaTurma.getCurso());
			pstm.setInt(2, novaTurma.getAnoCurso());
			
			// Irá executar a query e retornar o numeros de rows afetadas
			int linhas = pstm.executeUpdate();
			
			if(linhas > 0) {
				System.out.println("Turma adicionada com sucesso!");
			} else {
				System.out.println("A turma não foi adicionada!");
			}
			
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao tentar inserir a turma!\n" + e.getLocalizedMessage());
		}
	}
}
