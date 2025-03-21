package conmom.item.`throw`

import conmom.sound.ModSounds
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.projectile.ProjectileEntity
import net.minecraft.entity.projectile.thrown.SnowballEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.item.SnowballItem
import net.minecraft.server.world.ServerWorld
import net.minecraft.sound.SoundCategory
import net.minecraft.sound.SoundEvents
import net.minecraft.stat.Stats
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import net.minecraft.util.math.Direction
import net.minecraft.util.math.Position
import net.minecraft.world.World

class Cupcake(settings: Settings?) : Item(settings) {
    private val power = 1.5f

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
        if (world is ServerWorld) {
            ProjectileEntity.spawnWithVelocity({ world: ServerWorld?, owner: LivingEntity?, stack: ItemStack? ->
                SnowballEntity(
                    world,
                    owner,
                    stack
                )
            }, world, itemStack, user, 0.0f, this.power, 1.0f)
        }

        user.incrementStat(Stats.USED.getOrCreateStat(this))
        itemStack.decrementUnlessCreative(1, user)
        return ActionResult.SUCCESS
    }
}