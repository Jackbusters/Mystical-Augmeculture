package com.jackbusters.mysticalaugmeculture.mixins;

import com.blakebr0.mysticalagriculture.api.tinkering.AugmentType;
import com.blakebr0.mysticalagriculture.augment.SlownessResistanceAugment;
import com.blakebr0.mysticalagriculture.augment.SpeedAugment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.EnumSet;

/**
 * <h1>More Tools For Slowness Resistance Augment</h1>
 * <p>Expands Slowness Resistance augment compatibility to armor beyond the leggings.</p>
 */
@Mixin(SlownessResistanceAugment.class)
public class SlownessAugmentMoreArmor {

    /**
     * Replaces the following argument:
     * <pre>{@code
     * EnumSet.of(AugmentType.LEGGINGS);}</pre><br>
     * with one more accepting of different armors.
     *
     * @param compatibility The original compatibility set.
     * @return The new compatibility set
     */
    @ModifyArg(method = "<init>", at = @At(value = "INVOKE", target = "Lcom/blakebr0/mysticalagriculture/api/tinkering/Augment;<init>(Lnet/minecraft/resources/ResourceLocation;ILjava/util/EnumSet;II)V"), index = 2)
    private static EnumSet<? extends AugmentType> moreTools(EnumSet<AugmentType> compatibility){
        compatibility.add(AugmentType.BOOTS);
        return compatibility;
    }
}
