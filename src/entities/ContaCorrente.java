package entities;

public class ContaCorrente extends Conta {


	public ContaCorrente(Integer agencia, Cliente cliente) {
		super(agencia, cliente);
	}

	@Override
	public String toString() {
		return "--- Conta Corrente ---\n"
				+ super.toString();
	}
	
	

}
