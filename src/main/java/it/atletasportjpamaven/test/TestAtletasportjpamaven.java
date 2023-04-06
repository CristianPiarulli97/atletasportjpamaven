package it.atletasportjpamaven.test;

import java.time.LocalDate;

import it.atletasportjpamaven.dao.EntityManagerUtil;
import it.atletasportjpamaven.model.Atleta;
import it.atletasportjpamaven.model.Sport;
import it.atletasportjpamaven.service.AtletaService;
import it.atletasportjpamaven.service.MyServiceFactory;
import it.atletasportjpamaven.service.SportService;

public class TestAtletasportjpamaven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SportService sportServiceInstance = MyServiceFactory.getSportServiceInstance();
		AtletaService atletaServiceInstance = MyServiceFactory.getAtletaServiceInstance();

		// ora passo alle operazioni CRUD
		try {

		//	PROBLEMA 
		//testInserisciNuovoSport(sportServiceInstance);
			
		testInserisciNuovoAtleta(atletaServiceInstance);
			
			

			
			
			
			

		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			// questa è necessaria per chiudere tutte le connessioni quindi rilasciare il
			// main
			EntityManagerUtil.shutdown();
		}
		
	}
		
		
	private static void testInserisciNuovoAtleta(AtletaService atletaServiceInstance) throws Exception {
		System.out.println("-----TEST testInserisciNuovoAtleta INIZIO-----");
		Atleta nuovoAtleta = new Atleta("Cristian", "Piarulli", LocalDate.of(1997, 01, 25), 0001, 71);
		atletaServiceInstance.inserisciNuovo(nuovoAtleta);
		if (nuovoAtleta.getId() == null) {
			throw new RuntimeException("testInserisciNuovoAtleta FALLITO: atleta non inserito.");
		}
		System.out.println("-----TEST testInserisciNuovoAtleta FINE-----");
	}
	
	
	private static void testInserisciNuovoSport(SportService sportServiceInstance) throws Exception {
		System.out.println(".......testInserisciNuovoUtente inizio.............");

		Sport sportNuovo = new Sport("Calcio", LocalDate.of(1850,01,25), null);
		sportServiceInstance.inserisciNuovo(sportNuovo);
		if (sportNuovo.getId() == null)
			throw new RuntimeException("testInserisciNuovoUtente fallito ");

		System.out.println(".......testInserisciNuovoUtente fine: PASSED.............");
	}

	
	
		
		
	
		
		
		
	

}
