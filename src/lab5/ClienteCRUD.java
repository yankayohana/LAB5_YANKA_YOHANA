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

	public void createCliente(String cpf, String nome, String email, String localizacao) {
		if (nome.equals("")) {
			throw new NullPointerException("Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
		}
		if (email.equals("")) {
			throw new NullPointerException("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		}
		if (localizacao.equals("")) {
			throw new NullPointerException("Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
		}
		Cliente cliente = new Cliente(cpf, nome, email, localizacao);
		clientes.put(cpf, cliente);

	}

	public String readCliente(String cpf) {
		return clientes.get(cpf).toString();
	}

	public String exibeClientes() {
		String retorno = "";
		for (Cliente cliente : this.getClientesOrdenados()) {
			retorno += cliente.toString() + "|";
		}
		return retorno;
	}

	public List<Cliente> getClientesOrdenados() {
		List<Cliente> clientesOrdenados = new ArrayList<>(this.clientes.values());
		Collections.sort(clientesOrdenados);
		return clientesOrdenados;
	}

	public void editaCliente(String cpf, String parametro, String valor) {
		Cliente cliente = this.clientes.get(cpf);
		cliente.editarParametro(parametro, valor);

	}

	public void removeCliente(String cpf) {
		clientes.remove(cpf);
	}

	public String exibeCliente(String cpf) {
		return clientes.get(cpf).toString();

	}

}
