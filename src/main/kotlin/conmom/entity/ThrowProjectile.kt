package conmom.entity

import conmom.sound.ModSounds
import conmom.toontownmc.ToontownMC
import net.minecraft.entity.EntityStatuses
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.projectile.thrown.SnowballEntity
import net.minecraft.item.ItemStack
import net.minecraft.server.world.ServerWorld
import net.minecraft.sound.SoundCategory
import net.minecraft.util.hit.EntityHitResult
import net.minecraft.util.hit.HitResult

class ThrowProjectile(world: ServerWorld?, owner: LivingEntity?, stack: ItemStack?): SnowballEntity(world, owner, stack) {
    override fun onEntityHit(entityHitResult: EntityHitResult?) {
        val entity = entityHitResult!!.entity
        if (entity is LivingEntity) {
            var damage = 0
            when (this.stack.registryEntry.idAsString) {
                "toontownmc:cupcake" -> damage = 6
                "toontownmc:fruit_pie_slice" -> damage = 12
                "toontownmc:cream_pie_slice" -> damage = 17
                "toontownmc:whole_fruit_pie" -> damage = 27
                "toontownmc:whole_cream_pie" -> damage = 40
                "toontownmc:birthday_cake" -> damage = 100
                "toontownmc:wedding_cake" -> damage = 120
            }
            ToontownMC.logger.info("Damage is: $damage")
            entity.damage(world as ServerWorld?, this.damageSources.thrown(this, this.owner), damage.toFloat())
            entity.hurtTime = 1
        }
    }

    override fun onCollision(hitResult: HitResult?) {
        super.onCollision(hitResult)
        if (!world.isClient) {
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
            world.sendEntityStatus(this, EntityStatuses.PLAY_DEATH_SOUND_OR_ADD_PROJECTILE_HIT_PARTICLES)
            this.discard()
        }
    }
}