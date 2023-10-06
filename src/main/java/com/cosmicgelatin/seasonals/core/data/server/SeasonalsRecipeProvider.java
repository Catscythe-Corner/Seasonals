package com.cosmicgelatin.seasonals.core.data.server;

import com.cosmicgelatin.seasonals.core.ModIntegration;
import com.cosmicgelatin.seasonals.core.Seasonals;
import com.cosmicgelatin.seasonals.core.other.SeasonalsItemTags;
import com.cosmicgelatin.seasonals.core.registry.SeasonalsBlocks;
import com.cosmicgelatin.seasonals.core.registry.SeasonalsItems;
import com.teamabnormals.neapolitan.core.registry.NeapolitanItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.ModLoadedCondition;

import java.util.function.Consumer;
import java.util.function.Supplier;

import static com.cosmicgelatin.seasonals.core.data.SeasonalsDatagenUtil.*;

public class SeasonalsRecipeProvider extends RecipeProvider {

    public SeasonalsRecipeProvider(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        iceCreamAndBlockRecipe(SeasonalsItems.PUMPKIN_PUREE.get(), SeasonalsItems.PUMPKIN_ICE_CREAM, SeasonalsBlocks.PUMPKIN_ICE_CREAM_BLOCK, consumer);
        iceCreamAndBlockRecipe(Items.SWEET_BERRIES, SeasonalsItems.SWEET_BERRY_ICE_CREAM, SeasonalsBlocks.SWEET_BERRY_ICE_CREAM_BLOCK, consumer);
        iceCreamAndBlockRecipe(SeasonalsItems.ROASTED_BEETROOT.get(), SeasonalsItems.BEETROOT_ICE_CREAM, SeasonalsBlocks.BEETROOT_ICE_CREAM_BLOCK, consumer);

        milkshakeRecipes(SeasonalsItems.PUMPKIN_ICE_CREAM, SeasonalsItems.PUMPKIN_MILKSHAKE, consumer);
        milkshakeRecipes(SeasonalsItems.SWEET_BERRY_ICE_CREAM, SeasonalsItems.SWEET_BERRY_MILKSHAKE, consumer);
        milkshakeRecipes(SeasonalsItems.BEETROOT_ICE_CREAM, SeasonalsItems.BEETROOT_MILKSHAKE, consumer);

        cakeRecipes(SeasonalsItems.PUMPKIN_PUREE.get(), SeasonalsBlocks.PUMPKIN_CAKE, SeasonalsItems.PUMPKIN_CAKE_SLICE, consumer);
        cakeRecipes(Items.SWEET_BERRIES, SeasonalsBlocks.SWEET_BERRY_CAKE, SeasonalsItems.SWEET_BERRY_CAKE_SLICE, consumer);
        cakeRecipes(SeasonalsItems.ROASTED_BEETROOT.get(), SeasonalsBlocks.BEETROOT_CAKE, SeasonalsItems.BEETROOT_CAKE_SLICE, consumer);

        cookingRecipes(Items.BEETROOT, SeasonalsItems.ROASTED_BEETROOT.get(), 0.35F, "roasted_beetroot", consumer);

        addCraftingRecipe(ShapedRecipeBuilder.shaped(SeasonalsItems.OXIDIZED_BEETROOT.get()).define('X', SeasonalsItems.ROASTED_BEETROOT.get()).define('#', Items.OXIDIZED_COPPER).pattern("###").pattern("#X#").pattern("###"), SeasonalsItems.ROASTED_BEETROOT, SeasonalsItems.OXIDIZED_BEETROOT, consumer);
        addCraftingRecipe(ShapelessRecipeBuilder.shapeless(SeasonalsItems.CHOCOLATE_PUMPKIN_MUFFIN.get(), 4).requires(SeasonalsItems.PUMPKIN_PUREE.get()).requires(Items.SUGAR).requires(Items.WHEAT).requires(NeapolitanItems.CHOCOLATE_BAR.get()), NeapolitanItems.CHOCOLATE_BAR, SeasonalsItems.CHOCOLATE_PUMPKIN_MUFFIN, consumer);
        addCraftingRecipe(ShapelessRecipeBuilder.shapeless(SeasonalsItems.RED_VELVET_CUPCAKE.get(), 4).requires(SeasonalsItems.ROASTED_BEETROOT.get()).requires(Items.SUGAR).requires(Items.WHEAT).requires(Items.MILK_BUCKET), SeasonalsItems.ROASTED_BEETROOT, SeasonalsItems.RED_VELVET_CUPCAKE, consumer);
        addCraftingRecipe(ShapelessRecipeBuilder.shapeless(SeasonalsItems.RABBIT_ROAST.get()).requires(Items.COOKED_RABBIT).requires(SeasonalsItems.ROASTED_BEETROOT.get()).requires(SeasonalsItems.PUMPKIN_PUREE.get()), () -> Items.COOKED_RABBIT, SeasonalsItems.RABBIT_ROAST, consumer);
        addCraftingRecipe(ShapelessRecipeBuilder.shapeless(SeasonalsItems.SWEET_BERRY_VANILLA_YOGURT.get()).requires(Items.BOWL).requires(Items.SWEET_BERRIES).requires(SeasonalsItemTags.MILK).requires(NeapolitanItems.DRIED_VANILLA_PODS.get()), () -> Items.SWEET_BERRIES, SeasonalsItems.SWEET_BERRY_VANILLA_YOGURT, consumer);
        addCraftingRecipe(ShapelessRecipeBuilder.shapeless(SeasonalsItems.PUMPKIN_PUREE.get()).requires(Items.PUMPKIN).requires(Items.SUGAR, 3), () -> Items.PUMPKIN, SeasonalsItems.PUMPKIN_PUREE, consumer);
        addCraftingRecipe(ShapelessRecipeBuilder.shapeless(SeasonalsItems.GLAZED_SWEET_BERRIES.get(), 3).requires(Items.SWEET_BERRIES, 3).requires(Items.HONEY_BOTTLE), () -> Items.SWEET_BERRIES, SeasonalsItems.GLAZED_SWEET_BERRIES, consumer);
        addCraftingRecipe(ShapelessRecipeBuilder.shapeless(SeasonalsItems.MIXED_BERRY_MUFFIN.get(), 4).requires(Items.SWEET_BERRIES).requires(Items.GLOW_BERRIES).requires(Items.SUGAR).requires(Items.WHEAT), () -> Items.SWEET_BERRIES, SeasonalsItems.MIXED_BERRY_MUFFIN, consumer);
        addCraftingRecipe(ShapelessRecipeBuilder.shapeless(SeasonalsItems.PUMPKIN_ADZUKI_STEW.get()).requires(SeasonalsItems.PUMPKIN_PUREE.get()).requires(NeapolitanItems.ROASTED_ADZUKI_BEANS.get()).requires(Items.BOWL), SeasonalsItems.PUMPKIN_PUREE, SeasonalsItems.PUMPKIN_ADZUKI_STEW, consumer);
        addCraftingRecipe(ShapelessRecipeBuilder.shapeless(SeasonalsItems.BANANA_SPLIT_SUNDAE.get()).requires(SeasonalsItems.GLAZED_SWEET_BERRIES.get()).requires(NeapolitanItems.BANANA.get()).requires(NeapolitanItems.CHOCOLATE_ICE_CREAM.get()), NeapolitanItems.BANANA, SeasonalsItems.BANANA_SPLIT_SUNDAE, consumer);

        this.outsideRecipeConfigConditionRecipe(ShapelessRecipeBuilder.shapeless(NeapolitanItems.ADZUKI_CURRY.get()).requires(NeapolitanItems.ROASTED_ADZUKI_BEANS.get()).requires(NeapolitanItems.DRIED_BANANA.get()).requires(Items.CARROT).requires(SeasonalsItems.PUMPKIN_PUREE.get()).requires(Items.BOWL).unlockedBy(getHasName(NeapolitanItems.ROASTED_ADZUKI_BEANS.get()), has(NeapolitanItems.ROASTED_ADZUKI_BEANS.get())), craftingPath(getItemName(NeapolitanItems.ADZUKI_CURRY.get())), consumer);
        this.outsideRecipeConfigConditionRecipe(ShapelessRecipeBuilder.shapeless(Items.PUMPKIN_PIE).requires(SeasonalsItems.PUMPKIN_PUREE.get()).requires(Items.SUGAR).requires(Tags.Items.EGGS).unlockedBy(getHasName(SeasonalsItems.PUMPKIN_PUREE.get()), has(SeasonalsItems.PUMPKIN_PUREE.get())), craftingPath(getItemName(Items.PUMPKIN_PIE)), consumer);

    }

