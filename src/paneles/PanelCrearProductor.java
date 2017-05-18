package paneles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dbclases.Auspiciante;
import dbclases.Conductor;
import dbclases.Productor;
import miframe.MiHandler;
import miframe.UIHelper;

public class PanelCrearProductor extends PanelCrearPersonal{

	public PanelCrearProductor(MiHandler handler) {
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
					Productor pro = new Productor(nombreJTF.getText(),Float.parseFloat(sueldoJTF.getText()));
					handler.agregarProductor(pro);
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
