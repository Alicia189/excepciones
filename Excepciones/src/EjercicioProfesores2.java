

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

import modelo.Profesor;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class EjercicioProfesores2 extends JFrame {

	private JPanel contentPane;
	private JTextField txtDni;
	private JTextField txtNombre;
	private JTextField txtSalario;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbFijo;
	private JRadioButton rdbTemporal;
	private ArrayList<Profesor> lista;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EjercicioProfesores2 frame = new EjercicioProfesores2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EjercicioProfesores2() {
		lista=new ArrayList<Profesor> ();
		setTitle("Profesores");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][grow][]", "[][][][]"));
		
		JLabel lblNewLabel = new JLabel("DNI:");
		contentPane.add(lblNewLabel, "cell 0 0,alignx trailing");
		
		txtDni = new JTextField();
		contentPane.add(txtDni, "cell 1 0,growx");
		txtDni.setColumns(10);
		
		JButton btnNewButton = new JButton("A\u00F1adir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					añadir();
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, 
							"Error el salario debe ser un valor numérico");
				}
			}
		});
		contentPane.add(btnNewButton, "cell 2 0");
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		contentPane.add(lblNewLabel_1, "cell 0 1,alignx trailing");
		
		txtNombre = new JTextField();
		contentPane.add(txtNombre, "cell 1 1,growx");
		txtNombre.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Limpiar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		contentPane.add(btnNewButton_1, "cell 2 1");
		
		JLabel lblNewLabel_2 = new JLabel("Salario:");
		contentPane.add(lblNewLabel_2, "cell 0 2,alignx trailing");
		
		txtSalario = new JTextField();
		contentPane.add(txtSalario, "cell 1 2,growx");
		txtSalario.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Buscar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					buscar();
				} catch (NoEncontradoException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
					//e1.printStackTrace();
				}
			}
		});
		contentPane.add(btnNewButton_2, "cell 2 2");
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Tipo contrato", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panel, "cell 0 3,grow");
		panel.setLayout(new MigLayout("", "[]", "[][]"));
		
		rdbFijo = new JRadioButton("Fijo");
		rdbFijo.setSelected(true);
		buttonGroup.add(rdbFijo);
		panel.add(rdbFijo, "cell 0 0");
		
		rdbTemporal = new JRadioButton("Temporal");
		buttonGroup.add(rdbTemporal);
		panel.add(rdbTemporal, "cell 0 1");
		
		JButton btnNewButton_3 = new JButton("Salir");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		contentPane.add(btnNewButton_3, "cell 2 3,alignx center");
	}

	protected void buscar() throws NoEncontradoException {
		Profesor p = new Profesor();
		p.setDni(txtDni.getText());
		
		int indice = lista.indexOf(p);
		if (indice==-1) {
			throw new NoEncontradoException(
					"No se ha encontrado el profesor de DNI "+p.getDni());
		}
		p=lista.get(indice);
		txtNombre.setText(p.getNombre());
		txtSalario.setText(""+p.getSalario());
		if (p.isFijo()) {
			rdbFijo.setSelected(true);
		} else {
			rdbTemporal.setSelected(true);
		}

		
	}

	protected void limpiar() {
		txtDni.setText(null);
		txtNombre.setText(null);
		txtSalario.setText(null);
		buttonGroup.clearSelection();
		rdbFijo.setSelected(true);
		
		
	}

	protected void añadir() {
		Profesor p = new Profesor();
		
		p.setNombre(txtNombre.getText());
		p.setDni(txtDni.getText());
		p.setSalario(Double.parseDouble(txtSalario.getText()));
		p.setFijo(rdbFijo.isSelected());
		lista.add(p);
	}

}
