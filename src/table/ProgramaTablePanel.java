package table;

import java.awt.Color;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import dbclases.Programa;

public class ProgramaTablePanel extends MiTablePanel {
	
	public ProgramaTablePanel(List<Programa> lista)
	{
		super();
		programasTabla(lista);
	}
	
	private void programasTabla(List<Programa> lista)
	{
		removeAll();
		jTable = new JTable(new TableModelPrograma(lista));
		scrollPane = new JScrollPane(jTable);
		add(scrollPane);
	}
	
	public Programa getEntidadFilaPrograma()
	{
		return ((TableModelPrograma) jTable.getModel()).getEntidad(jTable.getSelectedRow());
	}
}
