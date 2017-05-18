package paneles;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dbclases.Programa;
import miframe.MiHandler;
import miframe.UIHelper;

public class PanelBorrarPrograma extends JPanel {

	private JTextField nombreJTF;
	private MiHandler handler;
	
	public PanelBorrarPrograma(MiHandler handler, String nombre) {
		super();
		this.handler = handler;
		nombreJTF = new JTextField();
		nombreJTF.setText(nombre);
		nombreJTF.setEditable(false);
		setBackground(new Color(80,80,80));
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		add(UIHelper.getInstance().labelNuevo("Borrar Programas",100,255,200));
		add(UIHelper.getInstance().labelNuevo("Nombre del programa: ",255,255,255));
		add(UIHelper.getInstance().labelNuevo(" "));
		add(nombreJTF);
		add(UIHelper.getInstance().labelNuevo(" "));
		add(UIHelper.getInstance().botonNuevo("Aceptar",new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//evento
				if( nombreJTF.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"El campo no puede estar vacio","Error de campo",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					Programa pgm = new Programa(nombreJTF.getText()," "," "," "," ");
					handler.eliminarProgramas(pgm);
					handler.cambiarPanelVolver();
				}
			}
		}));
		add(UIHelper.getInstance().botonNuevo("Cancelar",new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//evento
				handler.cambiarPanelVolver();

			}
		}));
	}

}