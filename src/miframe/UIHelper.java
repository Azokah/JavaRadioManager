package miframe;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dbmanager.DBManager;


/* Singleton! */
public class UIHelper{
	
	private static UIHelper instance;

	private UIHelper(){}
	
	public static UIHelper getInstance(){
		if(instance == null)
		{
			instance = new UIHelper();
		}
		return instance;
	}
	public JLabel labelNuevo(String texto)
	{
		JLabel label = new JLabel(texto);
		return label;
	}
	public JLabel labelNuevo(String texto, int r, int g, int b)
	{
		Color color = new Color(r,g,b);
		JLabel label = new JLabel(texto);
		label.setForeground(color);
		return label;
	}
	public JButton botonNuevo(String texto,ActionListener aL)
	{
		JButton boton = new JButton();
		boton.setText(texto);
		boton.addActionListener(aL);
		return boton;
	}
	public JButton botonNuevo(String texto)
	{
		JButton boton = new JButton();
		boton.setText(texto);
		return boton;
	}
	
	public ImageIcon cargarIcono(String texto)
	{
		BufferedImage myPicture;
		try {
			myPicture = ImageIO.read(new File(texto));
			ImageIcon picLabel = new ImageIcon(myPicture);
			return picLabel;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public JLabel cargarImagen(String texto)
	{
		BufferedImage myPicture;
		try {
			myPicture = ImageIO.read(new File(texto));
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			return picLabel;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	public JComboBox cBox()
	{
		return new JComboBox<Object>();
	}
	
	public JTextField campoTexto(String nombre)
	{
		JTextField texto = new JTextField();
		texto.setName(nombre);
		return texto;
	}
}
