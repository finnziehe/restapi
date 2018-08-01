

package com.ziehe.demorest;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import io.swagger.jaxrs.config.BeanConfig;

public class SwaggerConfigurationServlet extends HttpServlet {
	public void init(ServletConfig config)throws ServletException {
		super.init(config);
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setTitle("Personensuche");
        beanConfig.setVersion("1.0");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("141.89.53.142:8080/demorest/webapi");
        beanConfig.setBasePath("");
        beanConfig.setResourcePackage("com.ziehe.demorest");
        beanConfig.setScan(true);
        beanConfig.setDescription("REST API zur Personensuche");
	}
}
