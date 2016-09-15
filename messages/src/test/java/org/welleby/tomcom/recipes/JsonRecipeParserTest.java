package org.welleby.tomcom.recipes;

import java.io.IOException;
import java.net.URL;

import org.junit.Test;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

public class JsonRecipeParserTest {
	private static JsonRecipeParser jp = new JsonRecipeParser();	
	
	@Test
	public void testInt() throws IOException {
		URL url = Resources.getResource("recipes/sensorReports/basicTempSensor.json");
		String input = Resources.toString(url, Charsets.UTF_8);
		jp.getRecipe(input);
	}
	
}
