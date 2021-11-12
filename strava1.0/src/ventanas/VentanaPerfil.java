package ventanas;

import java.awt.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;

import javax.swing.*;

public class VentanaPerfil extends JFrame{

	private JPanel panelArribaFoto;
	private JPanel panelFoto;
	private JLabel foto;

	private JPanel panelMedioDatos;
	private JPanel panelUsuario;
	private JLabel labelUsuario;
	private JTextField textoUsuario;

	private JPanel panelEmail;
	private JLabel labelEmail;
	private JTextField textoEmail;

	private JPanel panelRetosAceptados;
	private JLabel labelRetosAceptados;
	private JLabel labelNumRetos;

	private JPanel panelBotonera;
	private JPanel panelBotonEditar;
	private JButton botonEditar;
	private JPanel panelBotonVolver;
	private JButton volver;

	private VentanaEditarPerfil vEP;


	public VentanaPerfil() {
		setTitle("Inicio");
		setSize(300,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(3,1));
		setLocationRelativeTo(null);
		setBackground(Color.WHITE);


		panelArribaFoto = new JPanel();
		panelArribaFoto.setLayout(new GridLayout(1,1));
		foto = new JLabel(new ImageIcon("iconos/perfil.png"));
		panelArribaFoto.add(foto);
		add(panelArribaFoto);

		panelMedioDatos = new JPanel();  
		panelMedioDatos.setLayout(new GridLayout(4,1));
		add(panelMedioDatos);


		panelUsuario = new JPanel();          
		labelUsuario = new JLabel("Usuario: ");          
		textoUsuario = new JTextField();  
		textoUsuario.setPreferredSize(new Dimension(175,25));
		panelUsuario.add(labelUsuario);
		panelUsuario.add(textoUsuario);
		panelMedioDatos.add(panelUsuario);

		panelEmail = new JPanel();            
		labelEmail = new JLabel("Email: ");            
		textoEmail = new JTextField();     
		textoEmail.setPreferredSize(new Dimension(175,25));
		panelEmail.add(labelEmail);
		panelEmail.add(textoEmail);
		panelMedioDatos.add(panelEmail);

		panelRetosAceptados = new JPanel();   
		labelRetosAceptados = new JLabel("Retos aceptados: ");   
		labelNumRetos = new JLabel("");   
		panelRetosAceptados.add(labelRetosAceptados);
		panelRetosAceptados.add(labelRetosAceptados);
		panelMedioDatos.add(panelRetosAceptados);


		panelBotonera = new JPanel();  
		panelBotonera.setLayout(new GridLayout(1,2));
		panelBotonEditar = new JPanel();  
		botonEditar = new JButton("Editar");
		botonEditar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				vEP = new VentanaEditarPerfil();

			}
		});
		panelBotonVolver = new JPanel();  
		volver = new JButton("Volver");           
		add(panelBotonera);
		panelBotonEditar.add(botonEditar);
		panelBotonVolver.add(volver);
		panelBotonera.add(panelBotonVolver);
		panelBotonera.add(panelBotonEditar);




		setVisible(true);
	}
}
