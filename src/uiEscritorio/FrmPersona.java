package uiEscritorio;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

//import entidades.Persona;
import entidades.Propiedad_Persona;
import negocio.Metodo_Personas;



public class FrmPersona {

	private JFrame frame;
	private JTextField textNombre;
	private JTextField textVida;
	private JTextField textEnergia;
	private JTextField textDefensa;
	private JTextField textEvasion;
	private Metodo_Personas ctrlPersonas;
	private JTextField textPuntosTotales;
	private JTextField textPuntosSinAsignar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPersona window = new FrmPersona();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**UiPersonajes
	 * Create the application.
	 */
	public FrmPersona() {
		initialize();
		ctrlPersonas=new Metodo_Personas();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 481, 349);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JLabel lblNombre = new JLabel("Nombre");
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		
		JLabel label = new JLabel("");
		
		JLabel lblEnergia = new JLabel("Energia");
		
		JLabel lblVida = new JLabel("Vida");
		
		JLabel lblNewLabel = new JLabel("Defensa");
		
		textVida = new JTextField();
		textVida.setColumns(10);
		
		textEnergia = new JTextField();
		textEnergia.setColumns(10);
		
		textDefensa = new JTextField();
		textDefensa.setColumns(10);
		
		textEvasion = new JTextField();
		textEvasion.setColumns(10);
		
