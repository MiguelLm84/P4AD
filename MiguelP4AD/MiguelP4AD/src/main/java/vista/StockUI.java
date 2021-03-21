package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controlador.AltaController;
import controlador.BajaController;
import controlador.ExportarController;
import controlador.ImportarController;
import controlador.ListarController;
import controlador.ReferenciaController;
import controlador.StockController;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.SwingConstants;

public abstract class StockUI extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		
		StockController stockController=new StockController();
		stockController.show();
	}

	public StockUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTituloMenu = new JLabel("MENÚ STOCK ");
		lblTituloMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloMenu.setForeground(Color.BLACK);
		lblTituloMenu.setFont(new Font("Myanmar Text", Font.BOLD, 14));
		lblTituloMenu.setBounds(26, 13, 377, 33);
		contentPane.add(lblTituloMenu);
		
		JButton btn_altaProducto = new JButton("Alta Producto");
		btn_altaProducto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
				altaProductos();
			}
		});
		btn_altaProducto.setBounds(26, 59, 120, 25);
		contentPane.add(btn_altaProducto);
		
		JButton btn_bajaProducto = new JButton("Baja Producto");
		btn_bajaProducto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
				bajaProducto();
			}
		});
		btn_bajaProducto.setBounds(169, 59, 120, 25);
		contentPane.add(btn_bajaProducto);
		
		JButton btn_ObtenerProdRef = new JButton("Referencia");
		btn_ObtenerProdRef.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
				productoPorReferencia();
			}
		});
		btn_ObtenerProdRef.setBounds(306, 59, 97, 25);
		contentPane.add(btn_ObtenerProdRef);
		
		JButton btn_listarProductos = new JButton("Listar");
		btn_listarProductos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
				listarProductos();
			}
		});
		btn_listarProductos.setBounds(26, 112, 120, 25);
		contentPane.add(btn_listarProductos);
		
		JButton btn_importarProductos = new JButton("Importar");
		btn_importarProductos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
				importarProductos();
			}
		});
		btn_importarProductos.setBounds(169, 112, 120, 25);
		contentPane.add(btn_importarProductos);
		
		JButton btn_exportarProductos = new JButton("Exportar");
		btn_exportarProductos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
				exportarProductos();
			}
		});
		btn_exportarProductos.setBounds(306, 112, 97, 25);
		contentPane.add(btn_exportarProductos);
		
		JButton btn_salir = new JButton("Salir");
		btn_salir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
				System.exit(EXIT_ON_CLOSE);
			}
		});
		btn_salir.setBounds(306, 178, 97, 25);
		contentPane.add(btn_salir);
	}
	
	private void altaProductos() {

		AltaController altaController=new AltaController();
		altaController.show();
	}
	
	private void bajaProducto() {

		BajaController bajaController=new BajaController();
		bajaController.show();
	}
	
	private void productoPorReferencia() {

		ReferenciaController referenciaController=new ReferenciaController();
		referenciaController.show();
	}
	
	private void listarProductos() {

		ListarController listarController=new ListarController();
		listarController.show();
		
	}
	
	private void importarProductos() {
		
		ImportarController importarController=new ImportarController();
		importarController.show();
		
	}
	
	private void exportarProductos() {

		ExportarController exportarController=new ExportarController();
		exportarController.show();
		
	}
}
