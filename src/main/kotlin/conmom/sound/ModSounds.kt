package conmom.sound

import conmom.toontownmc.ToontownMC
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.sound.SoundEvent
import net.minecraft.util.Identifier

object ModSounds {

    val THROW_GAG_ID: Identifier? = Identifier.of("toontownmc:gags.throw_gag")
    val THROW_GAG_EVENT = SoundEvent.of(THROW_GAG_ID)

    fun registerSounds() {
        ToontownMC.logger.info("Registering mod sound for ${ToontownMC.MOD_ID}")

        Registry.register(Registries.SOUND_EVENT, THROW_GAG_ID, THROW_GAG_EVENT)
    }
}