package paneles;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import miframe.UIHelper;

public class PanelMenu extends JPanel{
	
	public PanelMenu() {
		super();
		this.setBackground(new Color(125, 125, 125));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}

}
