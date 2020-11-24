package exercicios_24_11_2020;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

// Conexão na base de dados
public class explicacao1 {
	public static void main(String[] args) throws SQLException, IOException {
		Properties p = new Properties();
		Connection conn = efetuarConexao(p);
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
	
}
