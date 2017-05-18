package paneles;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dbclases.Productor;
import dbclases.Programa;
import miframe.MiHandler;
import miframe.UIHelper;

public class PanelEliminarProductor extends JPanel {

	private JTextField nombreJTF;
	private MiHandler handler;
	
	public PanelEliminarProductor(MiHandler handler,String nombreProgramaAEditar) {
		
		nombreJTF = new JTextField();
		nombreJTF.setText(nombreProgramaAEditar);
		nombreJTF.setEditable(false);
		
		setBackground(new Color(80,80,80));
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		add(UIHelper.getInstance().labelNuevo("Eliminar Productor",100,255,200));
		add(UIHelper.getInstance().labelNuevo(" "));
		add(UIHelper.getInstance().labelNuevo("Nombre del Productor a eliminar: ",255,255,255));
		add(UIHelper.getInstance().labelNuevo(" "));
		add(nombreJTF);
		add(UIHelper.getInstance().botonNuevo("Aceptar",new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//evento

				if(nombreJTF.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"Ningun campo puede estar vacio","Error de campo",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					Productor pro = new Productor(nombreJTF.getText(),0);
					handler.eliminarProductor(pro);
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
