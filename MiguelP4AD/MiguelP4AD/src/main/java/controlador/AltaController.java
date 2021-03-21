package controlador;

import dao.ProductoDAO;
import modelo.ProductoVO;
import vista.AltaProductoUI;


public class AltaController extends AltaProductoUI {

	@Override
	protected void altaProducto(String referencia, String nombre, String descripcion, int cantidad, float precio) {

		ProductoVO producto = new ProductoVO(referencia, nombre, referencia, cantidad,precio);
		ProductoDAO.guardarProducto(producto);
	}
}
