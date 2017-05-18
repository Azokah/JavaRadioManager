package dao;

import java.util.List;

import dbclases.Programa;
import exceptions.RadioException;

public interface ProgramaDAO {
	
	void nuevoPrograma(Programa programa) throws RadioException;
	void borrarPrograma(Programa programa) throws RadioException;
	void modificarPrograma(Programa programa) throws RadioException;
	Programa mostrarPrograma(Programa programa) throws RadioException;
	List<Programa> mostrarTodosPrograma() throws RadioException;

}
