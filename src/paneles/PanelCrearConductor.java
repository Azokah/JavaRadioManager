package paneles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dbclases.Conductor;
import miframe.MiHandler;
import miframe.UIHelper;

public class PanelCrearConductor extends PanelCrearPersonal{

	public PanelCrearConductor(MiHandler handler) {
		// TODO Auto-generated constructor stub
		super(handler);
		add(UIHelper.getInstance().botonNuevo("Aceptar",new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//evento
				if(
						nombreJTF.getText().isEmpty() ||
						sueldoJTF.getText().isEmpty() )
				{
					JOptionPane.showMessageDialog(null,"Ningun campo puede estar vacio","Error de campo",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					Conductor con = new Conductor(nombreJTF.getText(),Float.parseFloat(sueldoJTF.getText()));
					handler.agregarConductor(con);
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
