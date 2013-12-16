package artillects.entity;

import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import artillects.Vector3;
import artillects.entity.ai.EntityAIBuilding;
import artillects.entity.ai.EntityAIReproduce;
import artillects.hive.ArtillectTaskType;
import artillects.hive.zone.ZoneMining;
import artillects.hive.zone.ZoneProcessing;

public class EntityFabricator extends EntityArtillectBase
{
	public EntityFabricator(World par1World)
	{
		super(par1World);
		this.tasks.addTask(0, new EntityAIReproduce(this, 0.5f));
		this.tasks.addTask(0, new EntityAIBuilding(this, 0.5f));
		this.tasks.addTask(1, new EntityAIWander(this, 0.5f));
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();
		this.dataWatcher.addObject(EntityArtillectBase.DATA_TYPE_ID, (byte) ArtillectTaskType.FABRICATOR.ordinal());
	}

	@Override
	public void onEntityUpdate()
	{
		super.onEntityUpdate();

		if (this.getZone() == null)
		{
			//TODO: Remove this.
			this.setZone(new ZoneProcessing(this.worldObj, new Vector3(this).add(-25), new Vector3(this).add(25)));
		}

		this.cachedInventory = null;
	}
}
