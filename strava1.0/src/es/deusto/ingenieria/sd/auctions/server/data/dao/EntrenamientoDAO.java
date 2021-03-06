package es.deusto.ingenieria.sd.auctions.server.data.dao;

import java.util.ArrayList; 
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import es.deusto.ingenieria.sd.auctions.server.data.domain.Entrenamiento;
import es.deusto.ingenieria.sd.auctions.server.data.domain.User;

public class EntrenamientoDAO extends DataAccessObjectBase implements IDataAccessObject<Entrenamiento> {

	private static EntrenamientoDAO instance;	
	
	private EntrenamientoDAO() { }
	
	public static EntrenamientoDAO getInstance() {
		if (instance == null) {
			instance = new EntrenamientoDAO();
		}		
		
		return instance;
	}

	@Override
	public void save(Entrenamiento object) {
		super.saveObject(object);
		
	}

	@Override
	public void delete(Entrenamiento object) {
		super.deleteObject(object);
		
	}

	@Override
	public List<Entrenamiento> getAll() {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		List<Entrenamiento> entrenamientos = new ArrayList<>();

		try {
			tx.begin();
			
			Extent<Entrenamiento> extent = pm.getExtent(Entrenamiento.class, true);

			for (Entrenamiento e : extent) {
				entrenamientos.add(e);
			}

			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error retrieving all the Entrensamientos: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
		return entrenamientos;
	}

	@Override
	public Entrenamiento find(String param) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		Entrenamiento result = null; 

		try {
			tx.begin();
			
			Query<?> query = pm.newQuery("SELECT FROM " + Entrenamiento.class.getName() + " WHERE titulo == '" + param + "'");
			query.setUnique(true);
			result = (Entrenamiento) query.execute();
			
			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error querying a Entrenamiento: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return result;
	}
	
}
