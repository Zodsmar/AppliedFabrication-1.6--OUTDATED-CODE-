package afab.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import afab.AppliedFabrication;
import afab.crafting.Recipes;
import afab.lib.ModInfo;
import afab.lib.Names;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class IronHammer extends ItemCraftingDamage{

	protected IronHammer(int par1) {
		
		super(par1);
		this.setCreativeTab(AppliedFabrication.AFTab);
         this.setUnlocalizedName(Names.ironHammer_unlocalizedname);
		maxStackSize = 1;
		setMaxDamage(255);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {

		itemIcon = icon.registerIcon(ModInfo.MODID.toLowerCase() + ":" + Names.ironHammer_unlocalizedname);
	}
	
	@Override
	public boolean onItemUse(ItemStack par1ItemStack,
			EntityPlayer par2EntityPlayer, World par3World, int par4, int par5,
			int par6, int par7, float par8, float par9, float par10) {
		int id = par3World.getBlockId(par4, par5, par6);
		int meta = par3World.getBlockMetadata(par4, par5, par6);
		ItemStack output = Recipes.getHammerRecipe(id, meta);
		
		if(output != null) {
			String paricle = "explode";
			par3World.spawnParticle(paricle, par4, par5 + 1D, par6, 0D, 0D, 0D);
			par3World.spawnParticle(paricle, par4 + 1, par5 + 1D, par6, 0D, 0D, 0D);
			par3World.spawnParticle(paricle, par4 + 1, par5 + 1D, par6 + 1, 0D, 0D, 0D);
			par3World.spawnParticle(paricle, par4, par5 + 1D, par6 + 1, 0D, 0D, 0D);
			
			par3World.setBlock(par4, par5, par6, output.itemID, Recipes.getIgroneMeta(id, meta) ? meta : output.getItemDamage(), 2);
			
			if(!par2EntityPlayer.capabilities.isCreativeMode)
				par1ItemStack.damageItem(2, par2EntityPlayer);
			
			return true;
		}
		
		return false;
	}
	
	@Override
	public boolean isFull3D()
    {
        return true;
    }

}
