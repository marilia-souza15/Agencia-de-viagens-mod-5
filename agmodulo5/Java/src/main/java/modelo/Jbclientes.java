package model;

public class JbClientes {
		
	private String nome;
	private String telefone;
	private String id_cliente;
	private String email;
	private String id_promocoes;
	
	public JbClientes() {
		super();
	}
	
	public JbClientes(String nome, String telefone, String id_cliente,
			String email, String id_promocoes) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.id_cliente = id_cliente;
		this.email = email;
		this.id_promocoes = id_promocoes;
	}

	

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(String id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getId_promocoes() {
		return id_promocoes;
	}
	public void setId_promocoes(String id_promocoes) {
		this.id_promocoes = id_promocoes;
	}

}
