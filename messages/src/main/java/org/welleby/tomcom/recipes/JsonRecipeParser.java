package org.welleby.tomcom.recipes;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonRecipeParser implements RecipeParser {
	private static ObjectMapper mapper = new ObjectMapper();
	
	@Override
	public Recipe getRecipe(String input) {
		try {
			JsonNode tree = mapper.readTree(input);
			Map<String,TypeConverter> map = mapper.convertValue(tree, new TypeReference<Map<String,TypeConverter>>() {});
			Recipe recipe = new Recipe(map);
			return recipe;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
