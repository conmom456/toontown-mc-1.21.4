package conmom.entity

import conmom.sound.ModSounds
import net.minecraft.entity.EntityStatuses
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.projectile.thrown.SnowballEntity
import net.minecraft.item.ItemStack
import net.minecraft.server.world.ServerWorld
import net.minecraft.sound.SoundCategory
import net.minecraft.util.hit.EntityHitResult

class ThrowProjectile(world: ServerWorld?, owner: LivingEntity?, stack: ItemStack?): SnowballEntity(world, owner, stack) {
    override fun onEntityHit(entityHitResult: EntityHitResult?) {
        super.onEntityHit(entityHitResult)
        val entity = entityHitResult!!.entity
        entity.damage(world as ServerWorld?, this.damageSources.thrown(this, this.owner), 6.0f)
//        world.playSound(
//            null,
//            this.x,
//            this.y,
//            this.z,
//            ModSounds.THROW_HIT_EVENT,
//            SoundCategory.PLAYERS,
//            1.0f,
//            (world.getRandom().nextFloat() * 0.05f + 0.975f)
//        )
    }

    override fun handleStatus(status: Byte) {
        if (status == EntityStatuses.PLAY_DEATH_SOUND_OR_ADD_PROJECTILE_HIT_PARTICLES) {
            world.playSound(
                null,
                this.x,
                this.y,
                this.z,
                ModSounds.THROW_HIT_EVENT,
                SoundCategory.PLAYERS,
                1.0f,
                (world.getRandom().nextFloat() * 0.05f + 0.975f)
            )
        }
    }
}