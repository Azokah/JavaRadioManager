package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbclases.Auspiciante;
import dbmanager.DBManager;
import exceptions.RadioException;

public class DBDAOImpl implements AuspicianteDAO{

	@Override
	public void nuevoAuspiciante(Auspiciante auspiciante) throws RadioException {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO auspiciantes (nombre, sueldo) VALUES ('"
				+ auspiciante.getNombre()
				+ "','"
				+ auspiciante.getSaldo()
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
			throw new RadioException("Error al crear el auspiciante", e);
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
			}
		}
	}

	@Override
	public void borrarAuspiciante(Auspiciante auspiciante) throws RadioException{
		// TODO Auto-generated method stub
		String sql = "DELETE FROM auspiciantes WHERE nombre = '" + auspiciante.getNombre() + "'";
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
			throw new RadioException("Error al borrar el auspiciante", e);
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
			}
		}
	}

	@Override
	public void modificarAuspiciante(Auspiciante auspiciante) throws RadioException{
		// TODO Auto-generated method stub
		String sql = "UPDATE auspiciantes set sueldo = '" + auspiciante.getSaldo() + "' WHERE nombre = '" + auspiciante.getNombre() + "'";
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
			throw new RadioException("Error al modificar el auspiciante", e);
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
			}
		}
	}

	@Override
	public Auspiciante mostrarAuspiciante(Auspiciante auspiciante) throws RadioException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM auspiciantes WHERE nombre = '" + auspiciante.getNombre() + "'";
		Connection c = DBManager.getInstance().connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);

			if(rs.next()) { 
				System.out.println("Auspiciante:");
				System.out.print("\t ID:" + rs.getInt("id")+"\n");
				System.out.print("\t Nombre:" + rs.getString("nombre")+"\n");
				System.out.print("\t Sueldo:" + rs.getString("Sueldo")+"\n");
				System.out.println();
			}

		} catch (SQLException e) {
			e.printStackTrace();
			try {
				c.rollback();
			} catch (SQLException e1) {
			}
			throw new RadioException("Error al mostrar el auspiciante", e);
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
			}
		}
		return null;
	}

	@Override
	public List<Auspiciante> mostrarTodosAuspiciante() throws RadioException{
		// TODO Auto-generated method stub
		List<Auspiciante> listaAus = new ArrayList<Auspiciante>();
		String sql = "SELECT * FROM auspiciantes";
		Connection c = DBManager.getInstance().connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while(rs.next()) {
				listaAus.add(new Auspiciante(rs.getString("nombre"),rs.getFloat("Sueldo")));

			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				c.rollback();
			} catch (SQLException e1) {
			}
			throw new RadioException("Error al mostrar el auspiciante", e);
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
			}
		}
		return listaAus;
	}	
}
