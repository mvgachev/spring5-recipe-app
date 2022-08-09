package guru.springframework.services;

import guru.springframework.commands.IngredientCommand;

public interface IngredientService {

    IngredientCommand saveIngredientCommand(IngredientCommand ingredient);

    IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);
}
