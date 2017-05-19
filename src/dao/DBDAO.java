package dao;

import java.util.List;

import dbclases.Auspiciante;
import exceptions.RadioException;

public interface DBDAO {
	
	void crearTablaProgramas() throws RadioException;
	void crearTablaConductor() throws RadioException;
	void crearTablaAuspiciantes() throws RadioException;
	void crearTablaProductores() throws RadioException;
	void crearTablaUsuarios() throws RadioException;
	
	void dropTablaProgramas() throws RadioException;
	void dropTablaConductor() throws RadioException;
	void dropTablaAuspiciantes() throws RadioException;
	void dropTablaProductores() throws RadioException;
	void dropTablaUsuarios() throws RadioException;
	
	
}

//TablaProgramas, TablaConductor, TablaAuspiciantes, TablaProductores, TablaUsuarios

