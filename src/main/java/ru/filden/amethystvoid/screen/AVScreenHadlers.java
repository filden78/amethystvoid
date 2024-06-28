package ru.filden.amethystvoid.screen;

import net.minecraft.screen.ScreenHandlerType;

public class AVScreenHadlers {
    public static ScreenHandlerType<AVCleanerScreenHandler> AV_SCREEN_HANDLER;
    public static void registerAllScreenHandlers() {
        AV_SCREEN_HANDLER = new ScreenHandlerType<>(AVCleanerScreenHandler::new);
    }
}