package com.cosmicgelatin.seasonals.core.registry;

import com.cosmicgelatin.seasonals.common.item.SeasonalsMilkshakeItem;
import com.cosmicgelatin.seasonals.core.Seasonals;
import com.teamabnormals.blueprint.core.util.registry.ItemSubRegistryHelper;
import com.teamabnormals.neapolitan.core.registry.NeapolitanMobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BowlFoodItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;


@Mod.EventBusSubscriber(modid = Seasonals.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SeasonalsItems {
    public static final ItemSubRegistryHelper HELPER = Seasonals.REGISTRY_HELPER.getItemSubHelper();

    //Pumpkin Flavor
    public static final RegistryObject<Item> PUMPKIN_PUREE = HELPER.createItem("pumpkin_puree", () -> new Item(new Item.Properties().food(Foods.PUMPKIN_PUREE).tab(CreativeModeTab.TAB_FOOD)));
    public static final RegistryObject<Item> PUMPKIN_ICE_CREAM = HELPER.createItem("pumpkin_ice_cream", () -> new BowlFoodItem(new Item.Properties().food(Foods.PUMPKIN_ICE_CREAM).craftRemainder(Items.BOWL).stacksTo(1).tab(CreativeModeTab.TAB_FOOD)));
    public static final RegistryObject<Item> PUMPKIN_MILKSHAKE = HELPER.createItem("pumpkin_milkshake", () -> new SeasonalsMilkshakeItem(new Item.Properties().food(Foods.PUMPKIN_MILKSHAKE).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16).tab(CreativeModeTab.TAB_FOOD)));
    public static final RegistryObject<Item> CHOCOLATE_PUMPKIN_MUFFIN = HELPER.createItem("chocolate_pumpkin_muffin", () -> new Item(new Item.Properties().food(Foods.CHOCOLATE_PUMPKIN_MUFFIN).tab(CreativeModeTab.TAB_FOOD)));
    public static final RegistryObject<Item> PUMPKIN_ADZUKI_STEW = HELPER.createItem("pumpkin_adzuki_stew", () -> new BowlFoodItem(new Item.Properties().food(Foods.PUMPKIN_ADZUKI_STEW).stacksTo(1).craftRemainder(Items.BOWL).tab(CreativeModeTab.TAB_FOOD)));

    //Sweet Berry Flavor
    public static final RegistryObject<Item> SWEET_BERRY_ICE_CREAM = HELPER.createItem("sweet_berry_ice_cream", () -> new BowlFoodItem(new Item.Properties().food(Foods.SWEET_BERRY_ICE_CREAM).craftRemainder(Items.BOWL).stacksTo(1).tab(CreativeModeTab.TAB_FOOD)));
    public static final RegistryObject<Item> SWEET_BERRY_MILKSHAKE = HELPER.createItem("sweet_berry_milkshake", () -> new SeasonalsMilkshakeItem(new Item.Properties().food(Foods.SWEET_BERRY_MILKSHAKE).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16).tab(CreativeModeTab.TAB_FOOD)));
    public static final RegistryObject<Item> GLAZED_SWEET_BERRIES = HELPER.createItem("glazed_sweet_berries", () -> new Item(new Item.Properties().food(Foods.GLAZED_SWEET_BERRIES).tab(CreativeModeTab.TAB_FOOD)));
    public static final RegistryObject<Item> SWEET_BERRY_VANILLA_YOGURT = HELPER.createItem("sweet_berry_vanilla_yogurt", () -> new BowlFoodItem(new Item.Properties().food(Foods.SWEET_BERRY_VANILLA_YOGURT).craftRemainder(Items.BOWL).stacksTo(1).tab(CreativeModeTab.TAB_FOOD)));

    //Other Food
    public static final RegistryObject<Item> RABBIT_ROAST = HELPER.createItem("rabbit_roast", () -> new Item(new Item.Properties().food(Foods.RABBIT_ROAST).tab(CreativeModeTab.TAB_FOOD)));
    public static final RegistryObject<Item> MIXED_BERRY_MUFFIN = HELPER.createItem("mixed_berry_muffin", () -> new Item(new Item.Properties().food(Foods.MIXED_BERRY_MUFFIN).tab(CreativeModeTab.TAB_FOOD)));
    public static final RegistryObject<Item> BANANA_SPLIT_SUNDAE = HELPER.createItem("banana_split_sundae", () -> new Item(new Item.Properties().food(Foods.BANANA_SPLIT_SUNDAE).tab(CreativeModeTab.TAB_FOOD)));

    static class Foods {//TODO probably rebalance stats and potions
        public static final FoodProperties PUMPKIN_PUREE = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.3F).effect(() -> new MobEffectInstance(SeasonalsMobEffects.STUFFED.get(), 300), 1.0F).build();
        public static final FoodProperties PUMPKIN_ICE_CREAM = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.42F).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 2), 1.0F).effect(() -> new MobEffectInstance(SeasonalsMobEffects.STUFFED.get(), 1600), 1.0F).build();
        public static final FoodProperties PUMPKIN_MILKSHAKE = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.6F).build();
        public static final FoodProperties PUMPKIN_CAKE = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).effect(() -> new MobEffectInstance(SeasonalsMobEffects.STUFFED.get(), 200), 1.0F).build();
        public static final FoodProperties CHOCOLATE_PUMPKIN_MUFFIN = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.3F).fast().effect(() -> new MobEffectInstance(SeasonalsMobEffects.STUFFED.get(), 200), 1.0F).effect(() -> new MobEffectInstance(NeapolitanMobEffects.SUGAR_RUSH.get(), 100), 1.0F).build();
        public static final FoodProperties RABBIT_ROAST = (new FoodProperties.Builder()).nutrition(12).saturationMod(0.6F).meat().effect(() -> new MobEffectInstance(SeasonalsMobEffects.STUFFED.get(), 320), 1.0F).effect(() -> new MobEffectInstance(SeasonalsMobEffects.ROOTED.get(), 1160), 1.0F).build();
        public static final FoodProperties PUMPKIN_ADZUKI_STEW = (new FoodProperties.Builder()).nutrition(12).saturationMod(0.6F).effect(() -> new MobEffectInstance(SeasonalsMobEffects.STUFFED.get(), 700), 1.0F).effect(() -> new MobEffectInstance(NeapolitanMobEffects.HARMONY.get(), 400), 1.0F).build();
        public static final FoodProperties SWEET_BERRY_ICE_CREAM = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.42F).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 2), 1.0F).effect(() -> new MobEffectInstance(SeasonalsMobEffects.THORN_RESISTANCE.get(), 1800), 1.0F).build();
        public static final FoodProperties SWEET_BERRY_MILKSHAKE = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.6F).build();
        public static final FoodProperties SWEET_BERRY_CAKE = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).effect(() -> new MobEffectInstance(SeasonalsMobEffects.THORN_RESISTANCE.get(), 160), 1.0F).build();
        public static final FoodProperties SWEET_BERRY_VANILLA_YOGURT = (new FoodProperties.Builder()).nutrition(6).saturationMod(1.2F).effect(() -> new MobEffectInstance(SeasonalsMobEffects.THORN_RESISTANCE.get(), 720), 1.0F).effect(() -> new MobEffectInstance(NeapolitanMobEffects.VANILLA_SCENT.get(), 200), 1.0F).build();
        public static final FoodProperties GLAZED_SWEET_BERRIES = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.2F).fast().effect(() -> new MobEffectInstance(SeasonalsMobEffects.THORN_RESISTANCE.get(), 720), 1.0F).build();
        public static final FoodProperties MIXED_BERRY_MUFFIN = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.2F).fast().effect(() -> new MobEffectInstance(SeasonalsMobEffects.THORN_RESISTANCE.get(), 200), 1.0F).effect(() -> new MobEffectInstance(NeapolitanMobEffects.SUGAR_RUSH.get(), 100), 1.0F).build();
        public static final FoodProperties BANANA_SPLIT_SUNDAE = (new FoodProperties.Builder()).nutrition(10).saturationMod(0.4F).fast().effect(() -> new MobEffectInstance(SeasonalsMobEffects.THORN_RESISTANCE.get(), 720), 1.0F).effect(() -> new MobEffectInstance(NeapolitanMobEffects.SUGAR_RUSH.get(), 720), 1.0F).effect(() -> new MobEffectInstance(NeapolitanMobEffects.AGILITY.get(), 720), 1.0F).build();

    }
}