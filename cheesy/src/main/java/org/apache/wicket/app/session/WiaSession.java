package org.apache.wicket.app.session;

import java.util.Locale;

import org.apache.wicket.Session;
import org.apache.wicket.domain.model.User;
import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;

public class WiaSession extends WebSession {

	private static final long serialVersionUID = 1L;

	private User user;

	public static WiaSession get() {
		return (WiaSession) Session.get();
	}

	public WiaSession(Request request) {
		super(request);
		setLocale(Locale.ENGLISH);
	}

	public synchronized User getUser() {
		return user;
	}

	public synchronized boolean isAuthenticated() {
		return (user != null);
	}

	public synchronized void setUser(User user) {
		this.user = user;
		dirty();
	}

}
