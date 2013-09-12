package afab.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import afab.AppliedFabrication;
import afab.lib.ModInfo;
import afab.lib.Names;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class FabricationTable extends Block{

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
	public Icon getIcon(int side, int meta)
	{
	         return side == 1 ? this.tableIconTop : (side == 0 ? Block.planks.getBlockTextureFromSide(side) : (side != 2 && side != 4 ? this.blockIcon : this.tableIconFront));
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
	this.blockIcon = par1IconRegister.registerIcon(ModInfo.MODID.toLowerCase() + ":table_side");
	this.tableIconTop = par1IconRegister.registerIcon(ModInfo.MODID.toLowerCase() + ":table_top");
	this.tableIconFront = par1IconRegister.registerIcon(ModInfo.MODID.toLowerCase() + ":table_front");
	}
	
	public boolean onBlockActivated(World var1, int var2, int var3, int var4, EntityPlayer player, int var6, float var7, float var8, float var9)
	{
	         if (!player.isSneaking())
	{
	player.openGui(AppliedFabrication.instance, 0, var1, var2, var3, var4);
	return true;
	}
	else
	{
	return false;
	}
	}

}
