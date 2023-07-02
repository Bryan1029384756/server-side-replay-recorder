package com.thecolonel63.serversidereplayrecorder.mixin.player;

import com.thecolonel63.serversidereplayrecorder.recorder.PlayerRecorder;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Set;

@Mixin(ServerWorld.class)
public class ServerWorldMixin {

    //moved to PlayerManagerMixin#sendToAround
    //Sounds
    /*@Inject(method = "playSound", at = @At("HEAD"))
    private void recordPlaySound(@Nullable PlayerEntity except, double x, double y, double z, RegistryEntry<SoundEvent> sound, SoundCategory category, float volume, float pitch, long seed, CallbackInfo ci) {
        PlayerRecorder.playerRecorderMap.forEach((connection, playerThreadRecorder) -> {
                if (playerThreadRecorder.playerId != null) {
                    playerThreadRecorder.onClientSound(sound, category, x, y, z, volume, pitch, seed);
                }
        });
    }*/


    //moved to PlayerManagerMixin#sendToAround
    //Animations
   /* @Inject(method = "syncWorldEvent", at = @At("HEAD"))
    private void playLevelEvent(PlayerEntity player, int eventId, BlockPos pos, int data, CallbackInfo ci) {
        PlayerRecorder.playerRecorderMap.forEach(((connection, playerThreadRecorder) -> {
            if (player != null && playerThreadRecorder.playerId != null && playerThreadRecorder.playerId == player.getUuid()) {
                playerThreadRecorder.onClientEffect(eventId, pos, data);
            }
        }));
    }*/

    //Block breaking
    @Inject(method = "setBlockBreakingInfo", at = @At("TAIL"))
    private void saveBlockBreakingProgressPacket(int entityId, BlockPos pos, int progress, CallbackInfo ci) {
        Set.copyOf(PlayerRecorder.playerRecorderMap.values()).forEach((playerThreadRecorder) -> playerThreadRecorder.onBlockBreakAnim(entityId, pos, progress));
    }
}
