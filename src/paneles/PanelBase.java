package paneles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;

import javax.swing.JPanel;

import dbclases.Auspiciante;
import dbclases.Conductor;
import dbclases.Productor;
import dbclases.Programa;
import miframe.MiHandler;
import miframe.UIHelper;
import table.PersonalTablePanel;

public abstract class PanelBase extends JPanel {

	protected PanelPrincipal panelPrincipal;
	protected PanelFirma panelFirma;
	protected PanelMenu panelMenu;
	protected PanelCabecera panelCabecera;
	protected MiHandler handler;

	public PanelBase(MiHandler handler) {
		super();
		this.handler = handler;
		setLayout(new BorderLayout());
		setBackground(new Color(255,255,125));

	}
	
	public Programa getProgramaSelec()
	{
		return ((PanelPrincipalPrograma) panelPrincipal).getProgramaSelec();
	}
	
	public Auspiciante getAuspicianteSelec()
	{
		return ((PanelPrincipalPersonal) panelPrincipal).getAuspicianteSelec();
	}
	
	public Productor getProductorSelec()
	{
		return ((PanelPrincipalPersonal) panelPrincipal).getProductorSelec();
	}
	
	public Conductor getConductorSelec()
	{
		return ((PanelPrincipalPersonal) panelPrincipal).getConductorSelec();
	}
	
}
