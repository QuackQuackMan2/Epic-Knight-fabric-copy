package com.magistuarmory.block;

import com.magistuarmory.item.MedievalShieldItem;
import com.magistuarmory.item.ModItems;
import com.mojang.math.Axis;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import dev.architectury.registry.registries.RegistrySupplier;
import com.magistuarmory.EpicKnights;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.AbstractBannerBlock;
import net.minecraft.world.level.block.BannerBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.RotationSegment;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Quaternionf;
import org.joml.Vector3d;

import java.util.function.Supplier;


public class PaviseBlock extends AbstractBannerBlock
{
	public static final IntegerProperty ROTATION;
	static final AABB COLLISION_AABB = new AABB(0.0 / 16.0, 0.0, 7.5 / 16.0, 1.0, 1.0, 8.5 / 16.0);
	static final Vector3d CENTER = new Vector3d(0.5, 0.5, 0.5);
	static final Vector3d BOXMIN = new Vector3d(0.0, 0.0, 0.0);
	static final Vector3d BOXMAX = new Vector3d(1.0, 1.0, 1.0);
	
	public final MapCodec<PaviseBlock> codec;
	protected String shieldId;
	
	public PaviseBlock(DyeColor color, Properties prop, String shieldId)
	{
		super(color, prop.setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EpicKnights.ID, shieldId))));
		this.shieldId = shieldId;
		this.codec = RecordCodecBuilder.mapCodec((instance) -> instance.group(DyeColor.CODEC.fieldOf("color").forGetter(AbstractBannerBlock::getColor), propertiesCodec()).apply(instance, (a, b) -> new PaviseBlock(a, b, shieldId)));
	}
	
	public BlockEntityType<PaviseBlockEntity> getEntityType() {
		return ModBlockEntityTypes.getPaviseBlockEntityType().get();
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(ROTATION);
	}

	@Override
	protected MapCodec<? extends AbstractBannerBlock> codec()
	{
		return this.codec;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos blockpos, BlockState blockstate) 
	{
		return new PaviseBlockEntity(blockpos, blockstate);
	}
	
	@Override
	public @NotNull Item asItem() 
	{
		String material = this.shieldId.split("_")[0];
		RegistrySupplier<MedievalShieldItem> item = switch (material) {
			case "wood" -> ModItems.PAVISES.wood;
			case "gold" -> ModItems.PAVISES.gold;
			case "stone" -> ModItems.PAVISES.stone;
			case "iron" -> ModItems.PAVISES.iron;
			case "diamond" -> ModItems.PAVISES.diamond;
			case "netherite" -> ModItems.PAVISES.netherite;
			case "copper" -> ModItems.PAVISES.copper;
			case "silver" -> ModItems.PAVISES.silver;
			case "steel" -> ModItems.PAVISES.steel;
			case "tin" -> ModItems.PAVISES.tin;
			case "bronze" -> ModItems.PAVISES.bronze;
			default -> null;
		};
		return item != null ? item.get() : Items.AIR;
	}
	
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) 
	{
		return this.defaultBlockState().setValue(ROTATION, RotationSegment.convertToSegment(blockPlaceContext.getRotation()));
	}
	
	@Override
	public @NotNull ItemStack getCloneItemStack(LevelReader reader, BlockPos blockpos, BlockState state, boolean flag)
	{
		if (reader.getBlockEntity(blockpos) instanceof PaviseBlockEntity pavise)
			return pavise.getStack();

		return ItemStack.EMPTY;
	}

	@Override
	public VoxelShape getShape(BlockState blockstate, net.minecraft.world.level.BlockGetter blockgetter, BlockPos blockpos, CollisionContext context)
	{
		AABB aabb = COLLISION_AABB;
		
		float yrot = -RotationSegment.convertToDegrees(blockstate.getValue(BannerBlock.ROTATION));
		aabb = rotateAABB(aabb, Axis.YP.rotationDegrees(yrot));
		
		return Shapes.create(aabb);
	}

	public static AABB rotateAABB(AABB axisAlignedBB, Quaternionf quaternion)
	{
		// Extract the minimum and maximum coordinates of the AABB into vectors
		final Vector3d mincoords = new Vector3d(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ);
		final Vector3d maxcoords = new Vector3d(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ);
		
		mincoords.sub(CENTER);
		maxcoords.sub(CENTER);

		// Rotate the vectors in-place
		quaternion.transform(mincoords);
		quaternion.transform(maxcoords);

		mincoords.add(CENTER).max(BOXMIN);
		maxcoords.add(CENTER).min(BOXMAX);
		
		// Return an AABB with the new coordinates
		return new AABB(mincoords.x(), mincoords.y(), mincoords.z(), maxcoords.x(), maxcoords.y(), maxcoords.z());
	}

	@Override
	public void playerDestroy(Level level, Player player, BlockPos blockpos, BlockState blockstate, @Nullable BlockEntity blockentity, ItemStack stack)
	{
		player.awardStat(Stats.BLOCK_MINED.get(this));
		player.causeFoodExhaustion(0.005F);
		dropResources(blockstate, level, blockpos, blockentity, player, stack);
		if (blockentity instanceof PaviseBlockEntity pavise)
			level.addFreshEntity(new ItemEntity(level, blockpos.getX() + 0.5, blockpos.getY() + 0.5, blockpos.getZ() + 0.5, pavise.getStack()));
	}

	@Override
	public void destroy(LevelAccessor accessor, BlockPos blockpos, BlockState blockstate)
	{
		if (accessor.getBlockState(blockpos.above()).getBlock() == ModBlocks.PAVISE_UPPER_COLLISION.get())
			accessor.destroyBlock(blockpos.above(), false);
		super.destroy(accessor, blockpos, blockstate);
	}

	static {
		ROTATION = BlockStateProperties.ROTATION_16;
	}
}
