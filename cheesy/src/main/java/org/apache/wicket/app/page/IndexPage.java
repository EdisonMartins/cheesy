package org.apache.wicket.app.page;

import org.apache.wicket.app.component.ShoppingCartPanel;
import org.apache.wicket.domain.model.Cheese;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PageableListView;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;

public class IndexPage extends CheesrPage {

	private static final long serialVersionUID = 1L;

	public IndexPage() {

		//O número 5 é o número de itens que aparecerá na página
		PageableListView<Cheese> cheeses = new PageableListView<Cheese>("cheeses", getCheeses(), 5) {

			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<Cheese> item) {
				Cheese cheese = item.getModelObject();
				item.add(new Label("name", cheese.getName()));
				item.add(new Label("description", cheese.getDescription()));
				item.add(new Label("price", "$" + cheese.getName()));

				item.add(new Link<Cheese>("add", item.getModel()) {

					private static final long serialVersionUID = 1L;

					@Override
					public void onClick() {

						Cheese selected = getModelObject();
						getCart().getCheeses().add(selected);

					}
				});

			}
		};
		
		//Lista de Cheeses
		add(cheeses);
		//Paginação da Lista
		add(new PagingNavigator("navigator", cheeses));
		add(new ShoppingCartPanel("shoppingcart", getCart()));
		add(new Link<Cheese>("checkout") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				setResponsePage(new Checkout());

			}


		});
		
		







	}

}
