package org.apache.wicket.app.page;

import java.text.NumberFormat;

import org.apache.wicket.domain.model.Cheese;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.list.PageableListView;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

public class Index extends CheesrPage {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings({ "serial", "rawtypes" })
	public Index() {

		//O número 5 é o número de itens que aparecerá na página
		PageableListView<Cheese> cheeses = new PageableListView<Cheese>("cheeses", getCheeses(), 5) {

			@Override
			protected void populateItem(ListItem<Cheese> item) {
				Cheese cheese = item.getModelObject();
				item.add(new Label("name", cheese.getName()));
				item.add(new Label("description", cheese.getDescription()));
				item.add(new Label("price", "$" + cheese.getName()));

				item.add(new Link<Cheese>("add", item.getModel()) {

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


		add(new ListView<Cheese>("cart", new PropertyModel<>(this, "cart.cheeses")) {

			@Override
			protected void populateItem(ListItem<Cheese> item) {
				Cheese cheese = item.getModelObject();
				item.add(new Label("name", cheese.getName()));
				item.add(new Label("price", "$" + cheese.getName()));

				item.add(new Link<Cheese>("remove", item.getModel()) {

					@Override
					public void onClick() {
						Cheese selected = getModelObject();
						getCart().getCheeses().remove(selected);

					}
				});

			}

		});

		add(new Label("total", new Model() {
			@Override
			// No livro o tipo de retorno é um Object. Pg 78 pdf
			public String getObject() {
				NumberFormat nf = NumberFormat.getCurrencyInstance();
				return nf.format(getCart().getTotal());
			}
		}));

		add(new Link<Cheese>("checkout") {
			@Override
			public void onClick() {
				setResponsePage(new Checkout());
			}

		});

		add(new Link<Cheese>("checkout") {

			@Override
			public void onClick() {
				setResponsePage(new Checkout());

			}

			@Override
			public boolean isVisible() {
				return !getCart().getCheeses().isEmpty();
			}

		});

	}

}
