package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbclases.Programa;
import dbmanager.DBManager;
import exceptions.RadioException;

public class ProgramasDaoImpl implements ProgramaDAO{

	@Override
	public void nuevoPrograma(Programa programa) throws RadioException {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO programas (nombre, horario, conductor, productor, auspiciante) VALUES ('"
				+ programa.getNombre()
				+ "','"
				+ programa.getHorario()
				+ "','"
				+ programa.getConductor()
				+ "','"
				+ programa.getProductor()
				+ "','"
				+ programa.getAuspiciante()
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
			throw new RadioException("Error al crear el programa", e);
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
			}
		}
	}

	@Override
	public void borrarPrograma(Programa programa) throws RadioException{
		// TODO Auto-generated method stub
		String sql = "DELETE FROM programas WHERE nombre = '" + programa.getNombre() + "'";
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
			throw new RadioException("Error al borrar el programa", e);
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
			}
		}
	}

	@Override
	public void modificarPrograma(Programa programa) throws RadioException{
		// TODO Auto-generated method stub
		String sql = "UPDATE programas set conductor = '" + programa.getConductor() +"', productor = '"+ programa.getProductor() +"', horario = '" + programa.getHorario() + "', auspiciante = '" + programa.getAuspiciante() + "' WHERE nombre = '" + programa.getNombre() + "'";
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
			throw new RadioException("Error al modificar el programa", e);
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
			}
		}

	}

	@Override
	public Programa mostrarPrograma(Programa programa) throws RadioException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM programas WHERE nombre = '" + programa.getNombre() + "'";
		Connection c = DBManager.getInstance().connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);

			if(rs.next()) { 
				System.out.println("Programa:");
				System.out.print("\t ID:" + rs.getInt("id")+"\n");
				System.out.print("\t Titulo:" + rs.getString("nombre")+"\n");
				System.out.print("\t Horarios:" + rs.getString("horario")+"\n");
				System.out.print("\t Conductor:" + rs.getString("conductor")+"\n");
				System.out.print("\t Productor: " + rs.getString("productor")+"\n");
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				c.rollback();
			} catch (SQLException e1) {
			}
			throw new RadioException("Error al mostrar el programa", e);
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {}
		}
		return null;
	}

	@Override
	public List<Programa> mostrarTodosPrograma() throws RadioException{
		// TODO Auto-generated method stub
		List<Programa> listaPgm = new ArrayList<Programa>();
		String sql = "SELECT * FROM programas";
		Connection c = DBManager.getInstance().connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while(rs.next()) {
				/*System.out.println("Programa:");
					System.out.print("\t ID:" + rs.getInt("id")+"\n");
					System.out.print("\t Titulo:" + rs.getString("nombre")+"\n");
					System.out.print("\t Horarios:" + rs.getString("horario")+"\n");
					System.out.print("\t Conductor:" + rs.getString("conductor")+"\n");
					System.out.print("\t Productor: " + rs.getString("productor")+"\n");
					System.out.println();*/
				listaPgm.add(new Programa(rs.getString("nombre"),rs.getString("horario"),rs.getString("conductor"),rs.getString("productor"),rs.getString("auspiciante")));

			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				c.rollback();
			} catch (SQLException e1) {
			}
			throw new RadioException("Error al mostrar el programa", e);
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {}
		}
		return listaPgm;
	}	
}
