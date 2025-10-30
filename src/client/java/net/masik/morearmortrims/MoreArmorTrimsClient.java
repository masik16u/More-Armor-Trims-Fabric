package net.masik.morearmortrims;

import com.google.common.reflect.Reflection;
import net.fabricmc.api.ClientModInitializer;
import net.masik.morearmortrims.util.TrimFixer;

public class MoreArmorTrimsClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		TrimFixer.register();
	}
}