package ventanas;

import java.awt.Color;
import java.awt.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class VentanaPrincipal extends JFrame {
	
	private JPanel panelTitulo;
	private JPanel panelArriba;
	private JLabel tituloStrava;
	private JPanel panelPerfil;
	private JButton botonPerfil;

	private JPanel panelAbajo;
	private JPanel panelAIzq;
	private JPanel panelADch;
	private JButton botonVerEntranmiento;
	private JButton botonCrearEntrenamiento;
	private JButton botonVerReto;
	private JButton botonCrearReto;
	
	
	public VentanaPrincipal() {
		setTitle("Inicio");
		setSize(500,350);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(2,2));
		setResizable(false);
		setLocationRelativeTo(null);
		setBackground(Color.WHITE);
		
		JPanel panelVacio = new JPanel();
		
		panelArriba = new JPanel();
		tituloStrava = new JLabel("STRAVA");
		panelTitulo = new JPanel();
		panelTitulo.add(tituloStrava);
		panelPerfil= new JPanel();
		botonPerfil = new JButton("Perfil", new ImageIcon(""));
		panelPerfil.add(botonPerfil);
		botonPerfil.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		panelArriba.setLayout(new GridLayout(1,3));
		panelArriba.add(panelVacio);
		panelArriba.add(panelTitulo);
		panelArriba.add(panelPerfil);
		add(panelArriba);
		
		
		
		panelAbajo = new JPanel();
		panelAbajo.setLayout(new GridLayout(1,2));
		
		panelADch = new JPanel();
		panelADch.setLayout(new GridLayout(2,1));	
		
		JPanel panelContenedor1 = new JPanel();
		botonVerEntranmiento = new JButton("Ver entrenamiento");
		botonVerEntranmiento.setPreferredSize(new Dimension(200, 25));
		panelContenedor1.add(botonVerEntranmiento);
		panelADch.add(panelContenedor1);
		JPanel panelContenedor2 = new JPanel();
		botonCrearEntrenamiento = new JButton("Crear entrenamiento");
		botonCrearEntrenamiento.setPreferredSize(new Dimension(200, 25));
		panelContenedor2.add(botonCrearEntrenamiento);
		panelADch.add(panelContenedor2);
		panelAbajo.add(panelADch);
		
		panelAIzq = new JPanel();
		panelAIzq.setLayout(new GridLayout(2,1));
		JPanel panelContenedor3 = new JPanel();
		botonVerReto = new JButton("Ver retos");
		botonVerReto.setPreferredSize(new Dimension(200, 25));
		panelContenedor3.add(botonVerReto);
		panelAIzq.add(panelContenedor3);
		JPanel panelContenedor4 = new JPanel();
		botonCrearReto = new JButton("Crear reto");
		botonCrearReto.setPreferredSize(new Dimension(200, 25));
		panelContenedor4.add(botonCrearReto);
		panelAIzq.add(panelContenedor4);
		
		panelAbajo.add(panelAIzq);
		add(panelAbajo);

		
		panelAbajo.add(panelADch);
		
		setVisible(true);
	}
	
	
}
