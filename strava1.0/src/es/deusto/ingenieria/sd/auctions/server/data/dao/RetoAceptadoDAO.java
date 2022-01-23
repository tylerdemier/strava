package es.deusto.ingenieria.sd.auctions.server.data.dao;

import java.util.ArrayList;  
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import es.deusto.ingenieria.sd.auctions.server.data.domain.RetoAceptado;


//This class implements Singleton and DAO patterns
public class RetoAceptadoDAO extends DataAccessObjectBase implements IDataAccessObject<RetoAceptado> {

	private static RetoAceptadoDAO instance;	
	
	private RetoAceptadoDAO() { }
	
	public static RetoAceptadoDAO getInstance() {
		if (instance == null) {
			instance = new RetoAceptadoDAO();
		}		
		return instance;
	}
	
	@Override
	public void save(RetoAceptado object) {
		super.saveObject(object);
	}

	@Override
	public void delete(RetoAceptado object) {
		super.deleteObject(object);
	}

	@Override
	public List<RetoAceptado> getAll() {			
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		List<RetoAceptado> retos = new ArrayList<>();

		try {
			tx.begin();
			
			Extent<RetoAceptado> extent = pm.getExtent(RetoAceptado.class, true);

			for (RetoAceptado r : extent) {
				retos.add(r);
			}

			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error retrieving all the RetoAceptado: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return retos;
	}

	@Override
	public RetoAceptado find(String param) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		RetoAceptado result = null;

		try {
			tx.begin();
						
			Query<?> query = pm.newQuery("SELECT FROM " + RetoAceptado.class.getName() + " WHERE titulo == " + param);
			query.setUnique(true);			
			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error querying a Reto: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}		

		return result;
	}
}