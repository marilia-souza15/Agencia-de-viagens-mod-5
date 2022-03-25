package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAOClientes {
	
	/** The driver. */
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	/** The url. */
	private String url = "jdbc:mysql://127.0.0.1:3306/agencia?useTimezone=true&serverTimezone=UTC";
	
	/** The user. */
	private String user = "root";
	
	/** The password. */
	private String password = "ma4890";

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
	public void inserirContato(JbClientes contato) {
		String create = "insert into clientes (nome,telefone,email,) values (?,?,?)";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getTelefone());
			pst.setString(5, contato.getEmail());
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
	public ArrayList<JbClientes> listarContatos() {
		ArrayList<JbClientes> contatos = new ArrayList<>();
		String read = "select * from clientes order by nome";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				
				String nome = rs.getString(1);
				String telefone = rs.getString(2);
				String id_cliente = rs.getString(3);
				String email = rs.getString(4);
				String id_promocoes = rs.getString(5);
				contatos.add(new JbClientes(nome, telefone, id_cliente, email, id_promocoes ));
				//contatos.add(new JbClientes(nome,telefone,cidade_reside,uf_reside,email,país_reside));
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
	public void selecionarContato(JbClientes contato) {
		String read2 = "select * from clientes where id_cliente = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, contato.getId_cliente());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				contato.setNome(rs.getString(1));
				contato.setTelefone(rs.getString(2));
				contato.setCidade_reside(rs.getString(3));
				contato.setUf_reside(rs.getString(4));
				contato.setEmail(rs.getString(5));
				contato.setPaís_reside(rs.getString(6));
				contato.setId_pacote(rs.getString(7));
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
	public void alterarContato(JbClientes contato) {
		String update = "update clientes set nome=?,telefone=?,cidade_reside=?,uf_reside=?,email=?,país_reside=? where id_cliente=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(update);
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getTelefone());
			pst.setString(3, contato.getCidade_reside());
			pst.setString(4, contato.getUf_reside());
			pst.setString(5, contato.getEmail());
			pst.setString(6, contato.getPaís_reside());
			pst.setString(7, contato.getId_cliente());
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
	public void deletarContato(JbClientes contato) {
		String delete = "delete from clientes where id_cliente=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, contato.getId_cliente());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
