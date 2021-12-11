package com.cosmicgelatin.seasonals.core.registry;

import com.cosmicgelatin.seasonals.common.item.SeasonalsMilkshakeItem;
import com.minecraftabnormals.abnormals_core.core.util.registry.ItemSubRegistryHelper;
import com.minecraftabnormals.neapolitan.core.registry.NeapolitanEffects;
import com.cosmicgelatin.seasonals.core.Seasonals;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = Seasonals.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SeasonalsItems {
    public static final ItemSubRegistryHelper HELPER = Seasonals.REGISTRY_HELPER.getItemSubHelper();

    public static final RegistryObject<Item> ROASTED_PUMPKIN = HELPER.createItem("roasted_pumpkin", () -> new Item(new Item.Properties().food(Foods.ROASTED_PUMPKIN).tab(ItemGroup.TAB_FOOD)));
    public static final RegistryObject<Item> PUMPKIN_FEAST = HELPER.createItem("pumpkin_feast", () -> new Item(new Item.Properties().food(Foods.PUMPKIN_FEAST).tab(ItemGroup.TAB_FOOD)));
    public static final RegistryObject<Item> PUMPKIN_ICE_CREAM = HELPER.createItem("pumpkin_ice_cream", () -> new SoupItem(new Item.Properties().food(Foods.PUMPKIN_ICE_CREAM).craftRemainder(Items.BOWL).stacksTo(1).tab(ItemGroup.TAB_FOOD)));
    public static final RegistryObject<Item> PUMPKIN_MILKSHAKE = HELPER.createItem("pumpkin_milkshake", () -> new SeasonalsMilkshakeItem(new Item.Properties().food(Foods.PUMPKIN_MILKSHAKE).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16).tab(ItemGroup.TAB_FOOD)));
    public static final RegistryObject<Item> PUMPKIN_CAKE = HELPER.createItem("pumpkin_cake", () -> new BlockItem(SeasonalsBlocks.PUMPKIN_CAKE.get(), new Item.Properties().tab(ItemGroup.TAB_FOOD).stacksTo(1)));

    public static final RegistryObject<Item> SWEET_BERRY_ICE_CREAM = HELPER.createItem("sweet_berry_ice_cream", () -> new SoupItem(new Item.Properties().food(Foods.SWEET_BERRY_ICE_CREAM).craftRemainder(Items.BOWL).stacksTo(1).tab(ItemGroup.TAB_FOOD)));
    public static final RegistryObject<Item> SWEET_BERRY_MILKSHAKE = HELPER.createItem("sweet_berry_milkshake", () -> new SeasonalsMilkshakeItem(new Item.Properties().food(Foods.SWEET_BERRY_MILKSHAKE).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16).tab(ItemGroup.TAB_FOOD)));
    public static final RegistryObject<Item> SWEET_BERRY_CAKE = HELPER.createItem("sweet_berry_cake", () -> new BlockItem(SeasonalsBlocks.SWEET_BERRY_CAKE.get(), new Item.Properties().stacksTo(1).tab(ItemGroup.TAB_FOOD)));

    public static final RegistryObject<Item> CHOCOLATE_PUMPKIN_MUFFIN = HELPER.createItem("chocolate_pumpkin_muffin", () -> new Item(new Item.Properties().food(Foods.CHOCOLATE_PUMPKIN_MUFFIN).tab(ItemGroup.TAB_FOOD)));
    public static final RegistryObject<Item> SWEET_BERRY_VANILLA_YOGURT = HELPER.createItem("sweet_berry_vanilla_yogurt", () -> new SoupItem(new Item.Properties().food(Foods.SWEET_BERRY_VANILLA_YOGURT).craftRemainder(Items.BOWL).stacksTo(1).tab(ItemGroup.TAB_FOOD)));

    static class Foods {
        public static final Food ROASTED_PUMPKIN = (new Food.Builder()).nutrition(5).saturationMod(0.3F).effect(() -> new EffectInstance(SeasonalsEffects.PUPPETEERING.get(), 300), 1.0F).build();
        public static final Food PUMPKIN_ICE_CREAM = (new Food.Builder()).nutrition(6).saturationMod(0.42F).effect(() -> new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 100, 2), 1.0F).effect(() -> new EffectInstance(SeasonalsEffects.PUPPETEERING.get(), 1600), 1.0F).build();
        public static final Food PUMPKIN_MILKSHAKE = (new Food.Builder()).nutrition(3).saturationMod(0.6F).build();
        public static final Food PUMPKIN_CAKE = (new Food.Builder()).nutrition(1).saturationMod(0.1F).effect(() -> new EffectInstance(SeasonalsEffects.PUPPETEERING.get(), 200), 1.0F).build();
        public static final Food PUMPKIN_FEAST = (new Food.Builder()).nutrition(12).saturationMod(0.6F).meat().effect(() -> new EffectInstance(SeasonalsEffects.PUPPETEERING.get(), 700), 1.0F).build();

        public static final Food SWEET_BERRY_ICE_CREAM = (new Food.Builder()).nutrition(6).saturationMod(0.42F).effect(() -> new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 100, 2), 1.0F).effect(() -> new EffectInstance(SeasonalsEffects.THORN_RESISTANCE.get(), 1800), 1.0F).build();
        public static final Food SWEET_BERRY_MILKSHAKE = (new Food.Builder()).nutrition(3).saturationMod(0.6F).build();
        public static final Food SWEET_BERRY_CAKE = (new Food.Builder()).nutrition(1).saturationMod(0.1F).effect(() -> new EffectInstance(SeasonalsEffects.THORN_RESISTANCE.get(), 160), 1.0F).build();

        public static final Food SWEET_BERRY_VANILLA_YOGURT = (new Food.Builder()).nutrition(6).saturationMod(1.2F).effect(() -> new EffectInstance(SeasonalsEffects.THORN_RESISTANCE.get(), 720), 1.0F).effect(() -> new EffectInstance(NeapolitanEffects.VANILLA_SCENT.get(), 200), 1.0F).build();
        public static final Food CHOCOLATE_PUMPKIN_MUFFIN = (new Food.Builder()).nutrition(2).saturationMod(0.3F).fast().effect(() -> new EffectInstance(SeasonalsEffects.PUPPETEERING.get(), 200), 1.0F).effect(() -> new EffectInstance(NeapolitanEffects.SUGAR_RUSH.get(), 100), 1.0F).build();
    }
}