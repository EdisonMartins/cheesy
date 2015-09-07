package org.apache.wicket.app.cfg;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.wicket.Application;
import org.apache.wicket.Page;
import org.apache.wicket.RuntimeConfigurationType;
import org.apache.wicket.Session;
import org.apache.wicket.app.page.Index;
import org.apache.wicket.app.session.CheesrSession;
import org.apache.wicket.domain.model.Cheese;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;

/**
 * Classe responsável por inicializar e configurar a Aplicação.
 * 
 * @author edison
 *
 */
public class CheesrApplication extends WebApplication {
	private List<Cheese> cheeses = Arrays.asList(new Cheese("Gouda",
			"Gouda is a yellowish Dutch[...]", 1.65), new Cheese("Edam",
			"Edam (Dutch Edammer) is a D[...]", 1.05), new Cheese("Maasdam",
			"Maasdam cheese is a Dutc[...]", 2.35), new Cheese("Brie",
			"Brie is a soft cows' milk c[...]", 3.15), new Cheese(
			"Buxton Blue", "Buxton Blue cheese i[...]", 0.99), new Cheese(
			"Parmesan", "Parmesan is a grana, a [...]", 1.99), new Cheese(
			"Cheddar", "Cheddar cheese is a hard[...]", 2.95), new Cheese(
			"Roquefort", "Roquefort is a ewe's-m[...]", 1.67), new Cheese(
			"Boursin", "Boursin Cheese is a soft[...]", 1.33), new Cheese(
			"Camembert", "Camembert is a soft, c[...]", 1.69), new Cheese(
			"Emmental", "Emmental is a yellow, m[...]", 2.39), new Cheese(
			"Reblochon", "Reblochon is a French [...]", 2.99));

	public CheesrApplication() {

		/**
		 * Development or Deployment configuration
		 */
		System.out
				.println("-- WICKET APPLICATION: DEVELOPMENT MODE CONFIGURATION --");
		setConfigurationType(RuntimeConfigurationType.DEVELOPMENT);
	}

	/**
	 * Inicializa a aplicação
	 */
	@Override
	protected void init() {
	}

	/**
	 * 
	 * @return CheesrApplication - Retorna a aplicação
	 */
	public static CheesrApplication get() {
		return (CheesrApplication) Application.get();
	}

	/**
	 * Configura a home page.
	 */
	@Override
	public Class<? extends Page> getHomePage() {
		// TODO Auto-generated method stub
		return Index.class;
	}

	public List<Cheese> getCheeses() {
		return Collections.unmodifiableList(cheeses);
	}

	@Override
	public Session newSession(Request request, Response response) {
		return new CheesrSession(request);
	}

}
