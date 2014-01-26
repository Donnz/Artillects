package artillects.block;

import net.minecraft.block.material.Material;
import artillects.Artillects;
import artillects.ArtillectsTab;

public class BlockBase extends calclavia.lib.prefab.block.BlockAdvanced
{

	public BlockBase(String name, Material material)
	{
		super(Artillects.CONFIGURATION.getBlock(name, Artillects.idManager.getNextBlockID()).getInt(), material);
		this.setUnlocalizedName(Artillects.PREFIX + name);
		this.setTextureName(Artillects.PREFIX + name);
		this.setCreativeTab(ArtillectsTab.instance());
	}

}