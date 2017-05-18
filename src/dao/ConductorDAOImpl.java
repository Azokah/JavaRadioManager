package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbclases.Conductor;
import dbmanager.DBManager;
import exceptions.RadioException;

public class ConductorDAOImpl implements ConductorDAO{

	@Override
	public void nuevoConductor(Conductor conductor) throws RadioException {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO conductores (nombre, sueldo) VALUES ('"
				+ conductor.getNombre()
				+ "','"
				+ conductor.getSueldo()
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
			throw new RadioException("Error al crear el Conductor", e);
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
			}
		}
	}

	@Override
	public void borrarConductor(Conductor conductor) throws RadioException{
		// TODO Auto-generated method stub
		String sql = "DELETE FROM conductores WHERE nombre = '" + conductor.getNombre() + "'";
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
			throw new RadioException("Error al borrar el Conductor", e);
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
			}
		}
	}

	@Override
	public void modificarConductor(Conductor conductor) throws RadioException{
		// TODO Auto-generated method stub
		String sql = "UPDATE conductores set sueldo = '" + conductor.getSueldo() + "' WHERE nombre = '" + conductor.getNombre() + "'";
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
			throw new RadioException("Error al modificar el Conductor", e);
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
			}
		}
	}

	@Override
	public Conductor mostrarConductor(Conductor conductor) throws RadioException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM conductores WHERE nombre = '" + conductor.getNombre() + "'";
		Connection c = DBManager.getInstance().connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);

			if(rs.next()) { 
				System.out.println("Conductor:");
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
			throw new RadioException("Error al mostrar el Conductor", e);
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
			}
		}
		return null;
	}

	@Override
	public List<Conductor> mostrarTodosConductor() throws RadioException{
		// TODO Auto-generated method stub
		List<Conductor> listaCon = new ArrayList<Conductor>();
		String sql = "SELECT * FROM conductores";
		Connection c = DBManager.getInstance().connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while(rs.next()) {
				listaCon.add(new Conductor(rs.getString("nombre"),rs.getFloat("Sueldo")));

			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				c.rollback();
			} catch (SQLException e1) {
			}
			throw new RadioException("Error al mostrar el Conductor", e);
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
			}
		}
		return listaCon;
	}	
}
