package modelo.facade;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.MarshalException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.UnmarshalException;
import javax.xml.bind.Unmarshaller;

import org.hibernate.Session;

import controlador.ExportarController;
import controlador.ImportarController;
import modelo.ProductoVO;
import modelo.ProductosVO;
import util.HibernateConexion;


public class ProductoFacade {

	public ProductoFacade() {
		
	}
	
	public static void marshal(ProductosVO stock) throws FileNotFoundException {
		
        try {
            JAXBContext ctx=JAXBContext.newInstance(ProductosVO.class);
            Marshaller ms=ctx.createMarshaller();
            ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            ms.marshal(stock,new File("stock_actualizado.xml"));
            
        } catch (MarshalException e) {
            Logger.getLogger(ExportarController.class.getName()).log(Level.SEVERE,"Error inesperado durante el marshalling",e);
            
        } catch (JAXBException f) {
            Logger.getLogger(ExportarController.class.getName()).log(Level.SEVERE,"Error inesperado durante el marshalling",f);
        }
    }

    public static ProductosVO unmarshal() throws FileNotFoundException {
    	   	
        try {
            JAXBContext ctx=JAXBContext.newInstance(ProductosVO.class);   
            Unmarshaller ums=ctx.createUnmarshaller();
            return (ProductosVO) ums.unmarshal(new File("src//main//resources//stock.xml"));
            
        } catch (UnmarshalException e) {
            Logger.getLogger(ImportarController.class.getName()).log(Level.SEVERE,"Error inesperado durante el unmarshalling",e);
            
        } catch (JAXBException f) {
            Logger.getLogger(ImportarController.class.getName()).log(Level.SEVERE,"Error inesperado durante el unmarshalling",f);
        }
        
        return null;
    }

    public static List<ProductoVO>importarListarProductos() {
    	
    	List<ProductoVO> listarProd=new ArrayList<>();
    	
		try {
			
			ProductosVO stock = unmarshal();
			
			
			 if (stock==null) {
		            Logger.getLogger(ProductoFacade.class.getName()).log(Level.INFO,"No hay datos en el archivo 'stock.xml'");
		            return new ArrayList<>();
			 }
			
			 listarProd=stock.getListaProductos();
			 
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			//Logger.getLogger(ImportarController.class.getName()).log(Level.SEVERE,"Error inesperado durante el unmarshalling",e);
		}
		
        return listarProd;
    }

    public static void exportarListaProductos(List<ProductoVO> listaStocks) {
    	
    	
    	ProductosVO stocks=new ProductosVO();
		stocks.setListaProductos(listaStocks);
		
		try {
			marshal(stocks);
			
			
		} catch (FileNotFoundException e) {
			Logger.getLogger(ImportarController.class.getName()).log(Level.SEVERE,"Error inesperado durante el unmarshalling",e);
		}
    }
	    
}
