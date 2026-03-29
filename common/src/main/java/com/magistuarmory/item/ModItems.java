package com.magistuarmory.item;

import com.magistuarmory.EpicKnights;
import com.magistuarmory.api.item.ModItemsProvider;
import com.magistuarmory.block.ModBlocks;
import com.magistuarmory.config.ShieldsConfig;
import com.magistuarmory.config.WeaponsConfig;
import com.magistuarmory.item.armor.*;
import com.magistuarmory.misc.ModBannerPatternTags;
import dev.architectury.platform.Platform;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.annotation.Nullable;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.Holder;
import net.minecraft.world.item.*;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.SmithingTemplateItem;
import net.minecraft.world.item.equipment.ArmorMaterials;
import net.minecraft.world.level.material.MapColor;

import java.util.List;
import java.util.function.BiFunction;

public class ModItems extends ModItemsProvider {
	private static final WeaponsConfig WEAPONS_CONFIG = EpicKnights.CONFIG.weapons;
	private static final ShieldsConfig SHIELDS_CONFIG = EpicKnights.CONFIG.shields;

	public static ModItems INSTANCE = new ModItems();

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(EpicKnights.ID, net.minecraft.core.registries.Registries.ITEM);

	// Armor
	public static final RegistrySupplier<Item> ARMET = ITEMS.register("armet", () -> { Item.Properties p = new Item.Properties(); setId(p, "armet"); return new KnightItem(ArmorTypes.ARMET, net.minecraft.world.item.equipment.ArmorType.HELMET, p); });
	public static final RegistrySupplier<Item> KNIGHT_CHESTPLATE = ITEMS.register("knight_chestplate", () -> { Item.Properties p = new Item.Properties(); setId(p, "knight_chestplate"); return new MedievalArmorItem(ArmorTypes.KNIGHT, net.minecraft.world.item.equipment.ArmorType.CHESTPLATE, p); });
	public static final RegistrySupplier<Item> KNIGHT_LEGGINGS = ITEMS.register("knight_leggings", () -> new MedievalArmorItem(ArmorTypes.KNIGHT, net.minecraft.world.item.equipment.ArmorType.LEGGINGS, new Item.Properties()));
	public static final RegistrySupplier<Item> KNIGHT_BOOTS = ITEMS.register("knight_boots", () -> new MedievalArmorItem(ArmorTypes.KNIGHT, net.minecraft.world.item.equipment.ArmorType.BOOTS, new Item.Properties()));

	public static final RegistrySupplier<Item> STECHHELM = ITEMS.register("stechhelm", () -> new MedievalArmorItem(ArmorTypes.STECHHELM, net.minecraft.world.item.equipment.ArmorType.HELMET, new Item.Properties()));
	public static final RegistrySupplier<Item> JOUSTING_CHESTPLATE = ITEMS.register("jousting_chestplate", () -> new MedievalArmorItem(ArmorTypes.JOUSTING, net.minecraft.world.item.equipment.ArmorType.CHESTPLATE, new Item.Properties()));
	public static final RegistrySupplier<Item> JOUSTING_LEGGINGS = ITEMS.register("jousting_leggings", () -> new MedievalArmorItem(ArmorTypes.JOUSTING, net.minecraft.world.item.equipment.ArmorType.LEGGINGS, new Item.Properties()));
	public static final RegistrySupplier<Item> JOUSTING_BOOTS = ITEMS.register("jousting_boots", () -> new MedievalArmorItem(ArmorTypes.JOUSTING, net.minecraft.world.item.equipment.ArmorType.BOOTS, new Item.Properties()));

	public static final RegistrySupplier<Item> SALLET = ITEMS.register("sallet", () -> new MedievalArmorItem(ArmorTypes.SALLET, net.minecraft.world.item.equipment.ArmorType.HELMET, new Item.Properties()));
	public static final RegistrySupplier<Item> GOTHIC_CHESTPLATE = ITEMS.register("gothic_chestplate", () -> new MedievalArmorItem(ArmorTypes.GOTHIC, net.minecraft.world.item.equipment.ArmorType.CHESTPLATE, new Item.Properties()));
	public static final RegistrySupplier<Item> GOTHIC_LEGGINGS = ITEMS.register("gothic_leggings", () -> new MedievalArmorItem(ArmorTypes.GOTHIC, net.minecraft.world.item.equipment.ArmorType.LEGGINGS, new Item.Properties()));
	public static final RegistrySupplier<Item> GOTHIC_BOOTS = ITEMS.register("gothic_boots", () -> new MedievalArmorItem(ArmorTypes.GOTHIC, net.minecraft.world.item.equipment.ArmorType.BOOTS, new Item.Properties()));

	public static final RegistrySupplier<Item> MAXIMILIAN_HELMET = ITEMS.register("maximilian_helmet", () -> new MedievalArmorItem(ArmorTypes.MAXIMILIAN_HELMET, net.minecraft.world.item.equipment.ArmorType.HELMET, new Item.Properties()));
	public static final RegistrySupplier<Item> MAXIMILIAN_CHESTPLATE = ITEMS.register("maximilian_chestplate", () -> new MedievalArmorItem(ArmorTypes.MAXIMILIAN, net.minecraft.world.item.equipment.ArmorType.CHESTPLATE, new Item.Properties()));
	public static final RegistrySupplier<Item> MAXIMILIAN_LEGGINGS = ITEMS.register("maximilian_leggings", () -> new MedievalArmorItem(ArmorTypes.MAXIMILIAN, net.minecraft.world.item.equipment.ArmorType.LEGGINGS, new Item.Properties()));
	public static final RegistrySupplier<Item> MAXIMILIAN_BOOTS = ITEMS.register("maximilian_boots", () -> new MedievalArmorItem(ArmorTypes.MAXIMILIAN, net.minecraft.world.item.equipment.ArmorType.BOOTS, new Item.Properties()));

	public static final RegistrySupplier<Item> CHAINMAIL_HELMET = ITEMS.register("chainmail_helmet", () -> new MedievalArmorItem(ArmorTypes.CHAINMAIL, net.minecraft.world.item.equipment.ArmorType.HELMET, new Item.Properties()));
	public static final RegistrySupplier<Item> CHAINMAIL_CHESTPLATE = ITEMS.register("chainmail_chestplate", () -> new MedievalArmorItem(ArmorTypes.CHAINMAIL, net.minecraft.world.item.equipment.ArmorType.CHESTPLATE, new Item.Properties()));
	public static final RegistrySupplier<Item> CHAINMAIL_LEGGINGS = ITEMS.register("chainmail_leggings", () -> new MedievalArmorItem(ArmorTypes.CHAINMAIL, net.minecraft.world.item.equipment.ArmorType.LEGGINGS, new Item.Properties()));
	public static final RegistrySupplier<Item> CHAINMAIL_BOOTS = ITEMS.register("chainmail_boots", () -> new MedievalArmorItem(ArmorTypes.CHAINMAIL, net.minecraft.world.item.equipment.ArmorType.BOOTS, new Item.Properties()));

	public ModItems() {
		super(EpicKnights.ID);
	}

	public static void register() {
		ITEMS.register();
	}

