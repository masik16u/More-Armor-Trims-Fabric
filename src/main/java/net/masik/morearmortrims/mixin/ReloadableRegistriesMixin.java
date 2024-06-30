package net.masik.morearmortrims.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.masik.morearmortrims.util.ModLootTableModifiers;
import net.minecraft.loot.LootTable;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.MutableRegistry;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.ReloadableRegistries;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Mixin(ReloadableRegistries.class)
public class ReloadableRegistriesMixin {
	@Unique
	private static final Identifier LOOT_TABLE_ID = Identifier.ofVanilla("loot_table");

	@SuppressWarnings("unchecked")
	@ModifyArg(method = "reload", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Util;combineSafe(Ljava/util/List;)Ljava/util/concurrent/CompletableFuture;"), require = 0)
	private static List<CompletableFuture<MutableRegistry<?>>> modifyLootTables(
			List<CompletableFuture<MutableRegistry<?>>> futures,
			@Local DynamicRegistryManager.Immutable immutable
	) {
		RegistryEntryLookup.RegistryLookup lookup = immutable.createRegistryLookup();
		for (CompletableFuture<MutableRegistry<?>> future : futures)
			future.thenApplyAsync(registry -> {
				if (LOOT_TABLE_ID.equals(registry.getKey().getValue()))
					ModLootTableModifiers.modify((MutableRegistry<LootTable>) registry, lookup);
				return registry;
			});
		return futures;
	}
}