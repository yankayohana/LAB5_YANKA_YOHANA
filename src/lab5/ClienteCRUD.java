package lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClienteCRUD {

	private Map<String, Cliente> clientes;

	public ClienteCRUD() {
		this.clientes = new HashMap<>();

	}

	public void createCliente(String cpf, String nome, String email, String localizacao) throws Exception {
		if (clientes.containsKey(cpf)) {
			throw new Exception("cliente ja existe.");
		} else {
			Cliente cliente = new Cliente(cpf, nome, email, localizacao);
			clientes.put(cpf, cliente);
		}

	}

	public String readCliente(String cpf) {
		return clientes.get(cpf).toString();
	}

	public String exibeClientes() {
		String retorno = "";
		int contador = 0;
		for (Cliente cliente : this.getClientesOrdenados()) {
			contador += 1;
			if (contador < this.getClientesOrdenados().size()) {
				retorno += cliente.toString() + " | ";
			}
			if (contador == this.getClientesOrdenados().size()) {
				retorno += cliente.toString();
			}
		}
		return retorno;
	}

	public List<Cliente> getClientesOrdenados() {
		List<Cliente> clientesOrdenados = new ArrayList<>(this.clientes.values());
		Collections.sort(clientesOrdenados);
		return clientesOrdenados;
	}

	public void editaCliente(String cpf, String parametro, String valor) throws Exception {
		if (clientes.containsKey(cpf)) {
			Cliente cliente = this.clientes.get(cpf);
			cliente.editarParametro(parametro, valor);
		} else {
			throw new Exception("cliente nao existe.");
		}

	}

	public void removeCliente(String cpf) {
		clientes.remove(cpf);
	}

	public String exibeCliente(String cpf) throws Exception {
		if (clientes.containsKey(cpf)) {
			return clientes.get(cpf).toString();

		} else {
			throw new Exception("Erro na exibicao do cliente: cliente nao existe.");
		}

	}

	public Cliente getCliente(String cpf) throws Exception {
		if (clientes.containsKey(cpf)) {
			return clientes.get(cpf);
		} else {
			throw new Exception("cliente nao existe.");
		}
	}
	
	public String getNomeCliente(String cpf) throws Exception {
		Cliente cliente = getCliente(cpf);
		return cliente.getNome();
	}

}
