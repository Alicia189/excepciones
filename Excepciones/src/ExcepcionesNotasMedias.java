

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Alumno;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ExcepcionesNotasMedias extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtNota1;
	private JTextField txtNota2;
	private JTextField txtNota3;
	private JLabel lblPromedio;
	private JLabel lblResultado;
	private ArrayList<Alumno> listaAlumnos;
	private JTable tablaAlumnos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExcepcionesNotasMedias frame = new ExcepcionesNotasMedias();
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
	public ExcepcionesNotasMedias() {
		listaAlumnos = new ArrayList<Alumno>();
		setTitle("C\u00E1lculo de Promedio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("CALCULAR PROMEDIO");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[69.00,grow][grow][52.00,grow][80.00,grow][40][grow]", "[][][][][][81.00,grow]"));
		
		JLabel lblNewLabel_1 = new JLabel("Nombre: ");
		panel.add(lblNewLabel_1, "cell 0 0,alignx trailing");
		
		txtNombre = new JTextField();
		panel.add(txtNombre, "cell 1 0 5 1,growx");
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nota 1:");
		panel.add(lblNewLabel_2, "cell 0 1,alignx trailing");
		
		txtNota1 = new JTextField();
		panel.add(txtNota1, "cell 1 1,growx");
		txtNota1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Nota 2:");
		panel.add(lblNewLabel_3, "cell 2 1,alignx trailing");
		
		txtNota2 = new JTextField();
		panel.add(txtNota2, "cell 3 1,growx");
		txtNota2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Nota 3:");
		panel.add(lblNewLabel_4, "cell 4 1,alignx trailing");
		
		txtNota3 = new JTextField();
		panel.add(txtNota3, "cell 5 1,growx");
		txtNota3.setColumns(10);
		
		JButton btnNewButton = new JButton("Mostrar Datos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarLista();
			}
		});
		panel.add(btnNewButton, "cell 1 2");
		
		JButton btnCalcular = new JButton("Calcular e insertar");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					calcular();
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null,
							"Comprueba las notas. Deben ser un número válido" );
				}
			}
		});
		panel.add(btnCalcular, "cell 3 2 2 1");
		
		JLabel lblNewLabel_5 = new JLabel("Promedio: ");
		panel.add(lblNewLabel_5, "cell 0 3");
		
		lblPromedio = new JLabel("");
		panel.add(lblPromedio, "cell 1 3 5 1");
		
		JLabel lblNewLabel_6 = new JLabel("Resultado:");
		panel.add(lblNewLabel_6, "cell 0 4");
		
		lblResultado = new JLabel("");
		panel.add(lblResultado, "cell 1 4 5 1");
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, "cell 0 5 6 1,grow");
		
		tablaAlumnos = new JTable();
		tablaAlumnos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Nota 1", "Nota 2", "Nota 3", "Nota media"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Double.class, Double.class, Double.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(tablaAlumnos);
	}
	


	protected void mostrarLista() {
	
		DefaultTableModel modelo = (DefaultTableModel) tablaAlumnos.getModel();
		modelo.setRowCount(0);
		for (Alumno alumno : listaAlumnos) {
			Object fila [] = {
					alumno.getNombre(), alumno.getNota1(), alumno.getNota2(),
					alumno.getNota3(), alumno.getNotaMedia()
			};
			modelo.addRow(fila);
		}
	}

	public void calcular () {
		String nombre = txtNombre.getText();
			double nota1 = Double.parseDouble(txtNota1.getText());
			double nota2 = Double.parseDouble(txtNota2.getText());
			double nota3 = Double.parseDouble(txtNota3.getText());
			
			Alumno al = new Alumno(nombre,nota1,nota2,nota3);
			listaAlumnos.add(al);
			
			
			lblPromedio.setText( String.format("%.2f",al.getNotaMedia()) );
			
			if (al.getNotaMedia()>=5) {
				lblResultado.setText(nombre + " ha superado la asignatura");
			} else {
				lblResultado.setText(nombre + ", toca recuperar");
			}
		mostrarLista();
		
		
	}

}
