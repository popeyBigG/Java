package exercicio_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class GesCozinha {
	private static Armazem armazem = new Armazem();
	
	public static void main(String[] args) {
		// Ingredintes no armazém
		ArrayList<Ingrediente> Ingredientes = new ArrayList<Ingrediente>();
		ArrayList<Armazem> Armazem = new ArrayList<Armazem>();
		
		Ingrediente ing1 = new Ingrediente(2, "Kg", "Arroz");
		Ingrediente ing2 = new Ingrediente(1, "Unidade", "Ovos");
		Ingrediente ing3 = new Ingrediente(1, "Frasco", "Molho de salsa");
		Ingrediente ing4 = new Ingrediente(1, "Unidade", "Bacalhau");
		Ingrediente ing5 = new Ingrediente(1, "Frasco", "Pimenta");
		Ingrediente ing6 = new Ingrediente(3, "Unidade", "Batata");
		
		Ingredientes.addAll(Arrays.asList(ing1, ing2, ing3, ing4, ing5, ing6));
		
		Armazem lista_ingredientes = new Armazem(Ingredientes);
		Armazem.add(lista_ingredientes);
		
		// Receita do bacalhau
		ArrayList<Ingrediente> ingredientesBacalhau = new ArrayList<>();
		
		Ingrediente bacalhauIng1 = new Ingrediente(1, "Unidade", "Bacalhau");
		Ingrediente bacalhauIng2 = new Ingrediente(3, "Unidade", "Ovos");
		Ingrediente bacalhauIng3 = new Ingrediente(1, "Frasco", "Pimenta");
		Ingrediente bacalhauIng4 = new Ingrediente(4, "Unidade", "Batata");
		
		ingredientesBacalhau.addAll(Arrays.asList(bacalhauIng1, bacalhauIng2, bacalhauIng3, bacalhauIng4));

		armazem.checarQuantidade(Ingredientes, ingredientesBacalhau, 1);
		
	}
}
