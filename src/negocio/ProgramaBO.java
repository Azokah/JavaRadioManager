package negocio;

import java.util.List;

import javax.swing.JOptionPane;

import dao.ProgramaDAO;
import dbclases.Programa;
import exceptions.RadioException;

public class ProgramaBO {

	private ProgramaDAO programasDAO;


	public boolean agregarProgramas(Programa pgm) throws RadioException
	{
		boolean yaExiste = false;
		for(Programa prog : programasDAO.mostrarTodosPrograma())
		{
			if(prog.getNombre().equals(pgm.getNombre()))
			{
				yaExiste = true;
			}
		}
		if(!yaExiste) programasDAO.nuevoPrograma(pgm);
		return yaExiste;
	};
	public void editarProgramas(Programa pgm) throws RadioException
	{
		//No hay validaciones posibles a la hora de editar.
		programasDAO.modificarPrograma(pgm);
	};
	public void eliminarProgramas(Programa pgm) throws RadioException
	{
		//no hay validaciones posibles a la hora de eliminar
		//
		programasDAO.borrarPrograma(pgm);
	};

	public List<Programa> mostrarDatos() throws RadioException
	{
		return programasDAO.mostrarTodosPrograma();
	}

	public void setProgramasDAO(ProgramaDAO programasDAO) {
		this.programasDAO = programasDAO;
	}
}
