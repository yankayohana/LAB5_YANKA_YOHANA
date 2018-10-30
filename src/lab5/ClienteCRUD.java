package lab5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ClienteCRUD {
	
	private Map<String,Cliente> clientes;
	private ArrayList<Cliente> clientesOrdenados;
	
	public ClienteCRUD() {
		this.clientes = new HashMap<>();
		this.clientesOrdenados = new ArrayList<>();
	}
	
	public void creatCliente(String cpf, String nome, String email, String localizacao) {
		Cliente cliente = new Cliente(cpf, nome, email, localizacao);
		clientes.put(cpf, cliente);
		clientesOrdenados.add(cliente);
		
	}
	
	public String readCliente(String cpf) {
		return clientes.get(cpf).toString();
	}
	
	public String exibeClientes() {
		String retorno = "";
		for (Cliente cliente : clientes.values()) {
			retorno += cliente.toString() + "|";
		}
		return retorno;
	}
	
	

}
