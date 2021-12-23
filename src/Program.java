import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import entities.Banco;
import entities.Cliente;
import services.Cadastros;
import services.Menus;
import services.Transacoes;

public class Program {

	public static void main(String[] args){
		
		Locale.setDefault(Locale.US);
		
		List<Cliente> clientes = new ArrayList<>();
		List<Banco> bancos = new ArrayList<>();
		
		Menus menus = new Menus();
		Cadastros cadastros = new Cadastros();
		Transacoes transacoes = new Transacoes();
		
		int opcao;
		
		
		// --------- INÍCIO DO PROGRAMA 
		
		clientes = cadastros.cadastrarClientes();
		
		bancos = cadastros.cadastrarBancosEContas(clientes);
		
		opcao = menus.menuOperacoes();
		while (opcao != 5) {
			if (opcao == 1) {
				transacoes.fazerDeposito(bancos);
			} else if (opcao == 2) {
				transacoes.fazerSaque(bancos);
			} else if (opcao == 3) {
				transacoes.fazerTransferencia(bancos);
			} else {
				transacoes.imprimirExtratos(bancos);
			}
			opcao = menus.menuOperacoes();
		}
		
		System.out.println("\n\n --- PROGRAMA FINALIZADO ---");
	}
}
