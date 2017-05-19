package miframe;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import constantes.Constantes;
import dao.AuspicianteDAO;
import dao.AuspicianteDAOImpl;
import dao.ConductorDAOImpl;
import dao.DBDAOImpl;
import dao.ProductorDAOImpl;
import dao.ProgramasDaoImpl;
import dbclases.Auspiciante;
import dbclases.Balance;
import dbclases.Conductor;
import dbclases.Productor;
import dbclases.Programa;
import dbmanager.DBManager;
import exceptions.RadioException;
import login.LoginFrame;
import login.Usuario;
import login.UsuarioBO;
import login.UsuarioDAOImpl;
import negocio.AuspicianteBO;
import negocio.ConductorBO;
import negocio.DBBO;
import negocio.ProductorBO;
import negocio.ProgramaBO;
import paneles.PanelBase;
import paneles.PanelBaseBalanceEstandar;
import paneles.PanelBaseFull;
import paneles.PanelBasePersonal;
import paneles.PanelBasePersonalEstandar;
import paneles.PanelBasePrograma;
import paneles.PanelBaseProgramaEstandar;
import paneles.PanelBorrarPrograma;
import paneles.PanelCabecera;
import paneles.PanelCrearAuspiciante;
import paneles.PanelCrearConductor;
import paneles.PanelCrearPersonal;
import paneles.PanelCrearProductor;
import paneles.PanelCrearPrograma;
import paneles.PanelEditarAuspiciante;
import paneles.PanelEditarConductor;
import paneles.PanelEditarProductor;
import paneles.PanelEditarPrograma;
import paneles.PanelEliminarAuspiciante;
import paneles.PanelEliminarConductor;
import paneles.PanelEliminarProductor;
import paneles.PanelFirma;
import paneles.PanelMPersonal;
import paneles.PanelMBalance;
import paneles.PanelMPrograma;
import paneles.PanelMenu;
import paneles.PanelPrincipal;
import paneles.PanelPrincipalPrograma;


public class MiHandler implements Constantes{
	private MiFrame frame;
	private LoginFrame lFrame;
	private UsuarioBO usrBO;
	private ProgramaBO pgmBO;
	private AuspicianteBO ausBO;
	private ConductorBO conBO;
	private ProductorBO proBO;
	private DBBO dbBO;
	//private PanelBase pB;
	//private PanelPrincipal pP;

	public MiHandler() {
		dbBO = new DBBO();
		dbBO.setDBDAO(new DBDAOImpl());
		usrBO = new UsuarioBO();
		usrBO.setUsuarioDAO(new UsuarioDAOImpl());
		pgmBO = new ProgramaBO();
		pgmBO.setProgramasDAO(new ProgramasDaoImpl());
		ausBO = new AuspicianteBO();
		ausBO.setAuspicianteDAO(new AuspicianteDAOImpl());
		conBO = new ConductorBO();
		conBO.setConductorDAO(new ConductorDAOImpl());
		proBO = new ProductorBO();
		proBO.setProductorDAO(new ProductorDAOImpl());
		initLog();
	}

	private void initLog()
	{
		lFrame = new LoginFrame("GNR Login", this);

	}

	public void logear(Usuario usr) {
		boolean logeado = false;
		try {
			logeado = usrBO.buscarUsuario(usr);
			if(logeado)
			{
				initApp();
			}
			else JOptionPane.showMessageDialog(null, "No se encontro usuario/contraseña.","Login Invalido",JOptionPane.ERROR_MESSAGE);
		} catch (RadioException e) {
			JOptionPane.showMessageDialog(null,"Error no se pudo logear.", e.getMessage(),JOptionPane.ERROR_MESSAGE);
		}
	}

	private void initApp()
	{
		lFrame.setVisible(false);
		frame = new MiFrame("Galaxy News Radio (GNR).", this);
	}

	public void salir(){
		System.exit(0);
	}
	
