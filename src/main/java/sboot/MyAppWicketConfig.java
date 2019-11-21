package sboot;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import sboot.web.HomePage;

public class MyAppWicketConfig extends WebApplication {

    @Override
    protected void init() {
        super.init();
        mountPage("/", HomePage.class);
    }

    @Override
    public Class<? extends Page> getHomePage() {
        return HomePage.class;
    }

}
