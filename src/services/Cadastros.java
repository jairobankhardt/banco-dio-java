package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Banco;
import entities.Cliente;
import entities.Conta;
import entities.ContaCorrente;
import entities.ContaPoupanca;

public class Cadastros {
	
	private Scanner sc = new Scanner(System.in);
	
	public List<Cliente> cadastrarClientes() {
		List<Cliente> clientes = new ArrayList<>();
		char resposta;
		do {
			System.out.println("=-=-=-= Cadastrar novo cliente =-=-=-=");
			System.out.print("Nome: ");
			String nome = sc.nextLine();
			System.out.print("CPF: ");
			String cpf = sc.nextLine();
			clientes.add(new Cliente(nome, cpf));
			System.out.print("Quer cadastrar mais um cliente? (s para Sim, ou outra letra para sair) ");
			resposta = sc.next().toLowerCase().charAt(0);
			sc.nextLine();
		} while (resposta == 's');
		return clientes;
	}
	
	public List<Banco> cadastrarBancosEContas(List<Cliente> clientes) {
		List<Banco> bancos = new ArrayList<>();
		char resposta;
		do {
			System.out.println("\n=-=-=-= Cadastrar Banco =-=-=-=");
			System.out.print("Nome do Banco: ");
			String nomeBanco = sc.nextLine();
			List<Conta> contas = cadastrarContas(nomeBanco, clientes);
			bancos.add(new Banco(nomeBanco, contas));
			System.out.print("\nQuer cadastrar mais um banco? (s para Sim, ou outra letra para sair) ");
			resposta = sc.next().toLowerCase().charAt(0);
			sc.nextLine();
		} while (resposta == 's');
		return bancos;
	}
	
	private List<Conta> cadastrarContas(String nomeBanco, List<Cliente> clientes) {
		List<Conta> contas = new ArrayList<>();
		char resposta;
		do {
			System.out.printf(" --- Cadastrar Conta em %s ---\n\n ", nomeBanco);
			System.out.println("Lista de Clientes:");
			for (int i = 1; i <= clientes.size(); i++) {
				System.out.println(i + " - " + clientes.get(i-1).getNome());
			}
			System.out.print("Escolha um cliente (Digite o número correspondente): ");
			int numCliente = sc.nextInt();
			while (numCliente < 1 | numCliente > clientes.size()) {
				System.out.print("Valor inválido. Tente novamente: ");
				numCliente = sc.nextInt();
			}
			Cliente cliente = clientes.get(numCliente-1);
			System.out.print("Agência (somente números): ");
			Integer agencia = sc.nextInt();
			System.out.print("Esta é uma Conta Corrente (CC) ou Conta Poupança (CP)? ");
			String respostaConta = sc.next().toUpperCase();
			while (!respostaConta.equals("CC") && !respostaConta.equals("CP")) {
				System.out.println("respostaConta: " + respostaConta);
				System.out.print("Resposta inválida. Tente novamente: ");
				respostaConta = sc.next().toUpperCase();
			}
			if (respostaConta.equals("CC")) {
				contas.add(new ContaCorrente(agencia, cliente));
			}
			else {
				contas.add(new ContaPoupanca(agencia, cliente));
			}
			System.out.print("\nQuer cadastrar mais uma conta? (s para Sim, ou outra letra para sair) ");
			resposta = sc.next().toLowerCase().charAt(0);
		} while (resposta == 's'); 
		return contas;
	}

}