    private void addCraftingRecipe(RecipeBuilder recipe, Supplier<? extends ItemLike> unlockedBy, Supplier<? extends ItemLike> result, Consumer<FinishedRecipe> consumer) {
        String resultName = getItemName(result.get());
        recipe.unlockedBy(getHasName(unlockedBy.get()), has(unlockedBy.get())).save(consumer, craftingPath(resultName));
    }

    private void iceCreamAndBlockRecipe(ItemLike ingredient, Supplier<? extends ItemLike> resultItem, Supplier<? extends ItemLike> resultBlock, Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(resultItem.get()).requires(Items.BOWL).requires(ingredient).requires(SeasonalsItemTags.MILK).requires(NeapolitanItems.ICE_CUBES.get()).requires(Items.SUGAR)
                .unlockedBy(getHasName(ingredient), has(ingredient)).save(consumer, craftingPath(getItemName(resultItem.get())));

        ShapedRecipeBuilder.shaped(resultBlock.get(), 8).define('#', Items.SNOW_BLOCK).define('X', resultItem.get()).pattern("###").pattern("#X#").pattern("###")
                .unlockedBy(getHasName(resultItem.get()), has(resultItem.get())).save(consumer, craftingPath(getItemName(resultBlock.get())));
    }

    private void milkshakeRecipes(Supplier<? extends ItemLike> iceCream, Supplier<? extends ItemLike> result, Consumer<FinishedRecipe> consumer) {
        String resultName = getItemName(result.get());
        ShapelessRecipeBuilder.shapeless(result.get(), 3).requires(Items.GLASS_BOTTLE, 3).requires(iceCream.get()).requires(SeasonalsItemTags.MILK)
                .unlockedBy(getHasName(iceCream.get()), has(iceCream.get())).save(consumer, craftingPath(resultName));
    }

