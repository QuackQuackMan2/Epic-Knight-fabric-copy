package com.magistuarmory.item.armor;

import com.magistuarmory.EpicKnights;
import com.magistuarmory.config.ArmorConfig;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ArmorTypes
{
	public static final ArmorConfig ARMOR_CONFIG = EpicKnights.CONFIG.armor;

// Fabric: No DeferredRegister. We'll register directly in init().

	public static ArmorType MINICROWN;
	public static ArmorType CROWN;
	public static ArmorType FLOWERCROWN;
	public static ArmorType KNIGHT;
	public static ArmorType ARMET;
	public static ArmorType STECHHELM;
	public static ArmorType JOUSTING;
	public static ArmorType SALLET;
	public static ArmorType GOTHIC;
	public static ArmorType MAXIMILIAN_HELMET;
	public static ArmorType MAXIMILIAN;
	public static ArmorType CHAINMAIL;
	public static ArmorType KETTLEHAT;
	public static ArmorType PLATEMAIL;
	public static ArmorType BARBUTE;
	public static ArmorType HALFARMOR;
	public static ArmorType GREATHELM;
	public static ArmorType CRUSADER;
	public static ArmorType BRIGANDINE;
	public static ArmorType GAMBESON;
	public static ArmorType CEREMONIAL_ARMET;
	public static ArmorType CEREMONIAL;
	public static ArmorType SHISHAK;
	public static ArmorType NORMAN;
	public static ArmorType RUSTED_BARBUTE;
	public static ArmorType RUSTED_HALFARMOR;
	public static ArmorType RUSTED_CHAINMAIL;
	public static ArmorType RUSTED_KETTLEHAT;
	public static ArmorType RUSTED_NORMAN;
	public static ArmorType RUSTED_GREATHELM;
	public static ArmorType RUSTED_CRUSADER;
	public static ArmorType BASCINET;
	public static ArmorType XIV_CENTURY_KNIGHT;
	public static ArmorType WINGED_HUSSAR_CHESTPLATE;
	public static ArmorType CUIRASSIER;
	public static ArmorType KASTENBRUST;
	public static ArmorType GRAND_BASCINET;
	public static ArmorType LAMELLAR;

	static {
		// We'll initialize these in init()
	}

private static Ingredient ingredientFromTag(TagKey<Item> tag)
	{
		Iterable<Holder<Item>> holders = BuiltInRegistries.ITEM.getTagOrEmpty(tag);
		List<Holder<Item>> holderList = new ArrayList<>();
		holders.forEach(holderList::add);
		return Ingredient.of(HolderSet.direct(holderList));
	}

	private static ArmorType create(ResourceLocation location,
					   ResourceLocation modelLocation,
					   ArmorConfig.ArmorTypeConfig config,
					   Holder<SoundEvent> equipSound,
					   boolean dyeable,
					   String repairItemTag) {
		TagKey<Item> repairTag = TagKey.create(Registries.ITEM, ResourceLocation.parse(repairItemTag));
		return new ArmorType(location, modelLocation, config.toughness, config.knockbackResistance, new Integer[] {config.bootsDurability, config.leggingsDurability, config.chestplateDurability, config.helmetDurability}, new Integer[] {config.bootsDefense, config.leggingsDefense, config.chestplateDefense, config.helmetDefense}, config.enchantmentValue, equipSound, dyeable, config.enabled, repairTag);
	}

	private static ArmorType create(ResourceLocation location,
								   ResourceLocation modelLocation,
								   ArmorConfig.ArmorTypeConfig config,
								   Holder<SoundEvent> equipSound,
								   boolean dyeable,
								   TagKey<Item> repairTag) {
		return new ArmorType(location, modelLocation, config.toughness, config.knockbackResistance, new Integer[] {config.bootsDurability, config.leggingsDurability, config.chestplateDurability, config.helmetDurability}, new Integer[] {config.bootsDefense, config.leggingsDefense, config.chestplateDefense, config.helmetDefense}, config.enchantmentValue, equipSound, dyeable, config.enabled, repairTag);
	}

	private static ArmorType create(ResourceLocation location,
								   ResourceLocation modelLocation,
								   ArmorConfig.ArmorTypeConfig config,
								   Holder<SoundEvent> equipSound,
								   boolean dyeable) {
		TagKey<Item> repairTag = TagKey.create(Registries.ITEM, ResourceLocation.parse("minecraft:air"));
		return new ArmorType(location, modelLocation, config.toughness, config.knockbackResistance, new Integer[] {config.bootsDurability, config.leggingsDurability, config.chestplateDurability, config.helmetDurability}, new Integer[] {config.bootsDefense, config.leggingsDefense, config.chestplateDefense, config.helmetDefense}, config.enchantmentValue, equipSound, dyeable, config.enabled, repairTag);
	}

	public static void init() {
		// Fabric: Register armor materials and types here using Registry.register
		// TODO: Implement registration logic in Fabric style
		ARMET = create(ResourceLocation.parse(EpicKnights.ID + ":armet"), ResourceLocation.parse(EpicKnights.ID + ":armet"), ARMOR_CONFIG.get("armet"), SoundEvents.ARMOR_EQUIP_IRON, true, "minecraft:iron_ingot");
		KNIGHT = create(ResourceLocation.parse(EpicKnights.ID + ":knight"), ResourceLocation.parse(EpicKnights.ID + ":knight"), ARMOR_CONFIG.get("knight"), SoundEvents.ARMOR_EQUIP_IRON, true, "minecraft:iron_ingot");
		STECHHELM = create(ResourceLocation.parse(EpicKnights.ID + ":stechhelm"), ResourceLocation.parse(EpicKnights.ID + ":stechhelm"), ARMOR_CONFIG.get("stechhelm"), SoundEvents.ARMOR_EQUIP_IRON, true, "minecraft:iron_ingot");
		JOUSTING = create(ResourceLocation.parse(EpicKnights.ID + ":jousting"), ResourceLocation.parse(EpicKnights.ID + ":jousting"), ARMOR_CONFIG.get("jousting"), SoundEvents.ARMOR_EQUIP_IRON, true, "minecraft:iron_ingot");
		SALLET = create(ResourceLocation.parse(EpicKnights.ID + ":sallet"), ResourceLocation.parse(EpicKnights.ID + ":sallet"), ARMOR_CONFIG.get("sallet"), SoundEvents.ARMOR_EQUIP_IRON, true, "minecraft:iron_ingot");
		GOTHIC = create(ResourceLocation.parse(EpicKnights.ID + ":gothic"), ResourceLocation.parse(EpicKnights.ID + ":gothic"), ARMOR_CONFIG.get("gothic"), SoundEvents.ARMOR_EQUIP_IRON, true, "minecraft:iron_ingot");
		CEREMONIAL_ARMET = create(ResourceLocation.parse(EpicKnights.ID + ":ceremonialarmet"), ResourceLocation.parse(EpicKnights.ID + ":ceremonialarmet"), ARMOR_CONFIG.get("ceremonialArmet"), SoundEvents.ARMOR_EQUIP_GOLD, true, "minecraft:gold_ingot");
	}
}
