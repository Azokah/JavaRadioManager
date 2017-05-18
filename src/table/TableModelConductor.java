package table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import dbclases.Conductor;
import dbclases.Programa;

public class TableModelConductor extends AbstractTableModel { 
	public final static int NOMBRE = 0; // Constantes para las columnas o filas de la tabla.
	public final static int SUELDO = 1;
	
	private List<Conductor> conductor; //no usar array de dos dimensiones
	private String[] encabezados ={ "Conductor","Saldo"};

	public TableModelConductor (List<Conductor> progranas)
	{ 
		this.conductor = progranas;
	}
	
	public Conductor getEntidad(int fila)
	{
		if(fila != -1) return conductor.get(fila);
		else return null;
	}
	
	@Override
	public String getColumnName(int column) {
		return encabezados[column];
	}
	
	public Object getValueAt(int row, int col)
	{                                           
		Conductor pgm = conductor.get(row);
		
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
		return conductor.size();
	}

	@Override
	public int getColumnCount() {
		return encabezados.length;
	}
}