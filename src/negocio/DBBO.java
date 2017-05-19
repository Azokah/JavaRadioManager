package negocio;

import dao.AuspicianteDAO;
import dao.DBDAO;
import exceptions.RadioException;

public class DBBO {
	private DBDAO dbDao;
	
	public void setDBDAO(DBDAO dbDAO) {
		this.dbDao = dbDAO;
	}
	
	public void crearTablaProgramas() throws RadioException{
		dbDao.crearTablaProgramas();};
	public void crearTablaConductor() throws RadioException{
		dbDao.crearTablaConductor();
	};
	public void crearTablaAuspiciantes() throws RadioException{
		dbDao.crearTablaAuspiciantes();
	};
	public void crearTablaProductores() throws RadioException{
		dbDao.crearTablaProductores();
	};
	public void crearTablaUsuarios() throws RadioException{
		dbDao.crearTablaUsuarios();
	};
	
	public void dropTablaProgramas() throws RadioException{
		dbDao.dropTablaProgramas();
	};
	public void dropTablaConductor() throws RadioException{
		dbDao.dropTablaConductor();
	};
	public void dropTablaAuspiciantes() throws RadioException{
		dbDao.dropTablaAuspiciantes();
	};
	public void dropTablaProductores() throws RadioException{
		dbDao.dropTablaProductores();
	};
	public void dropTablaUsuarios() throws RadioException{
		dbDao.dropTablaUsuarios();
	};
	
}
