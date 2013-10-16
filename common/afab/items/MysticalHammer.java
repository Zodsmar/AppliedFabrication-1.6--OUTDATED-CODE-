package afab.items;

import java.util.List;

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

public class MysticalHammer extends ItemCraftingDamage{
protected MysticalHammer(int par1) {
		
		super(par1);
		this.setCreativeTab(AppliedFabrication.AFTab);
         this.setUnlocalizedName(Names.mysticalHammer_unlocalizedname);
		maxStackSize = 1;
		setMaxDamage(-1);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {

		itemIcon = icon.registerIcon(ModInfo.MODID.toLowerCase() + ":" + Names.mysticalHammer_unlocalizedname);
	}
	
	public boolean hasEffect(ItemStack par1ItemStack) {
		return true;
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
			
			par3World.setBlock(par4, par5, par6, output.itemID, output.getItemDamage(), 2);
			
			return true;
		}
		
		return false;
	}
	
	@SuppressWarnings({"unchecked", "rawtypes"})
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean i)
	{
	list.add("\u00A76An UNBREAKABLE Hammer!");
	}

	 public boolean isFull3D()
    {
        return true;
    }
}
