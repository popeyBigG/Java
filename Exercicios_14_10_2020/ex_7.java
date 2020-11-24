import sun.nio.ch.SelectorImpl;

public class ex_7 {

	public static void main(String[] args) {
		flaot a = 5, b = -3, c = -2;
		float delta, raiz_delta, raiz1, raiz2, resultado;

		delta = (b*b) + (-4 * a*c);
		raiz_delta = (float)Math.sqrt(delta);

		// Se a raiz de delta for menor que 0, não possui raízes reais
		if(resultado < 0) {
			System.out.println("Não existe raíz real!");
		// Se a raiz de delta for igual a 0, as raízes são reais iguais
		} else if (resultado == 0) {
			resultado = (-b + raiz_delta / (2*a);
			System.out.println("A raiz é de " + resultado);
		// Se a raiz de delta for maior que 0, as ráizes são reais diferentes
		} else {
			raiz1 = (-b + raiz_delta / (2*a);
			raiz2 = (-b - raiz_delta / (2*a);

			System.out.println("A 1º raíz é: " + raiz1);
			System.out.println("A 2º raíz é: " + raiz2);
		}
	}
}

