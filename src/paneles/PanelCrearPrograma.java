package paneles;

import java.awt.Color;
import java.awt.Component;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dbclases.Auspiciante;
import dbclases.Conductor;
import dbclases.Productor;
import dbclases.Programa;
import miframe.MiHandler;
import miframe.UIHelper;

public class PanelCrearPrograma extends JPanel {

	private JTextField programaJTF;
	private JTextField horaJTF;
	private JComboBox conductorJCB;
	private JComboBox productorJCB;
	private JComboBox auspicianteJCB;
	private MiHandler handler;
	private String[] nombrePro;
	private String[] nombreCon;
	private String[] nombreAus;
	
	private void listaProToString(List<Productor> p)
	{
		int i = 0;
		nombrePro = new String[p.size()];
		for (Productor pro : p) 
		{
		    nombrePro[i] = pro.getNombre();
		    i++;
		}
	}
	private void listaConToString(List<Conductor> p)
	{
		int i = 0;
		nombreCon = new String[p.size()];
		for (Conductor pro : p) 
		{
			nombreCon[i] = pro.getNombre();
		    i++;
		}
	}
	private void listaAusToString(List<Auspiciante> p)
	{
		int i = 0;
		nombreAus = new String[p.size()];
		for (Auspiciante pro : p) 
		{
			nombreAus[i] = pro.getNombre();
		    i++;
		}
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PanelCrearPrograma(MiHandler handler) {
		super();
		this.handler = handler;
		programaJTF = new JTextField();
		horaJTF = new JTextField();
		listaProToString(handler.mostrarProductores());
		productorJCB = new JComboBox(nombrePro);
		listaAusToString(handler.mostrarAuspiciantes());
		auspicianteJCB  = new JComboBox(nombreAus);
		listaConToString(handler.mostrarConductores());
		conductorJCB = new JComboBox(nombreCon);
		
		setBackground(new Color(80,80,80));
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		add(UIHelper.getInstance().labelNuevo("Crear Programa",100,255,200));
		add(UIHelper.getInstance().labelNuevo("Nombre programa: ",255,255,255));
		add(programaJTF);
		add(UIHelper.getInstance().labelNuevo(" "));
		add(UIHelper.getInstance().labelNuevo("Horario: ",255,255,255));
		add(horaJTF);
		add(UIHelper.getInstance().labelNuevo(" "));
		add(UIHelper.getInstance().labelNuevo("Conductor: ",255,255,255));
		add(conductorJCB);
		add(UIHelper.getInstance().labelNuevo(" "));
		add(UIHelper.getInstance().labelNuevo("Productor: ", 255,255,255));
		add(productorJCB);
		add(UIHelper.getInstance().labelNuevo(" "));
		add(UIHelper.getInstance().labelNuevo("Auspiciante: ", 255,255,255));
		add(auspicianteJCB);
		add(UIHelper.getInstance().labelNuevo(" "));
		add(UIHelper.getInstance().botonNuevo("Aceptar",new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//evento
				if(
						programaJTF.getText().isEmpty() ||
						horaJTF.getText().isEmpty() ||
						conductorJCB.getSelectedItem() == null ||
						productorJCB.getSelectedItem() == null ||
						auspicianteJCB.getSelectedItem() == null)
				{
					JOptionPane.showMessageDialog(null,"Ningun campo puede estar vacio","Error de campo",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					Programa pgm = new Programa(programaJTF.getText(),
							horaJTF.getText(),
							((String) conductorJCB.getSelectedItem()),
							((String) productorJCB.getSelectedItem()),
							((String) auspicianteJCB.getSelectedItem()));
					handler.agregarProgramas(pgm);
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