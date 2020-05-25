

import java.util.Scanner;

import defi.ezoqc.joseleno.domain.service.CalculatriceService;

public class CalculatriceConsole {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		CalculatriceService calculatrice = new CalculatriceService();
		char opcao;
		do {
			System.out.print("Expressão: ");
			String exp = ler.nextLine();
			System.out.println(calculatrice.calculer(exp));
			System.out.print("\nCalcular novamente [y|n]?");
			opcao = ler.next().charAt(0);
		} while (opcao == 'y');

	}

}
