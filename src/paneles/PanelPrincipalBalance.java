package paneles;

import java.awt.GridLayout;

import miframe.MiHandler;
import table.BalanceTablePanel;
import table.MiTablePanel;
import table.PersonalTablePanel;
import table.ProgramaTablePanel;

public class PanelPrincipalBalance extends PanelPrincipal{
	
	private MiHandler handler;
	
	public PanelPrincipalBalance(MiHandler handler) {
		super();
		this.handler = handler;
		tablePanel = crearTablePanel();
		add(tablePanel);
	}
	
	@Override
	protected MiTablePanel crearTablePanel() {
		return new BalanceTablePanel(handler.generarBalance());
	}


}
