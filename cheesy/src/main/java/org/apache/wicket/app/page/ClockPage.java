package org.apache.wicket.app.page;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;

public class ClockPage extends WebPage {

	private static final long serialVersionUID = 1L;
	
	public ClockPage(){
		SimpleDateFormat df = new SimpleDateFormat("hh:mm:ss");
		String time = df.format(new Date());
		Model<String> clock = new Model<String>(time);
		add(new Label("clock", clock));
		add(new Link<String>("refresh") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				System.out.println("refresh!");

			}


		});
		
		
		
		
	}

}
