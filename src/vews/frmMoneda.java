package vews;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import clases.aplicacion;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import java.awt.Font;
import java.awt.Frame;




public class frmMoneda extends JFrame {

	private JPanel contentPane;
	private JTextField txtIn;
	private JTextField txtOut;
	private JComboBox cboMonedaDe;
	private JComboBox cboMonedaA;
	private JButton btnCalc; 
	
	
	Object cboMoneda1, cboMoneda2;
	double  valorEntrada, valorSalida,
	PENtoPEN=1, USDtoPEN = 3.7742, EURtoPEN = 4.0235,GBPtoPEN = 4.5562, JPYtoPEN = 0.0280, KRWtoPEN = 0.0029,
	PENtoUSD = 0.2557,USDtoUSD=1, EURtoUSD = 1.0660,GBPtoUSD = 1.2071, JPYtoUSD = 0.0074, KRWtoUSD= 0.0007,
	PENtoEUR = 0.2398,USDtoEUR=0.9379, EURtoEUR = 1,GBPtoEUR = 1.1322, JPYtoEUR = 0.0069, KRWtoEUR= 0.0007,
	PENtoGBP = 0.2117,USDtoGBP=0.8282, EURtoGBP = 0.8830,GBPtoGBP = 1, JPYtoGBP = 0.0061, KRWtoGBP= 0.0006,
	PENtoJPY = 34.4382,USDtoJPY=134.684, EURtoJPY = 143.599,GBPtoJPY = 162.6, JPYtoJPY = 1, KRWtoJPY= 0.1034,
	PENtoKRW = 332.453,USDtoKRW=1300.18, EURtoKRW = 1386.06,GBPtoKRW = 1569.55, JPYtoKRW = 9.65228, KRWtoKRW= 1;
	private JButton btnMenuMoneda;
	private JButton btnSalir;


