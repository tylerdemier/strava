package ventanas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class VentanaIniciarSesion extends JFrame {

	private JPanel panelUsuario;
	private JTextField usuario;
	private JLabel labelUsuario = new JLabel("        Usuario: ");

	private JPanel panelcontrase�a;
	private JPasswordField contrase�a;
	private JLabel labelcontrase�a = new JLabel("  Contrase�a: ");

	private JButton aceptar;
	private JButton crearUsuario;
	private JPanel panelBotonera;

	private JPanel panelDatos;

	private JPanel panelDecorativo;
	private JLabel labelDecorativo;


	public VentanaIniciarSesion() {
		setTitle("Inicio");
		setSize(310,260);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(2,1));
		setResizable(false);
		setLocationRelativeTo(null);
		setBackground(Color.WHITE);


		panelDecorativo = new JPanel();
		panelDecorativo.setLayout(new GridLayout(1,1));
		panelDecorativo.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0)); //TOC
		labelDecorativo = new JLabel(new ImageIcon("iconos/login.png"));
		panelDecorativo.setBackground(Color.WHITE);
		panelDecorativo.add(labelDecorativo);
		add(panelDecorativo);


		panelDatos = new JPanel();
		panelDatos.setLayout(new GridLayout(3,1));
		panelDatos.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panelDatos.setSize(new Dimension(100,100));
		panelDatos.setBackground(new Color(111, 195, 179));
		panelDatos.setPreferredSize(new Dimension(280,100));
		add(panelDatos);

		panelUsuario = new JPanel();
		usuario = new JTextField();
		usuario.setPreferredSize(new Dimension(100,25));
		panelUsuario.add(labelUsuario);
		panelUsuario.add(usuario);
		panelUsuario.setBackground(new Color(111, 195, 179));
		panelDatos.add(panelUsuario);

		panelcontrase�a = new JPanel();
		contrase�a = new JPasswordField();
		contrase�a.setPreferredSize(new Dimension(100,25));
		panelcontrase�a.add(labelcontrase�a);
		panelcontrase�a.add(contrase�a);
		panelcontrase�a.setBackground(new Color(111, 195, 179));
		panelDatos.add(panelcontrase�a);

		panelBotonera = new JPanel();
		aceptar = new JButton("Iniciar Sesi�n");
		crearUsuario = new JButton("Crear Nuevo Usuario");
		aceptar.setEnabled(false);
		crearUsuario.setEnabled(false);
		panelBotonera.add(aceptar);
		panelBotonera.add(crearUsuario);
		panelBotonera.setBackground(new Color(111, 195, 179));
		panelDatos.add(panelBotonera);
		
		usuario.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				changed();
			}
			public void removeUpdate(DocumentEvent e) {
				changed();
			}
			public void insertUpdate(DocumentEvent e) {
				changed();
			}
		});

		contrase�a.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				changed();
			}
			public void removeUpdate(DocumentEvent e) {
				changed();
			}
			public void insertUpdate(DocumentEvent e) {
				changed();
			}
		});		


		setVisible(true);		
	}


	public void changed() {
		if (contrase�a.getText().equals("") || contrase�a.getText().contains(" ") || usuario.getText().equals("") || usuario.getText().contains(" ")){
			aceptar.setEnabled(false);
			crearUsuario.setEnabled(false);
		}
		else {
			aceptar.setEnabled(true);
			crearUsuario.setEnabled(true);
		}
	}
		
		
	}
