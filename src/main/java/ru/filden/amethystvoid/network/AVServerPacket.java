package ru.filden.amethystvoid.network;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;
import ru.filden.amethystvoid.Amethystvoid;

public class AVServerPacket {
    public final Identifier ID;
    public final ClientPlayNetworking.PlayChannelHandler HANDLER;

    public AVServerPacket(String id, ClientPlayNetworking.PlayChannelHandler handler){
        ID = new Identifier(Amethystvoid.MOD_ID, id);
        HANDLER = handler;
    }
}
