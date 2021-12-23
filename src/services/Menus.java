package services;

import java.util.Scanner;

public class Menus {

	Scanner sc = new Scanner(System.in);
	
	public int menuOperacoes() {
		System.out.println("\n\nO que você gostaria de fazer?");
		System.out.println("1 - Depositar");
		System.out.println("2 - Sacar");
		System.out.println("3 - Transferir");
		System.out.println("4 - Ver extratos");
		System.out.println("5 - Sair");
		System.out.print("Selecione uma opção: ");
		int opcao = sc.nextInt();
		while (opcao < 1 || opcao > 5) {
			System.out.print("Opção inválida. Tente novamente: ");
			opcao = sc.nextInt();
		}
		return opcao;
	}

}
