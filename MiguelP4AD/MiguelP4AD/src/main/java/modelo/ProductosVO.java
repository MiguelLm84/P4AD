package modelo;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="productos")
public class ProductosVO {
	private List<ProductoVO> listaProductos;
	
	public ProductosVO() {
		
	}

	public List<ProductoVO> getListaProductos() {
		return listaProductos;
	}

	@XmlElement(name="producto")
	public void setListaProductos(List<ProductoVO> listaProductos) {
		this.listaProductos = listaProductos;
	}
}
