package entities;

public class ContaPoupanca extends Conta{

	public ContaPoupanca(Integer agencia, Cliente cliente) {
		super(agencia, cliente);
	}

	@Override
	public String toString() {
		return "--- Conta Poupança ---\n"
				+ super.toString();
	}
}
