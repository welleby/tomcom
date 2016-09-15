package org.welleby.tomcom.recipes;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonRecipeParser implements RecipeParser {
	private static ObjectMapper mapper = new ObjectMapper();
	
	@Override
	public Recipe getRecipe(String input) {
		
		return null;
	}

}
