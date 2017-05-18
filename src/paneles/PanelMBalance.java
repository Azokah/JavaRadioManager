package paneles;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JLabel;

import miframe.MiHandler;
import miframe.UIHelper;

public class PanelMBalance extends PanelMenu {

	private MiHandler handler;
	public PanelMBalance(MiHandler handler) {
		super();
		this.handler = handler;
		setAlignmentX(CENTER_ALIGNMENT);
		setAlignmentY(CENTER_ALIGNMENT);
		JLabel label = new JLabel();
		label.setText("<html><span style='font-size:14px'>Balance Mensual</span></html>");
		label.setForeground(new Color(100,255,200));
		label.setBackground(new Color(80,80,80));
		add(label);
		add(Box.createVerticalGlue());
		add(Box.createHorizontalGlue());
		//add(UIHelper.getInstance().cargarImagen("GNRLogo100.png"));
	}

}
