package org.latin.latinrest;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.delete;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class NounRestTest {

	@SuppressWarnings("deprecation")
	@Test
	public void test() {
		
		given().
					parameters("nominativeSingular", "puella", "genitiveSingular", "puellae", "gender", "F").
		put("/noun/create")
			.then()
				.assertThat().statusCode(200);
		
		get("/noun/puella")
			.then()
				.body("nominativeSingular", is("puella"))
				.body("genitiveSingular", 	is("puellae"))
				.body("gender", 			is("F"));
		
		delete("noun/puella")
			.then()
				.assertThat().statusCode(200);
		
		get("/noun/puella")
		.then()
			.assertThat().statusCode(200);
	}

}
