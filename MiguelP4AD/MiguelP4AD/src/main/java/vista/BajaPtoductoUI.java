package vista;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import modelo.ProductoVO;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public abstract class BajaPtoductoUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Referencia;
	private JTextField textField_Nombre;
	private JTextField textField_Cantidad;
	private JTextField textField_Precio;
	private JButton btn_eliminar;
	private JTable table;
	private Integer id;

	
	public BajaPtoductoUI() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 723, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
						
		JLabel labelReferencia = new JLabel("Referencia");
		labelReferencia.setBounds(33, 30, 77, 14);
		contentPane.add(labelReferencia);
		
		textField_Referencia = new JTextField();
		textField_Referencia.setBounds(33, 45, 190, 20);
		textField_Referencia.setColumns(10);
		contentPane.add(textField_Referencia);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(257, 28, 56, 14);
		contentPane.add(lblNombre);
		
		textField_Nombre = new JTextField();
		textField_Nombre.setBounds(258, 43, 272, 22);
		textField_Nombre.setColumns(10);
		contentPane.add(textField_Nombre);
		
		btn_eliminar = new JButton("Eliminar");
		btn_eliminar.setBounds(572, 44, 89, 23);
		btn_eliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (id != null) {
					int res = JOptionPane.showConfirmDialog(null,
							"El producto  se eliminará de forma permanente", "Eliminar",
							JOptionPane.OK_CANCEL_OPTION);
					if (res == JOptionPane.OK_OPTION) {
						bajaProducto(id);
						clearFields();
						recargarTabla();
					}
				}
			}
		});
		btn_eliminar.setEnabled(false);
		contentPane.add(btn_eliminar);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(33, 78, 56, 16);
		contentPane.add(lblCantidad);
		
		textField_Cantidad = new JTextField();
		textField_Cantidad.setBounds(33, 94, 122, 22);
		textField_Cantidad.setColumns(10);
		contentPane.add(textField_Cantidad);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(257, 78, 56, 16);
		contentPane.add(lblPrecio);
		
		textField_Precio = new JTextField();
		textField_Precio.setBounds(257, 95, 134, 22);
		textField_Precio.setColumns(10);
		contentPane.add(textField_Precio);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(33, 129, 634, 2);
		contentPane.add(separator);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 144, 634, 260);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btn_eliminar.setEnabled(true);
				textField_Referencia.setText((String) table.getModel().getValueAt(table.getSelectedRow(), 0));
				textField_Nombre.setText((String) table.getModel().getValueAt(table.getSelectedRow(), 1));
				textField_Cantidad.setText((String) table.getModel().getValueAt(table.getSelectedRow(), 2));
				textField_Precio.setText((String) table.getModel().getValueAt(table.getSelectedRow(), 3));				
				id = Integer.parseInt((String) table.getModel().getValueAt(table.getSelectedRow(), 4));
			}
		});
		scrollPane.setViewportView(table);

		recargarTabla();
		
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

	private void clearFields() {
		id = null;
		btn_eliminar.setEnabled(false);
		textField_Referencia.setText("");
		textField_Nombre.setText("");
		textField_Cantidad.setText("");
		textField_Precio.setText("");
		table.clearSelection();
	}

	protected abstract List<ProductoVO> listarTodolosProductos();

	protected abstract void bajaProducto(Integer id);
}
