package exercicios_18_11_2020;

import java.util.ArrayList;

public class Turma {
	private char ID;
	private ArrayList<Aluno> alunos;
	
	// Construct
	public Turma() {
		
	}
	
	public Turma(char ID, ArrayList<Aluno> alunos) {
		this.ID = ID;
		this.alunos = alunos;
	}
	
	// Setters ou métodos de set	
	public void setID(char ID) {
		this.ID = ID;
	}
	public void setAlunos(ArrayList<Aluno> alunos) {
		this.alunos = alunos;
	}

	// Getters ou métodos de get
	public char getID() {
		return this.ID;
	}
	public ArrayList<Aluno> getAlunos() {
		return this.alunos;
	}
	
	// Metodos
	public int getContagemAlunosMenoresIdade() {
		int contador = 0;
		
		for(int i = 0; i < this.alunos.size(); i++) {
			if(this.alunos.get(i).getIdade() < 18) {
				contador++; 
			}		
		}
		return contador;
	}
	
	public String getNomesAlunosMenoresIdade() {
		String nomes = "";
		
		for(int i = 0; i < this.alunos.size(); i++) {
			if(this.alunos.get(i).getIdade() < 18) {
				nomes += this.alunos.get(i).getNome() + ", ";
			}		
		}
		return nomes;
	}
	
	public int getContagemAlunosMediaPositiva() {
		int contador = 0;
		
		for(int i = 0; i < this.alunos.size(); i++) {
			if(this.alunos.get(i).getMediaCurso() >= 10) {
				contador++; 
			}		
		}
		return contador;
	}
	
	public String getNomesAlunosMediaPositiva() {
		String nomes = "";
		
		for(int i = 0; i < this.alunos.size(); i++) {
			if(this.alunos.get(i).getMediaCurso() >= 10) {
				nomes += this.alunos.get(i).getNome() + ", ";
			}		
		}
		return nomes;
	}
}
