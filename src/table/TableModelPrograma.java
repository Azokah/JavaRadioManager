package table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import dbclases.Programa;

public class TableModelPrograma extends AbstractTableModel { 
	public final static int NOMBRE = 0; // Constantes para las columnas o filas de la tabla.
	public final static int HORARIO = 1;
	public final static int CONDUCTOR = 2;
	public final static int PRODUCTOR = 3;
	public final static int AUSPICIANTE = 4;
	
	private List<Programa> programas; //no usar array de dos dimensiones
	private String[] encabezados ={ "Programa","Horario","Conductor","Productor","Auspiciante"};

	public TableModelPrograma (List<Programa> progranas)
	{ 
		this.programas = progranas;
	}

	public Programa getEntidad(int fila)
	{
		if(fila != -1) return programas.get(fila);
		else return null;
	}
	
	@Override
	public String getColumnName(int column) {
		return encabezados[column];
	}
	
	public Object getValueAt(int row, int col)
	{                                           
		Programa pgm = programas.get(row);
		
		switch(col)
		{
			case NOMBRE:
				return pgm.getNombre();
				
			case HORARIO:
				return pgm.getHorario();
				
			case CONDUCTOR:
				return pgm.getConductor();
				
			case PRODUCTOR:
				return pgm.getProductor();
			case AUSPICIANTE:
				return pgm.getAuspiciante();
		}
		
		return null;
	}
	
	@Override
	public int getRowCount() {
		return programas.size();
	}

	@Override
	public int getColumnCount() {
		return encabezados.length;
	}
}