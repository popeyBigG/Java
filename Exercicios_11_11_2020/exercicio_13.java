package exercicios;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class exercicio_13 {
	public static void main(String[] args) {
		ArrayList<Produto> Produtos = new ArrayList<Produto>();
		
		Produto prod1 = new Produto(10, "Kg", "Batata vermelha", 0.59, 18);
		Produto prod2 = new Produto(1, "Lt", "Vinho branco", 1.65, 18);
		Produto prod3 = new Produto(2, "Embalagem", "Amaciador cabelo", 5.59, 18);
		Produto prod4 = new Produto(6, "Embalagem", "Iogurte grego", 0.95, 9);
		Produto prod5 = new Produto(1, "Kg", "Arroz carolino", 0.45, 18);
		Produto prod6 = new Produto(1, "Embalagem", "Pensos rápidos", 1, 9);
		
		Produtos.add(prod1);
		Produtos.add(prod2);
		Produtos.add(prod3);
		Produtos.add(prod4);
		Produtos.add(prod5);
		Produtos.add(prod6);
		
		printFatura(Produtos);
	}
	
	public static void printFatura(ArrayList<Produto> array) {
		double total = 0, iva = 0;
		
		String formatHeader  = "%1$5s\t%2$15s\t%3$30s\t%4$5s\t%5$5s\n";				///
		String formatRowData = "%1$5d\t%2$15s\t%3$30s\t%4$5s\t%5$5s\n";		
		System.out.format(formatHeader,"QTD", "UNIDADE", "DESCRIÇÃO", "P.UNIT", "IVA(%)");	///
		NumberFormat formatter = new DecimalFormat("#.##"); 
		
		for(int i = 0; i < array.size(); i++) {
			total += (array.get(i).getQuantidade() * array.get(i).getPrecoUnit());
			iva += ((array.get(i).getQuantidade() * array.get(i).getPrecoUnit()) * (array.get(i).getIva() / 100));
			System.out.format(formatRowData,array.get(i).getQuantidade(),array.get(i).getUnidade(), array.get(i).getDescricao(), formatter.format(array.get(i).getPrecoUnit()), formatter.format(array.get(i).getIva()));
		}
		System.out.println("Total a pagar: " + formatter.format(total+iva));
		System.out.println("Valor IVA: " + formatter.format(iva));
	}
}
