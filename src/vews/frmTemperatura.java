package vews;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.aplicacion;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmTemperatura extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtIn;
	private JTextField txtOut;
	private JComboBox cboTemperaturaDe;
	private JComboBox cboTemperaturaA;

	Object cboTemperatura1, cboTemperatura2;
	double  valorEntrada, valorSalida;
	private JButton btnMenuTemperatura;
	private JButton btnSalir;

	/**
	 * Create the frame.
	 */
	public frmTemperatura() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 342, 225);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 45, 310, 132);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("DE:");
		lblNewLabel_1.setBounds(42, 11, 46, 14);
		panel.add(lblNewLabel_1);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setBounds(195, 11, 1, 1);
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.add(contentPane_1);

		
		JLabel lblNewLabel_2 = new JLabel("A:");
		lblNewLabel_2.setBounds(170, 11, 46, 14);
		panel.add(lblNewLabel_2);
		
		txtIn = new JTextField();
		txtIn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int key = e.getKeyChar();

			    boolean numeros = key >= 48 && key <= 57 || key ==46;
			        
			    if (!numeros){
			        e.consume();
			    }
    	
			    if (txtIn.getText().trim().length() == 10 ) {
			        e.consume();
			    }
			}
		});
		txtIn.setBounds(42, 66, 94, 20);
		panel.add(txtIn);
		txtIn.setColumns(10);
		
		txtOut = new JTextField();
		txtOut.setEditable(false);
		txtOut.setBounds(166, 66, 98, 20);
		panel.add(txtOut);
		txtOut.setColumns(10);
		
		cboTemperaturaDe = new JComboBox();
		cboTemperaturaDe.setModel(new DefaultComboBoxModel(new String[] {"CELSIUS", "FAHRENHEIT"}));
		cboTemperaturaDe.setBounds(42, 36, 109, 22);
		panel.add(cboTemperaturaDe);
		
		cboTemperaturaA = new JComboBox();
		cboTemperaturaA.setModel(new DefaultComboBoxModel(new String[] {"CELSIUS", "FAHRENHEIT"}));
		cboTemperaturaA.setBounds(166, 36, 109, 22);
		panel.add(cboTemperaturaA);
		
		JButton btnAceptar = new JButton("ACEPTAR");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtIn.getText().length()==0) {
				       JOptionPane.showMessageDialog(btnAceptar, "INGRESAR UN VALOR");
				    }else {
				    	calculaCambioTemperatura();
				    }	
				
			}
		});
		btnAceptar.setBounds(105, 97, 89, 23);
		panel.add(btnAceptar);
		
		btnMenuTemperatura = new JButton("Menu");
		btnMenuTemperatura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Object [] botones = { "IR AL MENU", "CANCELAR" };
					
					int variable = JOptionPane.showOptionDialog (null, " Quiere ir al menu ?", "Menu", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, botones, botones[0]);
					
					if (variable==0) {
						dispose();
						aplicacion app = new aplicacion();
						
						
					}
					
				} catch (Exception e2) {
					System.out.print(e2);
				}
			}
		});
		btnMenuTemperatura.setBounds(10, 11, 89, 23);
		contentPane.add(btnMenuTemperatura);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	try {
					
					Object [] botones = { "SALIR", "CONTINUAR" };
					
					int variable = JOptionPane.showOptionDialog (null, " Desea continuar ?", "SALIDA", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, botones, botones[0]);
					
					if (variable==0) {
						System.exit(0);
						
					}
					
				} catch (Exception e2) {
					System.out.print(e2);
				}
			}
		});
		btnSalir.setBounds(231, 11, 89, 23);
		contentPane.add(btnSalir);
	}
	public void calculaCambioTemperatura() {
		
		
		valorEntrada = Double.parseDouble(txtIn.getText());
		cboTemperatura1 = cboTemperaturaDe.getSelectedItem();
		cboTemperatura2 = cboTemperaturaA.getSelectedItem();

				//Fahrenheit a Celsius 		(°F - 32) x 5/9 =°C

				//Celsius a Fahrenheit		(°C x 9/5) + 32 =°F
		 switch ((String) cboTemperatura1) {
		
		case "CELSIUS":
			
			switch ((String) cboTemperatura2) {

				case "CELSIUS":
					valorSalida = valorEntrada;
					break;
				case "FAHRENHEIT":
					valorSalida = (valorEntrada*9/5+32);
					break;
				
			}
			break;
		case "FAHRENHEIT":
			switch ((String) cboTemperatura2) {
	
				case "CELSIUS":
					valorSalida = ((valorEntrada-32)*5/9);
					break;
				case "FAHRENHEIT":
					valorSalida = valorEntrada;
					break;
				
			}
			break;

		}
		  DecimalFormat df = new DecimalFormat("###.####");
		txtOut.setText(String.valueOf(df.format(valorSalida))); 
		

	}
}
