package afab.items;



import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import afab.AppliedFabrication;
import afab.lib.ModInfo;
import afab.lib.Names;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MetaItems extends Item{

	public MetaItems(int id) {
		super(id);
		setCreativeTab(AppliedFabrication.AFComponents);
		setHasSubtypes(true);
		}

		@Override
		public String getUnlocalizedName(ItemStack itemstack) {
		return Names.metaItems_unlocalizedName[itemstack.getItemDamage()];
		}

		@SideOnly(Side.CLIENT)
		public static Icon[] icons;

		private static final String[] ICON = {
		"hammerHead",
		"rod",
		"divineRod",
		"infusedHead",
		"chain",
		};

		@Override
		@SideOnly(Side.CLIENT)
		public void registerIcons(IconRegister icon) {
		icons = new Icon[ICON.length];

		for(int i = 0; i < icons.length; i++) {
		icons[i] = icon.registerIcon(ModInfo.MODID.toLowerCase() + ":" + ICON[i]);
		}
		}

		@Override
		@SideOnly(Side.CLIENT)
		public Icon getIconFromDamage(int damage) {
		return icons[damage];
		}

		@Override
	    @SuppressWarnings({ "rawtypes", "unchecked" })
		public void getSubItems(int id, CreativeTabs tab, List list) {
		for(int i = 0; i < icons.length; i++) {
		ItemStack itemstack = new ItemStack(id, 1, i);
		list.add(itemstack);
		}
		}
		

		@SuppressWarnings({"unchecked", "rawtypes"})
		@SideOnly(Side.CLIENT)
		public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean i)
		{
			list.add("\u00A72Components");
		}


	
}