	/**
	 * Create the frame.
	 */
	public frmMoneda() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 297, 220);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 40, 263, 135);
		contentPane.add(panel);
		panel.setLayout(null);
		
		cboMonedaDe = new JComboBox();
		cboMonedaDe.setModel(new DefaultComboBoxModel(new String[] {"PEN", "USD", "EUR", "GBP", "JPY", "KRW"}));
		cboMonedaDe.setBounds(36, 31, 81, 22);
		panel.add(cboMonedaDe);
		
		JLabel lblNewLabel = new JLabel("DE:");
		lblNewLabel.setBounds(41, 11, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblA = new JLabel("A:");
		lblA.setBounds(141, 11, 46, 14);
		panel.add(lblA);
		
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
		txtIn.setBounds(36, 64, 86, 20);
		panel.add(txtIn);
		txtIn.setColumns(10);
		
		txtOut = new JTextField();
		txtOut.setEditable(false);
		txtOut.setColumns(10);
		txtOut.setBounds(136, 64, 81, 20);
		panel.add(txtOut);
		
		 btnCalc = new JButton("ACEPTAR");
		btnCalc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
				if (txtIn.getText().length()==0) {
				       JOptionPane.showMessageDialog(btnCalc, "INGRESAR UN VALOR");
				    }else {
				    	calculaCambioMoneda();
				    }		
			}
		});
		btnCalc.setBounds(86, 95, 89, 23);
		panel.add(btnCalc);
		
		 cboMonedaA = new JComboBox();
		 cboMonedaA.setModel(new DefaultComboBoxModel(new String[] {"PEN", "USD", "EUR", "GBP", "JPY", "KRW"}));
		 cboMonedaA.setBounds(135, 31, 81, 22);
		panel.add(cboMonedaA);
		
		btnMenuMoneda = new JButton("Menu");
		btnMenuMoneda.addActionListener(new ActionListener() {
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
		btnMenuMoneda.setBounds(10, 11, 68, 23);
		contentPane.add(btnMenuMoneda);
		btnMenuMoneda.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnMenuMoneda.setVerticalAlignment(SwingConstants.TOP);
		btnMenuMoneda.setHorizontalAlignment(SwingConstants.LEFT);
		
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
		btnSalir.setBounds(191, 10, 80, 23);
		contentPane.add(btnSalir);
	}

	public void calculaCambioMoneda() {
		
		
		valorEntrada = Double.parseDouble(txtIn.getText());
		cboMoneda1 = cboMonedaDe.getSelectedItem();
		cboMoneda2 = cboMonedaA.getSelectedItem();


		 switch ((String) cboMoneda1) {
		
		case "PEN":
			
			switch ((String) cboMoneda2) {

				case "PEN":
					valorSalida = valorEntrada*PENtoPEN;
					break;
				case "USD":
					valorSalida = valorEntrada * PENtoUSD;
					break;
				case "EUR":
					valorSalida = valorEntrada * PENtoEUR;
					break;
				case "GBP":
					valorSalida = valorEntrada * PENtoGBP;
					break;
				case "JPY":
					valorSalida = valorEntrada * PENtoJPY;
					break;
				case "KRW":
					valorSalida = valorEntrada * PENtoKRW;
					break;
			}
			break;
		case "USD":
			switch ((String) cboMoneda2) {
	
				case "PEN":
					valorSalida = valorEntrada * USDtoPEN;
					break;
				case "USD":
					valorSalida = valorEntrada*USDtoUSD;
					break;
				case "EUR":
					valorSalida = valorEntrada * USDtoEUR;
					break;
				case "GBP":
					valorSalida = valorEntrada * USDtoGBP;
					break;
				case "JPY":
					valorSalida = valorEntrada * USDtoJPY;
					break;
				case "KRW":
					valorSalida = valorEntrada * USDtoKRW;
					break;
			}
			break;
		case "EUR":
			switch ((String) cboMoneda2) {
			
				case "PEN":
					valorSalida = valorEntrada * EURtoPEN;
					break;
				case "USD":
					valorSalida = valorEntrada*EURtoUSD;
					break;
				case "EUR":
					valorSalida = valorEntrada * EURtoEUR;
					break;
				case "GBP":
					valorSalida = valorEntrada * EURtoGBP;
					break;
				case "JPY":
					valorSalida = valorEntrada * EURtoJPY;
					break;
				case "KRW":
					valorSalida = valorEntrada * EURtoKRW;
					break;
			}
			break;
		case "GBP":
			switch ((String) cboMoneda2) {
			
			case "PEN":
				valorSalida = valorEntrada * GBPtoPEN;
				break;
			case "USD":
				valorSalida = valorEntrada*GBPtoUSD;
				break;
			case "EUR":
				valorSalida = valorEntrada * GBPtoEUR;
				break;
			case "GBP":
				valorSalida = valorEntrada * GBPtoGBP;
				break;
			case "JPY":
				valorSalida = valorEntrada * GBPtoJPY;
				break;
			case "KRW":
				valorSalida = valorEntrada * GBPtoKRW;
				break;
		}
			break;
		case "JPY":
			switch ((String) cboMoneda2) {
			
			case "PEN":
				valorSalida = valorEntrada * JPYtoPEN;
				break;
			case "USD":
				valorSalida = valorEntrada*JPYtoUSD;
				break;
			case "EUR":
				valorSalida = valorEntrada * JPYtoEUR;
				break;
			case "GBP":
				valorSalida = valorEntrada * JPYtoGBP;
				break;
			case "JPY":
				valorSalida = valorEntrada * JPYtoJPY;
				break;
			case "KRW":
				valorSalida = valorEntrada * JPYtoKRW;
				break;
		}
			break;
		case "KRW":
			switch ((String) cboMoneda2) {
			
			case "PEN":
				valorSalida = valorEntrada * KRWtoPEN;
				break;
			case "USD":
				valorSalida = valorEntrada*KRWtoUSD;
				break;
			case "EUR":
				valorSalida = valorEntrada * KRWtoEUR;
				break;
			case "GBP":
				valorSalida = valorEntrada * KRWtoGBP;
				break;
			case "JPY":
				valorSalida = valorEntrada * KRWtoJPY;
				break;
			case "KRW":
				valorSalida = valorEntrada * KRWtoKRW;
				break;
		}
			break;

		}
		  DecimalFormat df = new DecimalFormat("###.####");
		txtOut.setText(String.valueOf(df.format(valorSalida))); 
		

	}
	


}
