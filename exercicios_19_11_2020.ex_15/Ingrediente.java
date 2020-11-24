package exercicio_15;

public class Ingrediente {
	private int qtd;
	private String unidade;
	private String descricao;
	
	// Constructs
	public Ingrediente() {
		
	}
	
	public Ingrediente(int qtd, String unidade, String descricao) {
		this.qtd = qtd;
		this.unidade = unidade;
		this.descricao = descricao;
	}
	
	// Getters
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	// Setters
	public String getUnidade() {
		return unidade;
	}
	public int getQtd() {
		return qtd;
	}
	public String getDescricao() {
		return descricao;
	}
}
