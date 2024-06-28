package ru.filden.amethystvoid.network;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;
import ru.filden.amethystvoid.Amethystvoid;

public class AVClientPacket {
    public final Identifier ID;
    public final ServerPlayNetworking.PlayChannelHandler HANDLER;

    public AVClientPacket(String id, ServerPlayNetworking.PlayChannelHandler handler){
        ID = new Identifier(Amethystvoid.MOD_ID, id);
        HANDLER = handler;
    }
}
