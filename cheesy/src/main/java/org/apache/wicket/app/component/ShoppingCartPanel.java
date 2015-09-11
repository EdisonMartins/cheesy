package org.apache.wicket.app.component;

import java.text.NumberFormat;

import org.apache.wicket.domain.model.Cart;
import org.apache.wicket.domain.model.Cheese;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

/**
 * Panel for displaying the contents of a shopping cart. The cart shows the
 * entries and the total value of the cart. Each item can be removed by the
 * user.
 */
public class ShoppingCartPanel extends Panel {

	private static final long serialVersionUID = 1L;
	
	private Cart cart;

	@SuppressWarnings({ "serial", "rawtypes" })
	public ShoppingCartPanel(String id, Cart cart) {
		super(id);
		this.cart = cart;
		
		
		add(new ListView<Cheese>("cart", new PropertyModel<>(this, "cart.cheeses")) {
			@Override
			protected void populateItem(ListItem<Cheese> item) {
				Cheese cheese = (Cheese) item.getModelObject();
				item.add(new Label("name", cheese.getName()));
				item.add(new Label("price", "$" + cheese.getPrice()));
				item.add(removeLink("remove", item));
			}
		});
		
		
		add(new Label("total", new Model() {
			@Override
			public String getObject() {
				NumberFormat nf = NumberFormat.getCurrencyInstance();
				return nf.format(getCart().getTotal());
			}
		}));
		
	}

	public Cart getCart() {
		return cart;
	}
	
	
	

	
	
	

}
