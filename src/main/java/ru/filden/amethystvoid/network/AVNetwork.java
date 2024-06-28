package ru.filden.amethystvoid.network;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.server.network.ServerPlayerEntity;
import ru.filden.amethystvoid.Amethystvoid;
import ru.filden.amethystvoid.dimension.ModDimension;

public class AVNetwork {
    private static AVClientPacket registerPacket(String id, ServerPlayNetworking.PlayChannelHandler handler){
        AVClientPacket packet = new AVClientPacket(id, handler);
        ServerPlayNetworking.registerGlobalReceiver(packet.ID, handler);
        return packet;
    }
    private static AVServerPacket registerPacket(String id, ClientPlayNetworking.PlayChannelHandler handler){
        AVServerPacket packet = new AVServerPacket(id, handler);
       ClientPlayNetworking.registerGlobalReceiver(packet.ID, handler);
        return packet;
    }
    public static void send(AVClientPacket packet){
        ClientPlayNetworking.send(packet.ID, PacketByteBufs.create());
    }
    public static void send(AVServerPacket packet, ServerPlayerEntity reciver){
        ServerPlayNetworking.send(reciver, packet.ID, PacketByteBufs.create());
    }
    public static void init(){

    }
}
