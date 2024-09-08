package com.ucb.budgetapp

fun main(){
    val recipe = Recipe()

    recipe.addIngredient("Rice")
    recipe.addIngredient("Chicken")
    recipe.addIngredient("Potatoes")

    println(recipe.getIngredients())
}