package net.masik.morearmortrims.mixin;

import net.minecraft.registry.entry.RegistryEntry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(targets = "net.minecraft.registry.entry.RegistryEntry$Reference")
public interface RegistryEntryAccessor<T> extends RegistryEntry<T> {
	@Accessor
	void setValue(T value);
}
