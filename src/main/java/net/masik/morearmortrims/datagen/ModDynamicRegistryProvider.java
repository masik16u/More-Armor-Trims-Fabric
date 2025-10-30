package net.masik.morearmortrims.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.item.equipment.trim.ArmorTrimMaterial;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

import static net.masik.morearmortrims.MoreArmorTrims.TRIM_MATERIALS;

public class ModDynamicRegistryProvider extends FabricDynamicRegistryProvider {
    public ModDynamicRegistryProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup, Entries entries) {
        TRIM_MATERIALS.forEach((key) -> add(wrapperLookup, entries, key));
    }

    private void add(RegistryWrapper.WrapperLookup wrapperLookup, Entries entries, RegistryKey<ArmorTrimMaterial> key) {
        entries.add(key, wrapperLookup.getOrThrow(RegistryKeys.TRIM_MATERIAL).getOrThrow(key).value());
    }

    @Override
    public String getName() {
        return "Trim Materials";
    }
}
