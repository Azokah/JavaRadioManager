package paneles;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import dbclases.Auspiciante;
import dbclases.Conductor;
import dbclases.Productor;
import dbclases.Programa;
import miframe.MiHandler;
import table.MiTablePanel;
import table.PersonalTablePanel;

public abstract class PanelPrincipal extends JPanel{
	
	protected MiTablePanel tablePanel;
	
	
	public PanelPrincipal() {
		super();
		setBackground(new Color(80,80,80));
		
	}

	protected abstract MiTablePanel crearTablePanel();

}