	private static void setId(Item.Properties p, String id) {
		try {
			java.lang.reflect.Field field = p.getClass().getDeclaredField("id");
			field.setAccessible(true);
			field.set(p, ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(EpicKnights.ID, id)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static final RegistrySupplier<Item> KETTLEHAT = ITEMS.register("kettlehat", () -> new MedievalArmorItem(ArmorTypes.KETTLEHAT, net.minecraft.world.item.equipment.ArmorType.HELMET, new Item.Properties()));
	public static final RegistrySupplier<Item> PLATEMAIL_CHESTPLATE = ITEMS.register("platemail_chestplate", () -> new MedievalArmorItem(ArmorTypes.PLATEMAIL, net.minecraft.world.item.equipment.ArmorType.CHESTPLATE, new Item.Properties()));
	public static final RegistrySupplier<Item> PLATEMAIL_LEGGINGS = ITEMS.register("platemail_leggings", () -> new MedievalArmorItem(ArmorTypes.PLATEMAIL, net.minecraft.world.item.equipment.ArmorType.LEGGINGS, new Item.Properties()));
	public static final RegistrySupplier<Item> PLATEMAIL_BOOTS = ITEMS.register("platemail_boots", () -> new MedievalArmorItem(ArmorTypes.PLATEMAIL, net.minecraft.world.item.equipment.ArmorType.BOOTS, new Item.Properties()));

	public static final RegistrySupplier<Item> BARBUTE = ITEMS.register("barbute", () -> new MedievalArmorItem(ArmorTypes.BARBUTE, net.minecraft.world.item.equipment.ArmorType.HELMET, new Item.Properties()));
	public static final RegistrySupplier<Item> HALFARMOR_CHESTPLATE = ITEMS.register("halfarmor_chestplate", () -> new MedievalArmorItem(ArmorTypes.HALFARMOR, net.minecraft.world.item.equipment.ArmorType.CHESTPLATE, new Item.Properties()));

	public static final RegistrySupplier<Item> GREATHELM = ITEMS.register("greathelm", () -> new DyeableMedievalArmorItem(ArmorTypes.GREATHELM, net.minecraft.world.item.equipment.ArmorType.HELMET, new Item.Properties(), 0xd3d3d3));
	public static final RegistrySupplier<Item> CRUSADER_CHESTPLATE = ITEMS.register("crusader_chestplate", () -> new DyeableMedievalArmorItem(ArmorTypes.CRUSADER, net.minecraft.world.item.equipment.ArmorType.CHESTPLATE, new Item.Properties(), -3227226));
	public static final RegistrySupplier<Item> CRUSADER_LEGGINGS = ITEMS.register("crusader_leggings", () -> new MedievalArmorItem(ArmorTypes.CRUSADER, net.minecraft.world.item.equipment.ArmorType.LEGGINGS, new Item.Properties()));
	public static final RegistrySupplier<Item> CRUSADER_BOOTS = ITEMS.register("crusader_boots", () -> new DyeableMedievalArmorItem(ArmorTypes.CRUSADER, net.minecraft.world.item.equipment.ArmorType.BOOTS, new Item.Properties(), -3227226));

	public static final RegistrySupplier<Item> CEREMONIAL_ARMET = ITEMS.register("ceremonialarmet", () -> new KnightItem(ArmorTypes.CEREMONIAL_ARMET, net.minecraft.world.item.equipment.ArmorType.HELMET, new Item.Properties()));
	public static final RegistrySupplier<Item> CEREMONIAL_CHESTPLATE = ITEMS.register("ceremonial_chestplate", () -> new MedievalArmorItem(ArmorTypes.CEREMONIAL, net.minecraft.world.item.equipment.ArmorType.CHESTPLATE, new Item.Properties()));
	public static final RegistrySupplier<Item> CEREMONIAL_BOOTS = ITEMS.register("ceremonial_boots", () -> new MedievalArmorItem(ArmorTypes.CEREMONIAL, net.minecraft.world.item.equipment.ArmorType.BOOTS, new Item.Properties()));

	public static final RegistrySupplier<Item> COIF = ITEMS.register("coif", () -> new DyeableMedievalArmorItem(ArmorTypes.GAMBESON, net.minecraft.world.item.equipment.ArmorType.HELMET, new Item.Properties(), -4280691));
	public static final RegistrySupplier<Item> GAMBESON = ITEMS.register("gambeson_chestplate", () -> new DyeableMedievalArmorItem(ArmorTypes.GAMBESON, net.minecraft.world.item.equipment.ArmorType.CHESTPLATE, new Item.Properties(), -4280691));
	public static final RegistrySupplier<Item> PANTYHOSE = ITEMS.register("pantyhose", () -> new DyeableMedievalArmorItem(ArmorTypes.GAMBESON, net.minecraft.world.item.equipment.ArmorType.LEGGINGS, new Item.Properties(), 0x22462C));
	public static final RegistrySupplier<Item> GAMBESON_BOOTS = ITEMS.register("gambeson_boots", () -> new DyeableMedievalArmorItem(ArmorTypes.GAMBESON, net.minecraft.world.item.equipment.ArmorType.BOOTS, new Item.Properties(), -4280691));

	public static final RegistrySupplier<Item> BRIGANDINE = ITEMS.register("brigandine_chestplate", () -> new DyeableMedievalArmorItem(ArmorTypes.BRIGANDINE, net.minecraft.world.item.equipment.ArmorType.CHESTPLATE, new Item.Properties(), 10511680));

	public static final RegistrySupplier<Item> NORMAN_HELMET = ITEMS.register("norman_helmet", () -> new DyeableMedievalArmorItem(ArmorTypes.NORMAN, net.minecraft.world.item.equipment.ArmorType.HELMET, new Item.Properties(), 0xF1F1F1));

	public static final RegistrySupplier<Item> SHISHAK = ITEMS.register("shishak", () -> new MedievalArmorItem(ArmorTypes.SHISHAK, net.minecraft.world.item.equipment.ArmorType.HELMET, new Item.Properties()));

	public static final RegistrySupplier<Item> RUSTED_BARBUTE = ITEMS.register("rustedbarbute", () -> new MedievalArmorItem(ArmorTypes.RUSTED_BARBUTE, net.minecraft.world.item.equipment.ArmorType.HELMET, new Item.Properties()));
	public static final RegistrySupplier<Item> RUSTED_HALFARMOR_CHESTPLATE = ITEMS.register("rustedhalfarmor_chestplate", () -> new MedievalArmorItem(ArmorTypes.RUSTED_HALFARMOR, net.minecraft.world.item.equipment.ArmorType.CHESTPLATE, new Item.Properties()));

	public static final RegistrySupplier<Item> RUSTED_GREATHELM = ITEMS.register("rustedgreathelm", () -> new MedievalArmorItem(ArmorTypes.RUSTED_GREATHELM, net.minecraft.world.item.equipment.ArmorType.HELMET, new Item.Properties()));
	public static final RegistrySupplier<Item> RUSTED_CRUSADER_CHESTPLATE = ITEMS.register("rustedcrusader_chestplate", () -> new MedievalArmorItem(ArmorTypes.RUSTED_CRUSADER, net.minecraft.world.item.equipment.ArmorType.CHESTPLATE, new Item.Properties()));
	public static final RegistrySupplier<Item> RUSTED_CRUSADER_BOOTS = ITEMS.register("rustedcrusader_boots", () -> new MedievalArmorItem(ArmorTypes.RUSTED_CRUSADER, net.minecraft.world.item.equipment.ArmorType.BOOTS, new Item.Properties()));

	public static final RegistrySupplier<Item> RUSTED_NORMAN_HELMET = ITEMS.register("rustednorman_helmet", () -> new MedievalArmorItem(ArmorTypes.RUSTED_NORMAN, net.minecraft.world.item.equipment.ArmorType.HELMET, new Item.Properties()));

	public static final RegistrySupplier<Item> RUSTED_CHAINMAIL_HELMET = ITEMS.register("rustedchainmail_helmet", () -> new MedievalArmorItem(ArmorTypes.RUSTED_CHAINMAIL, net.minecraft.world.item.equipment.ArmorType.HELMET, new Item.Properties()));
	public static final RegistrySupplier<Item> RUSTED_CHAINMAIL_CHESTPLATE = ITEMS.register("rustedchainmail_chestplate", () -> new MedievalArmorItem(ArmorTypes.RUSTED_CHAINMAIL, net.minecraft.world.item.equipment.ArmorType.CHESTPLATE, new Item.Properties()));
	public static final RegistrySupplier<Item> RUSTED_CHAINMAIL_LEGGINGS = ITEMS.register("rustedchainmail_leggings", () -> new MedievalArmorItem(ArmorTypes.RUSTED_CHAINMAIL, net.minecraft.world.item.equipment.ArmorType.LEGGINGS, new Item.Properties()));
	public static final RegistrySupplier<Item> RUSTED_CHAINMAIL_BOOTS = ITEMS.register("rustedchainmail_boots", () -> new MedievalArmorItem(ArmorTypes.RUSTED_CHAINMAIL, net.minecraft.world.item.equipment.ArmorType.BOOTS, new Item.Properties()));

	public static final RegistrySupplier<Item> RUSTED_KETTLEHAT = ITEMS.register("rustedkettlehat", () -> new MedievalArmorItem(ArmorTypes.RUSTED_KETTLEHAT, net.minecraft.world.item.equipment.ArmorType.HELMET, new Item.Properties()));

	public static final RegistrySupplier<Item> BASCINET = ITEMS.register("bascinet", () -> new MedievalArmorItem(ArmorTypes.BASCINET, net.minecraft.world.item.equipment.ArmorType.HELMET, new Item.Properties()));
	public static final RegistrySupplier<Item> XIV_CENTURY_KNIGHT_CHESTPLATE = ITEMS.register("xivcenturyknight_chestplate", () -> new MedievalArmorItem(ArmorTypes.XIV_CENTURY_KNIGHT, net.minecraft.world.item.equipment.ArmorType.CHESTPLATE, new Item.Properties()));
	public static final RegistrySupplier<Item> XIV_CENTURY_KNIGHT_LEGGINGS = ITEMS.register("xivcenturyknight_leggings", () -> new MedievalArmorItem(ArmorTypes.XIV_CENTURY_KNIGHT, net.minecraft.world.item.equipment.ArmorType.LEGGINGS, new Item.Properties()));
	public static final RegistrySupplier<Item> XIV_CENTURY_KNIGHT_BOOTS = ITEMS.register("xivcenturyknight_boots", () -> new MedievalArmorItem(ArmorTypes.XIV_CENTURY_KNIGHT, net.minecraft.world.item.equipment.ArmorType.BOOTS, new Item.Properties()));

	public static final RegistrySupplier<Item> WINGED_HUSSAR_CHESTPLATE = ITEMS.register("wingedhussar_chestplate", () -> new MedievalArmorItem(ArmorTypes.WINGED_HUSSAR_CHESTPLATE, net.minecraft.world.item.equipment.ArmorType.CHESTPLATE, new Item.Properties()));

	public static final RegistrySupplier<Item> BURGONET = ITEMS.register("cuirassier_helmet", () -> new MedievalArmorItem(ArmorTypes.CUIRASSIER, net.minecraft.world.item.equipment.ArmorType.HELMET, new Item.Properties()));
	public static final RegistrySupplier<Item> CUIRASSIER_CHESTPLATE = ITEMS.register("cuirassier_chestplate", () -> new DyeableMedievalArmorItem(ArmorTypes.CUIRASSIER, net.minecraft.world.item.equipment.ArmorType.CHESTPLATE, new Item.Properties(), -5465480));
	public static final RegistrySupplier<Item> CUIRASSIER_LEGGINGS = ITEMS.register("cuirassier_leggings", () -> new DyeableMedievalArmorItem(ArmorTypes.CUIRASSIER, net.minecraft.world.item.equipment.ArmorType.LEGGINGS, new Item.Properties(), -5465480));
	public static final RegistrySupplier<Item> CUIRASSIER_BOOTS = ITEMS.register("cuirassier_boots", () -> new MedievalArmorItem(ArmorTypes.CUIRASSIER, net.minecraft.world.item.equipment.ArmorType.BOOTS, new Item.Properties()));

	public static final RegistrySupplier<Item> GRAND_BASCINET = ITEMS.register("grand_bascinet", () -> new MedievalArmorItem(ArmorTypes.GRAND_BASCINET, net.minecraft.world.item.equipment.ArmorType.HELMET, new Item.Properties()));
	public static final RegistrySupplier<Item> KASTENBRUST_CHESTPLATE = ITEMS.register("kastenbrust_chestplate", () -> new MedievalArmorItem(ArmorTypes.KASTENBRUST, net.minecraft.world.item.equipment.ArmorType.CHESTPLATE, new Item.Properties()));
	public static final RegistrySupplier<Item> KASTENBRUST_LEGGINGS = ITEMS.register("kastenbrust_leggings", () -> new MedievalArmorItem(ArmorTypes.KASTENBRUST, net.minecraft.world.item.equipment.ArmorType.LEGGINGS, new Item.Properties()));
	public static final RegistrySupplier<Item> KASTENBRUST_BOOTS = ITEMS.register("kastenbrust_boots", () -> new MedievalArmorItem(ArmorTypes.KASTENBRUST, net.minecraft.world.item.equipment.ArmorType.BOOTS, new Item.Properties()));

	public static final RegistrySupplier<Item> FACE_HELMET = ITEMS.register("face_helmet", () -> new MedievalArmorItem(ArmorTypes.LAMELLAR, net.minecraft.world.item.equipment.ArmorType.HELMET, new Item.Properties()));
	public static final RegistrySupplier<Item> LAMELLAR_CHESTPLATE = ITEMS.register("lamellar_chestplate", () -> new MedievalArmorItem(ArmorTypes.LAMELLAR, net.minecraft.world.item.equipment.ArmorType.CHESTPLATE, new Item.Properties()));
	public static final RegistrySupplier<Item> LAMELLAR_BOOTS = ITEMS.register("lamellar_boots", () -> new MedievalArmorItem(ArmorTypes.LAMELLAR, net.minecraft.world.item.equipment.ArmorType.BOOTS, new Item.Properties()));

	public static final RegistrySupplier<Item> BARDING = ITEMS.register("barding", () -> new MedievalHorseArmorItem(Holder.direct(ArmorMaterials.DIAMOND), ResourceLocation.fromNamespaceAndPath(EpicKnights.ID, "textures/entity/horse/armor/barding.png"), false, new Item.Properties().stacksTo(1)));
	public static final RegistrySupplier<Item> CHAINMAIL_HORSE_ARMOR = ITEMS.register("chainmail_horse_armor", () -> new MedievalHorseArmorItem(Holder.direct(ArmorMaterials.IRON), ResourceLocation.fromNamespaceAndPath(EpicKnights.ID, "textures/entity/horse/armor/horse_armor_chainmail.png"), false, new Item.Properties().stacksTo(1)));

	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalShieldItem>> HEATER_SHIELD_SUPPLY = (material, prop) -> INSTANCE.addMedievalShieldItem(material.getMaterialName() + "_heatershield", "heatershield", prop, material, true, true, SHIELDS_CONFIG.get("heaterShield"));
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalShieldItem>> TARGET_SUPPLY = (material, prop) -> INSTANCE.addMedievalShieldItem(material.getMaterialName() + "_target", "target", prop, material, false, true, SHIELDS_CONFIG.get("target"));
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalShieldItem>> BUCKLER_SUPPLY = (material, prop) -> INSTANCE.addMedievalShieldItem(material.getMaterialName() + "_buckler", "buckler", prop, material, false, true, SHIELDS_CONFIG.get("buckler"));
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalShieldItem>> RONDACHE_SUPPLY = (material, prop) -> INSTANCE.addMedievalShieldItem(material.getMaterialName() + "_rondache", "rondache", prop, material, false, true, SHIELDS_CONFIG.get("rondache"));
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalShieldItem>> TARTSCHE_SUPPLY = (material, prop) -> INSTANCE.addMedievalShieldItem(material.getMaterialName() + "_tartsche", "tartsche", prop, material, true, true, SHIELDS_CONFIG.get("tartsche"));
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalShieldItem>> ELLIPTICAL_SHIELD_SUPPLY = (material, prop) -> INSTANCE.addMedievalShieldItem(material.getMaterialName() + "_ellipticalshield", "ellipticalshield", prop, material, true, true, SHIELDS_CONFIG.get("ellipticalShield"));
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalShieldItem>> ROUND_SHIELD_SUPPLY = (material, prop) -> INSTANCE.addMedievalShieldItem(material.getMaterialName() + "_roundshield", "roundshield", prop, material, true, true, SHIELDS_CONFIG.get("roundShield"));
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalShieldItem>> PAVISE_SUPPLY = (material, prop) -> INSTANCE.addPaviseItem(material.getMaterialName() + "_pavese", "pavese", prop, material, true, true, SHIELDS_CONFIG.get("pavise"), () -> ModBlocks.getPaviseByMaterialName(material));
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalShieldItem>> KITE_SHIELD_SUPPLY = (material, prop) -> INSTANCE.addMedievalShieldItem(material.getMaterialName() + "_kiteshield", "kiteshield", prop, material, true, true, SHIELDS_CONFIG.get("kiteShield"));

	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> STILETTO_SUPPLY = (material, prop) -> INSTANCE.addMedievalWeaponItem(material.getMaterialName() + "_stylet", prop, material, WEAPONS_CONFIG.getMelee("stiletto"));
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> SHORT_SWORD_SUPPLY = (material, prop) -> INSTANCE.addMedievalWeaponItem(material.getMaterialName() + "_shortsword", prop, material, WEAPONS_CONFIG.getMelee("shortSword"));
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> KATZBALGER_SUPPLY = (material, prop) -> INSTANCE.addMedievalWeaponItem(material.getMaterialName() + "_katzbalger", prop, material, WEAPONS_CONFIG.getMelee("katzbalger"));
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> PIKE_SUPPLY = (material, prop) -> INSTANCE.addMedievalWeaponItem(material.getMaterialName() + "_pike", prop, material, WEAPONS_CONFIG.getMelee("pike"));
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> RANSEUR_SUPPLY = (material, prop) -> INSTANCE.addMedievalWeaponItem(material.getMaterialName() + "_ranseur", prop, material, WEAPONS_CONFIG.getMelee("ranseur"));
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> AHLSPIESS_SUPPLY = (material, prop) -> INSTANCE.addMedievalWeaponItem(material.getMaterialName() + "_ahlspiess", prop, material, WEAPONS_CONFIG.getMelee("ahlspiess"));
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> GIANT_LANCE_SUPPLY = (material, prop) -> INSTANCE.addLanceItem(material.getMaterialName() + "_chivalrylance", prop, material, WEAPONS_CONFIG.getMelee("giantLance"));
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> BASTARD_SWORD_SUPPLY = (material, prop) -> INSTANCE.addMedievalWeaponItem(material.getMaterialName() + "_bastardsword", prop, material, WEAPONS_CONFIG.getMelee("bastardSword"));
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> ESTOC_SUPPLY = (material, prop) -> INSTANCE.addMedievalWeaponItem(material.getMaterialName() + "_estoc", prop, material, WEAPONS_CONFIG.getMelee("estoc"));
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> CLAYMORE_SUPPLY = (material, prop) -> INSTANCE.addMedievalWeaponItem(material.getMaterialName() + "_claymore", prop, material, WEAPONS_CONFIG.getMelee("claymore"));
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> ZWEIHANDER_SUPPLY = (material, prop) -> INSTANCE.addMedievalWeaponItem(material.getMaterialName() + "_zweihander", prop, material, WEAPONS_CONFIG.getMelee("zweihander"));
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> FlAME_BLADED_SWORD_SUPPLY = (material, prop) -> INSTANCE.addMedievalWeaponItem(material.getMaterialName() + "_flamebladedsword", prop, material, WEAPONS_CONFIG.getMelee("flameBladedSword"));
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> LOCHABER_AXE_SUPPLY = (material, prop) -> INSTANCE.addMedievalWeaponItem(material.getMaterialName() + "_lochaberaxe", prop, material, WEAPONS_CONFIG.getMelee("lochaberAxe"));
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> CONCAVE_EDGED_HALBERD_SUPPLY = (material, prop) -> INSTANCE.addMedievalWeaponItem(material.getMaterialName() + "_concavehalberd", prop, material, WEAPONS_CONFIG.getMelee("concaveEdgedHalberd"));
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> HEAVY_MACE_SUPPLY = (material, prop) -> INSTANCE.addMedievalWeaponItem(material.getMaterialName() + "_heavymace", prop, material, WEAPONS_CONFIG.getMelee("heavyMace"));
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> HEAVY_WAR_HAMMER_SUPPLY = (material, prop) -> INSTANCE.addMedievalWeaponItem(material.getMaterialName() + "_heavywarhammer", prop, material, WEAPONS_CONFIG.getMelee("heavyWarHammer"));
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> LUCERNE_HAMMER_SUPPLY = (material, prop) -> INSTANCE.addMedievalWeaponItem(material.getMaterialName() + "_lucernhammer", prop, material, WEAPONS_CONFIG.getMelee("lucerneHammer"));
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> MORNINGSTAR_SUPPLY = (material, prop) -> INSTANCE.addMedievalWeaponItem(material.getMaterialName() + "_morgenstern", prop, material, WEAPONS_CONFIG.getMelee("morningstar"));
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> FLAIL_SUPPLY = (material, prop) -> INSTANCE.addMedievalWeaponItem(material.getMaterialName() + "_chainmorgenstern", prop, material, WEAPONS_CONFIG.getMelee("flail"));
	public static final BiFunction<ModItemTier, Properties, RegistrySupplier<MedievalWeaponItem>> GUISARME_SUPPLY = (material, prop) -> INSTANCE.addMedievalWeaponItem(material.getMaterialName() + "_guisarme", prop, material, WEAPONS_CONFIG.getMelee("guisarme"));

	//Weapons
	public static final WeaponsSupply STILETTOS = INSTANCE.addWeaponsSupply(STILETTO_SUPPLY);
	public static final WeaponsSupply SHORT_SWORDS = INSTANCE.addWeaponsSupply(SHORT_SWORD_SUPPLY);
	public static final WeaponsSupply KATZBALGERS = INSTANCE.addWeaponsSupply(KATZBALGER_SUPPLY);
	public static final WeaponsSupply PIKES = INSTANCE.addWeaponsSupply(PIKE_SUPPLY);
	public static final WeaponsSupply RANSEURS = INSTANCE.addWeaponsSupply(RANSEUR_SUPPLY);
	public static final WeaponsSupply AHLSPIESSES = INSTANCE.addWeaponsSupply(AHLSPIESS_SUPPLY);
	public static final WeaponsSupply GIANT_LANCES = INSTANCE.addWeaponsSupply(GIANT_LANCE_SUPPLY);
	public static final WeaponsSupply BASTARD_SWORDS = INSTANCE.addWeaponsSupply(BASTARD_SWORD_SUPPLY);
	public static final WeaponsSupply ESTOCS = INSTANCE.addWeaponsSupply(ESTOC_SUPPLY);
	public static final WeaponsSupply CLAYMORS = INSTANCE.addWeaponsSupply(CLAYMORE_SUPPLY);
	public static final WeaponsSupply ZWEIHANDERS = INSTANCE.addWeaponsSupply(ZWEIHANDER_SUPPLY);
	public static final WeaponsSupply FLAME_BLADED_SWORDS = INSTANCE.addWeaponsSupply(FlAME_BLADED_SWORD_SUPPLY);
	public static final WeaponsSupply LOCHABER_AXES = INSTANCE.addWeaponsSupply(LOCHABER_AXE_SUPPLY);
	public static final WeaponsSupply CONCAVE_EDGED_HALBERDS = INSTANCE.addWeaponsSupply(CONCAVE_EDGED_HALBERD_SUPPLY);
	public static final WeaponsSupply HEAVY_MACES = INSTANCE.addWeaponsSupply(HEAVY_MACE_SUPPLY);
	public static final WeaponsSupply HEAVY_WAR_HAMMERS = INSTANCE.addWeaponsSupply(HEAVY_WAR_HAMMER_SUPPLY);
	public static final WeaponsSupply LUCERNE_HAMMERS = INSTANCE.addWeaponsSupply(LUCERNE_HAMMER_SUPPLY);
	public static final WeaponsSupply MORNINGSTARS = INSTANCE.addWeaponsSupply(MORNINGSTAR_SUPPLY);
	public static final WeaponsSupply FLAILS = INSTANCE.addWeaponsSupply(FLAIL_SUPPLY);
	public static final WeaponsSupply GUISARMES = INSTANCE.addWeaponsSupply(GUISARME_SUPPLY);

	public static final @Nullable RegistrySupplier<MedievalWeaponItem> BLACKSMITH_HAMMER = INSTANCE.addMedievalWeaponItem("blacksmith_hammer", new Properties(), ModItemTier.STEEL, WEAPONS_CONFIG.getMelee("blacksmithHammer"));
	public static final @Nullable RegistrySupplier<MedievalWeaponItem> BARBED_CLUB = INSTANCE.addMedievalWeaponItem("barbedclub", new Properties(), ModItemTier.IRON, WEAPONS_CONFIG.getMelee("barbedClub"));
	public static final @Nullable RegistrySupplier<MedievalWeaponItem> PITCHFORK = INSTANCE.addMedievalWeaponItem("pitchfork", new Properties(), ModItemTier.IRON, WEAPONS_CONFIG.getMelee("pitchfork"));
	public static final @Nullable RegistrySupplier<MedievalWeaponItem> NOBLE_SWORD = INSTANCE.addMedievalWeaponItem("noble_sword", new Properties(), ModItemTier.IRON, WEAPONS_CONFIG.getMelee("nobleSword"));
	public static final @Nullable RegistrySupplier<MedievalWeaponItem> RUSTED_BASTARD_SWORD = INSTANCE.addMedievalWeaponItem("rusted_bastardsword", new Properties(), ModItemTier.IRON, WEAPONS_CONFIG.getMelee("rustedBastardSword"));
	public static final @Nullable RegistrySupplier<MedievalWeaponItem> RUSTED_HEAVY_MACE = INSTANCE.addMedievalWeaponItem("rusted_heavymace", new Properties(), ModItemTier.IRON, WEAPONS_CONFIG.getMelee("rustedHeavyMace"));
	public static final @Nullable RegistrySupplier<MedievalWeaponItem> CLUB = INSTANCE.addMedievalWeaponItem("club", new Properties(), ModItemTier.WOOD, WEAPONS_CONFIG.getMelee("club"));
	public static final @Nullable RegistrySupplier<MedievalWeaponItem> MESSER_SWORD = INSTANCE.addMedievalWeaponItem("messer_sword", new Properties(), ModItemTier.IRON, WEAPONS_CONFIG.getMelee("messerSword"));

	public static final @Nullable RegistrySupplier<Item> LONGBOW = INSTANCE.addMedievalBowItem("longbow", WEAPONS_CONFIG.getRanged("longbow"));
	public static final @Nullable RegistrySupplier<Item> HEAVY_CROSSBOW = INSTANCE.addMedievalCrossbowItem("heavy_crossbow", WEAPONS_CONFIG.getRanged("heavyCrossbow"));

	//Shields
	public static final ShieldsSupply HEATER_SHIELDS = INSTANCE.addShieldsSupply(HEATER_SHIELD_SUPPLY, "heatershield");
	public static final ShieldsSupply TARGETS = INSTANCE.addShieldsSupply(TARGET_SUPPLY, "target");
	public static final ShieldsSupply BUCKLERS = INSTANCE.addShieldsSupply(BUCKLER_SUPPLY, "buckler");
	public static final ShieldsSupply RONDACHES = INSTANCE.addShieldsSupply(RONDACHE_SUPPLY, "rondache");
	public static final ShieldsSupply TARTSCHES = INSTANCE.addShieldsSupply(TARTSCHE_SUPPLY, "tartsche");
	public static final ShieldsSupply ELLIPTICAL_SHIELDS = INSTANCE.addShieldsSupply(ELLIPTICAL_SHIELD_SUPPLY, "ellipticalshield");
	public static final ShieldsSupply ROUND_SHIELDS = INSTANCE.addShieldsSupply(ROUND_SHIELD_SUPPLY, "roundshield");
	public static final ShieldsSupply PAVISES = INSTANCE.addShieldsSupply(PAVISE_SUPPLY, "pavese");
	public static final ShieldsSupply KITE_SHIELDS = INSTANCE.addShieldsSupply(KITE_SHIELD_SUPPLY, "kiteshield");

	public static final RegistrySupplier<MedievalShieldItem> CORRUPTED_ROUND_SHIELD = INSTANCE.addMedievalShieldItem("corruptedroundshield", "corruptedroundshield", new Properties(), ModItemTier.WOOD, false, true, SHIELDS_CONFIG.get("corruptedRoundShield"));

	//Patterns
	public static final RegistrySupplier<Item> APOSTOLIC_CROSS_PATTERN = INSTANCE.addIngredientItem("apostolic_cross_pattern", () -> new BannerPatternItem(ModBannerPatternTags.APOSTOLIC_CROSS_PATTERN, new Properties().stacksTo(1)));
	public static final RegistrySupplier<Item> BOWL_PATTERN = INSTANCE.addIngredientItem("bowl_pattern", () -> new BannerPatternItem(ModBannerPatternTags.BOWL_PATTERN, new Properties().stacksTo(1)));
	public static final RegistrySupplier<Item> BULL_PATTERN = INSTANCE.addIngredientItem("bull_pattern", () -> new BannerPatternItem(ModBannerPatternTags.BULL_PATTERN, new Properties().stacksTo(1)));
	public static final RegistrySupplier<Item> CHESS_PATTERN = INSTANCE.addIngredientItem("chess_pattern", () -> new BannerPatternItem(ModBannerPatternTags.CHESS_PATTERN, new Properties().stacksTo(1)));
	public static final RegistrySupplier<Item> CRUSADER_CROSS_PATTERN = INSTANCE.addIngredientItem("crusader_cross_pattern", () -> new BannerPatternItem(ModBannerPatternTags.CRUSADER_CROSS_PATTERN, new Properties().stacksTo(1)));
	public static final RegistrySupplier<Item> DRAGON_PATTERN = INSTANCE.addIngredientItem("dragon_pattern", () -> new BannerPatternItem(ModBannerPatternTags.DRAGON_PATTERN, new Properties().stacksTo(1)));
	public static final RegistrySupplier<Item> EAGLE_PATTERN = INSTANCE.addIngredientItem("eagle_pattern", () -> new BannerPatternItem(ModBannerPatternTags.EAGLE_PATTERN, new Properties().stacksTo(1)));
	public static final RegistrySupplier<Item> HORSE_PATTERN = INSTANCE.addIngredientItem("horse_pattern", () -> new BannerPatternItem(ModBannerPatternTags.HORSE_PATTERN, new Properties().stacksTo(1)));
	public static final RegistrySupplier<Item> LILY_PATTERN = INSTANCE.addIngredientItem("lily_pattern", () -> new BannerPatternItem(ModBannerPatternTags.LILY_PATTERN, new Properties().stacksTo(1)));
	public static final RegistrySupplier<Item> LION1_PATTERN = INSTANCE.addIngredientItem("lion1_pattern", () -> new BannerPatternItem(ModBannerPatternTags.LION1_PATTERN, new Properties().stacksTo(1)));
	public static final RegistrySupplier<Item> LION2_PATTERN = INSTANCE.addIngredientItem("lion2_pattern", () -> new BannerPatternItem(ModBannerPatternTags.LION2_PATTERN, new Properties().stacksTo(1)));
	public static final RegistrySupplier<Item> ORTHODOX_CROSS_PATTERN = INSTANCE.addIngredientItem("orthodox_cross_pattern", () -> new BannerPatternItem(ModBannerPatternTags.ORTHODOX_CROSS_PATTERN, new Properties().stacksTo(1)));
	public static final RegistrySupplier<Item> SNAKE_PATTERN = INSTANCE.addIngredientItem("snake_pattern", () -> new BannerPatternItem(ModBannerPatternTags.SNAKE_PATTERN, new Properties().stacksTo(1)));
	public static final RegistrySupplier<Item> SUN_PATTERN = INSTANCE.addIngredientItem("sun_pattern", () -> new BannerPatternItem(ModBannerPatternTags.SUN_PATTERN, new Properties().stacksTo(1)));
	public static final RegistrySupplier<Item> SWORDS_PATTERN = INSTANCE.addIngredientItem("swords_pattern", () -> new BannerPatternItem(ModBannerPatternTags.SWORDS_PATTERN, new Properties().stacksTo(1)));
	public static final RegistrySupplier<Item> TOWER_PATTERN = INSTANCE.addIngredientItem("tower_pattern", () -> new BannerPatternItem(ModBannerPatternTags.TOWER_PATTERN, new Properties().stacksTo(1)));
	public static final RegistrySupplier<Item> TREE_PATTERN = INSTANCE.addIngredientItem("tree_pattern", () -> new BannerPatternItem(ModBannerPatternTags.TREE_PATTERN, new Properties().stacksTo(1)));
	public static final RegistrySupplier<Item> TWOHEADED_EAGLE_PATTERN = INSTANCE.addIngredientItem("two_headed_eagle_pattern", () -> new BannerPatternItem(ModBannerPatternTags.TWOHEADED_EAGLE_PATTERN, new Properties().stacksTo(1)));

	//Materials
	public static final RegistrySupplier<Item> STEEL_INGOT = INSTANCE.addIngredientItem("steel_ingot", () -> new Item(new Properties()));
	public static final RegistrySupplier<Item> STEEL_NUGGET = INSTANCE.addIngredientItem("steel_nugget", () -> new Item(new Properties()));
	public static final RegistrySupplier<Item> STEEL_RING = INSTANCE.addIngredientItem("steel_ring", () -> new Item(new Properties()));
	public static final RegistrySupplier<Item> STEEL_CHAINMAIL = INSTANCE.addIngredientItem("steel_chainmail", () -> new Item(new Properties()));
	public static final RegistrySupplier<Item> STEEL_PLATE = INSTANCE.addIngredientItem("steel_plate", () -> new Item(new Properties()));
	public static final RegistrySupplier<Item> LEATHER_STRIP = INSTANCE.addIngredientItem("leather_strip", () -> new Item(new Properties()));
	public static final RegistrySupplier<Item> HILT = INSTANCE.addIngredientItem("hilt", () -> new Item(new Properties()));
	public static final RegistrySupplier<Item> POLE = INSTANCE.addIngredientItem("pole", () -> new Item(new Properties()));
	public static final RegistrySupplier<Item> STEEL_CHAIN = INSTANCE.addIngredientItem("steel_chain", () -> new Item(new Properties()));
	public static final RegistrySupplier<Item> WOOLEN_FABRIC = INSTANCE.addIngredientItem("woolen_fabric", () -> new Item(new Properties()));
	public static final RegistrySupplier<Item> SMALL_STEEL_PLATE = INSTANCE.addIngredientItem("small_steel_plate", () -> new Item(new Properties()));
	public static final RegistrySupplier<Item> LAMELLAR_ROWS = INSTANCE.addIngredientItem("lamellar_rows", () -> new Item(new Properties()));
	public static final @Nullable RegistrySupplier<Item> DARKENING_TEMPLATE = INSTANCE.addIngredientItem("darkening_template", () -> new SmithingTemplateItem(
			Component.translatable(EpicKnights.ID + ".darkening_template.applies_to"),
			Component.translatable(EpicKnights.ID + ".darkening_template.ingredients"),
			Component.translatable(EpicKnights.ID + ".darkening_template.upgrade_description"),
			Component.translatable(EpicKnights.ID + ".darkening_template.base_slot_description"),
			List.<ResourceLocation>of(),
			List.<ResourceLocation>of(),
			new Properties()));
	public static final @Nullable RegistrySupplier<Item> GILDING_TEMPLATE = INSTANCE.addIngredientItem("gilding_template", () -> new SmithingTemplateItem(
			Component.translatable(EpicKnights.ID + ".gilding_template.applies_to"),
			Component.translatable(EpicKnights.ID + ".gilding_template.ingredients"),
			Component.translatable(EpicKnights.ID + ".gilding_template.upgrade_description"),
			Component.translatable(EpicKnights.ID + ".gilding_template.base_slot_description"),
			List.<ResourceLocation>of(),
			List.<ResourceLocation>of(),
			new Properties()));
	
	//Decorations
	public static final RegistrySupplier<DyeableArmorDecorationItem> TORSE_AND_MANTLE_DECORATION = INSTANCE.addDyeableArmorDecorationItem("torse_and_mantle_decoration", () -> new DyeableArmorDecorationItem(ResourceLocation.fromNamespaceAndPath(EpicKnights.ID, "torse_and_mantle"), new Properties(), net.minecraft.world.item.equipment.ArmorType.HELMET));
	public static final RegistrySupplier<ArmorDecorationItem> GAZELLE_HORNS_DECORATION = INSTANCE.addArmorDecorationItem("gazelle_horns_decoration", () -> new ArmorDecorationItem(ResourceLocation.fromNamespaceAndPath(EpicKnights.ID, "gazelle_horns"), new Properties(), net.minecraft.world.item.equipment.ArmorType.HELMET));
	public static final RegistrySupplier<ArmorDecorationItem> DUCK_DECORATION = INSTANCE.addArmorDecorationItem("duck_decoration", () -> new ArmorDecorationItem(ResourceLocation.fromNamespaceAndPath(EpicKnights.ID, "duck"), new Properties(), net.minecraft.world.item.equipment.ArmorType.HELMET));
	public static final RegistrySupplier<DyeableArmorDecorationItem> SPIKE_DECORATION = INSTANCE.addDyeableArmorDecorationItem("spike_decoration", () -> new DyeableArmorDecorationItem(ResourceLocation.fromNamespaceAndPath(EpicKnights.ID, "spike"), new Properties(), net.minecraft.world.item.equipment.ArmorType.HELMET));
	public static final RegistrySupplier<DyeableArmorDecorationItem> HORSE_DECORATION = INSTANCE.addDyeableArmorDecorationItem("horse_decoration", () -> new DyeableArmorDecorationItem(ResourceLocation.fromNamespaceAndPath(EpicKnights.ID, "horse"), new Properties(), net.minecraft.world.item.equipment.ArmorType.HELMET, MapColor.TERRACOTTA_ORANGE.col));
	public static final RegistrySupplier<DyeableWearableArmorDecorationItem> CROWN_DECORATION = INSTANCE.addDyeableWearableArmorDecorationItem("crown_decoration", ArmorTypes.CROWN, net.minecraft.world.item.equipment.ArmorType.HELMET, new Properties(), MapColor.COLOR_CYAN.col);
	public static final RegistrySupplier<DyeableWearableArmorDecorationItem> FLOWERCROWN_DECORATION = INSTANCE.addDyeableWearableArmorDecorationItem("flowercrown_decoration", ArmorTypes.FLOWERCROWN, net.minecraft.world.item.equipment.ArmorType.HELMET, new Properties(), DyeColor.WHITE.getMapColor().col);
	public static final RegistrySupplier<DyeableArmorDecorationItem> UNICORN_DECORATION = INSTANCE.addDyeableArmorDecorationItem("unicorn_decoration", () -> new DyeableArmorDecorationItem(ResourceLocation.fromNamespaceAndPath(EpicKnights.ID, "unicorn"), new Properties(), net.minecraft.world.item.equipment.ArmorType.HELMET));
	public static final RegistrySupplier<ArmorDecorationItem> BULLHORNS_DECORATION = INSTANCE.addArmorDecorationItem("bullhorns_decoration", () -> new ArmorDecorationItem(ResourceLocation.fromNamespaceAndPath(EpicKnights.ID, "bullhorns"), new Properties(), net.minecraft.world.item.equipment.ArmorType.HELMET));
	public static final RegistrySupplier<DyeableArmorDecorationItem> DRAGON_DECORATION = INSTANCE.addDyeableArmorDecorationItem("dragon_decoration", () -> new DyeableArmorDecorationItem(ResourceLocation.fromNamespaceAndPath(EpicKnights.ID, "dragon"), new Properties(), net.minecraft.world.item.equipment.ArmorType.HELMET, MapColor.COLOR_GRAY.col));
	public static final RegistrySupplier<WearableArmorDecorationItem> MINICROWN_DECORATION = INSTANCE.addWearableArmorDecorationItem("minicrown_decoration", ArmorTypes.MINICROWN, net.minecraft.world.item.equipment.ArmorType.HELMET, new Properties());
	public static final RegistrySupplier<DyeableArmorDecorationItem> TORSE_DECORATION = INSTANCE.addDyeableArmorDecorationItem("torse_decoration", () -> new DyeableArmorDecorationItem(ResourceLocation.fromNamespaceAndPath(EpicKnights.ID, "torse"), new Properties(), net.minecraft.world.item.equipment.ArmorType.HELMET));
	public static final RegistrySupplier<DyeableArmorDecorationItem> TWO_PLUMES_DECORATION = INSTANCE.addDyeableArmorDecorationItem("two_plumes_decoration", () -> new DyeableArmorDecorationItem(ResourceLocation.fromNamespaceAndPath(EpicKnights.ID, "two_plumes"), new Properties(), net.minecraft.world.item.equipment.ArmorType.HELMET));
	public static final RegistrySupplier<ArmorDecorationItem> ANTLERS_DECORATION = INSTANCE.addArmorDecorationItem("antlers_decoration", () -> new ArmorDecorationItem(ResourceLocation.fromNamespaceAndPath(EpicKnights.ID, "antlers"), new Properties(), net.minecraft.world.item.equipment.ArmorType.HELMET));
	public static final RegistrySupplier<DyeableArmorDecorationItem> BIG_PLUME_DECORATION = INSTANCE.addDyeableArmorDecorationItem("big_plume_decoration", () -> new DyeableArmorDecorationItem(ResourceLocation.fromNamespaceAndPath(EpicKnights.ID, "big_plume"), new Properties(), net.minecraft.world.item.equipment.ArmorType.HELMET, -10092544));
	public static final RegistrySupplier<DyeableArmorDecorationItem> PLUME_LEFT_DECORATION = INSTANCE.addDyeableArmorDecorationItem("plume_left_decoration", () -> new DyeableArmorDecorationItem(ResourceLocation.fromNamespaceAndPath(EpicKnights.ID, "plume_left"), new Properties(), net.minecraft.world.item.equipment.ArmorType.HELMET));
	public static final RegistrySupplier<DyeableArmorDecorationItem> PLUME_MIDDLE_DECORATION = INSTANCE.addDyeableArmorDecorationItem("plume_middle_decoration", () -> new DyeableArmorDecorationItem(ResourceLocation.fromNamespaceAndPath(EpicKnights.ID, "plume_middle"), new Properties(), net.minecraft.world.item.equipment.ArmorType.HELMET));
	public static final RegistrySupplier<DyeableArmorDecorationItem> PLUME_RIGHT_DECORATION = INSTANCE.addDyeableArmorDecorationItem("plume_right_decoration", () -> new DyeableArmorDecorationItem(ResourceLocation.fromNamespaceAndPath(EpicKnights.ID, "plume_right"), new Properties(), net.minecraft.world.item.equipment.ArmorType.HELMET));
	public static final RegistrySupplier<DyeableArmorDecorationItem> BEAR_DECORATION = INSTANCE.addDyeableArmorDecorationItem("bear_decoration", () -> new DyeableArmorDecorationItem(ResourceLocation.fromNamespaceAndPath(EpicKnights.ID, "bear"), new Properties(), net.minecraft.world.item.equipment.ArmorType.HELMET, MapColor.COLOR_BROWN.col));
	public static final RegistrySupplier<DyeableArmorDecorationItem> LILY_DECORATION = INSTANCE.addDyeableArmorDecorationItem("lily_decoration", () -> new DyeableArmorDecorationItem(ResourceLocation.fromNamespaceAndPath(EpicKnights.ID, "lily"), new Properties(), net.minecraft.world.item.equipment.ArmorType.HELMET, MapColor.GOLD.col));
	public static final RegistrySupplier<DyeableArmorDecorationItem> LION_DECORATION = INSTANCE.addDyeableArmorDecorationItem("lion_decoration", () -> new DyeableArmorDecorationItem(ResourceLocation.fromNamespaceAndPath(EpicKnights.ID, "lion"), new Properties(), net.minecraft.world.item.equipment.ArmorType.HELMET, 0xFBC237));
	public static final RegistrySupplier<ArmorDecorationItem> DEMON_HORNS_DECORATION = INSTANCE.addArmorDecorationItem("demon_horns_decoration", () -> new ArmorDecorationItem(ResourceLocation.fromNamespaceAndPath(EpicKnights.ID, "demon_horns"), new Properties(), net.minecraft.world.item.equipment.ArmorType.HELMET));
	public static final RegistrySupplier<DyeableArmorDecorationItem> FEATHERS_DECORATION = INSTANCE.addDyeableArmorDecorationItem("feathers_decoration", () -> new DyeableArmorDecorationItem(ResourceLocation.fromNamespaceAndPath(EpicKnights.ID, "feathers"), new Properties(), net.minecraft.world.item.equipment.ArmorType.HELMET));
	public static final RegistrySupplier<DyeableArmorDecorationItem> VIKING_HORNS_DECORATION = INSTANCE.addDyeableArmorDecorationItem("viking_horns_decoration", () -> new DyeableArmorDecorationItem(ResourceLocation.fromNamespaceAndPath(EpicKnights.ID, "viking_horns"), new Properties(), net.minecraft.world.item.equipment.ArmorType.HELMET));
	public static final RegistrySupplier<DyeableArmorDecorationItem> GRIFFIN_DECORATION = INSTANCE.addDyeableArmorDecorationItem("griffin_decoration", () -> new DyeableArmorDecorationItem(ResourceLocation.fromNamespaceAndPath(EpicKnights.ID, "griffin"), new Properties(), net.minecraft.world.item.equipment.ArmorType.HELMET, 0xFBC237));
	public static final RegistrySupplier<DyeableArmorDecorationItem> HOOD_DECORATION = INSTANCE.addDyeableArmorDecorationItem("hood_decoration", () -> { Item.Properties p = new Item.Properties(); setId(p, "hood_decoration"); return new DyeableArmorDecorationItem(ResourceLocation.fromNamespaceAndPath(EpicKnights.ID, "hood"), p, net.minecraft.world.item.equipment.ArmorType.CHESTPLATE); });
	public static final RegistrySupplier<DyeableArmorDecorationItem> ECRANCHE_DECORATION = INSTANCE.addDyeableArmorDecorationItem("ecranche_decoration", () -> { Item.Properties p = new Item.Properties(); setId(p, "ecranche_decoration"); return new DyeableArmorDecorationItem(ResourceLocation.fromNamespaceAndPath(EpicKnights.ID, "ecranche"), p, net.minecraft.world.item.equipment.ArmorType.CHESTPLATE, 0xDFDFDF); });
	public static final RegistrySupplier<ArmorDecorationItem> RONDEL_DECORATION = INSTANCE.addArmorDecorationItem("rondel_decoration", () -> { Item.Properties p = new Item.Properties(); setId(p, "rondel_decoration"); return new ArmorDecorationItem(ResourceLocation.fromNamespaceAndPath(EpicKnights.ID, "rondel"), p, net.minecraft.world.item.equipment.ArmorType.CHESTPLATE); });
	public static final RegistrySupplier<ArmorDecorationItem> CAT_EARS_DECORATION = INSTANCE.addArmorDecorationItem("cat_ears_decoration", () -> { Item.Properties p = new Item.Properties(); setId(p, "cat_ears_decoration"); return new ArmorDecorationItem(ResourceLocation.fromNamespaceAndPath(EpicKnights.ID, "cat_ears"), p, net.minecraft.world.item.equipment.ArmorType.HELMET); });

	public static final RegistrySupplier<MedievalBagItem> MEDIEVAL_BAG = INSTANCE.items.register("medieval_bag", () -> { Item.Properties p = new Item.Properties(); setId(p, "medieval_bag"); return new MedievalBagItem(p); });
	
	{
		if (Platform.isFabric())
		{
			this.items.register("tin_ingot", () -> { Item.Properties p = new Item.Properties(); setId(p, "tin_ingot"); return new Item(p); });
			this.items.register("silver_ingot", () -> { Item.Properties p = new Item.Properties(); setId(p, "silver_ingot"); return new Item(p); });
			this.items.register("bronze_ingot", () -> { Item.Properties p = new Item.Properties(); setId(p, "bronze_ingot"); return new Item(p); });
		}
	}
	
}




