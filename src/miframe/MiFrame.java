package miframe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dbclases.Auspiciante;
import dbclases.Conductor;
import dbclases.Productor;
import dbclases.Programa;
import paneles.PanelBase;
import paneles.PanelBaseFull;

public class MiFrame extends JFrame {
	
	private MiHandler handler;
	private PanelBase pB;

	public MiFrame(String titulo, MiHandler handler) {
		super(titulo);
		this.handler = handler;
		initUI(titulo);
		
	}
	
	private void initUI(String titulo) {
		pB = new PanelBaseFull(handler);
		getContentPane().add(pB);
		setSize(625, 525);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void cambiarPanel(PanelBase panel){ 
		 
		pB = panel;
		getContentPane().removeAll();
		getContentPane().add(pB); 
		getContentPane().validate(); 
	}
	
	public Auspiciante getAuspicianteSelec()
	{
		return pB.getAuspicianteSelec();
	}
	
	public Productor getProductorSelec()
	{
		return pB.getProductorSelec();
	}
	
	public Conductor getConductorSelec()
	{
		return pB.getConductorSelec();
	}
	
	public Programa getProgramaSelec()
	{
		return pB.getProgramaSelec();
	}
}
