package com.takoito.technical_artifacts;

import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

//import static com.takoito.technical_artifacts.MenuRegister.RESEARCHING;
import static com.takoito.technical_artifacts.ModTechnicalArtifacts.RESEARCHING;

public class ContainerResearcher extends AbstractContainerMenu {

    private final Container container;

//    protected ContainerResearcher(@Nullable MenuType<?> p_38851_, int p_38852_, Container container) {
//        super(p_38851_, p_38852_);
//        this.container = new SimpleContainer(1);
//    }

    public ContainerResearcher(int containerId, Inventory playerInv){
        super(RESEARCHING.get(), containerId);

        this.container = new SimpleContainer(1);
        this.addSlot(new Slot(container,0,80,35));

        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 9; ++col) {
                this.addSlot(new Slot(playerInv, col + row * 9 + 9, 8 + col * 18, 84 + row * 18));
            }
        }
        for (int col = 0; col < 9; ++col) {
            this.addSlot(new Slot(playerInv, col, 8 + col * 18, 142));
        }
    }

    @Override
    public @NotNull ItemStack quickMoveStack(@NotNull Player p_38941_, int p_38942_) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(p_38942_);
        if (slot != null && slot.hasItem()) {
            ItemStack stack = slot.getItem();
            itemstack = stack.copy();
            if (p_38942_ == 0) {
                if (!this.moveItemStackTo(stack, 1, 37, true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(stack, 0, 1, false)) {
                return ItemStack.EMPTY;
            }
            if (stack.isEmpty()) slot.set(ItemStack.EMPTY);
            else slot.setChanged();
        }
        return itemstack;
    }

    @Override
    public void removed(Player p_38940_) {
        super.removed(p_38940_);
        this.clearContainer(p_38940_,this.container);
    }

    @Override
    public boolean stillValid(@NotNull Player p_38874_) {
        return true;
    }
}
