package exercicio_15;

import java.util.ArrayList;

public class Armazem {
	ArrayList<Ingrediente> ingredientes;
	
	// Constructs
	public Armazem() {
		
	}
	public Armazem(ArrayList<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}
	
	// Setters
	public void setArmazem(ArrayList<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}
	
	// Getters
	public ArrayList<Ingrediente> getArmazem() {
		return ingredientes;
	}
	
	// Methods
	public void checarQuantidade(ArrayList<Ingrediente> armazem, ArrayList<Ingrediente> receita, int doses) {
		int quantidadeNecessaria, quantidadeArmazem;
		for(int i = 0; i < armazem.size(); i++) {
			for(int k = 0; k < receita.size(); k++) {
				if(armazem.get(i).getDescricao() == receita.get(k).getDescricao()) {
					quantidadeNecessaria = (receita.get(k).getQtd() * doses);
					quantidadeArmazem = armazem.get(i).getQtd();
					if(quantidadeArmazem >= quantidadeNecessaria) {
						System.out.println("É possível fazer as " + doses + " doses!");
					} else {
						System.out.println("Faltam " + (quantidadeNecessaria - quantidadeArmazem) + " " + receita.get(k).getDescricao());
					}
				}
			}
		}
	}
	
}
