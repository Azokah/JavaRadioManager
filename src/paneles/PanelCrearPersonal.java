package paneles;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dbclases.Conductor;
import dbclases.Programa;
import miframe.MiHandler;
import miframe.UIHelper;

public class PanelCrearPersonal extends JPanel {

	JTextField nombreJTF;
	 JTextField sueldoJTF;
	private MiHandler handler;
	
	public PanelCrearPersonal(MiHandler handler) {
		super();
		this.handler = handler;
		nombreJTF = new JTextField();
		sueldoJTF = new JTextField();
		setBackground(new Color(80,80,80));
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		add(UIHelper.getInstance().labelNuevo("Crear Personal",100,255,200));
		add(UIHelper.getInstance().labelNuevo("Nombre: ",255,255,255));
		add(nombreJTF);
		add(UIHelper.getInstance().labelNuevo(" "));
		add(UIHelper.getInstance().labelNuevo("Saldo: ",255,255,255));
		add(sueldoJTF);
		add(UIHelper.getInstance().labelNuevo(" "));
		
	}
}
