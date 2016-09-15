package org.welleby.tomcom.recipes;

import java.util.Map;

public class Recipe {
	private Map<String, TypeConverter> recipe;

	public Recipe(Map<String, TypeConverter> map) {
		setRecipe(map);
	}

	public Map<String, TypeConverter> getRecipe() {
		return recipe;
	}

	public void setRecipe(Map<String, TypeConverter> recipe) {
		this.recipe = recipe;
	}
}
