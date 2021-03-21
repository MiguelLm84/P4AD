package controlador;

import java.util.List;

import dao.ProductoDAO;
import modelo.ProductoVO;
import vista.BajaPtoductoUI;

public class BajaController extends BajaPtoductoUI {
	
	@Override
	protected void bajaProducto(Integer id) {  

		ProductoDAO.borrarProducto(id);
	}
	
	@Override
	protected List<ProductoVO> listarTodolosProductos() {
		
		return ProductoDAO.listarTodo();
	}
}
