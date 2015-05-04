package br.com.ecommerce.log4jinit;

import java.io.File;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;


public class Log4JInitServlet extends HttpServlet {
	
	public static void main(String[] args) {
		System.out.println(System.getProperty("java.class.path"));
	}

	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		
		// This will be printed on tomcat initialization to be sure the log4j is working
		System.out.println("Log4JInitServlet is initializing log4j");
		
		String log4jLocation = config.getInitParameter("log4j-properties-location");

		ServletContext sc = config.getServletContext();

		if (log4jLocation == null) {
			System.err.println("*** No log4j-properties-location init param, so initializing log4j with BasicConfigurator");
			BasicConfigurator.configure();
		} else {
			String webAppPath = sc.getRealPath("/");
			String log4jProp = webAppPath + log4jLocation;
			File log4JPropertiesFile = new File(log4jProp);
			if (log4JPropertiesFile.exists()) {
				System.out.println("Initializing log4j with: " + log4jProp);
				PropertyConfigurator.configure(log4jProp);
			} else {
				System.err.println("*** " + log4jProp + " file not found, so initializing log4j with BasicConfigurator");
				BasicConfigurator.configure();
			}
		}
		super.init(config);
	}
}
