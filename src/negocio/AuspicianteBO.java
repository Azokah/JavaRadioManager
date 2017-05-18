package negocio;

import java.util.List;

import dao.AuspicianteDAO;
import dbclases.Auspiciante;
import dbclases.Productor;
import exceptions.RadioException;

public class AuspicianteBO {

	private AuspicianteDAO auspicianteDAO;


	public boolean agregarAuspiciante(Auspiciante aus) throws RadioException
	{
		boolean yaExiste = false;

		for(Auspiciante ausp : auspicianteDAO.mostrarTodosAuspiciante())
		{
			if(ausp.getNombre().equals(aus.getNombre()))
			{
				yaExiste = true;
			}
		}
		if(!yaExiste) auspicianteDAO.nuevoAuspiciante(aus);
		return yaExiste;
	};
	public void editarAuspiciante(Auspiciante aus) throws RadioException
	{
		//no hay validaciones posibles para la edicion.
		//Al conseguir los datos desde la tabla, estos siempre van a ser correctos y siempre van a existir.
		auspicianteDAO.modificarAuspiciante(aus);
	};
	public void eliminarAuspiciante(Auspiciante aus) throws RadioException
	{
		//no hay validaciones posibles para la eliminacion.
		//Al conseguir los datos desde la tabla, estos siempre van a ser correctos y siempre van a existir.
		auspicianteDAO.borrarAuspiciante(aus);
	};

	public List<Auspiciante> mostrarDatos() throws RadioException
	{
		return auspicianteDAO.mostrarTodosAuspiciante();
	}

	public void setAuspicianteDAO(AuspicianteDAO auspicianteDAO) {
		this.auspicianteDAO = auspicianteDAO;
	}
}
