package exercicios;

public class Produto {
	private int quantidade;
	private String unidade;
	private String descricao;
	private double punit;
	private double iva;
	
	// Construct
	public Produto(int quantidade, String unidade, String descricao, double punit, double iva) {
		this.quantidade = quantidade;
		this.unidade = unidade;
		this.descricao = descricao;
		this.punit = punit;	
		this.iva = iva;
	}
	
	// Setters ou métodos de set	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setPrecoUnit(double punit) {
		this.punit = punit;
	}
	public void setIva(double iva) {
		this.iva = iva;
	}
	
	// Getters ou métodos de get
	public int getQuantidade() {
		return this.quantidade;
	}
	public String getUnidade() {
		return this.unidade;
	}
	public String getDescricao() {
		return this.descricao;
	}
	public double getPrecoUnit() {
		return this.punit;
	}
	public double getIva() {
		return this.iva;
	}

}
