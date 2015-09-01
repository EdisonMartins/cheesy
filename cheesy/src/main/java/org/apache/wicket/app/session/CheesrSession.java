package org.apache.wicket.app.session;

import org.apache.wicket.domain.model.Cart;
import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;

/**
 * Custom Session (Não é SessionStore)
 * @author edison
 *
 */
public class CheesrSession extends WebSession {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Cart é único para cada Sessão do Usuário.
	 * 
	 */
	private Cart cart = new Cart();

	public CheesrSession(Request request) {
		super(request);
	}

	public Cart getCart() {
		return cart;
	}
	
	

}
