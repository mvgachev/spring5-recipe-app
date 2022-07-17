package guru.springframework.services;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
class RecipeServiceImplTest {

    @InjectMocks
    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getRecipes() {
            Recipe recipe = new Recipe();
            Set<Recipe> recipesData = new HashSet<>();
            recipesData.add(recipe);

            Mockito.when(recipeRepository.findAll()).thenReturn(recipesData);

            Set<Recipe> recipes = recipeService.getRecipes();

            assertEquals(recipes.size(), 1);
            Mockito.verify(recipeRepository, Mockito.times(1)).findAll();

    }
}