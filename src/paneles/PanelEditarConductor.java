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

public class PanelEditarConductor extends JPanel {

	private JTextField nombreJTF;
	private JTextField saldoJTF;
	private MiHandler handler;
	
	public PanelEditarConductor(MiHandler handler,String nombreProgramaAEditar) {
		
		nombreJTF = new JTextField();
		nombreJTF.setText(nombreProgramaAEditar);
		nombreJTF.setEditable(false);
		saldoJTF = new JTextField();
		
		setBackground(new Color(80,80,80));
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		add(UIHelper.getInstance().labelNuevo("Modificar Conductor",100,255,200));
		add(UIHelper.getInstance().labelNuevo(" "));
		add(UIHelper.getInstance().labelNuevo("Nombre del Conductor a modificar: ",255,255,255));
		add(UIHelper.getInstance().labelNuevo(" "));
		add(nombreJTF);
		add(UIHelper.getInstance().labelNuevo(" "));
		add(UIHelper.getInstance().labelNuevo("Re escriba los nuevos datos: ",255,200,200));
		add(UIHelper.getInstance().labelNuevo("Saldo: ",255,255,255));
		add(saldoJTF);
		add(UIHelper.getInstance().botonNuevo("Aceptar",new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//evento

				if(
						nombreJTF.getText().isEmpty() ||
						saldoJTF.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"Ningun campo puede estar vacio","Error de campo",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					Conductor con = new Conductor(nombreJTF.getText(),Float.parseFloat(saldoJTF.getText()));
					handler.editarConductor(con);
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
