package artillects.entity.ai.combat;

import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import artillects.entity.EntityArtillectGround;
import artillects.entity.IArtillect;
import artillects.hive.complex.HiveComplex;

public class EntityDroneSelector implements IEntitySelector
{
    IArtillect drone;

    public EntityDroneSelector(IArtillect drone)
    {
        this.drone = drone;
    }

    @Override
    public boolean isEntityApplicable(Entity entity)
    {
        if (entity instanceof EntityLivingBase)
        {
            if (entity.isEntityAlive() && !entity.isInvisible())
            {
                // Attack players if hive drone TODO change to hostile only system later
                if (drone.getOwner() instanceof HiveComplex && !((HiveComplex) drone.getOwner()).playerZone)
                {
                    if (entity instanceof EntityPlayer && entity.worldObj.difficultySetting > 0)
                    {
                        if (!((EntityPlayer) entity).capabilities.isCreativeMode)
                        {
                            return true;
                        }
                    }
                    // Attack enemy drones
                    if (entity instanceof EntityArtillectGround)
                    {
                        if (drone.getOwner() instanceof HiveComplex && ((HiveComplex) drone.getOwner()).playerZone)
                        {
                            return true;
                        }
                    }
                }
                else
                {
                    // Attack enemy drones
                    if (entity instanceof EntityArtillectGround)
                    {
                        if (drone.getOwner() instanceof HiveComplex && !((HiveComplex) drone.getOwner()).playerZone)
                        {
                            return true;
                        }
                    }
                }
                // Always attack mobs
                if (entity instanceof IMob)
                {
                    return true;
                }

            }
        }
        return false;
    }
}
