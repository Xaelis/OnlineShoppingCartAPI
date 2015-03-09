package com.model.initializer;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.RequestContextFilter;
import org.springframework.web.servlet.DispatcherServlet;

import com.model.filter.SimpleCORSFilter;

public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer
{
	private static final String	CONFIG_LOCATION	= "com.model.config";
	private static final String	MAPPING_URL		= "/";
	
	protected AnnotationConfigWebApplicationContext getContext()
	{
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.setConfigLocation(CONFIG_LOCATION);
		return context;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void beforeSpringSecurityFilterChain(ServletContext servletContext)
	{
		WebApplicationContext context = getContext();
		servletContext.addListener(new ContextLoaderListener(context));
		servletContext.addListener(new HttpSessionEventPublisher());
		ServletRegistration.Dynamic dispatcher =
			servletContext.addServlet("DispatcherServlet", new DispatcherServlet(context));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping(MAPPING_URL);
		dispatcher.setAsyncSupported(true);
		
		FilterRegistration.Dynamic filter =
			servletContext.addFilter("CORS", SimpleCORSFilter.class);
		filter.addMappingForUrlPatterns(null, false, "/*");
	}
}