		JButton btnAgregar = new JButton("Agregar");
		
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				agregar();
				
			}
		});

		JButton btnEliminar = new JButton("Eliminar");
		JButton btnModificar = new JButton("Modificar");
	    btnModificar.setVisible(false);
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modificar();
				btnAgregar.setEnabled(true);
				btnEliminar.setVisible(true);
				btnModificar.setVisible(true);
			}
		});
		
		btnEliminar.setVisible(false);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			    eliminar();
			    btnAgregar.setVisible(true);
			    btnEliminar.setVisible(false);
			    btnModificar.setVisible(false);
			}
		});
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				buscar();
				btnAgregar.setVisible(false);
				btnEliminar.setVisible(true);
				btnModificar.setVisible(true);
			}
		});
		
		JLabel lblPuntosTotales = new JLabel("Puntos Totales");
		
		textPuntosTotales = new JTextField();
		textPuntosTotales.setEditable(false);
		textPuntosTotales.setColumns(10);
		
		JLabel lblPuntosSinAsignar = new JLabel("Puntos sin asignar");
		
		textPuntosSinAsignar = new JTextField();
		textPuntosSinAsignar.setEditable(false);
		textPuntosSinAsignar.setColumns(10);
		
		JLabel lblEvasion = new JLabel("Evasion");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(48)
							.addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(btnAgregar)
							.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
							.addComponent(btnModificar, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(10)
									.addComponent(label))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(10)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(lblPuntosTotales)
													.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
													.addComponent(textPuntosTotales, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(lblPuntosSinAsignar)
													.addGap(10)
													.addComponent(textPuntosSinAsignar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(65)
											.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(10)
											.addComponent(lblNombre)
											.addGap(18)
											.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
									.addGap(31)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblVida)
										.addComponent(lblEnergia)
										.addComponent(lblNewLabel)
										.addComponent(lblEvasion))))
							.addGap(29)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textEnergia)
								.addComponent(textEvasion)
								.addComponent(textDefensa)
								.addComponent(textVida))))
					.addGap(126))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(43)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(6)
									.addComponent(lblNombre))
								.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(6)
							.addComponent(label)
							.addGap(3)
							.addComponent(btnBuscar)
							.addGap(37)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPuntosTotales)
								.addComponent(textPuntosTotales, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(21)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(3)
									.addComponent(lblPuntosSinAsignar))
								.addComponent(textPuntosSinAsignar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(52)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textVida, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblVida))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textEnergia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEnergia))
							.addGap(11)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textDefensa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel))
							.addGap(11)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textEvasion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEvasion))))
					.addGap(54)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnEliminar)
						.addComponent(btnAgregar)
						.addComponent(btnModificar)))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
	protected void modificar() {
		Propiedad_Persona p = new Propiedad_Persona();
		if(datosValidos()){
			p=MapearDeFormulario();
			if(p.Controlar_no_pasar_limites_de_punto()){
		    ctrlPersonas.update(p);
			limpiarCampos();
			} 
			else {
				 MessageError("La suma de los puntos asignados no puede superar los puntos totales\n------ Tope puntos defesa: 20 -----\n -------Tope puntos evasion: 80 -------");
			}
		}
	}	
	
	public Propiedad_Persona MapearDeFormulario(){
		Propiedad_Persona p = new Propiedad_Persona();
		p.setNombre(textNombre.getText());
		if(textDefensa.getText().trim().length()>0)
		{
			p.setDefensa(Integer.parseInt(textDefensa.getText()));
		} else {
			p.setDefensa(0) ;
		}
		if(textEnergia.getText().trim().length()>0) 
		{
			p.setEnergia(Integer.parseInt(textEnergia.getText()));
		} else {
			p.setEnergia(0);
		}
		if(textEvasion.getText().trim().length()>0) 
		{
			p.setEvasion(Integer.parseInt(textEvasion.getText()));
			} else {
				p.setEvasion(0);
			}
		if(textVida.getText().trim().length()>0)    
		{p.setVida(Integer.parseInt(textVida.getText()));      
		} else {
			p.setVida(0);
		}
	
		return p;
	}
	

	public void MapearAformulario(Propiedad_Persona p){
		textNombre.setText(p.getNombre());
		textDefensa.setText(Integer.toString(p.getDefensa()));
		textEnergia.setText(Integer.toString(p.getEnergia()));
		textVida.setText(Integer.toString(p.getVida()));
		textEvasion.setText(Integer.toString(p.getEvasion()));
		textPuntosTotales.setText(Integer.toString(p.getPuntosTotales()));
		textPuntosSinAsignar.setText(Integer.toString(p.getPuntosTotales()-(p.getDefensa()+p.getEnergia()+p.getEvasion()+p.getVida())));
	}
	public void limpiarCampos(){
		textNombre.setText("");
		textDefensa.setText("");
		textEnergia.setText("");
		textVida.setText("");
		textEvasion.setText("");
		textPuntosTotales.setText("");
		textPuntosSinAsignar.setText("");
	}
	public boolean datosValidos(){
		boolean valido=true;
		if(textNombre.getText().trim().length()==0
		   ||textDefensa.getText().trim().length()==0	
		   ||textEnergia.getText().trim().length()==0
		   ||textVida.getText().trim().length()==0
		   ||textEvasion.getText().trim().length()==0){
			valido=false;
			MessageError("Complete los campos faltantes");
		
		}

		if(valido && (!textDefensa.getText().matches("[0-9]*")
		   || !textEnergia.getText().matches("[0-9]*")
		   || !textVida.getText().matches("[0-9]*")
		   || !textEvasion.getText().matches("[0-9]*"))){
			valido=false;
			MessageError("Solamente se aceptan numeros enteros");
			textDefensa.setText("");
			textEnergia.setText("");
			textVida.setText("");
			textEvasion.setText("");
		}
		return valido;
	}
	
	private void MessageError(String Message) {
		JOptionPane.showMessageDialog(this.frame, Message);
    }

	protected void agregar() {
		Propiedad_Persona p=new Propiedad_Persona();
		
		if(datosValidos()){
		p=MapearDeFormulario();
		if(p.Controlar_no_pasar_limites_de_punto()){
		   ctrlPersonas.Save(p);
		   limpiarCampos();
		   }else{
			     MessageError("La suma de los puntos asignados no puede superar los puntos totales\n------ Tope puntos defesa: 20 -----\n -------Tope puntos evasion: 80 -------");
		   }
		}
	}
	protected void buscar() {
		Propiedad_Persona Personas=ctrlPersonas.getByNombre(MapearDeFormulario());
		if(Personas!=null)
			{
				MapearAformulario(Personas);
			}
		else 
			{
				MessageError("Persona no encontrado");
			}
	}
	protected void eliminar() {
		ctrlPersonas.delete(MapearDeFormulario());
		limpiarCampos();
	}
}
        
	