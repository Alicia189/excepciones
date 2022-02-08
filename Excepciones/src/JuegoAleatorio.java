import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author David
 *
 */
public class JuegoAleatorio {
	
	private static int num;
	private static int intentos;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		num = (int) (Math.random()*500+1);
		intentos=0;
		
		int dato=-1;
		Scanner entrada = new Scanner(System.in);
		
		do  {
			System.out.println("introduce un número entre 1 y 500, a ver si aciertas");
			try {
				dato = entrada.nextInt();
				if (num>dato) {
					System.out.println("El numero a acertar es mayor");
				} else if (num<dato) {
					System.out.println("El número a acertar es menor");
				} else {
					System.out.println("Has acertado");
				}
			} catch (InputMismatchException e) {
				System.out.println("Error. El número introducido no es correcto\n");
				entrada.nextLine();
			}
			intentos++;
			System.out.printf("Has utilizado %d intentos\n", intentos);
		} while (dato!=num);
		
	}

}
