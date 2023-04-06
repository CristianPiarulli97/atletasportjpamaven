package it.atletasportjpamaven.test;

import java.time.LocalDate;
import java.util.List;

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

		//	testInserisciNuovoSport(sportServiceInstance);
			
		//	testInserisciNuovoAtleta(atletaServiceInstance);
			
		//	testDeleteAtleta(atletaServiceInstance);

		//  testUpdateAtleta(atletaServiceInstance);
			
		//	System.out.println(atletaServiceInstance.listAll());
		//	System.out.println(sportServiceInstance.listAll());
			
			

		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			// questa è necessaria per chiudere tutte le connessioni quindi rilasciare il
			// main
			EntityManagerUtil.shutdown();
		}
		
	}
		
		
	private static void testInserisciNuovoAtleta(AtletaService atletaServiceInstance) throws Exception {
		System.out.println("-----TEST Test InserisciNuovoAtleta INIZIO-----");
		Atleta nuovoAtleta = new Atleta("Cristian", "Piarulli", LocalDate.of(1997, 01, 25), 0001, 71);
		atletaServiceInstance.inserisciNuovo(nuovoAtleta);
		if (nuovoAtleta.getId() == null) {
			throw new RuntimeException("testInserisciNuovoAtleta FALLITO: atleta non inserito.");
		}
		System.out.println("-----Fine Test InserisciNuovoAtleta-----");
	}
	
	
	private static void testInserisciNuovoSport(SportService sportServiceInstance) throws Exception {
		System.out.println(".......testInserisciNuovoUtente inizio.............");

		Sport sportNuovo = new Sport("Tennis", LocalDate.of(1910,04,24), null);
		sportServiceInstance.inserisciNuovo(sportNuovo);
		if (sportNuovo.getId() == null)
			throw new RuntimeException("testInserisciNuovoUtente fallito ");

		System.out.println(".......testInserisciNuovoUtente fine: PASSED.............");
	}
	
	private static void testDeleteAtleta(AtletaService atletaServiceInstance) throws Exception {
		System.out.println("-----TEST testDeleteAtleta INIZIO-----");
		List<Atleta> listaAtletiPrimaDellaRimozione = atletaServiceInstance.listAll();
		if (listaAtletiPrimaDellaRimozione.size() < 1)
			throw new RuntimeException("testDeleteAtleta FALLITO: non sono presenti atleti in lista.");

		// inserisco un atleta per poi eliminarlo
		Atleta nuovoAtleta = new Atleta("Ciro", "Immobile", LocalDate.of(1990, 02, 11), 38, 5);
		atletaServiceInstance.inserisciNuovo(nuovoAtleta);
		if (nuovoAtleta.getId() == null) {
			throw new RuntimeException("testDeleteAtleta FALLITO: atleta non inserito.");
		}
		atletaServiceInstance.rimuovi(nuovoAtleta.getId());
		List<Atleta> listaAtletiDopoDellaRimozione = atletaServiceInstance.listAll();
		if (listaAtletiPrimaDellaRimozione.size() != listaAtletiDopoDellaRimozione.size())
			throw new RuntimeException("testDeleteAtleta FALLITO: atleta non rimosso.");
		System.out.println("-----TEST testDeleteAtleta FINE-----");

	}
	
	private static void testUpdateAtleta(AtletaService atletaServiceInstance) throws Exception {
		System.out.println("-----TEST testUpdateAtleta INIZIO-----");
		List<Atleta> listaAtleti = atletaServiceInstance.listAll();
		if (listaAtleti.size() < 1)
			throw new RuntimeException("testDeleteAtleta FALLITO: non sono presenti atleti in lista.");
		
		Atleta atletaDaAggiornare = listaAtleti.get(2);
		String nuovoNome = "Piero";
		atletaDaAggiornare.setNome(nuovoNome);
		atletaServiceInstance.aggiorna(atletaDaAggiornare);
		System.out.println(atletaDaAggiornare);
		System.out.println("-----TEST testUpdateAtleta FINE-----");
	
	}

	
	
	
}
