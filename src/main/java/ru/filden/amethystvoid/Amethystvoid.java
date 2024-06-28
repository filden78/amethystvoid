package ru.filden.amethystvoid;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import ru.filden.amethystvoid.block.blocks;
import ru.filden.amethystvoid.block.entity.AVBlockEntities;
import ru.filden.amethystvoid.block.feature;
import ru.filden.amethystvoid.dimension.ModDimension;
import ru.filden.amethystvoid.effect.appeasementEffect;
import ru.filden.amethystvoid.effect.avdimPressureEffect;
import ru.filden.amethystvoid.effect.diarrheaEffect;
import ru.filden.amethystvoid.event.AVDIMPressure;
import ru.filden.amethystvoid.item.items;
import ru.filden.amethystvoid.screen.AVCleanerScreenHandler;
import ru.filden.amethystvoid.screen.AVScreenHadlers;


public class Amethystvoid implements ModInitializer {
    public static final String MOD_ID = "amethystvoid";
    public static final StatusEffect PRESSURE_DIM = new avdimPressureEffect();
    public static final StatusEffect APPEASEMENT = new appeasementEffect();
    public static final StatusEffect DIARRHEA = new diarrheaEffect();
    private void registryEffects(){
        Registry.register(Registry.STATUS_EFFECT, new Identifier(MOD_ID, "dim_pressure_effect"), PRESSURE_DIM);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(MOD_ID, "appeasement_effect"), APPEASEMENT);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(MOD_ID, "diarrhea_effect"), DIARRHEA);
    }



    @Override
    public void onInitialize() {
        blocks.init();
        AVBlockEntities.init();
        items.init();
        ModDimension.init();
        feature.init();
        registryEffects();
        AVScreenHadlers.registerAllScreenHandlers();
        ServerTickEvents.START_SERVER_TICK.register(new AVDIMPressure());
    }
}
