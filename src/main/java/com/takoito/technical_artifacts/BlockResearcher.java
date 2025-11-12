package com.takoito.technical_artifacts;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.NotNull;

public class BlockResearcher extends Block {
    public BlockResearcher() {
        super(Properties.of().strength(2.0F,6.0F).sound(SoundType.STONE));
    }

    public @NotNull InteractionResult use(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos,
                                          @NotNull Player player, @NotNull InteractionHand hand, net.minecraft.world.phys.@NotNull BlockHitResult hit) {
        if (!level.isClientSide) {
            MenuProvider provider = new SimpleMenuProvider(
                    (windowId, inv, plyr) -> new ContainerResearcher(windowId, inv),
                    Component.translatable("technical_artifacts.gui.researching"));
            NetworkHooks.openScreen((ServerPlayer) player, provider, pos);
        }
        return InteractionResult.sidedSuccess(level.isClientSide);
    }
}
