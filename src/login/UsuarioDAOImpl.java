package login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbclases.Auspiciante;
import dbmanager.DBManager;
import exceptions.RadioException;

public class UsuarioDAOImpl implements UsuarioDAO {

	@Override
	public void nuevoUsuario(Usuario usuario) throws RadioException {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO usuarios (usuario, pass) VALUES ('"
				+ usuario.getUsuario()
				+ "','"
				+ usuario.getPass()
				+ "')";
		Connection c = DBManager.getInstance().connect();
		try {
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			c.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				c.rollback();
			} catch (SQLException e1) {
			}
			throw new RadioException("Hubo un error al crear el usuario!", e);
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
			}
		}
	}

	@Override
	public void borrarUsuario(Usuario usuario) throws RadioException{
		// TODO Auto-generated method stub
		String sql = "DELETE FROM auspiciantes WHERE nombre = '" + usuario.getUsuario() + "'";
		Connection c = DBManager.getInstance().connect();
		try {
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			c.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				c.rollback();
			} catch (SQLException e1) {
			}
			throw new RadioException("Hubo un error al borrar el auspiciante", e);
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
			}
		}
	}

	@Override
	public Boolean buscarUsuario(Usuario usuario) throws RadioException{
		// TODO Auto-generated method stub
		Usuario usu = new Usuario("","");
		String sql = "SELECT * FROM usuarios WHERE usuario = '" + usuario.getUsuario() + "'";
		Connection c = DBManager.getInstance().connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while(rs.next()) {
				System.out.println(rs.getString("usuario"));
				System.out.println(rs.getString("pass"));
				usu.setUsuario(rs.getString("usuario"));
				usu.setPass(rs.getString("pass"));
			}
			if(usuario.getUsuario().equals(usu.getUsuario()) && usuario.getPass().equals(usu.getPass()))
			{
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				c.rollback();
			} catch (SQLException e1) {
			}
			throw new RadioException("Hubo un error al buscar el Usuario", e);
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
			}
		}
		return false;
	}	
}
