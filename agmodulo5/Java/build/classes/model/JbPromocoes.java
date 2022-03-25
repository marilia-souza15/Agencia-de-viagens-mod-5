package model;

public class JbPromocoes {
	  
	 private String id_promocoes;
	 private String preco;
	 private String data_ida;
	 private String nome_promocoes;
	 private String id_cliente;
	 private String id_destino;
	 
	public JbPromocoes() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public JbPromocoes(String id_pacote, String preco,
			String data_ida, String nome_promocoes, String id_cliente, String id_destino) {
		super();
		this.id_promocoes= id_promocoes;
		this.preco = preco;
		this.data_ida = data_ida;
		this.nome_promocoes= nome_promocoes;
		this.id_cliente = id_cliente;
		this.id_destino = id_destino;
	}

	public String getId_promocoes() {
		return id_promocoes;
	}
	public void setId_promocoes(String id_promocoes) {
		this.id_promocoes= id_promocoes;
	}
	public String getPreco() {
		return preco;
	}
	public void setPreco(String preco) {
		this.preco = preco;
	}
	public String getData_ida() {
		return data_ida;
	}
	public void setData_ida(String data_ida) {
		this.data_ida = data_ida;
	}

	public String getNome_promocoes() {
		return nome_promocoes;
	}
	public void setNome_promocoes(String nome_promocoes) {
		this.nome_promocoes= nome_promocoes;
	}
	public String getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(String id_cliente) {
		this.id_cliente = id_cliente;
	}
	public String getId_destino() {
		return id_destino;
	}
	public void setId_destino(String id_destino) {
		this.id_destino = id_destino;
	}

}
