package table;

import java.util.List;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.ScrollPane;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import dbclases.Auspiciante;
import dbclases.Balance;
import dbclases.Conductor;
import dbclases.Productor;
import dbclases.Programa;

public  class MiTablePanel extends JPanel {
	protected JTable jTable;
	protected JScrollPane scrollPane;
	
	public MiTablePanel (){
		setBackground(new Color(80,80,80));
	}
	
}
