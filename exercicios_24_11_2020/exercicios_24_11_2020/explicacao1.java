package exercicios_24_11_2020;

import java.io.*;
import java.sql.*;
import java.util.Properties;

// Conexão na base de dados
public class explicacao1 {
	public static void main(String[] args) throws SQLException, IOException {
		Properties p = new Properties();
		Connection conn = efetuarConexao(p);
		ResultSet consulta;
		
		inserir(conn, "Alberto", "Bizerro", 19);
		consulta = consulta(conn);
		
		
		while(consulta.next()) {
			String primNome = consulta.getString("primNome");
			String ultNome = consulta.getString("ultNome");
			int idade = consulta.getInt("idade");
			
			System.out.println(primNome + " " + ultNome + " " + idade);
		}
		
		
		conn.close();
	} 
	
	public static Connection efetuarConexao(Properties p) throws SQLException, IOException {
		Connection connection = null;
		
		try {
			FileInputStream ficheiro_configuracoes = new FileInputStream("dbConfig.properties");
			p.load(ficheiro_configuracoes);
				
			connection = DriverManager.getConnection(p.getProperty("url"), p.getProperty("username"), p.getProperty("password"));
			System.out.println("Conectado..."); 
			
		} catch (FileNotFoundException e) {
			System.out.println("Ficheiro não encontrado...");
		}
		
		return connection;
	}
	
	// Base de dados alunos
	public static ResultSet consulta(Connection connection) { 
		ResultSet resultado = null;
		 
		try { 
			String queryGetAlunos = "SELECT primNome, ultNome, idade FROM alunos";
		 
			Statement stm = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE); stm.setFetchSize(1); 
			resultado = stm.executeQuery(queryGetAlunos);
		 
		 } catch(Exception e) {
			 System.out.println("Ocorreu um erro ao fazer uma consulta com o Dr. St0cki");
		 } 
		 
		 return resultado; 
	}	 
	
	private static void inserir(Connection connection, String primNome, String ultNome, int idade) {
		String queryInsAluno = "INSERT INTO alunos (primNome, ultNome, idade) VALUES (?, ?, ?)";
		
		try {
			PreparedStatement pstm = connection.prepareStatement(queryInsAluno);
			
			// Inserir os dados do alunos dentro dos ? presentes dentro da string que tem a query
			pstm.setString(1, primNome);
			pstm.setString(2, ultNome);
			pstm.setInt(3, idade);
			
			// Irá executar a query e retornar o numeros de rows afetadas
			int linhas = pstm.executeUpdate();
			
			if(linhas > 0) {
				System.out.println("Linha adicionada");
			} else {
				System.out.println("Ocorreu um erro ao inserir um aluno");
			}
			
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao tentar inserir um aluno!");
		}
	}
	
	
	// Base de dados world
	/*
	 * public static ResultSet consulta(Connection connection) { ResultSet resultado
	 * = null;
	 * 
	 * try { String queryGetCidade =
	 * "SELECT name, population FROM city WHERE CountryCode LIKE 'BOL' ORDER BY population DESC"
	 * ;
	 * 
	 * Statement stm = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
	 * ResultSet.CONCUR_UPDATABLE); stm.setFetchSize(1); resultado =
	 * stm.executeQuery(queryGetCidade);
	 * 
	 * } catch(Exception e) {
	 * System.out.println("Ocorreu um erro ao fazer uma consulta com o Dr. St0cki");
	 * } return resultado; }
	 * 
	 * private static double mediaPopulacao(ResultSet resultado) throws SQLException
	 * { String name; int populacao, total_populacao = 0, numLinhas = 0;
	 * 
	 * while(resultado.next()) { name = resultado.getString("name"); populacao =
	 * resultado.getInt("population");
	 * 
	 * total_populacao += populacao; numLinhas++; } return (total_populacao /
	 * numLinhas); }
	 * 
	 * private static String maiorPopulacao(ResultSet resultado) throws SQLException
	 * { String cidade = "";
	 * 
	 * if(resultado.first()) { cidade = resultado.getString("name"); } return
	 * cidade; }
	 * 
	 * private static String menorPopulacao(ResultSet resultado) throws SQLException
	 * { String cidade = "";
	 * 
	 * if(resultado.last()) { cidade = resultado.getString("name"); }
	 * 
	 * return cidade; }
	 */
}
