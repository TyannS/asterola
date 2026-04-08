package com.tyanns.asterola;

import com.tyanns.asterola.item.ModCreativeModeTabs;
import com.tyanns.asterola.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Asterola implements ModInitializer {
	public static final String MOD_ID = "asterola";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.register();
		ModCreativeModeTabs.register();
		LOGGER.info("Asterola let's go!");
	}
}