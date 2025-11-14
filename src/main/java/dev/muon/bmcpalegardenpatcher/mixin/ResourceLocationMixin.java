package dev.muon.bmcpalegardenpatcher.mixin;

import dev.muon.bmcpalegardenpatcher.BMCPaleGardenPatcher;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(ResourceLocation.class)
public class ResourceLocationMixin {

    // that's one way to do it. shoutout Noaaan

    @Shadow(remap = true)  /*lmao??*/
    protected static String[] decompose(String pLocation, char pSeparator) {
        return null;
    }

    @ModifyArg(method = "<init>(Ljava/lang/String;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/resources/ResourceLocation;<init>([Ljava/lang/String;)V"))
    private static String[] remapIdentifier(String[] decomposed) {
        String fullId = decomposed[0] + ":" + decomposed[1];
        if (fullId.startsWith("dtkupd:")) {
            String newId = BMCPaleGardenPatcher.remapIdentifier(fullId);
            return decompose(newId, ':');
        }
        return decomposed;
    }
}