    private void cakeRecipes(ItemLike ingredient, Supplier<? extends ItemLike> result, Supplier<? extends ItemLike> slice, Consumer<FinishedRecipe> consumer) {
        String resultName = getItemName(result.get());
        ShapedRecipeBuilder.shaped(result.get()).define('A', SeasonalsItemTags.MILK).define('B', Items.SUGAR).define('C', Items.WHEAT).define('D', ingredient).define('E', Tags.Items.EGGS).pattern("ADA").pattern("BEB").pattern("CDC")
                .unlockedBy(getHasName(ingredient), has(ingredient)).save(consumer, craftingPath(resultName));

        modLoadedConditionRecipe(ModIntegration.FARMERSDELIGHT_ID, ShapelessRecipeBuilder.shapeless(result.get()).requires(slice.get(), 7).unlockedBy(getHasName(slice.get()), has(slice.get())), craftingPath(resultName + "_from_slices"), consumer);
    }

    private static void cookingRecipes(ItemLike ingredient, ItemLike result, float experience, String group, Consumer<FinishedRecipe> consumer) {
        String resultName = getItemName(result);

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ingredient), result, experience, 200).group(group)
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(consumer, cookingPath(resultName));
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(ingredient), result, experience, 600).group(group)
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(consumer, cookingPath(resultName + "_from_campfire_cooking"));
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(ingredient), result, experience, 100).group(group)
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(consumer, cookingPath(resultName + "_from_smoking"));
    }

    private void outsideRecipeConfigConditionRecipe(RecipeBuilder recipe, ResourceLocation customPath, Consumer<FinishedRecipe> consumer) {
        this.conditionalRecipe(outsideRecipeConfig(), recipe, customPath, consumer);
    }

    private void modLoadedConditionRecipe(String modId, RecipeBuilder recipe, ResourceLocation customPath, Consumer<FinishedRecipe> consumer) {
        this.conditionalRecipe(new ModLoadedCondition(modId), recipe, customPath, consumer);
    }

    private void conditionalRecipe(ICondition condition, RecipeBuilder recipe, ResourceLocation customPath, Consumer<FinishedRecipe> consumer) {
        ConditionalRecipe.builder().addCondition(condition)
                .addRecipe(consumer1 -> recipe.save(consumer1, Seasonals.modPrefix(RecipeBuilder.getDefaultRecipeId(recipe.getResult()).getPath()))).generateAdvancement(new ResourceLocation(RecipeBuilder.getDefaultRecipeId(recipe.getResult()).getNamespace(), "recipes/" + recipe.getResult().getItemCategory().getRecipeFolderName() + "/" + RecipeBuilder.getDefaultRecipeId(recipe.getResult()).getPath()))
                .build(consumer, customPath);
    }
}
