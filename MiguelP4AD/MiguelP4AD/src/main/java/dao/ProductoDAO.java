package dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.service.spi.ServiceException;
import modelo.ProductoVO;
import util.HibernateConexion;

public class ProductoDAO {
	
	public static List<ProductoVO> listarTodo() {
		
        final List<ProductoVO> productos = new ArrayList<>();
        final String query = "SELECT p FROM ProductoVO p";
        try (Session session = HibernateConexion.getSessionFactory().openSession()) {
        	productos.addAll(session.createQuery(query, ProductoVO.class).getResultList());
        	
        } catch (ServiceException e) {
        	System.out.println("Error, no se han podido mostar los productos por un fallo de conexión con la BD.");
        	e.printStackTrace();
        	
        } 
        
        return productos;
	}
	
	public static ProductoVO mostrarPorReferencia(final String referencia) {
		
		ProductoVO producto = null;
        final String query = "SELECT p FROM ProductoVO p WHERE p.referencia = '" + referencia + "'";
        try (Session session = HibernateConexion.getSessionFactory().openSession()) {
            producto = session.createQuery(query, ProductoVO.class).getSingleResult();
            
        } catch (ServiceException e) {
        	System.out.println("Error, no se han podido mostar los productos por un fallo de conexión con la BD.");
        	e.printStackTrace();
        	
        } 
        
        return producto;
	}
	
	public static void guardarProducto(final ProductoVO producto) {
		
        try (Session session = HibernateConexion.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(producto);
            session.getTransaction().commit();
            
            
        } catch (ServiceException e) {
        	System.out.println("Error, no se ha podido guardar el producto por un fallo de conexión con la BD.");
        	e.printStackTrace();
        	
        } 
	}
	
	/*public static void borrarProducto(final ProductoVO producto) {
	 
        try (Session session = HibernateConexion.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(producto);
            session.getTransaction().commit();
            
        } catch (ServiceException e) {
        	System.out.println("Error, no se ha podido dar de baja el producto por un fallo de conexión con la BD.");
        	e.printStackTrace();
        	
        } 
	}*/
	
	public static void borrarProducto(final Integer id) {
		
        final String query = "DELETE FROM ProductoVO p WHERE p.id=" + id;
        try (Session session = HibernateConexion.getSessionFactory().openSession()) {
        	 session.beginTransaction();
        	 session.createQuery(query).executeUpdate();
        	 session.getTransaction().commit();
            
        } catch (ServiceException e) {
        	System.out.println("Error, no se ha podido dar de baja el producto por un fallo de conexión con la BD.");
        	e.printStackTrace();
        	
        } 
	}
}
