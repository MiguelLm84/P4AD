package vista;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import modelo.ProductoVO;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.List;

public abstract class ListarUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	
	public ListarUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 723, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(33, 81, 632, 2);
		contentPane.add(separator);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 96, 632, 305);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);

		recargarTabla();
		
		JLabel lblListaDeProductos = new JLabel("LISTA DE PRODUCTOS EN STOCK");
		lblListaDeProductos.setForeground(Color.BLACK);
		lblListaDeProductos.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblListaDeProductos.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaDeProductos.setBackground(Color.WHITE);
		lblListaDeProductos.setBounds(33, 48, 633, 16);
		contentPane.add(lblListaDeProductos);
	}
	
	private void recargarTabla() {
		DefaultTableModel tm = new DefaultTableModel();
		tm.addColumn("Referencia");
		tm.addColumn("Nombre");
		tm.addColumn("Cantidad");
		tm.addColumn("Precio");
		tm.addColumn("ID");
		for (ProductoVO producto : listarTodolosProductos()) {
			tm.addRow(new String[] { producto.getReferencia(), producto.getNombre(), String.valueOf(producto.getCantidad()), 
					String.valueOf(producto.getPrecio()),String.valueOf(producto.getId()) });
		}

		table.setModel(tm);
		table.removeColumn(table.getColumnModel().getColumn(4));
		table.getColumnModel().getColumn(0).setPreferredWidth(150);
		table.getColumnModel().getColumn(1).setPreferredWidth(250);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}

	protected abstract List<ProductoVO> listarTodolosProductos();
}
