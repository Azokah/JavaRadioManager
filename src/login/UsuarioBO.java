package login;

import java.util.List;

import dao.AuspicianteDAO;
import dbclases.Auspiciante;
import exceptions.RadioException;

public class UsuarioBO {

	private UsuarioDAO usuarioDAO;
	
	public void setUsuarioDAO(UsuarioDAO usrDao)
	{
		usuarioDAO = usrDao;
	}
	public void nuevoUsuario(Usuario usr) throws RadioException
	{
		usuarioDAO.nuevoUsuario(usr);
	}
	public Boolean buscarUsuario(Usuario usuario) throws RadioException
	{
		
		return usuarioDAO.buscarUsuario(usuario);
	}
}
