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
		
		consulta = consulta(conn);
		System.out.println("Média de população: " + mediaPopulacao(consulta));
		
		consulta = consulta(conn);
		System.out.println("Maior população: " + maiorPopulacao(consulta));
		
		consulta = consulta(conn);
		System.out.println("Menor população: " + menorPopulacao(consulta));
		
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
	
	public static ResultSet consulta(Connection connection) {
		ResultSet resultado = null;
		
		try {
			String queryGetCidade = "SELECT name, population FROM city WHERE CountryCode LIKE 'BOL' ORDER BY population DESC"; 
			
			Statement stm = connection.createStatement();
			resultado = stm.executeQuery(queryGetCidade);
			
		} catch(Exception e) {
			System.out.println("Ocorreu um erro ao fazer uma consulta com o Dr. St0cki");
		}
		return resultado;
	}
	
	private static double mediaPopulacao(ResultSet resultado) throws SQLException {
		String name;
		int populacao, total_populacao = 0, numLinhas = 0;
		
		while(resultado.next()) {
			name = resultado.getString("name");
			populacao = resultado.getInt("population");
			
			total_populacao += populacao;
			numLinhas++;
		}
		return (total_populacao / numLinhas);
	}
	
	private static String maiorPopulacao(ResultSet resultado) throws SQLException {
		String cidade = "";
		
		if(resultado.next()) {
			cidade = resultado.getString("name");
		}
		return cidade;
	}
	
	private static String menorPopulacao(ResultSet resultado) throws SQLException {
		String cidade = "";
		
		while(resultado.next()) {
			cidade = resultado.getString("name");
		}
		
		return cidade;
	}
}
