package paneles;

import java.awt.GridLayout;

import dbclases.Auspiciante;
import dbclases.Conductor;
import dbclases.Productor;
import miframe.MiHandler;
import table.MiTablePanel;
import table.PersonalTablePanel;

public class PanelPrincipalPersonal extends PanelPrincipal{
	
	private MiHandler handler;
	
	public PanelPrincipalPersonal(MiHandler handler)
	{
		super();
		this.handler = handler;
		setLayout(new GridLayout(1,3));
		tablePanel = crearTablePanel();
		add(tablePanel);
		
	}
	
	@Override
	protected MiTablePanel crearTablePanel() {
		return new PersonalTablePanel(handler.mostrarConductores(),handler.mostrarProductores(),handler.mostrarAuspiciantes());
	}

	public Auspiciante getAuspicianteSelec()
	{
		return ((PersonalTablePanel) tablePanel).getEntidadFilaAuspiciante();
	}
	
	public Productor getProductorSelec()
	{
		return((PersonalTablePanel) tablePanel).getEntidadFilaProductor();
	}
	
	public Conductor getConductorSelec()
	{
		return ((PersonalTablePanel) tablePanel).getEntidadFilaConductor();
	}
	
}
