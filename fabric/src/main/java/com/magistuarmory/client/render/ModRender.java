package com.magistuarmory.client.render;

import com.magistuarmory.EpicKnights;
import com.magistuarmory.api.item.ModItemsProvider;
import com.magistuarmory.block.ModBlockEntityTypes;
import com.magistuarmory.client.render.entity.layer.ArmorDecorationLayer;
import com.magistuarmory.client.render.entity.layer.HorseArmorDecorationLayer;
import com.magistuarmory.client.render.model.decoration.ArmorDecorationModelSet;
import com.magistuarmory.client.render.model.ModModels;
import com.magistuarmory.client.render.tileentity.HeraldryItemStackRenderer;
import com.magistuarmory.client.render.tileentity.PaviseBlockRenderer;
import com.magistuarmory.fabric.client.render.entity.layer.MedievalArmorLayer;
import com.magistuarmory.fabric.client.render.tileentity.HeraldryItemStackRendererFabric;
import com.magistuarmory.item.DyeableItemLike;
import com.magistuarmory.item.IHasModelProperty;
import com.magistuarmory.item.MedievalShieldItem;
import com.magistuarmory.item.ModItems;
import com.magistuarmory.item.PaviseItem;
import com.magistuarmory.item.armor.MedievalArmorItem;
import dev.architectury.registry.client.rendering.BlockEntityRendererRegistry;
import dev.architectury.registry.registries.RegistrySupplier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HorseRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;

import java.util.HashMap;
import java.util.Map;

@Environment(EnvType.CLIENT)
public class ModRender
{
	public static HumanoidModel INNER_ARMOR = null;
	public static HumanoidModel OUTER_ARMOR = null;
	public static Map<ResourceLocation, HumanoidModel> ARMOR_MODELS_CACHE = new HashMap<>();
	public static Map<ResourceLocation, Object> SHIELD_MODELS_CACHE = new HashMap<>();

	static void addLayers(ModItemsProvider content, EntityType<? extends LivingEntity> entitytype, LivingEntityRenderer<?, ?, ?> renderer, LivingEntityFeatureRendererRegistrationCallback.RegistrationHelper helper, EntityRendererProvider.Context context)
	{
		// Custom armor decoration layers are disabled for Fabric 1.21.4 compatibility.
	}

	public static void addArmorDecorationLayer(LivingEntityRenderer<?, ?, ?> renderer, ModItemsProvider content, EntityRendererProvider.Context context, LivingEntityFeatureRendererRegistrationCallback.RegistrationHelper helper) {
		// Disabled for Fabric 1.21.4 compatibility.
	}

	public static void addHorseArmorDecorationLayer(HorseRenderer renderer, ModItemsProvider content, EntityRendererProvider.Context context, LivingEntityFeatureRendererRegistrationCallback.RegistrationHelper helper) {
		// Disabled for Fabric 1.21.4 compatibility.
	}

	public static void setupPlatform(ModItemsProvider content)
	{
		MedievalArmorLayer layer = new MedievalArmorLayer();
		for (RegistrySupplier<? extends Item> supplier : content.armorItems)
			ArmorRenderer.register(layer, supplier.get());
	}

	public static void setup(ModItemsProvider content)
	{
		for (RegistrySupplier<? extends Item> supplier : content.dyeableItems)
		{
			// ColorHandlerRegistry.registerItemColors((stack, i) -> i > 0 ? 0xFFFFFFFF : ((DyeableItemLike) stack.getItem()).getColor(stack), supplier.get());
		}
		
		for (RegistrySupplier<? extends Item> supplier : content.items)
			if (supplier.get() instanceof IHasModelProperty havingproperty)
				havingproperty.registerModelProperty();

		content.shieldItems.stream()
				.filter(s -> s.get() instanceof PaviseItem)
				.map(s -> (PaviseItem) s.get())
				.forEach(p -> BlockEntityRendererRegistry.register(p.getBlock().getEntityType(), 
						context -> new PaviseBlockRenderer(context, p.getId(), p.getLocation())));
		
		setupPlatform(content);
	}

	public static void registerRenderers()
	{
		// This method exists for compatibility with common client lifecycle hooks.
		// In Fabric 1.21.4, the needed render setup is done in ModRender.setup() / setupPlatform().
	}

	public static void registerModelsLoadListener(ModItemsProvider content)
	{
		LivingEntityFeatureRendererRegistrationCallback.EVENT.register((entitytype, renderer, helper, context) -> {
			ModRender.loadModels(content, context);
		});
	}

	public static void loadModels(ModItemsProvider content, EntityRendererProvider.Context context)
	{
		OUTER_ARMOR = new HumanoidModel(context.bakeLayer(ModModels.DEFAULT_ARMOR_LOCATION));
		INNER_ARMOR = new HumanoidModel(context.bakeLayer(ModModels.DEFAULT_LEGGINGS_LOCATION));

		for (RegistrySupplier<? extends MedievalShieldItem> supplier : content.shieldItems)
			loadShieldModel(context, supplier.get());

		for (RegistrySupplier<? extends MedievalArmorItem> supplier : content.armorItems)
			loadArmorModel(context, supplier.get());
	}

	public static void loadShieldModel(EntityRendererProvider.Context context, MedievalShieldItem shield)
	{
		// Shield model rendering disabled for 1.21.4
	}

	public static void loadArmorModel(EntityRendererProvider.Context context, MedievalArmorItem armor)
	{
		// Armor rendering not fully compatible with 1.21.4 rendering system
	}

	public static HeraldryItemStackRenderer createHeraldryItemStackRenderer(String id, ResourceLocation location)
	{
		return new HeraldryItemStackRendererFabric(id, location);
	}
}