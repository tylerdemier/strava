package ventanas;

import java.awt.Dimension; 
import java.awt.GridLayout;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaEditarPerfil extends JInternalFrame {
	
	private JPanel panelContrasenya;
	private JLabel labelContrasenya;
	private JTextField textoContrasenya;
	private JPanel panelInternoUsuario;
	private JLabel labelInternoUsuario;
	private JTextField textoInternoUsuario;
	private JPanel panelInternoEmail;
	private JLabel labelInternoEmail;
	private JTextField textoInternoEmail;
	

	public VentanaEditarPerfil() {
		setTitle("EditarDatos");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(250,250);
		setBounds(0, 0, 600, 100);

		JPanel panelInternal = new JPanel();
		panelInternal.setLayout(new GridLayout(4,1));

		panelInternoUsuario = new JPanel();
		labelInternoUsuario= new JLabel("Usuario:");
		panelInternoUsuario.add(labelInternoUsuario);
		textoInternoUsuario = new JTextField();
		panelInternoUsuario.add(textoInternoUsuario);
		panelInternal.add(panelInternoUsuario);
		
		panelInternoEmail = new JPanel();
		labelInternoEmail= new JLabel("Email:");
		panelInternoEmail.add(labelInternoEmail);
		textoInternoEmail = new JTextField();
		panelInternoEmail.add(textoInternoEmail);
		panelInternal.add(panelInternoEmail);
		
		
		panelContrasenya = new JPanel();;
		labelContrasenya = new JLabel("Contraseña:");
		textoContrasenya = new JTextField();
		textoContrasenya.setPreferredSize(new Dimension(175,25));
		panelContrasenya.add(labelContrasenya);
		panelContrasenya.add(textoContrasenya);
		
		panelInternal.add(panelContrasenya);
		add(panelInternal);
		
		setVisible(true);
	}
}
