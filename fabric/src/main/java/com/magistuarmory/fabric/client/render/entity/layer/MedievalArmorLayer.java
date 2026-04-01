package com.magistuarmory.fabric.client.render.entity.layer;

import com.magistuarmory.item.MedievalArmorItem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;

@Environment(EnvType.CLIENT)
public class MedievalArmorLayer implements ArmorRenderer
{
   @Override
   public void render(PoseStack pose, MultiBufferSource buffer, ItemStack stack, HumanoidRenderState entity, EquipmentSlot slot, int i, HumanoidModel<HumanoidRenderState> contextmodel)
   {
      // Render armor only if it's a medieval armor item
      if (stack.getItem() instanceof MedievalArmorItem armorItem)
      {
         // Custom armor rendering will be handled by the armor models
         // This is a placeholder for future custom decoration rendering
      }
   }
}
