package com.magistuarmory.item;

import com.magistuarmory.block.PaviseBlock;
import com.magistuarmory.item.*;
import com.magistuarmory.item.armor.*;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class ItemRegistryHelper
{
	public static RegistrySupplier<MedievalArmorItem> registerKnightItem(DeferredRegister<Item> items, String id, ArmorType material, net.minecraft.world.item.equipment.ArmorType type, Item.Properties properties)
	{
		////setId(properties, id);
		return items.register(id, () -> new KnightItem(material, type, properties));
	}

	public static RegistrySupplier<MedievalArmorItem> registerJoustingItem(DeferredRegister<Item> items, String id, ArmorType material, net.minecraft.world.item.equipment.ArmorType type, Item.Properties properties)
	{
		//setId(properties, id);
		return items.register(id, () -> new JoustingItem(material, type, properties));
	}

	public static RegistrySupplier<MedievalArmorItem> registerMedievalArmorItem(DeferredRegister<Item> items, String id, ArmorType material, net.minecraft.world.item.equipment.ArmorType type, Item.Properties properties)
	{
		//setId(properties, id);
		return items.register(id, () -> new MedievalArmorItem(material, type, properties));
	}

	public static RegistrySupplier<MedievalArmorItem> registerDyeableMedievalArmorItem(DeferredRegister<Item> items, String id, ArmorType material, net.minecraft.world.item.equipment.ArmorType type, Item.Properties properties, int defaultcolor)
	{
		//setId(properties, id);
		return items.register(id, () -> new DyeableMedievalArmorItem(material, type, properties, defaultcolor));
	}

	public static RegistrySupplier<WearableArmorDecorationItem> registerWearableArmorDecorationItem(DeferredRegister<Item> items, String id, ArmorType material, net.minecraft.world.item.equipment.ArmorType type, Item.Properties properties)
	{
		//setId(properties, id);
		return items.register(id, () -> new WearableArmorDecorationItem(material, type, properties));
	}

	public static RegistrySupplier<DyeableWearableArmorDecorationItem> registerDyeableWearableArmorDecorationItem(DeferredRegister<Item> items, String id, ArmorType material, net.minecraft.world.item.equipment.ArmorType type, Item.Properties properties, int defaultcolor)
	{
		//setId(properties, id);
		return items.register(id, () -> new DyeableWearableArmorDecorationItem(material, type, properties, defaultcolor));
	}

	public static RegistrySupplier<MedievalWeaponItem> registerMedievalWeaponItem(DeferredRegister<Item> items, String id, Item.Properties properties, ModItemTier material, WeaponType type)
	{
		//setId(properties, id);
		return items.register(id, () -> new MedievalWeaponItem(properties, material, type));
	}

	public static RegistrySupplier<MedievalWeaponItem> registerLanceItem(DeferredRegister<Item> items, String id, Item.Properties properties, ModItemTier material, WeaponType type)
	{
		//setId(properties, id);
		return items.register(id, () -> new LanceItem(properties, material, type));
	}

	public static RegistrySupplier<MedievalShieldItem> registerMedievalShieldItem(DeferredRegister<Item> items, String id, ResourceLocation location, Item.Properties properties, ModItemTier material, boolean paintable, boolean is3d, ShieldType type)
	{
		//setId(properties, id);
		return items.register(id, () -> new MedievalShieldItem(id, location, properties, material, paintable, is3d, type));
	}

	public static RegistrySupplier<MedievalShieldItem> registerPaviseItem(DeferredRegister<Item> items, String id, ResourceLocation location, Item.Properties properties, ModItemTier material, boolean paintable, boolean is3d, ShieldType type, Supplier<PaviseBlock> block)
	{
		//setId(properties, id);
		return items.register(id, () -> new PaviseItem(id, location, properties, material, paintable, is3d, type, block));
	}

	public static void setId(Item.Properties p, String id) {
		try {
			java.lang.reflect.Field field = p.getClass().getDeclaredField("id");
			field.setAccessible(true);
			field.set(p, ResourceKey.create(Registries.ITEM, net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("magistuarmory", id)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}