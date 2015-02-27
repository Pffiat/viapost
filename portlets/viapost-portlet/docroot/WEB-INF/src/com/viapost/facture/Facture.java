package com.viapost.facture;

import java.io.FileReader;
import java.io.OutputStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;

/**
 * Portlet implementation class Facture
 */
public class Facture extends MVCPortlet {
 
	@Override
	public void serveResource(final ResourceRequest request, final ResourceResponse response) {
		/*
		 * Get template from version
		 */
		final Date date = ParamUtil.getDate(request, "date", DateFormat.getDateInstance(DateFormat.SHORT, Locale.FRANCE));
		
		final String userId = request.getRemoteUser();


		//create and export only one file with scenario script for this simulation id
		response.setContentType("application/pdf");
		try {
			response.addProperty("Content-Disposition", "attachment; filename=Facture.pdf");
			final OutputStream out = response.getPortletOutputStream();
			
			
			final String currentPath = request.getPortletSession().getPortletContext().getRealPath("/WEB-INF/src/resource/facture.mustache");
			final Template tmpl = Mustache.compiler().compile(new FileReader(currentPath));
			final String script = tmpl.execute(new FactureGenerator(date, userId));
			out.write(script.getBytes());
			out.flush();
			out.close();
		} catch (final Exception e) {
			throw new RuntimeException("cannot export script file " + e.getMessage());
		}
		
		response.addProperty(HttpHeaders.CACHE_CONTROL, "max-age=3600, must-revalidate");
	}
	
}
