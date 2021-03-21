package vista;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.ProductoDAO;
import modelo.ProductoVO;

import javax.swing.JLabel;
import javax.swing.JButton;

public abstract class ImportarUI extends JFrame {

	private JPanel contentPane;

	public ImportarUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 371, 176);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		List<ProductoVO> productos=importarProductos();
		
		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setBounds(222, 37, 98, 16);
		
		
		lblNewLabel_1.setText(""+productos.size());
		
		for (ProductoVO p : productos) {
			ProductoDAO.guardarProducto(p);
		}
				
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Total de productos importados: ");
		lblNewLabel.setBounds(33, 37, 184, 16);
		contentPane.add(lblNewLabel);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
			}
		});
		btnAceptar.setBounds(233, 80, 87, 25);
		contentPane.add(btnAceptar);
	}
	
	protected abstract List<ProductoVO> importarProductos();
}
