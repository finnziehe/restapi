package com.ziehe.demorest;
import java.util.Collections;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.lucene.analysis.CharArraySet;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import com.google.gson.Gson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;



@Path("mitarbeiter")
@Api(value="Mitarbeiter Methoden")
public class MitarbeiterRessources {
	
@GET 
@Produces(MediaType.APPLICATION_JSON)
@ApiOperation(value="Gibt alle Mitarbeiter in der Datenbank aus")
@ApiResponses(value = { @ApiResponse(code = 400, message = "Fehler"),
@ApiResponse(code = 404, message = "Datenbank nicht gefunden") })
public String getallMitarbeiter() { 
	
	
	Configuration con = new Configuration().configure().addAnnotatedClass(Mitarbeiter.class); 
	ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry(); 
	SessionFactory sf = con.buildSessionFactory(reg); 
	Session session = sf.openSession(); 
	org.hibernate.Transaction tx = session.beginTransaction();
	
	String hql = "FROM Mitarbeiter";
	Query query = session.createQuery(hql);
	List<?> results = query.list();
	String json = new Gson().toJson(results); 
	tx.commit(); 
	
	return json;
}	





@GET
@Produces(MediaType.APPLICATION_JSON)
@ApiResponses(value = { @ApiResponse(code = 400, message = "falsche Eingabe"),
@ApiResponse(code = 404, message = "nichts gefunden") })
@ApiOperation(value="Volltextsuche über die gesamte Datenbank mithilfe einer Lucene Suche")
@Path("/suche/{suche}")
public String getbyStringLucene(@PathParam("suche")String suche) {	
	final long timeStart = System.currentTimeMillis(); 
    System.out.println(suche);     		
    Configuration con = new Configuration().configure().addAnnotatedClass(Mitarbeiter.class); 
	ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry(); 
	SessionFactory sf = con.buildSessionFactory(reg); 
	Session test = sf.openSession(); 
	org.hibernate.Transaction tx = test.beginTransaction();
	FullTextSession fullTextSession = Search.getFullTextSession(test);
	QueryBuilder qb = fullTextSession.getSearchFactory().buildQueryBuilder().forEntity(Mitarbeiter.class).get();
	org.apache.lucene.search.Query query = qb.keyword().onFields("Vorname", "Abteilung", "Email", "Fax", "Nachname", "Namenszusatz", "Raum", "show_only_altPhone", "Struktureinheiten", "Suchbegriffe", "Telefon", "zweitesTelefon", "PCFax", "gueltigbis", "Titel", "Email_Langform" ).matching(suche).createQuery();
	org.hibernate.Query hibQuery = fullTextSession.createFullTextQuery(query, Mitarbeiter.class);
	List results = hibQuery.list();
	tx.commit();
	test.close();
    String json = new Gson().toJson(results);
    final long timeEnd = System.currentTimeMillis(); 
    System.out.println(hibQuery);
    System.out.println(query);
    System.out.println("Verlaufszeit der Methode: " + (timeEnd - timeStart) + " Millisek."); 
    return json; 
    
}


@GET
@Produces(MediaType.APPLICATION_JSON)
@ApiResponses(value = { @ApiResponse(code = 400, message = "falsche Eingabe"),
@ApiResponse(code = 404, message = "nichts gefunden") })
@ApiOperation(value="Volltextsuche über die gesamte Datenbank mithilfe eines SQL Like Befehls")
@Path("/like/{like}")
public String getbyString(@PathParam("like")String like) {

    final long timeStart = System.currentTimeMillis(); 
	Configuration con = new Configuration().configure().addAnnotatedClass(Mitarbeiter.class); 
	ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry(); 
	SessionFactory sf = con.buildSessionFactory(reg); 
	Session session = sf.openSession(); 
	org.hibernate.Transaction tx = session.beginTransaction();
	String hql = "FROM Mitarbeiter where Abteilung like :like or Nachname like :like or Email like :like or Fax "
			+ "like :like or Nachname like :like or Namenszusatz like :like or Raum like :like or "
			+ "show_only_altPhone like :like or Struktureinheiten like :like or Suchbegriffe like :like or Telefon like :like or Vorname like :like or zweitesTelefon like :like or PCFax "
			+ "like :like or gueltigbis like :like or Titel like :like or Email_Langform like :like";
	
	Query query = session.createQuery(hql);
	query.setParameter("like", '%'+like+ '%');
	List<?> results = query.list();
    String json = new Gson().toJson(results); 
    tx.commit();
    final long timeEnd = System.currentTimeMillis(); 
    System.out.println("Verlaufszeit der Methode: " + (timeEnd - timeStart) + " Millisek."); 
	return json; 

}
@GET  
@Produces(MediaType.APPLICATION_JSON)
@ApiResponses(value = { @ApiResponse(code = 400, message = "falsche Eingabe"),
@ApiResponse(code = 404, message = "nichts gefunden") })
@ApiOperation(value="Suche eines Vornamens in der Datenbank-Spalte Vorname mithilfe eines SQL Like Befehls")
@Path("/vorname/{vorname}")
public String getMitarbeiterbyName(@PathParam("vorname")String vorname) {

    final long timeStart = System.currentTimeMillis(); 
	Configuration con = new Configuration().configure().addAnnotatedClass(Mitarbeiter.class); 
	ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry(); 
	SessionFactory sf = con.buildSessionFactory(reg); 
	Session session = sf.openSession(); 
	org.hibernate.Transaction tx = session.beginTransaction();
	String hql = "FROM Mitarbeiter where Vorname like :vorname";
	Query query = session.createQuery(hql);
	query.setParameter("vorname", '%'+ vorname + '%');
	List<?> results = query.list();
	String json = new Gson().toJson(results); 
	tx.commit();
    final long timeEnd = System.currentTimeMillis(); 
    System.out.println("Verlaufszeit der Methode: " + (timeEnd - timeStart) + " Millisek."); 
	return json; 
}


@GET
@Produces(MediaType.APPLICATION_JSON)
@ApiResponses(value = { @ApiResponse(code = 400, message = "falsche Eingabe"),
@ApiResponse(code = 404, message = "nichts gefunden") })
@ApiOperation(value="Suche eines Nachnamens in der Datenbank-Spalte Nachname mithilfe eines SQL Like Befehls")
@Path("/nachname/{nachname}")
public String getMitarbeiterbyNachname(@PathParam("nachname") String nachname) {

	Configuration con = new Configuration().configure().addAnnotatedClass(Mitarbeiter.class); 
	ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry(); 
	SessionFactory sf = con.buildSessionFactory(reg); 
	Session session = sf.openSession(); 
	org.hibernate.Transaction tx = session.beginTransaction();  
	String hql = "FROM Mitarbeiter where Nachname like :nachname";
	Query query = session.createQuery(hql);
	query.setParameter("nachname", nachname);
	List<?> results = query.list();
	String json = new Gson().toJson(results); 
	tx.commit();
	
	return json;
	
}
}
