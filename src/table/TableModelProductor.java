package table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import dbclases.Productor;
import dbclases.Programa;

public class TableModelProductor extends AbstractTableModel { 
	public final static int NOMBRE = 0; // Constantes para las columnas o filas de la tabla.
	public final static int SUELDO = 1;
	
	private List<Productor> productor; //no usar array de dos dimensiones
	private String[] encabezados ={ "Productor","Saldo"};

	public TableModelProductor (List<Productor> productor)
	{ 
		this.productor = productor;
	}
	
	public Productor getEntidad(int fila)
	{
		if(fila != -1) return productor.get(fila);
		else return null;
	}
	
	@Override
	public String getColumnName(int column) {
		return encabezados[column];
	}
	
	public Object getValueAt(int row, int col)
	{                                           
		Productor pgm = productor.get(row);
		
		switch(col)
		{
			case NOMBRE:
				return pgm.getNombre();
				
			case SUELDO:
				return pgm.getSueldo();
		}
		
		return null;
	}
	
	@Override
	public int getRowCount() {
		return productor.size();
	}

	@Override
	public int getColumnCount() {
		return encabezados.length;
	}
}