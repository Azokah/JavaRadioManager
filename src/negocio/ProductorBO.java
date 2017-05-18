package negocio;

import java.util.List;

import dao.ProductorDAO;
import dbclases.Productor;
import exceptions.RadioException;

public class ProductorBO {

	private ProductorDAO productorDAO;
	
	
	public boolean agregarProductor(Productor pro) throws RadioException
	{
		boolean yaExiste = false;
		
		for(Productor prod : productorDAO.mostrarTodosProductor())
		{
			if(prod.getNombre().equals(pro.getNombre()))
			{
				yaExiste = true;
			}
		}
		if(!yaExiste) productorDAO.nuevoProductor(pro);
		return yaExiste;
	};
	public void editarProductor(Productor pro) throws RadioException
	{
		//no hay validaciones posibles para la edicion.
		//Al conseguir los datos desde la tabla, estos siempre van a ser correctos y siempre van a existir.
		productorDAO.modificarProductor(pro);
	};
	public void eliminarProductor(Productor pro) throws RadioException
	{
		//no hay validaciones posibles para la eliminacion.
		//Al conseguir los datos desde la tabla, estos siempre van a ser correctos y siempre van a existir.
		productorDAO.borrarProductor(pro);
	};
	
	public List<Productor> mostrarDatos() throws RadioException
	{
		return productorDAO.mostrarTodosProductor();
	}
	
	public void setProductorDAO(ProductorDAO productorDAO) {
		this.productorDAO = productorDAO;
	}
}
