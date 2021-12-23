package services;

import java.util.List;
import java.util.Scanner;

import entities.Banco;
import entities.Conta;

public class Transacoes {
	
	private Scanner sc = new Scanner(System.in);
	
	public void fazerDeposito(List<Banco> bancos) {
		System.out.println("\n=-=-=-=-= Procedimento de depósito =-=-=-=-=\n");
		mostraBancos(bancos);
		int opcaoBanco = escolherBanco(bancos);
		System.out.println();
		mostraContas(bancos.get(opcaoBanco-1));
		int opcaoConta = escolherConta(bancos.get(opcaoBanco-1).getContas());
		System.out.print("Qual o valor para depositar na conta? ");
		Double valor = sc.nextDouble();
		bancos.get(opcaoBanco-1).getContas().get(opcaoConta-1).deposita(valor);
	}
	
	public void fazerSaque(List<Banco> bancos) {
		System.out.println("\n=-=-=-=-= Procedimento de saque =-=-=-=-=");
		mostraBancos(bancos);
		int opcaoBanco = escolherBanco(bancos);
		mostraContas(bancos.get(opcaoBanco-1));
		int opcaoConta = escolherConta(bancos.get(opcaoBanco-1).getContas());
		System.out.print("Qual o valor para saque? ");
		Double valor = sc.nextDouble();
		bancos.get(opcaoBanco-1).getContas().get(opcaoConta-1).saca(valor);
	}
	
	public void fazerTransferencia(List<Banco> bancos) {
		System.out.println("\n=-=-=-=-= Procedimento de transferência =-=-=-=-=");
		System.out.println("\n----- Escolha a conta de origem -----");
		mostraBancos(bancos);
		int opcaoBanco = escolherBanco(bancos);
		mostraContas(bancos.get(opcaoBanco-1));
		int opcaoConta = escolherConta(bancos.get(opcaoBanco-1).getContas());
		Conta contaOrigem = bancos.get(opcaoBanco-1).getContas().get(opcaoConta-1);
		System.out.println("\n----- Escolha a conta de destino -----");
		mostraBancos(bancos);
		opcaoBanco = escolherBanco(bancos);
		mostraContas(bancos.get(opcaoBanco-1));
		opcaoConta = escolherConta(bancos.get(opcaoBanco-1).getContas());
		Conta contaDestino = bancos.get(opcaoBanco-1).getContas().get(opcaoConta-1);
		System.out.print("Qual o valor para transferência? ");
		Double valor = sc.nextDouble();
		contaOrigem.transferir(valor, contaDestino);
	}
	
	private void mostraBancos(List<Banco> bancos) {
		int contador = 1;
		System.out.println("Bancos cadastrados");
		for (Banco b : bancos) {
			System.out.printf("%d - <%s>\n", contador, b.getNomeBanco());
			contador ++;
		}
	}
	
	private int escolherBanco(List<Banco> bancos) {
		System.out.print("Escolha um banco: ");
		int opcaoBanco = sc.nextInt();
		while (opcaoBanco < 1 || opcaoBanco > bancos.size()) {
			System.out.print("Opção inválida. Tente novamente: ");
			opcaoBanco = sc.nextInt();
		}
		return opcaoBanco;
	}
	
	private void mostraContas(Banco banco) {
		int contador = 1;
		System.out.println("Contas deste banco <" + banco.getNomeBanco() + ">\n");
		for (Conta c : banco.getContas()) {
			System.out.printf("%d - %s\n", contador, c);
			contador ++;
		}
	}
	
	private int escolherConta(List<Conta> contas) {
		System.out.print("Escolha uma conta: ");
		int opcaoConta = sc.nextInt();
		while (opcaoConta < 1 || opcaoConta > contas.size()) {
			System.out.print("Opção inválida. Tente novamente: ");
			opcaoConta = sc.nextInt();
		}
		return opcaoConta;
	}
	
	public void imprimirExtratos(List<Banco> bancos) {
		for (Banco b : bancos) {
			System.out.println("\nEXTRATOS DO BANCO ** " + b.getNomeBanco() + " **\n");
			for (Conta c : b.getContas()) {
				System.out.println(c);
			}
		}
	}

}
