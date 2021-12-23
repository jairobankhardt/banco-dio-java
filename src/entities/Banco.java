package entities;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	
	private String nomeBanco;
	private List<Conta> contas = new ArrayList<>();
	
	public Banco(String nomeBanco, List<Conta> contas) {
		this.nomeBanco = nomeBanco;
		this.contas = contas;
	}

	public String getNomeBanco() {
		return nomeBanco;
	}

	public List<Conta> getContas() {
		return contas;
	}
	
	public void adicionaConta(Conta conta) {
		this.contas.add(conta);
	}

	@Override
	public String toString() {
		return "*** " + nomeBanco + " ***\n" + contas;
	}
	

}
