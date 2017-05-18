package paneles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;

import constantes.Constantes;
import miframe.MiHandler;
import miframe.UIHelper;

public class PanelMPrograma extends PanelMenu implements Constantes{

	private MiHandler handler;
	
	public PanelMPrograma(MiHandler handler) {
		super();
		this.handler = handler;
		setAlignmentX(CENTER_ALIGNMENT);
		setAlignmentY(CENTER_ALIGNMENT);
		add(UIHelper.getInstance().botonNuevo("Agregar Programa",new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//evento
				handler.cambiarPanel(AGREGAR_PROGRAMA);
			}
		}));
		add(UIHelper.getInstance().botonNuevo("Editar Programa",new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//evento
				handler.cambiarPanel(EDITAR_PROGRAMA);
			}
		}));
		add(UIHelper.getInstance().botonNuevo("Eliminar Programa",new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//evento
				handler.cambiarPanel(BORRAR_PROGRAMA);
			}
		}));
		add(Box.createVerticalGlue());
		add(Box.createHorizontalGlue());
		//add(UIHelper.getInstance().cargarImagen("GNRLogo100.png"));
	}

}
