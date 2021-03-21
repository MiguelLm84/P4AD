package controlador;

import java.util.List;

import modelo.ProductoVO;
import modelo.facade.ProductoFacade;
import vista.ImportarUI;


public class ImportarController extends ImportarUI {

	@Override
	protected List<ProductoVO> importarProductos() {
		
		return ProductoFacade.importarListarProductos();
	}
}
