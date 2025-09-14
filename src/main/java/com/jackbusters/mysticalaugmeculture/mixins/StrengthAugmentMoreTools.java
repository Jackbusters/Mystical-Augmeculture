package com.jackbusters.mysticalaugmeculture.mixins;

import com.blakebr0.mysticalagriculture.api.tinkering.AugmentType;
import com.blakebr0.mysticalagriculture.augment.StrengthAugment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.EnumSet;

/**
 * <h1>More Tools For Strength Augment</h1>
 * <p>Expands Strength augment compatibility to weapons beyond the sword.</p>
 */
@Mixin(StrengthAugment.class)
public class StrengthAugmentMoreTools {

    /**
     * Replaces the following argument:
     * <pre>{@code
     * EnumSet.of(AugmentType.SWORD);}</pre><br>
     * with one more accepting of different weapons.
     *
     * @param compatibility The original compatibility set.
     * @return The new compatibility set
     */
    @ModifyArg(method = "<init>", at = @At(value = "INVOKE", target = "Lcom/blakebr0/mysticalagriculture/api/tinkering/Augment;<init>(Lnet/minecraft/resources/ResourceLocation;ILjava/util/EnumSet;II)V"), index = 2)
    private static EnumSet<? extends AugmentType> moreTools(EnumSet<AugmentType> compatibility){
        compatibility.add(AugmentType.AXE);
        compatibility.add(AugmentType.SCYTHE);
        compatibility.add(AugmentType.SICKLE);
        return compatibility;
    }
}
