package org.apache.wicket.app.page;

import org.apache.wicket.domain.model.Address;
import org.apache.wicket.domain.model.Cart;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.PropertyModel;

public class Checkout extends CheesrPage {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("serial")
	public Checkout() {
		System.out.println("Checkout()");
		Form<Address> form = new Form<>("Form");
		add(form);

		Address address = getCart().getBillingAddress();

		form.add(new TextField<>("name", new PropertyModel<>(address, "name")));
		form.add(new TextField<>("street", new PropertyModel<>(address, "street")));
		form.add(new TextField<>("zipCode", new PropertyModel<>(address, "zipCode")));
		form.add(new TextField<>("city", new PropertyModel<>(address, "city")));

		form.add(new Link<Address>("cancel") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				setResponsePage(Index.class);

			}
		});

		form.add(new Button("order") {
			@Override
			public void onSubmit() {
				Cart cart = getCart();
				// charge customers’ credit card
				// ship cheeses to our customer
				// clean out shopping cart
				cart.getCheeses().clear();
				// return to front page
				setResponsePage(Index.class);
			}
		});

	}

}



















