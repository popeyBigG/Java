package exercicio_1;

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
	private static ResultSet consulta;
	
	public static void main(String[] args) throws SQLException {
		
		exibirMenu();
		input.close();
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
				+ "\nEscolha uma operação (1-5): ";
		
		clearConsole();
		System.out.print(menu);
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
					System.out.println("Opcao 2 escolhida!");
					inserirAluno(criarNovoAluno());
					executarDelay(3);
					exibirMenu();
					break;
				case 3:
					System.out.println("Opcao 3 escolhida!");
					listarTurmasExistentes();
					pressContinuar();
					exibirMenu();
					break;
				case 4:
					System.out.println("Opcao 4 escolhida!");
					listar_alunos();
					pressContinuar();
					exibirMenu();
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
		
		String primNome, ultNome;
		int idTurma;

		// Fazer listagem das turmas disponiveis
		System.out.println("Lista de turmas disponiveis:");
		listarTurmasExistentes();
		
		input.nextLine();  // Usado para desbugar o programa (se retirar o programa pula o input de inserir o nome do curso)
		
		// Receber dados do utilizador
		System.out.print("\nPrimeiro nome: ");
		primNome = input.nextLine();
		
		System.out.print("Ultimo nome: ");
		ultNome = input.nextLine();		
		
		System.out.print("Numero da turma: ");
		idTurma = input.nextInt();
		
		// Inserir no objeto Turma
		novoAluno.setPrimNome(primNome);
		novoAluno.setUltNome(ultNome);
		novoAluno.setIdTurma(idTurma);
		
		return novoAluno;
	}
	
	private static void listarTurmasExistentes() {
		clearConsole();
		
		consulta = consulta_turmas();
				
		String formatHeader = "| %-7s | %-35s | %8s |%n";
		String leftAlignFormat = "| %-7d | %-35s | %8d |%n";	
				
		System.out.format("+---------+-------------------------------------+----------+%n");
		System.out.format(formatHeader,"idTurma", "curso", "anoCurso");	
		System.out.format("+---------+-------------------------------------+----------+%n");
			try {
				consulta.beforeFirst();
				while(consulta.next()) {						
					System.out.format(leftAlignFormat, consulta.getInt(1), consulta.getString(2), consulta.getInt(3));
				}
			} catch (SQLException e) {
					System.out.println("Ocorreu um erro ao fazer a listagem de turmas!\n" + e.getLocalizedMessage());
			}
		System.out.format("+---------+-------------------------------------+----------+%n");
	}
	
	//metodo para mostrar alunos de turma especifica
    private static void listar_alunos() {
    	listarTurmasExistentes();

        //Mostra alunos da turma escolhida
        System.out.print("Numero da turma que pretende consultar os alunos: ");
        int num_turma = input.nextInt();
        
        try {
        	consulta = consulta_alunosDeTurma(num_turma);
        	clearConsole();
        	
        	if(consulta.next()) {
        		String formatHeader = "| %-20s | %-15s | %7s |%n";
        		String leftAlignFormat = "| %-20s | %-15s | %7d |%n";	
        		
        		System.out.println("\nAlunos disponiveis na turma " + num_turma);
        		System.out.format("+----------------------+-----------------+---------+%n");
        		System.out.format(formatHeader,"primNome", "ultNome", "idTurma");	
        		System.out.format("+----------------------+-----------------+---------+%n");
        			try {
        				consulta.beforeFirst();
        				while(consulta.next()) {					
        					System.out.format(leftAlignFormat, consulta.getString(2), consulta.getString(3), consulta.getInt(4));
        				}
        			} catch (SQLException e) {
        					System.out.println("Ocorreu um erro ao fazer a listagem de algum aluno!\n" + e.getLocalizedMessage());
        			}
        		System.out.format("+----------------------+-----------------+---------+%n");
        		
        	} else {
        		System.out.println("\nNao ha turmas disponivel");
        	}
        } catch (SQLException e){
        	System.out.println("Ocorreu um erro ao fazer a listagem de alunos de certa turma!\n" + e.getLocalizedMessage());
        }
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
	
	private static void pressContinuar() {
		System.out.println("\nPressione qualquer tecla e pressione ENTER para continuar...");
		input.next();
	}
	
	// Database methods
	private static Connection connection(Properties p) {
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
	
	private static void inserirTurma(Turma novaTurma) {
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
	
	private static void inserirAluno(Aluno novoAluno) {
		String queryInsAluno = "INSERT INTO alunos (primNome, ultNome, idTurma) VALUES (?, ?, ?)";
		
		try {
			PreparedStatement pstm = conn.prepareStatement(queryInsAluno);
			
			// Inserir os dados do alunos dentro dos ? presentes dentro da string que tem a query
			pstm.setString(1, novoAluno.getPrimNome());
			pstm.setString(2, novoAluno.getUltNome());
			pstm.setInt(3, novoAluno.getIdTurma());
			
			// Irá executar a query e retornar o numeros de rows afetadas
			int linhas = pstm.executeUpdate();
			
			if(linhas > 0) {
				System.out.println("Aluno adicionado com sucesso!");
			} else {
				System.out.println("O aluno não foi adicionado!");
			}
			
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao tentar inserir o aluno!\n" + e.getLocalizedMessage());
		}
	}
	
	private static ResultSet consulta_turmas() {
		ResultSet resultado = null;
		
		try {
			String queryGetTurmas = "SELECT * FROM turmas";
			
			Statement pstm = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE); pstm.setFetchSize(1); 
			resultado = pstm.executeQuery(queryGetTurmas);
		} catch(Exception e) {
			 System.out.println("Ocorreu um erro ao fazer uma consulta com o Dr. St0cki nas turmas");
		} 
		
		return resultado;
	}
	
	private static ResultSet consulta_alunosDeTurma(int num_turma) {
		ResultSet resultado = null;
		
		try {
			String queryGetAlunosWhereTurmaID = String.format("SELECT * FROM alunos WHERE idTurma = '%d'", num_turma);
	    	
	        Statement pstm = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE); pstm.setFetchSize(1);
	        resultado = pstm.executeQuery(queryGetAlunosWhereTurmaID);
		} catch(Exception e) {
			 System.out.println("Ocorreu um erro ao fazer uma consulta com o Dr. St0cki nos alunos");
		} 
		
		return resultado;
	}
}
