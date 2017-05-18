package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbclases.Productor;
import dbmanager.DBManager;
import exceptions.RadioException;

public class ProductorDAOImpl implements ProductorDAO{

	@Override
	public void nuevoProductor(Productor productor) throws RadioException {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO productores (nombre, sueldo) VALUES ('"
				+ productor.getNombre()
				+ "','"
				+ productor.getSueldo()
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
			throw new RadioException("Error al crear el productor", e);
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
			}
		}
	}

	@Override
	public void borrarProductor(Productor productor) throws RadioException{
		// TODO Auto-generated method stub
		String sql = "DELETE FROM productores WHERE nombre = '" + productor.getNombre() + "'";
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
			throw new RadioException("Error al borrar el productor", e);
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
			}
		}
	}

	@Override
	public void modificarProductor(Productor productor) throws RadioException{
		// TODO Auto-generated method stub
		String sql = "UPDATE productores set sueldo = '" + productor.getSueldo() + "' WHERE nombre = '" + productor.getNombre() + "'";
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
			throw new RadioException("Error al modificar el productor", e);
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
			}
		}
	}

	@Override
	public Productor mostrarProductor(Productor productor) throws RadioException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM productores WHERE nombre = '" + productor.getNombre() + "'";
		Connection c = DBManager.getInstance().connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);

			if(rs.next()) { 
				System.out.println("Productor:");
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
			throw new RadioException("Error al mostrar el productor", e);
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
			}
		}
		return null;
	}

	@Override
	public List<Productor> mostrarTodosProductor() throws RadioException{
		// TODO Auto-generated method stub
		List<Productor> listaPro = new ArrayList<Productor>();
		String sql = "SELECT * FROM productores";
		Connection c = DBManager.getInstance().connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while(rs.next()) {
				listaPro.add(new Productor(rs.getString("nombre"),rs.getFloat("Sueldo")));

			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				c.rollback();
			} catch (SQLException e1) {
			}
			throw new RadioException("Error al mostrar el productor", e);
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
			}
		}
		return listaPro;
	}	
}
