package dao;

import java.util.List;

import dbclases.Auspiciante;
import exceptions.RadioException;

public interface DBDAO {
	
	void nuevoAuspiciante(Auspiciante auspiciante) throws RadioException;
	void borrarAuspiciante(Auspiciante auspiciante) throws RadioException;
	void modificarAuspiciante(Auspiciante auspiciante) throws RadioException;
	Auspiciante mostrarAuspiciante(Auspiciante auspiciante) throws RadioException;
	List<Auspiciante> mostrarTodosAuspiciante() throws RadioException;

}

//TablaProgramas, TablaConductor, TablaAuspiciantes, TablaProductores, TablaUsuarios

