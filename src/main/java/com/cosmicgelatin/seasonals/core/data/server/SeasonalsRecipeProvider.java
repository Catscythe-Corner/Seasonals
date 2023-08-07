package com.cosmicgelatin.seasonals.core.data.server;

import com.cosmicgelatin.seasonals.core.Seasonals;
import com.cosmicgelatin.seasonals.core.other.SeasonalsItemTags;
import com.cosmicgelatin.seasonals.core.registry.SeasonalsBlocks;
import com.cosmicgelatin.seasonals.core.registry.SeasonalsItems;
import com.teamabnormals.neapolitan.core.registry.NeapolitanItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.ICondition;

import java.util.function.Consumer;
import java.util.function.Supplier;

import static com.cosmicgelatin.seasonals.core.data.SeasonalsDatagenUtil.outsideRecipeConfig;

public class SeasonalsRecipeProvider extends RecipeProvider {

    public SeasonalsRecipeProvider(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        iceCreamAndBlockRecipe(SeasonalsItems.PUMPKIN_PUREE.get(), SeasonalsItems.PUMPKIN_ICE_CREAM, SeasonalsBlocks.PUMPKIN_ICE_CREAM_BLOCK, consumer);
        iceCreamAndBlockRecipe(Items.SWEET_BERRIES, SeasonalsItems.SWEET_BERRY_ICE_CREAM, SeasonalsBlocks.SWEET_BERRY_ICE_CREAM_BLOCK, consumer);
        iceCreamAndBlockRecipe(Items.BEETROOT, SeasonalsItems.BEETROOT_ICE_CREAM, SeasonalsBlocks.BEETROOT_ICE_CREAM_BLOCK, consumer);

        milkshakeRecipes(SeasonalsItems.PUMPKIN_PUREE.get(), SeasonalsItems.PUMPKIN_ICE_CREAM, SeasonalsItems.PUMPKIN_MILKSHAKE, consumer);
        milkshakeRecipes(Items.SWEET_BERRIES, SeasonalsItems.SWEET_BERRY_ICE_CREAM, SeasonalsItems.SWEET_BERRY_MILKSHAKE, consumer);
        milkshakeRecipes(Items.BEETROOT, SeasonalsItems.BEETROOT_ICE_CREAM, SeasonalsItems.BEETROOT_MILKSHAKE, consumer);

        cakeRecipes(SeasonalsItems.PUMPKIN_PUREE.get(), SeasonalsBlocks.PUMPKIN_CAKE, consumer);
        cakeRecipes(Items.SWEET_BERRIES, SeasonalsBlocks.SWEET_BERRY_CAKE, consumer);
        cakeRecipes(Items.BEETROOT, SeasonalsBlocks.BEETROOT_CAKE, consumer);

        ShapelessRecipeBuilder.shapeless(SeasonalsItems.CHOCOLATE_PUMPKIN_MUFFIN.get(), 4).requires(SeasonalsItems.PUMPKIN_PUREE.get()).requires(Items.SUGAR).requires(Items.WHEAT).requires(NeapolitanItems.CHOCOLATE_BAR.get()).unlockedBy(getHasName(NeapolitanItems.CHOCOLATE_BAR.get()), has(NeapolitanItems.CHOCOLATE_BAR.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(SeasonalsItems.RABBIT_ROAST.get()).requires(Items.COOKED_RABBIT).requires(Items.BEETROOT).requires(SeasonalsItems.PUMPKIN_PUREE.get()).unlockedBy(getHasName(Items.COOKED_RABBIT), has(Items.COOKED_RABBIT)).save(consumer);
        ShapelessRecipeBuilder.shapeless(SeasonalsItems.SWEET_BERRY_VANILLA_YOGURT.get()).requires(Items.BOWL).requires(Items.SWEET_BERRIES).requires(SeasonalsItemTags.MILK).requires(NeapolitanItems.DRIED_VANILLA_PODS.get()).unlockedBy(getHasName(Items.SWEET_BERRIES), has(Items.SWEET_BERRIES)).save(consumer);
        ShapelessRecipeBuilder.shapeless(SeasonalsItems.PUMPKIN_PUREE.get()).requires(Items.PUMPKIN).requires(Items.SUGAR, 3).unlockedBy(getHasName(Items.PUMPKIN), has(Items.PUMPKIN)).save(consumer);
        ShapelessRecipeBuilder.shapeless(SeasonalsItems.GLAZED_SWEET_BERRIES.get(), 3).requires(Items.SWEET_BERRIES, 3).requires(Items.HONEY_BOTTLE).unlockedBy(getHasName(Items.SWEET_BERRIES), has(Items.SWEET_BERRIES)).save(consumer);
        ShapelessRecipeBuilder.shapeless(SeasonalsItems.MIXED_BERRY_MUFFIN.get(), 4).requires(Items.SWEET_BERRIES).requires(Items.GLOW_BERRIES).requires(Items.SUGAR).requires(Items.WHEAT).unlockedBy(getHasName(Items.SWEET_BERRIES), has(Items.SWEET_BERRIES)).save(consumer);
        ShapelessRecipeBuilder.shapeless(SeasonalsItems.PUMPKIN_ADZUKI_STEW.get()).requires(SeasonalsItems.PUMPKIN_PUREE.get()).requires(NeapolitanItems.ROASTED_ADZUKI_BEANS.get()).requires(Items.BOWL).unlockedBy(getHasName(SeasonalsItems.PUMPKIN_PUREE.get()), has(SeasonalsItems.PUMPKIN_PUREE.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(SeasonalsItems.BANANA_SPLIT_SUNDAE.get()).requires(SeasonalsItems.GLAZED_SWEET_BERRIES.get()).requires(NeapolitanItems.BANANA.get()).requires(NeapolitanItems.CHOCOLATE_ICE_CREAM.get()).unlockedBy(getHasName(NeapolitanItems.BANANA.get()), has(NeapolitanItems.BANANA.get())).save(consumer);

        this.outsideRecipeConfigConditionRecipe(ShapelessRecipeBuilder.shapeless(NeapolitanItems.ADZUKI_CURRY.get()).requires(NeapolitanItems.ROASTED_ADZUKI_BEANS.get()).requires(NeapolitanItems.DRIED_BANANA.get()).requires(Items.CARROT).requires(SeasonalsItems.PUMPKIN_PUREE.get()).requires(Items.BOWL).unlockedBy(getHasName(NeapolitanItems.ROASTED_ADZUKI_BEANS.get()), has(NeapolitanItems.ROASTED_ADZUKI_BEANS.get())), consumer);
        this.outsideRecipeConfigConditionRecipe(ShapelessRecipeBuilder.shapeless(Items.PUMPKIN_PIE).requires(SeasonalsItems.PUMPKIN_PUREE.get()).requires(Items.SUGAR).requires(Tags.Items.EGGS).unlockedBy(getHasName(SeasonalsItems.PUMPKIN_PUREE.get()), has(SeasonalsItems.PUMPKIN_PUREE.get())), consumer);

    }

    public void iceCreamAndBlockRecipe(ItemLike ingredient, Supplier<? extends ItemLike> resultItem, Supplier<? extends ItemLike> resultBlock, Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(resultItem.get()).requires(Items.BOWL).requires(ingredient).requires(SeasonalsItemTags.MILK).requires(NeapolitanItems.ICE_CUBES.get()).requires(Items.SUGAR)
                .unlockedBy(getHasName(ingredient), has(ingredient)).save(consumer);

        ShapedRecipeBuilder.shaped(resultBlock.get(), 8).define('#', Items.SNOW_BLOCK).define('X', resultItem.get()).pattern("###").pattern("#X#").pattern("###")
                .unlockedBy(getHasName(resultItem.get()), has(resultItem.get())).save(consumer);
    }

    public void milkshakeRecipes(ItemLike ingredient, Supplier<? extends ItemLike> iceCream, Supplier<? extends ItemLike> result, Consumer<FinishedRecipe> consumer) {
        String resultName = getItemName(result.get());
        ShapelessRecipeBuilder.shapeless(result.get(), 3).requires(Items.GLASS_BOTTLE, 3).requires(ingredient).requires(NeapolitanItems.VANILLA_ICE_CREAM.get()).requires(SeasonalsItemTags.MILK)
                .unlockedBy(getHasName(ingredient), has(ingredient)).save(consumer);

        ShapelessRecipeBuilder.shapeless(result.get(), 3).requires(Items.GLASS_BOTTLE, 3).requires(iceCream.get()).requires(NeapolitanItems.DRIED_VANILLA_PODS.get()).requires(SeasonalsItemTags.MILK)
                .unlockedBy(getHasName(iceCream.get()), has(iceCream.get())).save(consumer, Seasonals.modPrefix(resultName + "_from_ice_cream"));

        ShapelessRecipeBuilder.shapeless(result.get()).requires(ingredient).requires(NeapolitanItems.VANILLA_MILKSHAKE.get())
                        .unlockedBy(getHasName(ingredient), has(ingredient)).save(consumer, Seasonals.modPrefix(resultName + "_from_vanilla_milkshake"));
    }

    public void cakeRecipes(ItemLike ingredient, Supplier<? extends ItemLike> result, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(result.get()).define('A', SeasonalsItemTags.MILK).define('B', Items.SUGAR).define('C', Items.WHEAT).define('D', ingredient).define('E', Tags.Items.EGGS).pattern("ADA").pattern("BEB").pattern("CDC")
                .unlockedBy(getHasName(ingredient), has(ingredient)).save(consumer);

    }

    public void outsideRecipeConfigConditionRecipe(RecipeBuilder recipe, Consumer<FinishedRecipe> consumer) {
        this.conditionalRecipe(outsideRecipeConfig(), RecipeBuilder.getDefaultRecipeId(recipe.getResult()), recipe, consumer);
    }

    public void conditionalRecipe(ICondition condition, ResourceLocation resultId, RecipeBuilder recipe, Consumer<FinishedRecipe> consumer) {
        ConditionalRecipe.builder().addCondition(condition)
                .addRecipe(consumer1 -> recipe.save(consumer1, Seasonals.modPrefix(resultId.getPath()))).generateAdvancement(new ResourceLocation(resultId.getNamespace(), "recipes/" + recipe.getResult().getItemCategory().getRecipeFolderName() + "/" + resultId.getPath()))
                .build(consumer, Seasonals.modPrefix(resultId.getPath()));
    }
}
