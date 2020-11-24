import java.util.Scanner;

public class ex_6 {

	public static void main(String[] args) {
		float numero;
		final float intervalo[] = {
				-100,
				100
				};
		
		boolean bool;
		
		
		numero = insNumero();
		bool = checkIntervalo(numero, intervalo);

		if(bool) {
			System.out.println("O número se encontra no intervalo [" + intervalo[0] + ", " + intervalo[1] + "]");
		} else {
			System.out.println("O número não se encontra no intervalo [" + intervalo[0] + ", " + intervalo[1] + "]: ");
		}
		
	}
	
	private static boolean checkIntervalo(float numero, float intervalo[]) {
		if(numero >= intervalo[0] && numero <= intervalo[1]) {
			return true;
		} else {
			return false;
		}
	}
	
	private static int insNumero() {
		Scanner scanner = new Scanner(System.in);
		int numero;
		
		System.out.print("Insira um número: ");
		numero = scanner.nextInt();
		
		return numero;
	}
}
