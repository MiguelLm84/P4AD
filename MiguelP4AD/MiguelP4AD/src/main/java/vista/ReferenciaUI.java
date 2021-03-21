package vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import modelo.ProductoVO;

public abstract class ReferenciaUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Referencia;
	private JTable table;
	private JButton btnBuscar;
	private JLabel lblErrorReferencia;
	
	public ReferenciaUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 709, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(32, 80, 632, 2);
		contentPane.add(separator);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 90, 632, 220);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel labelReferencia = new JLabel("Referencia");
		labelReferencia.setBounds(32, 13, 77, 14);
		contentPane.add(labelReferencia);
		
		lblErrorReferencia = new JLabel("Referencia incorrecta");
		lblErrorReferencia.setForeground(Color.RED);
		lblErrorReferencia.setVisible(false);
		lblErrorReferencia.setBounds(32, 51, 239, 16);
		contentPane.add(lblErrorReferencia);	
		
		textField_Referencia = new JTextField();
		textField_Referencia.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnBuscar.setEnabled(true);
		    }
		});
		textField_Referencia.setColumns(10);
		textField_Referencia.setBounds(32, 29, 223, 20);
		contentPane.add(textField_Referencia);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setEnabled(false);
		btnBuscar.setBounds(575, 28, 89, 23);		
		btnBuscar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	
		    	if(textField_Referencia.getText().isEmpty()) {
		    		lblErrorReferencia.setVisible(true);
				
				} else {
					recargarTabla();
				}
		    }
		});				
		contentPane.add(btnBuscar);
	}
	
	private void recargarTabla() {
		DefaultTableModel tm = new DefaultTableModel();
		tm.addColumn("Referencia");
		tm.addColumn("Nombre");
		tm.addColumn("Cantidad");
		tm.addColumn("Precio");
		tm.addColumn("ID");
		for (ProductoVO producto : listarTodolosProductos()) {
			if(producto.getReferencia().equals(textField_Referencia.getText())) {
				tm.addRow(new String[] { producto.getReferencia(), producto.getNombre(), String.valueOf(producto.getCantidad()), 
						String.valueOf(producto.getPrecio()),String.valueOf(producto.getId()) });
				
			} else {
				lblErrorReferencia.setVisible(true);
			}			
		}

		table.setModel(tm);
		table.removeColumn(table.getColumnModel().getColumn(4));
		table.getColumnModel().getColumn(0).setPreferredWidth(150);
		table.getColumnModel().getColumn(1).setPreferredWidth(250);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}

	protected abstract List<ProductoVO> listarTodolosProductos();
}
