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

public class PanelBaseFull extends PanelBase {


	public PanelBaseFull(MiHandler handler) {
		super(handler);
		FullInit();
	}

	private void FullInit()
	{
		panelPrincipal = new PanelPrincipalPrograma(handler);
		add(panelPrincipal,BorderLayout.CENTER);
		panelFirma = new PanelFirma(handler);
		add(panelFirma,BorderLayout.SOUTH);
		panelCabecera = new PanelCabecera();
		add(panelCabecera,BorderLayout.NORTH);
		panelMenu = new PanelMPrograma(handler);
		add(panelMenu,BorderLayout.EAST);
	}
	
}
