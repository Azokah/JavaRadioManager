package table;

import java.awt.Color;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import dbclases.Balance;

public class BalanceTablePanel extends MiTablePanel{

	public BalanceTablePanel(List<Balance> lista)
	{
		super();
		balanceTabla(lista);
	}
	public void balanceTabla(List<Balance> lista)
	{
		removeAll();
		jTable = new JTable(new TableModelBalance(lista));
		scrollPane = new JScrollPane(jTable);
		add(scrollPane);
		
	}
	
//	getBalance() {
//		int row = jTable.getSelectedRow();
//		if(row != -1) {
//			handler.modificarBalance((((TableModelBalance)jTable.getModel()).getBalance(row) )
//		}
//	}
}
