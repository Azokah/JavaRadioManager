package table;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import dbclases.Auspiciante;
import dbclases.Conductor;
import dbclases.Productor;
import dbclases.Programa;

public class PersonalTablePanel extends MiTablePanel {

	private JTable jtCon;
	private JTable jtPro;
	private JTable jtAus;
	private JScrollPane scrollPane1;
	private JScrollPane scrollPane2;
	private JScrollPane scrollPane3;

	public PersonalTablePanel(List<Conductor> listaCon, List<Productor> listaPro, List<Auspiciante> listaAus)
	{
		super();
		removeAll();
		setLayout(new GridLayout(1,3));
		actualizarAConductor(listaCon);
		actualizarAProductor(listaPro);
		actualizarAAuspiciante(listaAus);
	}

	public void actualizarAConductor(List<Conductor> lista)
	{
		jtCon = new JTable(new TableModelConductor(lista));
		scrollPane1 = new JScrollPane(jtCon);
		add(scrollPane1);
	}
	public void actualizarAProductor(List<Productor> lista)
	{
		jtPro = new JTable(new TableModelProductor(lista));
		scrollPane2 = new JScrollPane(jtPro);
		add(scrollPane2);
	}
	public void actualizarAAuspiciante(List<Auspiciante> lista)
	{
		jtAus = new JTable(new TableModelAuspiciante(lista));
		scrollPane3 = new JScrollPane(jtAus);
		add(scrollPane3);
	}

	public Auspiciante getEntidadFilaAuspiciante()
	{
		return ((TableModelAuspiciante) jtAus.getModel()).getEntidad(jtAus.getSelectedRow());
	}
	public Conductor getEntidadFilaConductor()
	{
		return ((TableModelConductor) jtCon.getModel()).getEntidad(jtCon.getSelectedRow());
	}
	public Productor getEntidadFilaProductor()
	{
		return ((TableModelProductor) jtPro.getModel()).getEntidad(jtPro.getSelectedRow());
	}

}
