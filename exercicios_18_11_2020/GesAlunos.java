package exercicios_18_11_2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GesAlunos {
	public static void main(String[] args) {
		ArrayList<Aluno> AlunosA = new ArrayList<Aluno>();
		ArrayList<Aluno> AlunosB = new ArrayList<Aluno>();
		ArrayList<Turma> Turma = new ArrayList<Turma>();
		
		Aluno aluno1 = new Aluno("Joaquim Barbosa", 17, "joaquimbarbosa@oemail.com", 15.2);
		Aluno aluno2 = new Aluno("Maria Joaquina", 19, "mariajoaquina@oemail.com", 19.7);
		Aluno aluno3 = new Aluno("Pomps Pomposo", 16, "pomps@oemail.com", 12.6);
		Aluno aluno4 = new Aluno("Careca narigudo", 20, "narigudo@oemail.com", 8.4);
		Aluno aluno5 = new Aluno("Joerso Marco", 25, "joerso@oemail.com", 12.3);
		Aluno aluno6 = new Aluno("Neymar Pikoso", 16, "neymarpikoso@oemail.com", 11.5);
		Aluno aluno7 = new Aluno("Lele Arango", 15, "lelearango@oemail.com", 9.7);
		Aluno aluno8 = new Aluno("Maria II", 19, "mariasegunda@oemail.com", 16.3);
		Aluno aluno9 = new Aluno("Maria kokumber", 18, "mariakokumber@oemail.com", 11.2);
		Aluno aluno10 = new Aluno("Jao bartola", 20, "jaobartola@oemail.com", 15.4);
		
		List<Aluno> alunos_turma1 = new ArrayList<>();
		List<Aluno> alunos_turma2 = new ArrayList<>();
		
		alunos_turma1.addAll(Arrays.asList(aluno1, aluno2, aluno3, aluno4, aluno5));
		// alunos_turma1.add(aluno10);  exemplo de adição de um aluno em uma turma
		
		alunos_turma2.addAll(Arrays.asList(aluno6, aluno7, aluno8, aluno9, aluno10));
		
		AlunosA.addAll(alunos_turma1);
		AlunosB.addAll(alunos_turma2);
		
		Turma turmaA = new Turma('A', AlunosA);
		Turma turmaB = new Turma('B', AlunosB);
		
		Turma.add(turmaA);
		Turma.add(turmaB);
		
		
		System.out.println("Números de alunos menores de 18 anos (Turma A): " + turmaA.getContagemAlunosMenoresIdade());
		System.out.println("Nomes dos alunos: " + turmaA.getNomesAlunosMenoresIdade());

		System.out.println("\nNúmeros de alunos com média positiva (Turma A): " + turmaA.getContagemAlunosMediaPositiva());
		System.out.println("Nomes dos alunos: " + turmaA.getNomesAlunosMediaPositiva());
		
		System.out.println("\nTodos os alunos: ");
		
		System.out.println("Números de alunos menores de 18 anos: " + (turmaA.getContagemAlunosMenoresIdade() + turmaB.getContagemAlunosMenoresIdade()));
		System.out.println("Nomes dos alunos: " + (turmaA.getNomesAlunosMenoresIdade() + turmaB.getNomesAlunosMenoresIdade()));
		
		System.out.println("\nNúmeros de alunos com média positiva: " + (turmaA.getContagemAlunosMediaPositiva() + turmaB.getContagemAlunosMediaPositiva()));
		System.out.println("Nomes dos alunos: " + (turmaA.getNomesAlunosMediaPositiva() + turmaB.getNomesAlunosMediaPositiva()));
	}
}
