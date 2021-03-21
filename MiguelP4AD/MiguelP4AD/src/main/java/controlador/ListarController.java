package controlador;

import java.util.List;

import dao.ProductoDAO;
import modelo.ProductoVO;
import vista.ListarUI;

public class ListarController extends ListarUI{

	@Override
	protected List<ProductoVO> listarTodolosProductos() {
		
		return ProductoDAO.listarTodo();
	}
}
