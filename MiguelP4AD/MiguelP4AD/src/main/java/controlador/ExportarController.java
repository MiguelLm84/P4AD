package controlador;

import java.util.List;

import modelo.ProductoVO;
import modelo.facade.ProductoFacade;
import vista.ExportarUI;

public class ExportarController extends ExportarUI {
	
	@Override
	protected void transformarListaVOparaExportar(List<ProductoVO> listaStocks) {
		
		ProductoFacade.exportarListaProductos(listaStocks);
	}
}
