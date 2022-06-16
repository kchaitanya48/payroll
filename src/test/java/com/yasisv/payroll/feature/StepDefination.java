package com.yasisv.payroll.feature;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.configureFor;
import static com.github.tomakehurst.wiremock.client.WireMock.containing;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.junit.Assert.assertEquals;
import static com.github.tomakehurst.wiremock.client.WireMock.verify;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.github.tomakehurst.wiremock.WireMockServer;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefination {

	private static final String EMPLOYEE_PATH = "/employee";
	private static final String APPLICATION_JSON = "application/json";

	private final InputStream jsonInputStream = this.getClass().getClassLoader().getResourceAsStream("newEmployee.json");
	private final String jsonString = new Scanner(jsonInputStream, "UTF-8").useDelimiter("\\Z").next();

	private final WireMockServer wireMockServer = new WireMockServer(options().dynamicPort());
	private final CloseableHttpClient httpClient = HttpClients.createDefault();

	@When("send employee request to enroll the member")
	public void send_employee_request_to_enroll_the_member() throws ClientProtocolException, IOException {
		wireMockServer.start();

		configureFor("localhost", wireMockServer.port());
		stubFor(post(urlEqualTo(EMPLOYEE_PATH)).withHeader("content-type", equalTo(APPLICATION_JSON))
				.withRequestBody(containing("testing-framework")).willReturn(aResponse().withStatus(200)));

		HttpPost request = new HttpPost("http://localhost:" + wireMockServer.port() + EMPLOYEE_PATH);
		StringEntity entity = new StringEntity(jsonString);
		request.addHeader("content-type", APPLICATION_JSON);
		request.setEntity(entity);
		HttpResponse response = httpClient.execute(request);

		assertEquals(200, response.getStatusLine().getStatusCode());
		verify(postRequestedFor(urlEqualTo(EMPLOYEE_PATH)).withHeader("content-type", equalTo(APPLICATION_JSON)));

		wireMockServer.stop();
	}

	@Then("new enroll member details from {string} should match with new enroll member from backend database")
	public void new_enroll_member_details_from_should_match_with_new_enroll_member_from_backend_database(
			String string) {
		System.out.println(string);
	}

}
