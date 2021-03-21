package vista;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public abstract class AltaProductoUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField_referencia;
	private JTextField textField_nombre;
	private JTextField textField_cantidad;
	private JTextField textField_precio;
	private JTextField textField_descipcion;
	private JLabel lblErrorReferencia;
	private JLabel lblErrorNombre;
	private JLabel lblErrorCantidad;
	private JLabel lblErrorPrecio;
	

	public AltaProductoUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 698, 329);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblErrorReferencia = new JLabel("Referencia incorrecta");
		lblErrorReferencia.setForeground(Color.RED);
		lblErrorReferencia.setVisible(false);
		lblErrorReferencia.setBounds(23, 72, 137, 16);
		contentPane.add(lblErrorReferencia);
		
		lblErrorNombre = new JLabel("Precio incorrecto");
		lblErrorNombre.setForeground(Color.RED);
		lblErrorNombre.setVisible(false);
		lblErrorNombre.setBounds(557, 72, 98, 16);
		contentPane.add(lblErrorNombre);
		
		lblErrorCantidad = new JLabel("El nombre introducido no es correcto");
		lblErrorCantidad.setForeground(Color.RED);
		lblErrorCantidad.setVisible(false);
		lblErrorCantidad.setBounds(160, 72, 263, 16);
		contentPane.add(lblErrorCantidad);
		
		lblErrorPrecio = new JLabel("Valor incorrecto");
		lblErrorPrecio.setForeground(Color.RED);
		lblErrorPrecio.setVisible(false);
		lblErrorPrecio.setBounds(447, 72, 98, 16);
		contentPane.add(lblErrorPrecio);
		
		JLabel lbl_tituloReferencia = new JLabel("Referencia");
		lbl_tituloReferencia.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_tituloReferencia.setBounds(23, 26, 86, 16);
		contentPane.add(lbl_tituloReferencia);
		
		textField_referencia = new JTextField();
		textField_referencia.setBounds(23, 48, 106, 22);
		contentPane.add(textField_referencia);
		textField_referencia.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(160, 26, 56, 16);
		contentPane.add(lblNombre);
		
		textField_nombre = new JTextField();
		textField_nombre.setBounds(160, 48, 263, 22);
		contentPane.add(textField_nombre);
		textField_nombre.setColumns(10);
		
		if(textField_nombre.getText() == null) {
			lblErrorNombre.setVisible(true);
		}
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(447, 26, 56, 16);
		contentPane.add(lblCantidad);
		
		textField_cantidad = new JTextField();
		textField_cantidad.setBounds(447, 48, 86, 22);
		contentPane.add(textField_cantidad);
		textField_cantidad.setColumns(10);
		
		if(textField_cantidad.getText() == null) {
			lblErrorCantidad.setVisible(true);
		}
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(557, 26, 56, 16);
		contentPane.add(lblPrecio);
		
		textField_precio = new JTextField();
		textField_precio.setBounds(557, 48, 98, 22);
		contentPane.add(textField_precio);
		textField_precio.setColumns(10);
		
		if(textField_precio.getText() == null) {
			lblErrorPrecio.setVisible(true);
		}
		
		JLabel lblDescripcin = new JLabel("Descripción");
		lblDescripcin.setBounds(23, 101, 76, 16);
		contentPane.add(lblDescripcin);
		
		textField_descipcion = new JTextField();
		textField_descipcion.setBounds(23, 119, 632, 112);
		contentPane.add(textField_descipcion);
		textField_descipcion.setColumns(10);
		
		JButton btn_guardar = new JButton("Añadir");
		btn_guardar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	
		    	limpiarMensajesDeError();
		    	
				if(textField_referencia != null && textField_nombre.getText() != null && textField_cantidad.getText() != null
						&& textField_precio.getText() != null) {
					
					try {
						altaProducto(textField_referencia.getText(), textField_nombre.getText(), textField_descipcion.getText(),
								Integer.parseInt(textField_cantidad.getText()), Float.parseFloat(textField_precio.getText()));
						
					} catch (NumberFormatException e1) {
						lblErrorReferencia.setVisible(true);
						lblErrorNombre.setVisible(true);
						lblErrorCantidad.setVisible(true);
						lblErrorPrecio.setVisible(true);
						
					} catch (Exception e1) {
						lblErrorReferencia.setVisible(true);
						lblErrorNombre.setVisible(true);
						lblErrorCantidad.setVisible(true);
						lblErrorPrecio.setVisible(true);						
					}
					
				} else {
					lblErrorReferencia.setVisible(true);
					lblErrorNombre.setVisible(true);
					lblErrorCantidad.setVisible(true);
					lblErrorPrecio.setVisible(true);
				}
			}
		});
		btn_guardar.setBounds(569, 244, 86, 25);
		contentPane.add(btn_guardar);
	}
	
	public void limpiarMensajesDeError() {
		lblErrorReferencia.setVisible(false);
		lblErrorNombre.setVisible(false);
		lblErrorCantidad.setVisible(false);
		lblErrorPrecio.setVisible(false);
		
	}

	protected abstract void altaProducto(String referencia, String nombre, String descripcion, int cantidad, float precio);
		
}