	public void crearTablas(){
		try {
		dbBO.crearTablaProgramas();
		dbBO.crearTablaConductor();
		dbBO.crearTablaAuspiciantes();
		dbBO.crearTablaUsuarios();
		dbBO.crearTablaProductores();
		} catch (RadioException e){
			JOptionPane.showMessageDialog(null,"Error, las tablas no pudieron ser creadas.", e.getMessage(),JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void dropTablas(){
		try{
			dbBO.dropTablaProgramas();
			dbBO.dropTablaAuspiciantes();
			dbBO.dropTablaConductor();
			dbBO.dropTablaUsuarios();
			dbBO.dropTablaProductores();
		} catch (RadioException e){
			JOptionPane.showMessageDialog(null,"Error, no se pudieron dropear las tablas.", e.getMessage(),JOptionPane.ERROR_MESSAGE);
		}
	}
	public void agregarProgramas(Programa pgm)
	{
		try {
			if(!pgmBO.agregarProgramas(pgm))
			{
				JOptionPane.showMessageDialog(null,"El programa se ha creado exitosamente.","Programa creado",JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "El nombre del programa ya existe","Nombre Invalido",JOptionPane.ERROR_MESSAGE);
			}
		} catch (RadioException e) {
			JOptionPane.showMessageDialog(null,"Error, el programa no pudo ser creado.", e.getMessage(),JOptionPane.ERROR_MESSAGE);
		}
	};
	public void editarProgramas(Programa pgm)
	{
		try{
			pgmBO.editarProgramas(pgm);
			JOptionPane.showMessageDialog(null,"El programa  ha sido editado.","Programa editado",JOptionPane.INFORMATION_MESSAGE);
		} catch (RadioException e) {
			JOptionPane.showMessageDialog(null,"Error, el programa no pudo ser editado.", e.getMessage(),JOptionPane.ERROR_MESSAGE);
		}
	};
	public void eliminarProgramas(Programa pgm)
	{
		try
		{
			pgmBO.eliminarProgramas(pgm);
			JOptionPane.showMessageDialog(null,"El programa ha sido borrado.","Programa borrado",JOptionPane.INFORMATION_MESSAGE);
		} catch (RadioException e) {
			JOptionPane.showMessageDialog(null, "Error, el programa no se pudo borrar.", e.getMessage(),JOptionPane.ERROR_MESSAGE);
		}
	};

	public void agregarAuspiciantes(Auspiciante aus)
	{
		try
		{
			if(!ausBO.agregarAuspiciante(aus))
			{
				JOptionPane.showMessageDialog(null,"El auspiciante se ha creado exitosamente.","Auspiciante creado",JOptionPane.INFORMATION_MESSAGE);
			}
			else JOptionPane.showMessageDialog(null, "El nombre del auspiciante ya existe","Nombre Invalido",JOptionPane.ERROR_MESSAGE);
		} catch (RadioException e) {
			JOptionPane.showMessageDialog(null,"Error, no se pudo crear el auspiciante.", e.getMessage(),JOptionPane.ERROR_MESSAGE);
		}
	};
	public void editarAuspiciantes(Auspiciante aus)
	{
		try
		{
			ausBO.editarAuspiciante(aus);
			JOptionPane.showMessageDialog(null,"El Auspiciante  ha sido editado.","Auspiciante editado",JOptionPane.INFORMATION_MESSAGE);
		} catch (RadioException e) {
			JOptionPane.showMessageDialog(null, "Error, no se pudo editar el auspiciante.", e.getMessage(),JOptionPane.ERROR_MESSAGE);
		}
	};
	public void eliminarAuspiciantes(Auspiciante aus)
	{
		try
		{
			ausBO.eliminarAuspiciante(aus);
			JOptionPane.showMessageDialog(null,"El Auspiciante ha sido borrado.","Auspiciante eliminado",JOptionPane.INFORMATION_MESSAGE);
		} catch (RadioException e) {
			JOptionPane.showMessageDialog(null,"Error, no se pudo borrar el auspiciante.", e.getMessage(),JOptionPane.ERROR_MESSAGE);
		}
	};

	public List<Auspiciante> mostrarAuspiciantes()
	{
		try
		{
			return ausBO.mostrarDatos();
		}	
		catch (RadioException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(),"Error! :c",JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}

	public void agregarConductor(Conductor con)
	{
		try
		{
			if(!conBO.agregarConductor(con))
			{
				JOptionPane.showMessageDialog(null,"El conductor se ha creado exitosamente.","Conductor creado",JOptionPane.INFORMATION_MESSAGE);
			}
			else JOptionPane.showMessageDialog(null, "El nombre del conductor ya existe","Nombre Invalido",JOptionPane.ERROR_MESSAGE);
		} catch (RadioException e) {
			JOptionPane.showMessageDialog(null,"Error,el conductor no se pudo crear.",e.getMessage(),JOptionPane.ERROR_MESSAGE);
		}
	};
	public void editarConductor(Conductor con)
	{
		try
		{
			conBO.editarConductor(con);
			JOptionPane.showMessageDialog(null,"El Conductor  ha sido editado.","Conductor editado",JOptionPane.INFORMATION_MESSAGE);
		} catch (RadioException e) {
			JOptionPane.showMessageDialog(null,"Error, el conductor no se pudo editar.",e.getMessage(),JOptionPane.ERROR_MESSAGE);
		}
	};
	public void eliminarConductor(Conductor con)
	{
		try
		{
			conBO.eliminarConductor(con);
			JOptionPane.showMessageDialog(null,"El Conductor ha sido borrado.","Conductor eliminado",JOptionPane.INFORMATION_MESSAGE);
		} catch (RadioException e) {
			JOptionPane.showMessageDialog(null,"Error, el conductor no se pudo eliminar",e.getMessage(),JOptionPane.ERROR_MESSAGE);
		}
	};

	public List<Conductor> mostrarConductores()
	{
		try
		{
			return conBO.mostrarDatos();
		}	
		catch (RadioException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),"Error! :c",JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}

	public void agregarProductor(Productor pro)
	{
		try
		{
			if(!proBO.agregarProductor(pro))
			{
				JOptionPane.showMessageDialog(null,"El productor se ha creado exitosamente.","Productor creado",JOptionPane.INFORMATION_MESSAGE);

			} else JOptionPane.showMessageDialog(null, "El nombre del productor ya existe","Nombre Invalido",JOptionPane.ERROR_MESSAGE);

		} catch (RadioException e) {
			JOptionPane.showMessageDialog(null,"Error, el productor no se ha creado.", e.getMessage(),JOptionPane.ERROR_MESSAGE);
		}
	};
	public void editarProductor(Productor pro)
	{
		try
		{
			proBO.editarProductor(pro);
			JOptionPane.showMessageDialog(null,"El Productor  ha sido editado.","Productor editado",JOptionPane.INFORMATION_MESSAGE);
		} catch (RadioException e) {
			JOptionPane.showMessageDialog(null,"Error, el productor no se ha editado.", e.getMessage(),JOptionPane.ERROR_MESSAGE);
		}
	};
	public void eliminarProductor(Productor pro)
	{
		try
		{
			proBO.eliminarProductor(pro);
			JOptionPane.showMessageDialog(null,"El Productor ha sido borrado.","Productor eliminado",JOptionPane.INFORMATION_MESSAGE);
		} catch (RadioException e) {
			JOptionPane.showMessageDialog(null, "Error, el producotr no se ha borrado.", e.getMessage(),JOptionPane.ERROR_MESSAGE);
		}
	};

	public List<Productor> mostrarProductores()
	{
		try
		{
			return proBO.mostrarDatos();
		}	
		catch (RadioException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),"Error! :c",JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}

	public List<Balance> generarBalance()
	{
		List<Balance> balance = new ArrayList<Balance>();
		for (Auspiciante aus : mostrarAuspiciantes()) 
		{
			balance.add(new Balance(aus.getNombre(),"Auspiciante",aus.getSaldo()));
		}
		for (Conductor con : mostrarConductores()) 
		{
			balance.add(new Balance(con.getNombre(),"Conductor",con.getSueldo()));
		}
		for (Productor pro : mostrarProductores()) 
		{
			balance.add(new Balance(pro.getNombre(),"Productor",pro.getSueldo()));
		}
		return balance;
	};
	
	public void cambiarPanelVolver() 
	{
		PanelBase pB = new PanelBaseFull(this);
		frame.cambiarPanel(pB);
	}

	public void cambiarPanel(int panel)
	{
		PanelBase pB;
		PanelPrincipal pP = new PanelPrincipalPrograma(this);
		pP.removeAll();
		switch(panel)
		{
		default:
			pP.add(new PanelCrearPrograma(this));
			pB = new PanelBasePrograma(this,pP);
			break;
		case EDITAR_PROGRAMA:
			
			pP.add(new PanelEditarPrograma(this,frame.getProgramaSelec().getNombre()));
			pB = new PanelBasePrograma(this,pP);
			break;
		case BORRAR_PROGRAMA:
			pP.add(new PanelBorrarPrograma(this,frame.getProgramaSelec().getNombre()),BorderLayout.CENTER);
			pB = new PanelBasePrograma(this,pP);
			break;
		case AGREGAR_CONDUCTOR:
			pP.add(new PanelCrearConductor(this),BorderLayout.CENTER);
			pB = new PanelBasePersonal(this,pP);
			break;
		case EDITAR_CONDUCTOR:
			pP.add(new PanelEditarConductor(this,frame.getConductorSelec().getNombre()),BorderLayout.CENTER);
			pB = new PanelBasePersonal(this,pP);
			break;
		case BORRAR_CONDUCTOR:
			pP.add(new PanelEliminarConductor(this,frame.getConductorSelec().getNombre()));
			pB = new PanelBasePersonal(this,pP);;
			break;
		case AGREGAR_PRODUCTOR:
			pP.add(new PanelCrearProductor(this),BorderLayout.CENTER);
			pB = new PanelBasePersonal(this,pP);
			break;
		case EDITAR_PRODUCTOR:
			pP.add(new PanelEditarProductor(this,frame.getProductorSelec().getNombre()),BorderLayout.CENTER);
			pB = new PanelBasePersonal(this,pP);
			break;
		case BORRAR_PRODUCTOR:
			pP.add(new PanelEliminarProductor(this,frame.getProductorSelec().getNombre()),BorderLayout.CENTER);
			pB = new PanelBasePersonal(this,pP);
			break;
		case AGREGAR_AUSPICIANTE:
			pP.add(new PanelCrearAuspiciante(this),BorderLayout.CENTER);
			pB = new PanelBasePersonal(this,pP);
			break;
		case EDITAR_AUSPICIANTE:
			pP.add(new PanelEditarAuspiciante(this,frame.getAuspicianteSelec().getNombre()),BorderLayout.CENTER);
			pB = new PanelBasePersonal(this,pP);
			break;
		case  BORRAR_AUSPICIANTE:
			pP.add(new PanelEliminarAuspiciante(this,frame.getAuspicianteSelec().getNombre()),BorderLayout.CENTER);
			pB = new PanelBasePersonal(this,pP);
			break;

		}
		frame.cambiarPanel(pB);
	}
	public void cambiarPanelMenu(int panel)
	{
		PanelBase pB;
		switch(panel)
		{
		default:
			pB = new PanelBaseProgramaEstandar(this);
			break;
		case AUSPICIANTE:
			pB = new PanelBasePersonalEstandar(this);
			break;
		case BALANCE:
			pB = new PanelBaseBalanceEstandar(this);
			break;
		}
		frame.cambiarPanel(pB);
	};

	public List<Programa> mostrarDatos()
	{
		try
		{
			return pgmBO.mostrarDatos();
		}	
		catch (RadioException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),"Error! :c",JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}

	public MiFrame getFrame() {
		return frame;
	}
	public void setFrame(MiFrame frame) {
		this.frame = frame;
	}

	public void nuevoUsuario(Usuario usr)
	{
		System.out.println(usr.getUsuario());
		System.out.println(usr.getPass());
		try {
			usrBO.nuevoUsuario(usr);
		} catch (RadioException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),"Error creando User!! :c",JOptionPane.ERROR_MESSAGE);
		}
	}
}
