package lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClienteCRUD {

	private Map<String, Cliente> clientes;
//	private ArrayList<Cliente> clientesOrdenados;

	public ClienteCRUD() {
		this.clientes = new HashMap<>();

	}

	public void createCliente(String cpf, String nome, String email, String localizacao) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clientes == null) ? 0 : clientes.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClienteCRUD other = (ClienteCRUD) obj;
		if (clientes == null) {
			if (other.clientes != null)
				return false;
		} else if (!clientes.equals(other.clientes))
			return false;
		return true;
	}

}
