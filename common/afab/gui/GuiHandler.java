package afab.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import afab.tileentities.TileEntityFabTable;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{

	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntityFabTable tileFabTable = (TileEntityFabTable) world.getBlockTileEntity(x, y, z);
	if(tileFabTable instanceof TileEntityFabTable){
		return new ContainerFabTable(tileFabTable, player.inventory, world, x, y, z);
		}
	return null;
	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntityFabTable tileFabTable = (TileEntityFabTable) world.getBlockTileEntity(x, y, z);
		if(tileFabTable instanceof TileEntityFabTable){
			return new FabTableGui(player.inventory, tileFabTable, world, x, y, z);
			}

	return null;
	}

}
