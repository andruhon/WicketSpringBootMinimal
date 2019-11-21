package sboot.web;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.ResourceModel;

public class HomePage extends WebPage {

    public HomePage() {
        add(new Label("friend", new ResourceModel("friend")));
    }

}
