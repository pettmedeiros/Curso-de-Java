import java.util.Scanner;

public class EX_RESOLVIDO {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int minutos = sc.nextInt();
		
		double conta = 50.0;
		
		if (minutos > 100) {
			conta += (minutos - 100) * 2.0; // += significa que é uma operacação cumulativa,é conta = conta mais minutos-100 * 2
			
		}
		
		System.out.printf("Valor da conta = %.2f\n", conta);
			
		
		
		
		sc.close();

	}

}
