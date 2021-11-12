package ventanas;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Date;

import javax.swing.*;

public class VentanaCrearEntrenamiento extends JFrame {
//	private String titulo;	
//	private String deporte;	
//	private float distancia;
//	private Date fechaIni;	
//	private long horaIni;
//	private long duracion;	
	
	private JPanel panelPrincipal;

	private JPanel panelTitulo;
	private JTextField textoTitulo;

	private JPanel panelDeporte;
	private JComboBox<String> comboDeporte;

	private JPanel panelDistancia;
	private JSpinner spinnerDistancia;
	
	private JPanel panelDuracion;
	private JSpinner spinnerDuracion;
	
	private JPanel panelFechaIni;
	private JTextField dateIni;
	
	private JPanel panelHoraIni;
	private JTextField horaIni;


	private JPanel panelBotonera;
	private JPanel panelBotonConfirmar;
	private JButton botonConfirmar;
	private JPanel panelBotonVolver;
	private JButton botonCancelar;
	
	
	public VentanaCrearEntrenamiento() {
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

		panelDeporte = new JPanel();
		comboDeporte = new JComboBox<>();
		panelDeporte.add(new JLabel("Deporte:"));
		panelDeporte.add(comboDeporte);
		comboDeporte.addItem("Correr");
		comboDeporte.addItem("Bici");
		comboDeporte.setSelectedItem("Correr");
		panelPrincipal.add(panelDeporte);
		
		panelDistancia = new JPanel();
		spinnerDistancia = new JSpinner();
		panelDistancia.add(new JLabel("Distancia (km):"));
		spinnerDistancia.setPreferredSize(new Dimension(50,25));
		panelDistancia.add(spinnerDistancia);
		panelPrincipal.add(panelDistancia);
		
		panelDuracion = new JPanel();
		spinnerDuracion = new JSpinner();
		panelDuracion.add(new JLabel("Duracion (h):"));
		spinnerDuracion.setPreferredSize(new Dimension(50,25));
		panelDuracion.add(spinnerDuracion);
		panelPrincipal.add(panelDuracion);

		panelFechaIni = new JPanel();
		dateIni = new JTextField();
		panelFechaIni.add(new JLabel("Fecha inicio:"));
		panelFechaIni.add(dateIni);
		dateIni.setPreferredSize(new Dimension(175,25));
		panelPrincipal.add(panelFechaIni);

		panelHoraIni = new JPanel();
		horaIni = new JTextField();
		panelHoraIni.add(new JLabel("Hora inicio:"));
		panelHoraIni.add(horaIni);
		horaIni.setPreferredSize(new Dimension(175,25));
		panelPrincipal.add(panelHoraIni);

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
