import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JuegoAleatorioGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtNumero;
	private int num;
	private int intentos;
	private JLabel lblIntentos;
	private JLabel lblMensaje;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JuegoAleatorioGUI frame = new JuegoAleatorioGUI();
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
	public JuegoAleatorioGUI() {
		num = (int) (Math.random()*500+1);
		intentos=0;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 308);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][grow]", "[][][][][][][][][]"));
		
		JLabel lblNewLabel_1 = new JLabel("Acierta un n\u00FAmero entre 1 y 500");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		contentPane.add(lblNewLabel_1, "cell 1 0 2 1,alignx center,aligny center");
		
		JLabel lblNewLabel = new JLabel("Introduce el numero:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblNewLabel, "cell 1 2,alignx trailing");
		
		txtNumero = new JTextField();
		contentPane.add(txtNumero, "cell 2 2,growx");
		txtNumero.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Num intentos:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_2, "cell 1 4,alignx right");
		
		lblIntentos = new JLabel("");
		contentPane.add(lblIntentos, "cell 2 4");
		
		lblMensaje = new JLabel("");
		contentPane.add(lblMensaje, "cell 1 6 2 1");
		
		JButton btnNewButton = new JButton("Probar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comprobarNumero();
			}
		});
		contentPane.add(btnNewButton, "cell 0 8 3 1,alignx center,aligny center");
	}

	protected void comprobarNumero() {
		try {
			int dato = Integer.parseInt(txtNumero.getText());
			
			if (num>dato) {
				lblMensaje.setText("El numero a acertar es mayor");
			} else if (num<dato) {
				lblMensaje.setText("El número a acertar es menor");
			} else {
				lblMensaje.setText("Has acertado");
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Debes introducir un número enetero válido");
		}
		
		intentos++;
		lblIntentos.setText(""+intentos);
		
	}

}
