package negocio;

import java.util.List;

import dao.ConductorDAO;
import dbclases.Conductor;
import exceptions.RadioException;

public class ConductorBO {

	private ConductorDAO conductorDAO;


	public boolean agregarConductor(Conductor con) throws RadioException
	{
		boolean yaExiste = false;
		for(Conductor cond : conductorDAO.mostrarTodosConductor())
		{
			if(cond.getNombre().equals(con.getNombre()))
			{
				yaExiste = true;
			}
		}
		if(!yaExiste)conductorDAO.nuevoConductor(con);
		return yaExiste;
	};
	public void editarConductor(Conductor con) throws RadioException
	{
		//no hay validaciones posibles para la edicion.
				//Al conseguir los datos desde la tabla, estos siempre van a ser correctos y siempre van a existir.
		conductorDAO.modificarConductor(con);
	};
	public void eliminarConductor(Conductor con) throws RadioException
	{
		//no hay validaciones posibles para la eliminacion.
				//Al conseguir los datos desde la tabla, estos siempre van a ser correctos y siempre van a existir.
		conductorDAO.borrarConductor(con);
	};

	public List<Conductor> mostrarDatos() throws RadioException
	{
		return conductorDAO.mostrarTodosConductor();
	}

	public void setConductorDAO(ConductorDAO conductorDAO) {
		this.conductorDAO = conductorDAO;
	}
}
