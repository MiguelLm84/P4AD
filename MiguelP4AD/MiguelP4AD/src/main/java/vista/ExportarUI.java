package vista;

import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import dao.ProductoDAO;
import modelo.ProductoVO;

public abstract class ExportarUI extends JFrame {

	private JPanel contentPane;

	public ExportarUI() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 371, 176);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		List<ProductoVO> listaStocks = ProductoDAO.listarTodo();
		transformarListaVOparaExportar(listaStocks);
		
		
		JLabel lblNewLabel_1 = new JLabel();
		
		for(int i=0;i<listaStocks.size();i++) {
			lblNewLabel_1.setText(""+i);
		}		
		
		lblNewLabel_1.setBounds(222, 37, 98, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Total de productos exportados: ");
		lblNewLabel.setBounds(33, 37, 184, 16);
		contentPane.add(lblNewLabel);
	}

	protected abstract void transformarListaVOparaExportar(List<ProductoVO> listaStocks);
}
