package dao;

import java.util.List;

import dbclases.Productor;
import exceptions.RadioException;

public interface ProductorDAO {
	
	void nuevoProductor(Productor productor) throws RadioException;
	void borrarProductor(Productor productor) throws RadioException;
	void modificarProductor(Productor productor) throws RadioException;
	Productor mostrarProductor(Productor productor) throws RadioException;
	List<Productor> mostrarTodosProductor() throws RadioException;

}
