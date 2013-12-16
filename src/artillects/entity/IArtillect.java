package artillects.entity;

import net.minecraft.inventory.IInventory;
import artillects.hive.ArtillectTaskType;
import artillects.hive.zone.Zone;

public interface IArtillect
{
	public void setOwner(Object hive);

	public Object getOwner();

	public Zone getZone();

	public void setZone(Zone zone);

	public ArtillectTaskType getType();

	public void setType(ArtillectTaskType type);

	public IInventory getInventory();
}
