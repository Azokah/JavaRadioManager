package paneles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;

import constantes.Constantes;
import miframe.MiHandler;
import miframe.UIHelper;

public class PanelMPersonal extends PanelMenu implements Constantes{

	private MiHandler handler;
	public PanelMPersonal(MiHandler handler) {
		super();
		this.handler = handler;
		setAlignmentX(CENTER_ALIGNMENT);
		setAlignmentY(CENTER_ALIGNMENT);
		
		add(UIHelper.getInstance().botonNuevo("Agregar Conductor",new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//evento
				handler.cambiarPanel(AGREGAR_CONDUCTOR);
			}
		}));
		add(UIHelper.getInstance().botonNuevo("Editar Conductor",new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//evento
				handler.cambiarPanel(EDITAR_CONDUCTOR);
			}
		}));
		add(UIHelper.getInstance().botonNuevo("Eliminar Conductor",new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//evento
				handler.cambiarPanel(BORRAR_CONDUCTOR);
			}
		}));
		add(UIHelper.getInstance().labelNuevo(" "));
		add(UIHelper.getInstance().botonNuevo("Agregar Productor",new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//evento
				handler.cambiarPanel(AGREGAR_PRODUCTOR);
			}
		}));
		add(UIHelper.getInstance().botonNuevo("Editar Productor",new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//evento
				handler.cambiarPanel(EDITAR_PRODUCTOR);
			}
		}));
		add(UIHelper.getInstance().botonNuevo("Eliminar Productor",new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//evento
				handler.cambiarPanel(BORRAR_PRODUCTOR);
			}
		}));
		add(UIHelper.getInstance().labelNuevo(" "));
		add(UIHelper.getInstance().botonNuevo("Agregar Auspiciante",new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//evento
				handler.cambiarPanel(AGREGAR_AUSPICIANTE);
			}
		}));
		add(UIHelper.getInstance().botonNuevo("Editar Auspiciante",new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//evento
				handler.cambiarPanel(EDITAR_AUSPICIANTE);
			}
		}));
		add(UIHelper.getInstance().botonNuevo("Eliminar Auspiciante",new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//evento
				handler.cambiarPanel(BORRAR_AUSPICIANTE);
			}
		}));
		add(Box.createVerticalGlue());
		add(Box.createHorizontalGlue());
	}

}
