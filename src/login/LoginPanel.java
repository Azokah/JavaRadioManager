package login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import miframe.MiHandler;
import miframe.UIHelper;

public class LoginPanel extends JPanel {
	
	private JTextField usuarioJTF;
	private JPasswordField passJTF;
	private MiHandler handler;
	
	public LoginPanel(MiHandler handler)
	{
		super();
		this.handler = handler;
		setBackground(new Color(125,125,125));
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		init();
	}
	
	private void init()
	{
		usuarioJTF = new JTextField();
		passJTF = new JPasswordField();
		JLabel titulo = new JLabel();
		titulo.setText("Log in");
		titulo.setForeground(new Color(100,255,200));
		add(titulo);
		add(new JLabel("Usuario: "));
		add(usuarioJTF);
		add(new JLabel("Contraseña: "));
		add(passJTF);
		add(UIHelper.getInstance().botonNuevo("Logear",new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//evento
				if( usuarioJTF.getText().isEmpty() || (String.copyValueOf(passJTF.getPassword())).isEmpty() )
				{
					JOptionPane.showMessageDialog(null,"Ningun campo puede estar vacio","Error de campo",JOptionPane.ERROR_MESSAGE);
				}
				else
					{
						Usuario usr = new Usuario(usuarioJTF.getText(),(String.copyValueOf(passJTF.getPassword())));
						handler.logear(usr);
					}
			}
		}));
		add(UIHelper.getInstance().botonNuevo("Salir",new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//evento
				handler.salir();
			}
		}));
	}
	
}
