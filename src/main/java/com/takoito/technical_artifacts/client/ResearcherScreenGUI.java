package com.takoito.technical_artifacts.client;

import com.mojang.blaze3d.systems.RenderSystem;
import com.takoito.technical_artifacts.ContainerResearcher;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import org.jetbrains.annotations.NotNull;

public class ResearcherScreenGUI extends AbstractContainerScreen<ContainerResearcher> {

    private static final ResourceLocation TEXTURE = new ResourceLocation("technical_artifacts","textures/gui/researcher.png");

    public ResearcherScreenGUI(ContainerResearcher p_97741_, Inventory p_97742_, Component p_97743_) {
        super(p_97741_, p_97742_, p_97743_);
        this.imageWidth = 176;
        this.imageHeight = 166;
    }

    @Override
    protected void renderBg(@NotNull GuiGraphics p_283065_, float p_97788_, int p_97789_, int p_97790_) {
        RenderSystem.setShaderTexture(0,TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;
        p_283065_.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight);

    }

    public void render(@NotNull GuiGraphics p_283065_, int x, int y, float partialTicks){
        this.renderBackground(p_283065_);
        super.render(p_283065_, x, y, partialTicks);
        this.renderTooltip(p_283065_, x, y);
    }
}
