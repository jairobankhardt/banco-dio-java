package entities;

import java.util.Random;

public abstract class Conta {
	
	private Integer agencia;
	private Integer numero;
	private Double saldo;
	private Cliente cliente;
	
	public Conta(Integer agencia, Cliente cliente) {
		this.agencia = agencia;
		this.cliente = cliente;
		this.saldo = 0.0;
		this.numero = new Random().nextInt();
	}

	public Double getSaldo() {
		return saldo;
	}

	public Integer getAgencia() {
		return agencia;
	}

	public Integer getNumero() {
		return numero;
	}

	public Cliente getCliente() {
		return cliente;
	}
	
	public void deposita(Double valor) {
		this.saldo += valor;
		System.out.println("Depósito efetuado com sucesso.");
	}
	
	public void saca(Double valor) {
		if (this.saldo < valor) {
			System.out.println("Não há saldo para este valor.");
		} else {
			this.saldo -= valor;
			System.out.println("Valor retirado. Saldo atual: " + this.saldo);
		}
	}
	
	public void transferir(Double valor, Conta destino) {
		if (this.getSaldo() < valor) {
			System.out.println("Saldo insufiente para esta transferência.");
		} else {
			this.saca(valor);
			destino.deposita(valor);
			System.out.println("Transferência realizada com sucesso.");
		}
	}

	@Override
	public String toString() {
		return "Agência: " + 
				agencia + 
				" | Número: " + 
				numero + 
				" | " +
				cliente + 
				" | Saldo: R$ " + 
				String.format("%.2f", saldo) +
				"\n";
	}
	
	
}
