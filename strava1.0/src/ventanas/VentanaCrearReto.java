package ventanas;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;

public class VentanaCrearReto extends JFrame {

	private JPanel panelPrincipal;

	private JPanel panelTitulo;
	private JTextField textoTitulo;

	private JPanel panelDescripcion;
	private JTextField textoDescripcion;

	private JPanel panelDeporte;
	private JComboBox<String> comboDeporte;

	private JPanel panelFechaIni;
	private JTextField dateIni;

	private JPanel panelFechaFin;
	private JTextField dateFin;

	private JPanel panelObjetivo;
	private JSpinner spinnerObjetivo;

	private JPanel panelBotonera;
	private JPanel panelBotonConfirmar;
	private JButton botonConfirmar;
	private JPanel panelBotonVolver;
	private JButton botonCancelar;


	public VentanaCrearReto() {
		setTitle("Crear reto");
		setSize(new Dimension(300, 500));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new GridLayout(1,1));

		panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new GridLayout(7,1));
		add(panelPrincipal);

		panelTitulo = new JPanel();
		textoTitulo = new JTextField();
		panelTitulo.add(new JLabel("Titulo:"));
		panelTitulo.add(textoTitulo);
		textoTitulo.setPreferredSize(new Dimension(175,25));
		panelPrincipal.add(panelTitulo);

		panelDescripcion = new JPanel();
		textoDescripcion = new JTextField();
		panelDescripcion.add(new JLabel("Descripcion:"));
		panelDescripcion.add(textoDescripcion);
		textoDescripcion.setPreferredSize(new Dimension(175,25));
		panelPrincipal.add(panelDescripcion);

		panelDeporte = new JPanel();
		comboDeporte = new JComboBox<>();
		panelDeporte.add(new JLabel("Deporte:"));
		panelDeporte.add(comboDeporte);
		comboDeporte.addItem("Correr");
		comboDeporte.addItem("Bici");
		comboDeporte.setSelectedItem("Correr");
		panelPrincipal.add(panelDeporte);

		panelFechaIni = new JPanel();
		dateIni = new JTextField();
		panelFechaIni.add(new JLabel("Fecha inicio:"));
		panelFechaIni.add(dateIni);
		dateIni.setPreferredSize(new Dimension(175,25));
		panelPrincipal.add(panelFechaIni);

		panelFechaFin = new JPanel();
		dateFin = new JTextField();
		panelFechaFin.add(new JLabel("Fecha fin:"));
		panelFechaFin.add(dateFin);
		dateFin.setPreferredSize(new Dimension(175,25));
		panelPrincipal.add(panelFechaFin);

		panelObjetivo = new JPanel();
		spinnerObjetivo = new JSpinner();
		panelObjetivo.add(new JLabel("Objetivo (km):"));
		spinnerObjetivo.setPreferredSize(new Dimension(50,25));
		panelObjetivo.add(spinnerObjetivo);
		panelPrincipal.add(panelObjetivo);

		panelBotonera = new JPanel();  
		panelBotonera.setLayout(new GridLayout(1,2));
		panelBotonConfirmar = new JPanel();
		panelBotonVolver = new JPanel();
		botonCancelar = new JButton("Volver");
		botonCancelar.setPreferredSize(new Dimension(100, 25));
		panelBotonVolver.add(botonCancelar);
		panelBotonera.add(panelBotonVolver); 
		botonConfirmar = new JButton("Confirmar");
		botonConfirmar.setPreferredSize(new Dimension(100, 25));
		panelBotonConfirmar.add(botonConfirmar);
		panelBotonera.add(panelBotonConfirmar); 
		panelPrincipal.add(panelBotonera);

		setVisible(true);

	}



}
