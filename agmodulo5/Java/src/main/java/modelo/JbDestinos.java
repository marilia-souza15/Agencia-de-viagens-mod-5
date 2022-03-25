package model;

public class JbDestinos {
	 
	 private String id_destino;
   	 private String cidade;
	 private String estado;
	 private String id_promocoes;
	 
	public JbDestinos() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public JbDestinos(String id_destino, String cidade, String estado, String id_promocoes) {
		super();
		this.id_destino = id_destino;
		this.cidade = cidade;
		this.estado = estado;
		this.id_promocoes = id_promocoes;
	}

	public String getId_destino() {
		return id_destino;
	}
	public void setId_destino(String id_destino) {
		this.id_destino = id_destino;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getId_promocoes() {
		return id_promocoes;
	}
	public void setId_promocoes(String id_promocoes) {
		this.id_promocoes = id_promocoes;
	}

}
