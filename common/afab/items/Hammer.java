package afab.items;



import net.minecraft.client.renderer.texture.IconRegister;
import afab.AppliedFabrication;
import afab.lib.ModInfo;
import afab.lib.Names;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Hammer extends ItemCraftingDamage{

	protected Hammer(int par1) {
		
		super(par1);
		this.setCreativeTab(AppliedFabrication.AFTab);
         this.setUnlocalizedName(Names.hammer_unlocalizedname);
		maxStackSize = 1;
		setMaxDamage(127);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {

		itemIcon = icon.registerIcon(ModInfo.MODID.toLowerCase() + ":" + Names.hammer_unlocalizedname);
	}
	

}
