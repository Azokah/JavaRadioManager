package table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import dbclases.Auspiciante;
import dbclases.Productor;
import dbclases.Programa;

public class TableModelAuspiciante extends AbstractTableModel { 
	public final static int NOMBRE = 0; // Constantes para las columnas o filas de la tabla.
	public final static int SUELDO = 1;
	
	private List<Auspiciante> auspiciante; //no usar array de dos dimensiones
	private String[] encabezados ={ "Auspiciante","Saldo"};

	public TableModelAuspiciante (List<Auspiciante> auspiciante)
	{ 
		this.auspiciante = auspiciante;
	}
	
	public Auspiciante getEntidad(int fila)
	{
		if(fila != -1) return auspiciante.get(fila);
		else return (new Auspiciante("Seleccione un Auspiciante.",0));//QUICKFIX 26/05/17
		//else return null;
	}
	
	@Override
	public String getColumnName(int column) {
		return encabezados[column];
	}
	
	public Object getValueAt(int row, int col)
	{                                           
		Auspiciante pgm = auspiciante.get(row);
		
		switch(col)
		{
			case NOMBRE:
				return pgm.getNombre();
				
			case SUELDO:
				return pgm.getSaldo();
		}
		
		return null;
	}
	
	@Override
	public int getRowCount() {
		return auspiciante.size();
	}

	@Override
	public int getColumnCount() {
		return encabezados.length;
	}
}