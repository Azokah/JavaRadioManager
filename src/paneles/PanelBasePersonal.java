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

public class PanelBasePersonal extends PanelBase {


	public PanelBasePersonal(MiHandler handler,PanelPrincipal per) {
		super(handler);
		PersonalINIT(per);
	}

	private void PersonalINIT(PanelPrincipal per)
	{
		panelPrincipal = per;
		add(panelPrincipal,BorderLayout.CENTER);
		panelFirma = new PanelFirma(handler);
		add(panelFirma,BorderLayout.SOUTH);
		panelCabecera = new PanelCabecera();
		add(panelCabecera,BorderLayout.NORTH);
		panelMenu = new PanelMPersonal(handler);
		add(panelMenu,BorderLayout.EAST);
	}
	
}
