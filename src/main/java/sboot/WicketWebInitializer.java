package sboot;

import org.apache.wicket.protocol.http.WicketFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * Primary container configuration to configure Wicket requests.
 * 
 * @author Marc Giffing
 */
@Configuration
public class WicketWebInitializer implements ServletContextInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

	}

	@Bean
	public FilterRegistrationBean<WicketFilter> wicketFilter(){
		FilterRegistrationBean<WicketFilter> registrationBean
				= new FilterRegistrationBean<>();

		registrationBean.setFilter(new WicketFilter());
		registrationBean.setName("Sboot");
		registrationBean.addUrlPatterns("/app/*");
		registrationBean.setDispatcherTypes(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.ERROR);

		registrationBean.addInitParameter(WicketFilter.FILTER_MAPPING_PARAM, "/*");
		registrationBean.addInitParameter("configuration", "development");
		registrationBean.addInitParameter("applicationFactoryClassName", "org.apache.wicket.spring.SpringWebApplicationFactory");
		registrationBean.addInitParameter("applicationBean", "mySbootApplication");

		return registrationBean;
	}

	@Bean
	public MyAppWicketConfig mySbootApplication() {
		return new MyAppWicketConfig();
	}

}
