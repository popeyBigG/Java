package exercicios_18_11_2020;

public class Aluno {
	private String nome;
	private int idade;
	private String email;
	private double media_curso;
	
	// Construct
	public Aluno() {
		
	}
	
	public Aluno(String nome, int idade, String email, double media_curso) {
		this.nome = nome;
		this.idade = idade;
		this.email = email;
		this.media_curso = media_curso;	
	}
	
	// Setters ou métodos de set	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setMediaCurso(double media_curso) {
		this.media_curso = media_curso;
	}
	
	// Getters ou métodos de get
	public String getNome() {
		return this.nome;
	}
	public int getIdade() {
		return this.idade;
	}
	public String getEmail() {
		return this.email;
	}
	public double getMediaCurso() {
		return this.media_curso;
	}

}
