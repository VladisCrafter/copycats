package com.copycatsplus.copycats.mixin.copycat.step;

import com.copycatsplus.copycats.content.copycat.ICTCopycatBlock;
import com.simibubi.create.content.decoration.copycat.CopycatStepBlock;
import com.simibubi.create.content.decoration.copycat.WaterloggedCopycatBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CopycatStepBlock.class)
public abstract class CopycatStepBlockMixin extends WaterloggedCopycatBlock implements ICTCopycatBlock {
    public CopycatStepBlockMixin(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public BlockState getAppearance(BlockState state, BlockAndTintGetter level, BlockPos pos, Direction side, BlockState queryState, BlockPos queryPos) {
        if (!allowCTAppearance(state, level, pos, side, queryState, queryPos))
            return state;
        return super.getAppearance(state, level, pos, side, queryState, queryPos);
    }

    @Inject(
            at = @At("HEAD"),
            method = "use(Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/world/InteractionHand;Lnet/minecraft/world/phys/BlockHitResult;)Lnet/minecraft/world/InteractionResult;",
            cancellable = true
    )
    public void use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult ray, CallbackInfoReturnable<InteractionResult> cir) {
        InteractionResult toggleResult = ICTCopycatBlock.super.toggleCT(state, world, pos, player, hand, ray);
        if (toggleResult.consumesAction()) cir.setReturnValue(toggleResult);
    }
}
