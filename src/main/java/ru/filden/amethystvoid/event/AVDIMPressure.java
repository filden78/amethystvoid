package ru.filden.amethystvoid.event;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import ru.filden.amethystvoid.Amethystvoid;
import ru.filden.amethystvoid.dimension.ModDimension;
import ru.filden.amethystvoid.item.armor.AVarmorItem;

public class AVDIMPressure implements  ServerTickEvents.StartTick  {
    private MinecraftServer server;
    @Override
    public void onStartTick(MinecraftServer server) {
        this.server = server;
        for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
            if(player.getWorld().getDimensionKey()== ModDimension.AVDIM_TYPE && !player.isSpectator()){
                if(!AVarmorItem.hasFullAmethystArmor()){
                    if(player.getStatusEffect(Amethystvoid.PRESSURE_DIM)== null){
                    player.addStatusEffect(new StatusEffectInstance(Amethystvoid.PRESSURE_DIM, 100,0));
                    }
                }
            }
        }
    }
}