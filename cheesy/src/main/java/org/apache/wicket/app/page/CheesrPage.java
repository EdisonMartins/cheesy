package org.apache.wicket.app.page;

import java.util.List;

import org.apache.wicket.app.cfg.CheesrApplication;
import org.apache.wicket.app.session.CheesrSession;
import org.apache.wicket.domain.model.Cart;
import org.apache.wicket.domain.model.Cheese;
import org.apache.wicket.markup.html.WebPage;

/**
 * Base Classe fornece funcionalidades para todas as páginas abaixo dela.
 * Funciona como um template.
 * 
 * @author edison
 *
 */
public abstract class CheesrPage extends WebPage {

	private static final long serialVersionUID = 1L;

	public CheesrSession getCheesrSession() {
		return (CheesrSession) getSession();
	}

	//Recupera um Cart (Carrinho) da Session
	public Cart getCart() {
		return getCheesrSession().getCart();
	}

	
	public List<Cheese> getCheeses() {
		return CheesrApplication.get().getCheeses();
	}

}
