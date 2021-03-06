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

public class PanelBaseBalanceEstandar extends PanelBase {


	public PanelBaseBalanceEstandar(MiHandler handler) {
		super(handler);
		MenuBalanceINIT();
	}

	private void MenuBalanceINIT()
	{
		panelPrincipal = new PanelPrincipalBalance(handler);
		add(panelPrincipal,BorderLayout.CENTER);
		panelFirma = new PanelFirma(handler);
		add(panelFirma,BorderLayout.SOUTH);
		panelCabecera = new PanelCabecera();
		add(panelCabecera,BorderLayout.NORTH);
		panelMenu = new PanelMBalance(handler);
		add(panelMenu,BorderLayout.EAST);
	}
	
}
