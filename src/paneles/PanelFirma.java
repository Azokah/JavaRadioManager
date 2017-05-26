package paneles;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import constantes.Constantes;
import miframe.MiHandler;
import miframe.UIHelper;

public class PanelFirma extends JPanel implements Constantes{

	MiHandler handler;
	
	public PanelFirma(MiHandler handler) {
		super();
		this.handler = handler;
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.setBackground(new Color(80,80,80));
		add(UIHelper.getInstance().botonNuevo("Programas",new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//evento
				handler.cambiarPanelMenu(PROGRAMA);
			}
		}));
		add(UIHelper.getInstance().botonNuevo("Personal",new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//evento
				handler.cambiarPanelMenu(AUSPICIANTE);
			}
		}));
		add(UIHelper.getInstance().botonNuevo("Balance",new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//evento
				handler.cambiarPanelMenu(BALANCE);
			}
		}));
		add(Box.createHorizontalGlue());
		add(UIHelper.getInstance().botonNuevo("Acerca de",new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//evento
				JOptionPane.showMessageDialog(null, "Creado por Jaime Gonzalez Bonorino.\n Trabajo Practico de Laboratorio 1.\n 23/05/2017", "Sistema de Radio.", JOptionPane.INFORMATION_MESSAGE,UIHelper.getInstance().cargarIcono("Fo4_GNN_logo2.png"));
			}
		}));
		add(UIHelper.getInstance().botonNuevo("Salir",new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//evento
				int respuesta = JOptionPane.showConfirmDialog(null, "Sus cambios se guardaran automaticamente.", "Seguro desea salir?", JOptionPane.YES_NO_OPTION);
				if (respuesta == JOptionPane.YES_OPTION) {
					handler.salir();
				}
			}
		}));
	}
}