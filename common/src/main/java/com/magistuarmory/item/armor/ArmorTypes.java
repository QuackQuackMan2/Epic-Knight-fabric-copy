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
import net.minecraft.world.item.Items;
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
		ArmorTypes.init();
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
					   String repairItem) {
		return new ArmorType(location, modelLocation, config.toughness, config.knockbackResistance, new Integer[] {config.bootsDurability, config.leggingsDurability, config.chestplateDurability, config.helmetDurability}, new Integer[] {config.bootsDefense, config.leggingsDefense, config.chestplateDefense, config.helmetDefense}, config.enchantmentValue, equipSound, dyeable, config.enabled, Ingredient.ofItems(BuiltInRegistries.ITEM.get(ResourceLocation.parse(repairItem))));
	}

	private static ArmorType create(ResourceLocation location,
								   ResourceLocation modelLocation,
								   ArmorConfig.ArmorTypeConfig config,
								   Holder<SoundEvent> equipSound,
								   boolean dyeable,
								   TagKey<Item> repairTag) {
		return new ArmorType(location, modelLocation, config.toughness, config.knockbackResistance, new Integer[] {config.bootsDurability, config.leggingsDurability, config.chestplateDurability, config.helmetDurability}, new Integer[] {config.bootsDefense, config.leggingsDefense, config.chestplateDefense, config.helmetDefense}, config.enchantmentValue, equipSound, dyeable, config.enabled, Ingredient.of(BuiltInRegistries.ITEM.getTagOrEmpty(repairTag)));
	}

	private static ArmorType create(ResourceLocation location,
								   ResourceLocation modelLocation,
								   ArmorConfig.ArmorTypeConfig config,
								   Holder<SoundEvent> equipSound,
								   boolean dyeable) {
		return new ArmorType(location, modelLocation, config.toughness, config.knockbackResistance, new Integer[] {config.bootsDurability, config.leggingsDurability, config.chestplateDurability, config.helmetDurability}, new Integer[] {config.bootsDefense, config.leggingsDefense, config.chestplateDefense, config.helmetDefense}, config.enchantmentValue, equipSound, dyeable, config.enabled, Ingredient.ofItems(Items.AIR));
	}

	public static void init() {
		// Fabric: Register armor materials and types here using Registry.register
		// TODO: Implement registration logic in Fabric style
		MINICROWN = create(ResourceLocation.parse(EpicKnights.ID + ":minicrown"), ResourceLocation.parse(EpicKnights.ID + ":minicrown"), ARMOR_CONFIG.get("minicrown"), SoundEvents.ARMOR_EQUIP_GOLD, true);
		CROWN = create(ResourceLocation.parse(EpicKnights.ID + ":crown"), ResourceLocation.parse(EpicKnights.ID + ":crown"), ARMOR_CONFIG.get("crown"), SoundEvents.ARMOR_EQUIP_GOLD, true);
		FLOWERCROWN = create(ResourceLocation.parse(EpicKnights.ID + ":flowercrown"), ResourceLocation.parse(EpicKnights.ID + ":flowercrown"), ARMOR_CONFIG.get("flowercrown"), SoundEvents.ARMOR_EQUIP_GOLD, true);
		KNIGHT = create(ResourceLocation.parse(EpicKnights.ID + ":knight"), ResourceLocation.parse(EpicKnights.ID + ":knight"), ARMOR_CONFIG.get("knight"), SoundEvents.ARMOR_EQUIP_IRON, true, Items.IRON_INGOT);
		ARMET = create(ResourceLocation.parse(EpicKnights.ID + ":armet"), ResourceLocation.parse(EpicKnights.ID + ":armet"), ARMOR_CONFIG.get("armet"), SoundEvents.ARMOR_EQUIP_IRON, true, "minecraft:iron_ingot");
		STECHHELM = create(ResourceLocation.parse(EpicKnights.ID + ":stechhelm"), ResourceLocation.parse(EpicKnights.ID + ":stechhelm"), ARMOR_CONFIG.get("stechhelm"), SoundEvents.ARMOR_EQUIP_IRON, true, "minecraft:iron_ingot");
		JOUSTING = create(ResourceLocation.parse(EpicKnights.ID + ":jousting"), ResourceLocation.parse(EpicKnights.ID + ":jousting"), ARMOR_CONFIG.get("jousting"), SoundEvents.ARMOR_EQUIP_IRON, true, "minecraft:iron_ingot");
		SALLET = create(ResourceLocation.parse(EpicKnights.ID + ":sallet"), ResourceLocation.parse(EpicKnights.ID + ":sallet"), ARMOR_CONFIG.get("sallet"), SoundEvents.ARMOR_EQUIP_IRON, true, "minecraft:iron_ingot");
		GOTHIC = create(ResourceLocation.parse(EpicKnights.ID + ":gothic"), ResourceLocation.parse(EpicKnights.ID + ":gothic"), ARMOR_CONFIG.get("gothic"), SoundEvents.ARMOR_EQUIP_IRON, true, "minecraft:iron_ingot");
		MAXIMILIAN_HELMET = create(ResourceLocation.parse(EpicKnights.ID + ":maximilianHelmet"), ResourceLocation.parse(EpicKnights.ID + ":maximilianHelmet"), ARMOR_CONFIG.get("maximilianHelmet"), SoundEvents.ARMOR_EQUIP_IRON, true, "minecraft:iron_ingot");
		MAXIMILIAN = create(ResourceLocation.parse(EpicKnights.ID + ":maximilian"), ResourceLocation.parse(EpicKnights.ID + ":maximilian"), ARMOR_CONFIG.get("maximilian"), SoundEvents.ARMOR_EQUIP_IRON, true, "minecraft:iron_ingot");
		CHAINMAIL = create(ResourceLocation.parse(EpicKnights.ID + ":chainmail"), ResourceLocation.parse(EpicKnights.ID + ":chainmail"), ARMOR_CONFIG.get("chainmail"), SoundEvents.ARMOR_EQUIP_CHAIN, true, "minecraft:iron_ingot");
		KETTLEHAT = create(ResourceLocation.parse(EpicKnights.ID + ":kettlehat"), ResourceLocation.parse(EpicKnights.ID + ":kettlehat"), ARMOR_CONFIG.get("kettlehat"), SoundEvents.ARMOR_EQUIP_IRON, true, "minecraft:iron_ingot");
		PLATEMAIL = create(ResourceLocation.parse(EpicKnights.ID + ":platemail"), ResourceLocation.parse(EpicKnights.ID + ":platemail"), ARMOR_CONFIG.get("platemail"), SoundEvents.ARMOR_EQUIP_IRON, true, "minecraft:iron_ingot");
		BARBUTE = create(ResourceLocation.parse(EpicKnights.ID + ":barbute"), ResourceLocation.parse(EpicKnights.ID + ":barbute"), ARMOR_CONFIG.get("barbute"), SoundEvents.ARMOR_EQUIP_IRON, true, "minecraft:iron_ingot");
		HALFARMOR = create(ResourceLocation.parse(EpicKnights.ID + ":halfarmor"), ResourceLocation.parse(EpicKnights.ID + ":halfarmor"), ARMOR_CONFIG.get("halfarmor"), SoundEvents.ARMOR_EQUIP_IRON, true, "minecraft:iron_ingot");
		GREATHELM = create(ResourceLocation.parse(EpicKnights.ID + ":greathelm"), ResourceLocation.parse(EpicKnights.ID + ":greathelm"), ARMOR_CONFIG.get("greathelm"), SoundEvents.ARMOR_EQUIP_IRON, true, "minecraft:iron_ingot");
		CRUSADER = create(ResourceLocation.parse(EpicKnights.ID + ":crusader"), ResourceLocation.parse(EpicKnights.ID + ":crusader"), ARMOR_CONFIG.get("crusader"), SoundEvents.ARMOR_EQUIP_IRON, true, "minecraft:iron_ingot");
		BRIGANDINE = create(ResourceLocation.parse(EpicKnights.ID + ":brigandine"), ResourceLocation.parse(EpicKnights.ID + ":brigandine"), ARMOR_CONFIG.get("brigandine"), SoundEvents.ARMOR_EQUIP_IRON, true, "minecraft:iron_ingot");
		GAMBESON = create(ResourceLocation.parse(EpicKnights.ID + ":gambeson"), ResourceLocation.parse(EpicKnights.ID + ":gambeson"), ARMOR_CONFIG.get("gambeson"), SoundEvents.ARMOR_EQUIP_LEATHER, true, "minecraft:leather");
		CEREMONIAL_ARMET = create(ResourceLocation.parse(EpicKnights.ID + ":ceremonialarmet"), ResourceLocation.parse(EpicKnights.ID + ":ceremonialarmet"), ARMOR_CONFIG.get("ceremonialArmet"), SoundEvents.ARMOR_EQUIP_GOLD, true, "minecraft:gold_ingot");
		CEREMONIAL = create(ResourceLocation.parse(EpicKnights.ID + ":ceremonial"), ResourceLocation.parse(EpicKnights.ID + ":ceremonial"), ARMOR_CONFIG.get("ceremonial"), SoundEvents.ARMOR_EQUIP_GOLD, true, Items.GOLD_INGOT);
		SHISHAK = create(ResourceLocation.parse(EpicKnights.ID + ":shishak"), ResourceLocation.parse(EpicKnights.ID + ":shishak"), ARMOR_CONFIG.get("shishak"), SoundEvents.ARMOR_EQUIP_IRON, true, "minecraft:iron_ingot");
		NORMAN = create(ResourceLocation.parse(EpicKnights.ID + ":norman"), ResourceLocation.parse(EpicKnights.ID + ":norman"), ARMOR_CONFIG.get("norman"), SoundEvents.ARMOR_EQUIP_IRON, true, "minecraft:iron_ingot");
		RUSTED_BARBUTE = create(ResourceLocation.parse(EpicKnights.ID + ":rustedBarbute"), ResourceLocation.parse(EpicKnights.ID + ":rustedBarbute"), ARMOR_CONFIG.get("rustedBarbute"), SoundEvents.ARMOR_EQUIP_IRON, true, "minecraft:iron_ingot");
		RUSTED_HALFARMOR = create(ResourceLocation.parse(EpicKnights.ID + ":rustedHalfarmor"), ResourceLocation.parse(EpicKnights.ID + ":rustedHalfarmor"), ARMOR_CONFIG.get("rustedHalfarmor"), SoundEvents.ARMOR_EQUIP_IRON, true, "minecraft:iron_ingot");
		RUSTED_CHAINMAIL = create(ResourceLocation.parse(EpicKnights.ID + ":rustedChainmail"), ResourceLocation.parse(EpicKnights.ID + ":rustedChainmail"), ARMOR_CONFIG.get("rustedChainmail"), SoundEvents.ARMOR_EQUIP_CHAIN, true, "minecraft:iron_ingot");
		RUSTED_KETTLEHAT = create(ResourceLocation.parse(EpicKnights.ID + ":rustedKettlehat"), ResourceLocation.parse(EpicKnights.ID + ":rustedKettlehat"), ARMOR_CONFIG.get("rustedKettlehat"), SoundEvents.ARMOR_EQUIP_IRON, true, "minecraft:iron_ingot");
		RUSTED_NORMAN = create(ResourceLocation.parse(EpicKnights.ID + ":rustedNorman"), ResourceLocation.parse(EpicKnights.ID + ":rustedNorman"), ARMOR_CONFIG.get("rustedNorman"), SoundEvents.ARMOR_EQUIP_IRON, true, "minecraft:iron_ingot");
		RUSTED_GREATHELM = create(ResourceLocation.parse(EpicKnights.ID + ":rustedGreathelm"), ResourceLocation.parse(EpicKnights.ID + ":rustedGreathelm"), ARMOR_CONFIG.get("rustedGreathelm"), SoundEvents.ARMOR_EQUIP_IRON, true, "minecraft:iron_ingot");
		RUSTED_CRUSADER = create(ResourceLocation.parse(EpicKnights.ID + ":rustedCrusader"), ResourceLocation.parse(EpicKnights.ID + ":rustedCrusader"), ARMOR_CONFIG.get("rustedCrusader"), SoundEvents.ARMOR_EQUIP_IRON, true, "minecraft:iron_ingot");
		BASCINET = create(ResourceLocation.parse(EpicKnights.ID + ":bascinet"), ResourceLocation.parse(EpicKnights.ID + ":bascinet"), ARMOR_CONFIG.get("bascinet"), SoundEvents.ARMOR_EQUIP_IRON, true, "minecraft:iron_ingot");
		XIV_CENTURY_KNIGHT = create(ResourceLocation.parse(EpicKnights.ID + ":xivCenturyKnight"), ResourceLocation.parse(EpicKnights.ID + ":xivCenturyKnight"), ARMOR_CONFIG.get("xivCenturyKnight"), SoundEvents.ARMOR_EQUIP_IRON, true, "minecraft:iron_ingot");
		WINGED_HUSSAR_CHESTPLATE = create(ResourceLocation.parse(EpicKnights.ID + ":wingedHussarChestplate"), ResourceLocation.parse(EpicKnights.ID + ":wingedHussarChestplate"), ARMOR_CONFIG.get("wingedHussarChestplate"), SoundEvents.ARMOR_EQUIP_IRON, true, "minecraft:iron_ingot");
		CUIRASSIER = create(ResourceLocation.parse(EpicKnights.ID + ":cuirassier"), ResourceLocation.parse(EpicKnights.ID + ":cuirassier"), ARMOR_CONFIG.get("cuirassier"), SoundEvents.ARMOR_EQUIP_IRON, true, "minecraft:iron_ingot");
		KASTENBRUST = create(ResourceLocation.parse(EpicKnights.ID + ":kastenbrust"), ResourceLocation.parse(EpicKnights.ID + ":kastenbrust"), ARMOR_CONFIG.get("kastenbrust"), SoundEvents.ARMOR_EQUIP_IRON, true, "minecraft:iron_ingot");
		GRAND_BASCINET = create(ResourceLocation.parse(EpicKnights.ID + ":grandBascinet"), ResourceLocation.parse(EpicKnights.ID + ":grandBascinet"), ARMOR_CONFIG.get("grandBascinet"), SoundEvents.ARMOR_EQUIP_IRON, true, "minecraft:iron_ingot");
		LAMELLAR = create(ResourceLocation.parse(EpicKnights.ID + ":lamellar"), ResourceLocation.parse(EpicKnights.ID + ":lamellar"), ARMOR_CONFIG.get("lamellar"), SoundEvents.ARMOR_EQUIP_IRON, true, "minecraft:iron_ingot");

		// Register armor materials
		MINICROWN.registerArmorMaterial();
		CROWN.registerArmorMaterial();
		FLOWERCROWN.registerArmorMaterial();
		KNIGHT.registerArmorMaterial();
		ARMET.registerArmorMaterial();
		STECHHELM.registerArmorMaterial();
		JOUSTING.registerArmorMaterial();
		SALLET.registerArmorMaterial();
		GOTHIC.registerArmorMaterial();
		MAXIMILIAN_HELMET.registerArmorMaterial();
		MAXIMILIAN.registerArmorMaterial();
		CHAINMAIL.registerArmorMaterial();
		KETTLEHAT.registerArmorMaterial();
		PLATEMAIL.registerArmorMaterial();
		BARBUTE.registerArmorMaterial();
		HALFARMOR.registerArmorMaterial();
		GREATHELM.registerArmorMaterial();
		CRUSADER.registerArmorMaterial();
		BRIGANDINE.registerArmorMaterial();
		GAMBESON.registerArmorMaterial();
		CEREMONIAL_ARMET.registerArmorMaterial();
		CEREMONIAL.registerArmorMaterial();
		SHISHAK.registerArmorMaterial();
		NORMAN.registerArmorMaterial();
		RUSTED_BARBUTE.registerArmorMaterial();
		RUSTED_HALFARMOR.registerArmorMaterial();
		RUSTED_CHAINMAIL.registerArmorMaterial();
		RUSTED_KETTLEHAT.registerArmorMaterial();
		RUSTED_NORMAN.registerArmorMaterial();
		RUSTED_GREATHELM.registerArmorMaterial();
		RUSTED_CRUSADER.registerArmorMaterial();
		BASCINET.registerArmorMaterial();
		XIV_CENTURY_KNIGHT.registerArmorMaterial();
		WINGED_HUSSAR_CHESTPLATE.registerArmorMaterial();
		CUIRASSIER.registerArmorMaterial();
		KASTENBRUST.registerArmorMaterial();
		GRAND_BASCINET.registerArmorMaterial();
		LAMELLAR.registerArmorMaterial();
	}
}
