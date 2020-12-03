package exercicio_1;

public class Aluno {
	// Declaracao dos campos da classe
	private String primNome, ultNome;
	private int idTurma;
	
	
	// Construtor vazio
	public void Aluno() {
		
	}

	
	// Getters
	public String getPrimNome() {
		return primNome;
	}
	public String getUltNome() {
		return ultNome;
	}
	public int getIdTurma() {
		return idTurma;
	}

	// Setters
	public void setPrimNome(String primNome) {
		this.primNome = primNome;
	}	
	public void setUltNome(String ultNome) {
			this.ultNome = ultNome;
	}
	public void setIdTurma(int idTurma) {
		this.idTurma = idTurma;
	}
}
