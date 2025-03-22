package conmom.item.`throw`

import conmom.entity.ThrowProjectile
import conmom.sound.ModSounds
import conmom.toontownmc.ToontownMC
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking
import net.minecraft.entity.Entity
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.projectile.ProjectileEntity
import net.minecraft.entity.projectile.thrown.SnowballEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.server.world.ServerWorld
import net.minecraft.sound.SoundCategory
import net.minecraft.sound.SoundEvent
import net.minecraft.stat.Stats
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import net.minecraft.util.Identifier
import net.minecraft.world.World

class Cupcake(settings: Settings?) : Item(settings) {
    private val power = 1.5f
    val PLAY_ENTITY_SOUND = Identifier.of(ToontownMC.MOD_ID, "play_entity_sound")

    override fun use(world: World, user: PlayerEntity, hand: Hand?): ActionResult {
        val itemStack = user.getStackInHand(hand)
        world.playSound(
            null,
            user.x,
            user.y,
            user.z,
            ModSounds.THROW_GAG_EVENT,
            SoundCategory.NEUTRAL,
            0.5f,
            (world.getRandom().nextFloat() * 0.05f + 0.975f)
        )
        lateinit var throwProj: ProjectileEntity
        if (world is ServerWorld) {
            throwProj = ProjectileEntity.spawnWithVelocity({ world: ServerWorld?, owner: LivingEntity?, stack: ItemStack? ->
                ThrowProjectile(
                    world,
                    owner,
                    stack
                )
            }, world, itemStack, user, 0.0f, this.power, 0.1f)
            throwProj.setVelocity(user.rotationVector.normalize().multiply(power.toDouble()))

//            world.server.playerManager.send
//            world.playSoundFromEntity(throwProj, ModSounds.THROW_GAG_EVENT, SoundCategory.PLAYERS, 5.0f, (world.getRandom().nextFloat() * 0.05f + 0.975f))
        }

        user.incrementStat(Stats.USED.getOrCreateStat(this))
        itemStack.decrementUnlessCreative(1, user)
        return ActionResult.SUCCESS
    }
//    fun sendEntitySoundPacket(player: ServerPlayerEntity, entity: Entity, sound: SoundEvent) {
//        val buf = PacketByteBufs.create()
//        buf.writeInt(entity.id)
//        buf.writeIdentifier(sound.id)
//        ServerPlayNetworking.send(player, PLAY_ENTITY_SOUND, buf)
//    }
}