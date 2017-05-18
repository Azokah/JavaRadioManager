package login;

import java.util.List;

import dbclases.Auspiciante;
import exceptions.RadioException;

public interface UsuarioDAO {
	
	void nuevoUsuario(Usuario usuario) throws RadioException;
	void borrarUsuario(Usuario usuario) throws RadioException;
	Boolean buscarUsuario(Usuario usuario) throws RadioException;
}
