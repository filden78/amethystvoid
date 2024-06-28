package ru.filden.amethystvoid.client;
import  net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import ru.filden.amethystvoid.screen.AVCleanerScreen;
import ru.filden.amethystvoid.screen.AVScreenHadlers;
@Environment(EnvType.CLIENT)
public class AmethystvoidClient implements ClientModInitializer  {

    @Override
    public void onInitializeClient() {
        HandledScreens.register(AVScreenHadlers.AV_SCREEN_HANDLER, AVCleanerScreen::new);

    }
}
