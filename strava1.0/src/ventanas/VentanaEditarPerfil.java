package ventanas;

import java.awt.Dimension; 
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaEditarPerfil extends JFrame {
	
	private JPanel panelContrasenya;
	private JLabel labelContrasenya;
	private JTextField textoContrasenya;
	private JPanel panelInternoUsuario;
	private JLabel labelInternoUsuario;
	private JTextField textoInternoUsuario;
	private JPanel panelInternoEmail;
	private JLabel labelInternoEmail;
	private JTextField textoInternoEmail;
	
	private JPanel panelBotonera;
	private JPanel panelBotonEditar;
	private JButton botonEditar;
	private JPanel panelBotonConfirmar;
	private JButton botonConfirmar;
	

	public VentanaEditarPerfil() {
		setTitle("EditarDatos");
		setLayout(new GridLayout(1,1));
		setSize(new Dimension(300,200));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

		JPanel panelInternal = new JPanel();
		panelInternal.setLayout(new GridLayout(4,1));

		panelInternoUsuario = new JPanel();
		labelInternoUsuario= new JLabel("Usuario:");
		panelInternoUsuario.add(labelInternoUsuario);
		textoInternoUsuario = new JTextField();
		textoInternoUsuario.setEnabled(false);
		textoInternoUsuario.setPreferredSize(new Dimension(175,25));
		panelInternoUsuario.add(textoInternoUsuario);
		panelInternal.add(panelInternoUsuario);
		
		panelInternoEmail = new JPanel();
		labelInternoEmail= new JLabel("Email:");
		panelInternoEmail.add(labelInternoEmail);
		textoInternoEmail = new JTextField();
		textoInternoEmail.setEnabled(false);
		textoInternoEmail.setPreferredSize(new Dimension(175,25));
		panelInternoEmail.add(textoInternoEmail);
		panelInternal.add(panelInternoEmail);
		
		
		panelContrasenya = new JPanel();;
		labelContrasenya = new JLabel("Contraseña:");
		textoContrasenya = new JTextField();
		textoContrasenya.setEnabled(false);
		textoContrasenya.setPreferredSize(new Dimension(175,25));
		panelContrasenya.add(labelContrasenya);
		panelContrasenya.add(textoContrasenya);
		
		panelInternal.add(panelContrasenya);
		add(panelInternal);
		
		panelBotonera = new JPanel();
		panelBotonera.setLayout(new GridLayout(1,2));
		panelBotonEditar = new JPanel();
		panelBotonera.add(panelBotonEditar);
		botonEditar = new JButton("Editar");
		panelBotonEditar.add(botonEditar);
		panelInternal.add(panelBotonera);
		botonEditar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textoContrasenya.setEnabled(true);
				textoInternoEmail.setEnabled(true);
				textoInternoUsuario.setEnabled(true);
				botonConfirmar.setEnabled(true);
				botonEditar.setEnabled(false);
				repaint();
				validate();

			}
		});
		
		panelBotonConfirmar = new JPanel();
		panelBotonera.add(panelBotonConfirmar);
		botonConfirmar = new JButton("Confirmar");
		botonConfirmar.setEnabled(false);
		panelBotonConfirmar.add(botonConfirmar);
		botonConfirmar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
		
		setVisible(true);
	}
}
