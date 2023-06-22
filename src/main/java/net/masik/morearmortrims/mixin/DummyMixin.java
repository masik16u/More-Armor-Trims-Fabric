package net.masik.morearmortrims.mixin;

import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(TitleScreen.class)
public class DummyMixin {
    // Makes git keep it, but isn't loaded in the game
}
