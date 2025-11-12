package com.takoito.technical_artifacts.client;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import static com.takoito.technical_artifacts.ModTechnicalArtifacts.RESEARCHING;

//import static com.takoito.technical_artifacts.MenuRegister.RESEARCHING;

@OnlyIn(Dist.CLIENT)
public class MenuScreenRegister {
    static {
        MenuScreens.register(RESEARCHING.get(),ResearcherScreenGUI::new);
    }
}
