package org.testobject.rest.api.resource.v2;

import org.testobject.rest.api.model.InstrumentationRequestData;
import org.testobject.rest.api.model.XcuiTestReport;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("v2/instrumentation")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })
public interface InstrumentationResource {

	@POST
	@Path("xcuitest")
	long createAndStartXCUITestInstrumentation(@HeaderParam("Authorization") String apiKey,
			InstrumentationRequestData requestData);

	@GET
	@Path("{testReportId}/junitreport")
	@Produces(MediaType.APPLICATION_XML)
	String getJUnitReport(@HeaderParam("Authorization") String authorizationHeader,
			@PathParam("testReportId") long reportId);

	@GET
	@Path("testreport/{testReportId}")
	XcuiTestReport getTestReport(@HeaderParam("Authorization") String authorizationHeader,
			@PathParam("testReportId") long reportId);
}