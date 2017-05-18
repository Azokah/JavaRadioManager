package dbmanager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dbclases.Programa;
import dbmanager.DBManager;
import exceptions.RadioException;

/*
 * TEMPORAL
 */

public class DBWrap {

	DBManager Dbm;

	public DBWrap (DBManager DBM)
	{
		Dbm = DBM;
	}

	public void crearTablaProgramas() {

		try{

			Connection c = Dbm.connect();

			String sql = "CREATE TABLE programas ( id INTEGER IDENTITY, nombre VARCHAR(256), horario VARCHAR(256), conductor VARCHAR(256), productor VARCHAR(256), auspiciante VARCHAR(256))";

			try {
				Statement s = c.createStatement();
				s.execute(sql);
			} catch (SQLException e) {
				try {
					c.rollback();
					e.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} finally {
				try {
					c.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}catch(RadioException a)
		{
			System.out.println(a); //Imprime mensaje en consola: No hay conexion
		}

	}

	public void dropTablaProgramas() {

		try
		{


			Connection c = Dbm.connect();

			String sql = "DROP TABLE programas";

			try {
				Statement s = c.createStatement();
				s.execute(sql);
				c.commit();
			} catch (SQLException e) {
				try {
					c.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} finally {
				try {
					c.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}catch(RadioException a){

			System.out.println(a); //Imprime mensaje en consola: No hay conexion
		}

	}


	public void crearTablaConductor() {

		try{

			Connection c = Dbm.connect();

			String sql = "CREATE TABLE conductores ( id INTEGER IDENTITY, nombre VARCHAR(256), sueldo FLOAT)";

			try {
				Statement s = c.createStatement();
				s.execute(sql);
			} catch (SQLException e) {
				try {
					c.rollback();
					e.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} finally {
				try {
					c.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}catch(RadioException a)
		{
			System.out.println(a); //Imprime mensaje en consola: No hay conexion
		}

	}

	public void dropTablaConductor() {

		try
		{


			Connection c = Dbm.connect();

			String sql = "DROP TABLE conductores";

			try {
				Statement s = c.createStatement();
				s.execute(sql);
				c.commit();
			} catch (SQLException e) {
				try {
					c.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} finally {
				try {
					c.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}catch(RadioException a){

			System.out.println(a); //Imprime mensaje en consola: No hay conexion
		}

	}

	public void crearTablaProductores() {

		try{

			Connection c = Dbm.connect();

			String sql = "CREATE TABLE productores ( id INTEGER IDENTITY, nombre VARCHAR(256), sueldo FLOAT)";

			try {
				Statement s = c.createStatement();
				s.execute(sql);
			} catch (SQLException e) {
				try {
					c.rollback();
					e.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} finally {
				try {
					c.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}catch(RadioException a)
		{
			System.out.println(a); //Imprime mensaje en consola: No hay conexion
		}

	}

	public void dropTablaProductores() {

		try
		{


			Connection c = Dbm.connect();

			String sql = "DROP TABLE productores";

			try {
				Statement s = c.createStatement();
				s.execute(sql);
				c.commit();
			} catch (SQLException e) {
				try {
					c.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} finally {
				try {
					c.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}catch(RadioException a){

			System.out.println(a); //Imprime mensaje en consola: No hay conexion
		}

	}

	public void crearTablaAuspiciantes() {

		try{

			Connection c = Dbm.connect();

			String sql = "CREATE TABLE auspiciantes ( id INTEGER IDENTITY, nombre VARCHAR(256), sueldo FLOAT)";

			try {
				Statement s = c.createStatement();
				s.execute(sql);
			} catch (SQLException e) {
				try {
					c.rollback();
					e.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} finally {
				try {
					c.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}catch(RadioException a)
		{
			System.out.println(a); //Imprime mensaje en consola: No hay conexion
		}

	}

	public void dropTablaAuspiciantes() {

		try
		{


			Connection c = Dbm.connect();

			String sql = "DROP TABLE auspiciantes";

			try {
				Statement s = c.createStatement();
				s.execute(sql);
				c.commit();
			} catch (SQLException e) {
				try {
					c.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} finally {
				try {
					c.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}catch(RadioException a){

			System.out.println(a); //Imprime mensaje en consola: No hay conexion
		}

	}

	public void crearTablaUsuarios() {

		try{

			Connection c = Dbm.connect();

			String sql = "CREATE TABLE usuarios ( id INTEGER IDENTITY, usuario VARCHAR(256), pass VARCHAR(256))";

			try {
				Statement s = c.createStatement();
				s.execute(sql);
			} catch (SQLException e) {
				try {
					c.rollback();
					e.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} finally {
				try {
					c.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}catch(RadioException a)
		{
			System.out.println(a); //Imprime mensaje en consola: No hay conexion
		}

	}

	public void dropTablaUsuarios() {

		try
		{


			Connection c = Dbm.connect();

			String sql = "DROP TABLE usuarios";

			try {
				Statement s = c.createStatement();
				s.execute(sql);
				c.commit();
			} catch (SQLException e) {
				try {
					c.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} finally {
				try {
					c.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}catch(RadioException a){

			System.out.println(a); //Imprime mensaje en consola: No hay conexion
		}

	}
}

