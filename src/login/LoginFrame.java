package login;

import javax.swing.JFrame;

import miframe.MiHandler;

public class LoginFrame extends JFrame{

	private MiHandler handler;
	
	public LoginFrame(String titulo, MiHandler handler) {
		super(titulo);
		this.handler = handler;
		initUI(titulo);
		
	}
	
	private void initUI(String titulo)
	{
		LoginPanel lP = new LoginPanel(handler);
		getContentPane().add(lP);
		setSize(250, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
