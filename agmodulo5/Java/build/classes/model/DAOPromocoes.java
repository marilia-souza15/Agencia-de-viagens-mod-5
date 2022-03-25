package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class DAOPacotes {
	/** The driver. */
	private String driver = "com.mysql.ag.jdbc.Driver";
	
	/** The url. */
	private String url = "jdbc:'mysql:/localhost:3000/agencia";
	
	/** The user. */
	private String user = "root";
	
	/** The password. */
	private String password = "Ma4890";

	/**
	 * Conectar.
	 *
	 * @return the connection
	 */
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	/**
	 * Inserir contato.
	 *
	 * @param contato the contato
	 */
	public void inserirContato(JbPromocoes contato) {
		String create = "insert into promocoes (preco,data_ida,nome_promocoes) values (?,?,?)";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, contato.getPreco());
			pst.setString(2, contato.getData_ida());
			pst.setString(3, contato.getNome_promocoes());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Listar contatos.
	 *
	 * @return the array list
	 */
	public ArrayList<JbPromocoes> listarContatos() {
		ArrayList<JbPromocoes> contatos = new ArrayList<>();
		String read = "select * from promocoes order by nome_promocoes";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String id_promocoes = rs.getString(1);
				String num_acompanhantes = rs.getString(2);
				String preco = rs.getString(3);
				String data_ida = rs.getString(4);
				String nome_promocoes = rs.getString(5);
				String id_cliente = rs.getString(6);
				String id_destino = rs.getString(7);
				contatos.add(new JbPromocoes(id_promocoes, preco, data_ida, nome_promocoes, id_cliente, id_destino ));
				//contatos.add(new JbClientes(nome,telefone,email));
			}
			con.close();
			return contatos;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/**
	 * Selecionar contato.
	 *
	 * @param contato the contato
	 */
	public void selecionarContato(JbPromocoes contato) {
		String read2 = "select * from promocoes where id_promocoes = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, contato.getId_promocoes());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				contato.setPreco(rs.getString(1));
				contato.setData_ida(rs.getString(2));
				contato.setId_promocoes(rs.getString(3));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Alterar contato.
	 *
	 * @param contato the contato
	 */
	public void alterarContato(JbPromocoes contato) {
		String update = "update promocoes set preco=?,data_ida=?, where id_pacote=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(update);
			pst.setString(1, contato.getPreco());
			pst.setString(2, contato.getData_ida());
			pst.setString(3, contato.getId_promocoes());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Deletar contato.
	 *
	 * @param contato the contato
	 */
	public void deletarContato(JbPromocoes contato) {
		String delete = "delete from promocoes where id_promocoes=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, contato.getId_promocoes());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
