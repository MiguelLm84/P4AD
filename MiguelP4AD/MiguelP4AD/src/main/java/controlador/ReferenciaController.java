package controlador;

import java.util.List;
import dao.ProductoDAO;
import modelo.ProductoVO;
import vista.ReferenciaUI;

public class ReferenciaController extends ReferenciaUI {

	@Override
	protected List<ProductoVO> listarTodolosProductos() {
		
		return ProductoDAO.listarTodo();
	}
}
