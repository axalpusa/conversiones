package clases;

import javax.swing.JOptionPane;

import vews.frmMoneda;
import vews.frmTemperatura;

public class aplicacion {

	Object respuestaSelecion;

	public aplicacion() {
		ventanaMenuPrincipal();
	}

	public void ventanaMenuPrincipal() {
		try {
			Object[] opciones = { "CONVERSOR DE MONEDA", "CONVERSOR DE TEMPERATURA" };
			String lblSubTitulo = "SELECCIONE UNA OPCION DE CONVERSION";
			String lblTitulo = "CONVERION";
			respuestaSelecion = JOptionPane.showInputDialog(null, lblSubTitulo, lblTitulo, JOptionPane.INFORMATION_MESSAGE,
					null, opciones, null);

			opcionSelecionada(respuestaSelecion);

		} catch (Exception e) {
			System.out.print(e);	
		}

		
	}



	public void opcionSelecionada(Object respuestaSelecion) {
		try {
			if (respuestaSelecion.toString().contains("MONEDA")) {
				frmMoneda moneda = new frmMoneda();
				moneda.setVisible(true);
			} else if (respuestaSelecion.toString().contains("TEMPERATURA")) {
				frmTemperatura temperatura = new frmTemperatura();
				temperatura.setVisible(true);
			} 

		} catch (Exception e) {
			System.out.print(e);	
		}

		
		/**
		 * switch((String) respuestaSelecion) {
		 * 
		 * case "MONEDA": break; case "TEMPERATURA": break; case "PESO": break; case
		 * "LOINGITUD": break;
		 * 
		 * }
		 **/
	}
}
