package paneles;

import java.awt.Color;

import javax.swing.JPanel;

import miframe.UIHelper;

public class PanelCabecera extends JPanel {

	public PanelCabecera() {
		super();
		add(UIHelper.getInstance().labelNuevo("Galaxy News Radio (GNR)",100,255,200));
		this.setBackground(new Color(80, 80, 80));
	}

}
