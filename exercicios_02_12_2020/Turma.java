package exercicio_1;

public class Turma {
	// Declaracao dos campos da classe
	private String curso;
	private int anoCurso;
	
	
	// Construtor vazio
	public Turma() {
		
	}

	
	// Getters
	public String getCurso() {
		return curso;
	}
	public int getAnoCurso() {
		return anoCurso;
	}

	// Setters
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public void setAnoCurso(int anoCurso) {
		this.anoCurso = anoCurso;
	}
}
