package afab.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import afab.lib.IDs;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{

	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
	world.getBlockTileEntity(x, y, z);
	switch(id)
	{
	case 0: return id == 0 && world.getBlockId(x, y, z) == IDs.fabTable_actual ? new ContainerFabTable(player.inventory, world, x, y, z) : null;
	}
	return null;
	}
	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
	world.getBlockTileEntity(x, y, z);
	switch(id)
	{
	case 0: return id == 0 && world.getBlockId(x, y, z) == IDs.fabTable_actual ? new FabTableGui(player.inventory, world, x, y, z) : null;
	}
	return null;
	}

}
