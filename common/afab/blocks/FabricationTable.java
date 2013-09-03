package afab.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import afab.AppliedFabrication;
import afab.lib.ModInfo;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class FabricationTable extends Block{

	public FabricationTable(int id) {
		super(id, Material.wood);
		this.setCreativeTab(AppliedFabrication.AFTab);
		this.setHardness(2F);
		this.setStepSound(soundWoodFootstep);
	}
	@SideOnly(Side.CLIENT)
	private Icon tableIconTop;
	@SideOnly(Side.CLIENT)
	private Icon tableIconFront;
	
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int par1, int par2)
	{
	         return par1 == 1 ? this.tableIconTop : (par1 == 0 ? Block.planks.getBlockTextureFromSide(par1) : (par1 != 2 && par1 != 4 ? this.blockIcon : this.tableIconFront));
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
	this.blockIcon = par1IconRegister.registerIcon(ModInfo.MODID.toLowerCase() + ":table_side");
	this.tableIconTop = par1IconRegister.registerIcon(ModInfo.MODID.toLowerCase() + ":table_top");
	this.tableIconFront = par1IconRegister.registerIcon(ModInfo.MODID.toLowerCase() + ":table_front");
	}




}
