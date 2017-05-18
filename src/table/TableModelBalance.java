package table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import dbclases.Auspiciante;
import dbclases.Balance;
import dbclases.Programa;

public class TableModelBalance extends AbstractTableModel { 
	public final static int NOMBRE = 0; // Constantes para las columnas o filas de la tabla.
	public final static int TIPO = 1;
	public final static int SALDO = 2;
	public final static int ESPACIO = 3;
	public final static int TOTAL = 4;
	
	private List<Balance> balance; //no usar array de dos dimensiones
	private String[] encabezados ={ "Nombre","Tipo","Saldo"," ","TOTAL"};
	
	private float total;

	public TableModelBalance (List<Balance> lista)
	{ 
		this.balance = lista;
		setTotal();
	}
	
	
	
	private void setTotal()
	{
		total = 0;
		for (Balance bln : balance) 
		{
			if(bln.getTipo().equals("Auspiciante"))
			{
				total += bln.getSaldo();
			}
			else total -= bln.getSaldo();
		}
	}

	@Override
	public String getColumnName(int column) {
		return encabezados[column];
	}
	
	public Object getValueAt(int row, int col)
	{   
		Balance blnc = new Balance("","",0);
		if(!(row == balance.size()))
			{
				blnc = balance.get(row);
			}
		
		switch(col)
		{
			case NOMBRE:
				if(row == balance.size()) return " ";
				else return blnc.getNombre();
				
			case TIPO:
				if(row == balance.size()) return " ";
				else return blnc.getTipo();
				
			case SALDO:
				if(row == balance.size()) return " ";
				else return blnc.getSaldo();
				
			case ESPACIO:
				return " ";
				
			case TOTAL:
				if(row == balance.size()) return total;
				else return " ";
		}
		
		return null;
	}
	
	@Override
	public int getRowCount() {
		return balance.size()+1;
	}

	@Override
	public int getColumnCount() {
		return encabezados.length;
	}
}