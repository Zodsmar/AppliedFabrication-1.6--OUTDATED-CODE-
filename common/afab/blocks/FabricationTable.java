package afab.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import afab.AppliedFabrication;
import afab.gui.GuiIDs;
import afab.lib.ModInfo;
import afab.lib.Names;
import afab.tileentities.TileEntityFabTable;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class FabricationTable extends BlockContainer{

	public FabricationTable(int id) {
		super(id, Material.wood);
		this.setCreativeTab(AppliedFabrication.AFTab);
		this.setHardness(2F);
		this.setStepSound(soundWoodFootstep);
		this.setUnlocalizedName(Names.fabTable_unlocalizedname);
	}
	@SideOnly(Side.CLIENT)
	private Icon tableIconTop;
	@SideOnly(Side.CLIENT)
	private Icon tableIconFront;
	@SideOnly(Side.CLIENT)
	private Icon tableIconSide;

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{
	this.tableIconSide = iconRegister.registerIcon(ModInfo.MODID.toLowerCase() + ":table_side");
	this.tableIconTop = iconRegister.registerIcon(ModInfo.MODID.toLowerCase() + ":table_top");
	this.tableIconFront = iconRegister.registerIcon(ModInfo.MODID.toLowerCase() + ":table_front");
	}
	
	@Override
	public Icon getIcon(int side, int meta) {
	if(side == 0) {	
	return Block.planks.getBlockTextureFromSide(side);
	} else if(side == 1) {
	return tableIconTop;
	} else if(side == 5 || side == 3){
	return tableIconFront;
	} else{
		return tableIconSide;
	}
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
	         if (!player.isSneaking())
	{
	player.openGui(AppliedFabrication.instance, GuiIDs.FABTABGui, world, x, y, z);
	return true;
	}
	else
	{
	return false;
	}
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityFabTable();
	}

	

}
