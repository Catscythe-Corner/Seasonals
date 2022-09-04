package com.cosmicgelatin.seasonals.core.registry;

import com.cosmicgelatin.seasonals.common.item.SeasonalsMilkshakeItem;
import com.teamabnormals.blueprint.core.util.registry.ItemSubRegistryHelper;
import com.teamabnormals.neapolitan.core.registry.NeapolitanMobEffects;
import com.cosmicgelatin.seasonals.core.Seasonals;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = Seasonals.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SeasonalsItems {
    public static final ItemSubRegistryHelper HELPER = Seasonals.REGISTRY_HELPER.getItemSubHelper();

    public static final RegistryObject<Item> ROASTED_PUMPKIN = HELPER.createItem("roasted_pumpkin", () -> new Item(new Item.Properties().food(Foods.ROASTED_PUMPKIN).tab(CreativeModeTab.TAB_FOOD)));
    public static final RegistryObject<Item> PUMPKIN_FEAST = HELPER.createItem("pumpkin_feast", () -> new Item(new Item.Properties().food(Foods.PUMPKIN_FEAST).tab(CreativeModeTab.TAB_FOOD)));
    public static final RegistryObject<Item> PUMPKIN_ICE_CREAM = HELPER.createItem("pumpkin_ice_cream", () -> new BowlFoodItem(new Item.Properties().food(Foods.PUMPKIN_ICE_CREAM).craftRemainder(Items.BOWL).stacksTo(1).tab(CreativeModeTab.TAB_FOOD)));
    public static final RegistryObject<Item> PUMPKIN_MILKSHAKE = HELPER.createItem("pumpkin_milkshake", () -> new SeasonalsMilkshakeItem(new Item.Properties().food(Foods.PUMPKIN_MILKSHAKE).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16).tab(CreativeModeTab.TAB_FOOD)));
    public static final RegistryObject<Item> SWEET_BERRY_ICE_CREAM = HELPER.createItem("sweet_berry_ice_cream", () -> new BowlFoodItem(new Item.Properties().food(Foods.SWEET_BERRY_ICE_CREAM).craftRemainder(Items.BOWL).stacksTo(1).tab(CreativeModeTab.TAB_FOOD)));
    public static final RegistryObject<Item> SWEET_BERRY_MILKSHAKE = HELPER.createItem("sweet_berry_milkshake", () -> new SeasonalsMilkshakeItem(new Item.Properties().food(Foods.SWEET_BERRY_MILKSHAKE).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16).tab(CreativeModeTab.TAB_FOOD)));

    public static final RegistryObject<Item> CHOCOLATE_PUMPKIN_MUFFIN = HELPER.createItem("chocolate_pumpkin_muffin", () -> new Item(new Item.Properties().food(Foods.CHOCOLATE_PUMPKIN_MUFFIN).tab(CreativeModeTab.TAB_FOOD)));
    public static final RegistryObject<Item> SWEET_BERRY_VANILLA_YOGURT = HELPER.createItem("sweet_berry_vanilla_yogurt", () -> new BowlFoodItem(new Item.Properties().food(Foods.SWEET_BERRY_VANILLA_YOGURT).craftRemainder(Items.BOWL).stacksTo(1).tab(CreativeModeTab.TAB_FOOD)));

    static class Foods {
        public static final FoodProperties ROASTED_PUMPKIN = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.3F).effect(() -> new MobEffectInstance(SeasonalsEffects.FALL_FLAVOR.get(), 300), 1.0F).build();
        public static final FoodProperties PUMPKIN_ICE_CREAM = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.42F).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 2), 1.0F).effect(() -> new MobEffectInstance(SeasonalsEffects.FALL_FLAVOR.get(), 1600), 1.0F).build();
        public static final FoodProperties PUMPKIN_MILKSHAKE = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.6F).build();
        public static final FoodProperties PUMPKIN_CAKE = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).effect(() -> new MobEffectInstance(SeasonalsEffects.FALL_FLAVOR.get(), 200), 1.0F).build();
        public static final FoodProperties PUMPKIN_FEAST = (new FoodProperties.Builder()).nutrition(12).saturationMod(0.6F).meat().effect(() -> new MobEffectInstance(SeasonalsEffects.FALL_FLAVOR.get(), 700), 1.0F).build();

        public static final FoodProperties SWEET_BERRY_ICE_CREAM = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.42F).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 2), 1.0F).effect(() -> new MobEffectInstance(SeasonalsEffects.THORN_RESISTANCE.get(), 1800), 1.0F).build();
        public static final FoodProperties SWEET_BERRY_MILKSHAKE = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.6F).build();
        public static final FoodProperties SWEET_BERRY_CAKE = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).effect(() -> new MobEffectInstance(SeasonalsEffects.THORN_RESISTANCE.get(), 160), 1.0F).build();

        public static final FoodProperties SWEET_BERRY_VANILLA_YOGURT = (new FoodProperties.Builder()).nutrition(6).saturationMod(1.2F).effect(() -> new MobEffectInstance(SeasonalsEffects.THORN_RESISTANCE.get(), 720), 1.0F).effect(() -> new MobEffectInstance(NeapolitanMobEffects.VANILLA_SCENT.get(), 200), 1.0F).build();
        public static final FoodProperties CHOCOLATE_PUMPKIN_MUFFIN = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.3F).fast().effect(() -> new MobEffectInstance(SeasonalsEffects.FALL_FLAVOR.get(), 200), 1.0F).effect(() -> new MobEffectInstance(NeapolitanMobEffects.SUGAR_RUSH.get(), 100), 1.0F).build();
    }
}