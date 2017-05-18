package paneles;

import dbclases.Programa;
import miframe.MiHandler;
import table.MiTablePanel;
import table.ProgramaTablePanel;

public class PanelPrincipalPrograma extends PanelPrincipal{
	
	private MiHandler handler;
	
	public PanelPrincipalPrograma(MiHandler handler)
	{
		super();
		this.handler = handler;
		tablePanel = crearTablePanel();
		add(tablePanel);
	}
	
	@Override
	protected MiTablePanel crearTablePanel() {
		return new ProgramaTablePanel(handler.mostrarDatos());
	}
	
	public Programa getProgramaSelec()
	{
		return ((ProgramaTablePanel) tablePanel).getEntidadFilaPrograma();
		
	}
}
