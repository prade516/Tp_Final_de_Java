package uiEscritorio;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import entidades.Propiedad_Persona;

import negocio.*;
import utils.ApplicationException;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;


public class frmJuego {
   
	private JFrame frame;
	private JTextField textFieldVidaJ1;
	private JTextField textFieldEnergiaJ1;
	private JTextField textFieldDefensaJ1;
	private JTextField textFieldEvasionJ1;
	private JTextField textFieldVidaJ2;
	private JTextField textFieldEnergiaJ2;
	private JTextField textFieldDefensaJ2;
	private JTextField textFieldEvasionJ2;
	private JTextField textFieldTurnoPersonaje;
	private JTextField textFieldPuntosAtaque;
	private JTextField txtjugador2;
	private JTextField txtjugador1;
	
	private MetodoJuego ctrlCombate;
	private Propiedad_Persona jugador1;
	private Propiedad_Persona jugador2;
	
	

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmJuego window = new frmJuego();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public frmJuego() {
		initialize();
		ctrlCombate=new MetodoJuego();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 580, 444);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblJugad = new JLabel("Jugador I");
		lblJugad.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
			}
		});
		
		JLabel lblJugador = new JLabel("Jugador II");
		
		JLabel lblVida = new JLabel("VIDA");
		
		textFieldVidaJ1 = new JTextField();
		textFieldVidaJ1.setEditable(false);
		textFieldVidaJ1.setColumns(10);
		
		JLabel lblEnergia = new JLabel("ENERGIA");
		
		JLabel lblDefensa = new JLabel("DEFENSA");
		
		JLabel lblEvasion = new JLabel("EVASION");
		
		textFieldEnergiaJ1 = new JTextField();
		textFieldEnergiaJ1.setEditable(false);
		textFieldEnergiaJ1.setColumns(10);
		
		textFieldDefensaJ1 = new JTextField();
		textFieldDefensaJ1.setEditable(false);
		textFieldDefensaJ1.setColumns(10);
		
		textFieldEvasionJ1 = new JTextField();
		textFieldEvasionJ1.setEditable(false);
		textFieldEvasionJ1.setColumns(10);
		
		textFieldVidaJ2 = new JTextField();
		textFieldVidaJ2.setEditable(false);
		textFieldVidaJ2.setColumns(10);
		
		textFieldEnergiaJ2 = new JTextField();
		textFieldEnergiaJ2.setEditable(false);
		textFieldEnergiaJ2.setColumns(10);
		
		textFieldDefensaJ2 = new JTextField();
		textFieldDefensaJ2.setEditable(false);
		textFieldDefensaJ2.setColumns(10);
		
		textFieldEvasionJ2 = new JTextField();
		textFieldEvasionJ2.setEditable(false);
		textFieldEvasionJ2.setColumns(10);
		
		JLabel lblVida_1 = new JLabel("VIDA");
		
		JLabel lblEnergia_1 = new JLabel("ENERGIA");
		
		JLabel lblDefensa_1 = new JLabel("DEFENSA");
		
		JLabel lblEvasion_1 = new JLabel("EVASION");
		
		JButton btnNuevaPartida = new JButton("NUEVA PARTIDA");
		btnNuevaPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevaPartida();	
			}

		});
		
		JLabel lblTurnoJugador = new JLabel("TURNO JUGADOR:");
		
		textFieldTurnoPersonaje = new JTextField();
		textFieldTurnoPersonaje.setEditable(false);
		textFieldTurnoPersonaje.setColumns(10);
		
		JButton btnAtacar = new JButton("ATACAR");
		btnAtacar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atacar();
			}
		});
		
		textFieldPuntosAtaque = new JTextField();
		textFieldPuntosAtaque.setColumns(10);
		
		JButton btnDefender = new JButton("DEFENDER");
		btnDefender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				defender();
			}
		});
		
		txtjugador2 = new JTextField();
		txtjugador2.setColumns(10);
		
		JButton btnBuscarJ1 = new JButton("BUSCAR");
		btnBuscarJ1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarJugador1();
			}
		});
		
		txtjugador1 = new JTextField();
		txtjugador1.setColumns(10);
		
		JButton btnBuscarJ2 = new JButton("BUSCAR");
		btnBuscarJ2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarJugador2();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(10, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblEvasion_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textFieldEvasionJ2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblDefensa_1)
										.addComponent(lblEnergia_1)
										.addComponent(lblVida_1))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(textFieldEnergiaJ2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textFieldDefensaJ2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textFieldVidaJ2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblJugad)
									.addGap(18)
									.addComponent(txtjugador1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGap(48))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblTurnoJugador)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textFieldTurnoPersonaje, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(41)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNuevaPartida)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnAtacar, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textFieldPuntosAtaque, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnDefender)))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnBuscarJ2)))
					.addGap(138))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(236)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblJugador)
							.addGap(18)
							.addComponent(txtjugador2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnBuscarJ1)
							.addGap(12))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblVida)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(textFieldVidaJ1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblEnergia)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(lblEvasion)
											.addComponent(lblDefensa)))
									.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(textFieldEnergiaJ1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textFieldDefensaJ1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textFieldEvasionJ1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
							.addGap(98)))
					.addContainerGap(70, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblJugad)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(txtjugador1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnBuscarJ2)))
							.addGap(12)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblVida_1)
								.addComponent(textFieldVidaJ2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(6)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEnergia_1)
								.addComponent(textFieldEnergiaJ2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDefensa_1)
								.addComponent(textFieldDefensaJ2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(54)
							.addComponent(btnNuevaPartida)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnAtacar)
								.addComponent(textFieldPuntosAtaque, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(btnDefender)
							.addGap(32)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFieldTurnoPersonaje, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTurnoJugador)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(11)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEvasion_1)
								.addComponent(textFieldEvasionJ2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtjugador2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnBuscarJ1))
							.addGap(18))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblJugador)
							.addGap(18)))
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblVida)
						.addComponent(textFieldVidaJ1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnergia)
						.addComponent(textFieldEnergiaJ1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDefensa)
						.addComponent(textFieldDefensaJ1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEvasion)
						.addComponent(textFieldEvasionJ1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(33, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
		
	protected void defender() {
		
	}

	protected void buscarJugador1() {
		try {
			jugador1=ctrlCombate.getByNombre(txtjugador2.getText());
			JugadorSeleccionadoJ1(jugador1);
		} catch (ApplicationException e) {
			notifyUser("Jugador no registrado");
		}

	}
	
	protected void buscarJugador2() {
		try {
			jugador2=ctrlCombate.getByNombre(txtjugador1.getText());
			JugadorSeleccionadoJ2(jugador2);

		} catch (ApplicationException e) {
			notifyUser("Jugador no registrado");

		}
	}


	protected void setJugadorSeleccionado1(Propiedad_Persona p){
        ctrlCombate.setJugador1(p);
	}
	
	protected void setJugadorSeleccionado2(Propiedad_Persona p){
        ctrlCombate.setJugador2(p);
	}
	
	protected void JugadorSeleccionadoJ1(Propiedad_Persona p){
	    textFieldDefensaJ1.setText(Integer.toString(p.getDefensa()));
		textFieldEnergiaJ1.setText(Integer.toString(p.getEnergiaActual()));
		textFieldVidaJ1.setText(Integer.toString(p.getVidaActual()));
		textFieldEvasionJ1.setText(Integer.toString(p.getEvasion()));	
	}

	protected void JugadorSeleccionadoJ2(Propiedad_Persona p){
		textFieldDefensaJ2.setText(Integer.toString(p.getDefensa()));
		textFieldEnergiaJ2.setText(Integer.toString(p.getEnergiaActual()));
		textFieldVidaJ2.setText(Integer.toString(p.getVidaActual()));
		textFieldEvasionJ2.setText(Integer.toString(p.getEvasion()));	
	}

	protected void nuevaPartida() {
			try {
				ctrlCombate.Partido_Nuevo(jugador1,jugador2);
				JugadorSeleccionadoJ1(jugador1);
				JugadorSeleccionadoJ2(jugador2);
				mostrarTurnoPersonaje();	
			} catch (ApplicationException e) {
				notifyUser(e.getMessage());
				limpiarTurnoPersonaje();
			}
	}
	protected void atacar(){
		try {
			ctrlCombate.ataque(Integer.parseUnsignedInt(textFieldPuntosAtaque.getText()));
			
			Propiedad_Persona j1=ctrlCombate.getJugador1();
			Propiedad_Persona j2=ctrlCombate.getJugador2();
			
			JugadorSeleccionadoJ1(j1);
			JugadorSeleccionadoJ2(j2);
			
			if(!ctrlCombate.isFinCombate()){
				mostrarTurnoPersonaje();
			}else {
				notifyUser("partida finalizada");
				limpiarTurnoPersonaje();
			}
			
		} catch (NumberFormatException e) {
			notifyUser("ingrese un numero entero positivo");
			limpiarCampoPuntosAtaque();
		} catch (ApplicationException e) {
			notifyUser(e.getMessage());
		}
		limpiarCampoPuntosAtaque();

	}
	private void notifyUser(String mensaje) {
		JOptionPane.showMessageDialog(this.frame, mensaje);
    }
	
	protected void limpiarCampoPuntosAtaque(){
		textFieldPuntosAtaque.setText("");
	}
	
	protected void mostrarTurnoPersonaje(){
		textFieldTurnoPersonaje.setText(ctrlCombate.getJugadorTurnoActual().getNombre());

	}
	
	protected void limpiarTurnoPersonaje(){
		textFieldTurnoPersonaje.setText("");
	}
	
	
	protected void limpiarCamposNombres(){
		txtjugador2.setText("");
		txtjugador1.setText("");
	}

	
}


