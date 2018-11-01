package lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProdutoCRUD {
	
	private Set<Produto> produtos;
	
	public ProdutoCRUD() {
		this.produtos = new HashSet<>();
	}
	
	public void createProduto(String nome, double preco, String descricao) {
		Produto produto = new Produto(nome, preco, descricao);
		produtos.add(produto);
	}
	
	public Produto procuraProduto(String nome) throws Exception {
		for(Produto produto : produtos) {
			if(produto.getNome().equals(nome)) {
				return produto;
			}
		}
		throw new Exception("Produto não encontrado."); 
	}
	
	public String readProduto(String nome) throws Exception {
		Produto produto = procuraProduto(nome);
		return produto.toString() + "|";
	}
	
	public String exibeProdutos() {
		String retorno = "";
		for(Produto produto : this.getProdutosOrdenados()) {
			retorno += produto;
		}
		return retorno;
	}
	
	private List<Produto> getProdutosOrdenados() {
		List<Produto> produtosOrdenados = new ArrayList<>(this.produtos);
		Collections.sort(produtosOrdenados);
		return produtosOrdenados;
	}
	
	public void editaPreco(String nome, double preco) throws Exception {
		Produto produto = this.procuraProduto(nome);
		produto.setPreco(preco);
	}
	
	public void removeProduto(String nome) throws Exception {
		Produto produto = this.procuraProduto(nome);
		this.produtos.remove(produto);
	}
	
	public List<String> getToStringProdutos(){
		List<String> toStringProdutos = new ArrayList<>();
		for(Produto produto : produtos) {
			toStringProdutos.add(produto.toString()); 
		}
		return toStringProdutos;
	}
	
	
}
