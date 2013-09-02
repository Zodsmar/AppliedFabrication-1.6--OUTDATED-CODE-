package afab.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import afab.AppliedFabrication;
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
	
	@SuppressWarnings({"unchecked", "rawtypes"})
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean i)
	{
	list.add("\u00A76An UNBREAKABLE Hammer!");
	}

}
