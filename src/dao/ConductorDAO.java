package dao;

import java.util.List;

import dbclases.Conductor;
import exceptions.RadioException;

public interface ConductorDAO {
	
	void nuevoConductor(Conductor conductor) throws RadioException;
	void borrarConductor(Conductor conductor) throws RadioException;
	void modificarConductor(Conductor conductor) throws RadioException;
	Conductor mostrarConductor(Conductor conductor) throws RadioException;
	List<Conductor> mostrarTodosConductor() throws RadioException;

}
