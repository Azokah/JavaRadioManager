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

public class PanelBasePrograma extends PanelBase {


	public PanelBasePrograma(MiHandler handler,PanelPrincipal pgm) {
		super(handler);
		ProgramaINIT(pgm);
	}

	private void ProgramaINIT(PanelPrincipal pgm)
	{
		panelPrincipal = pgm;
		add(panelPrincipal,BorderLayout.CENTER);
		panelFirma = new PanelFirma(handler);
		add(panelFirma,BorderLayout.SOUTH);
		panelCabecera = new PanelCabecera();
		add(panelCabecera,BorderLayout.NORTH);
		panelMenu = new PanelMPrograma(handler);
		add(panelMenu,BorderLayout.EAST);
	}
	
}
