package afab.lib;

import afab.items.Items;
import net.minecraft.creativetab.CreativeTabs;

public class AFComponentsTab extends CreativeTabs{

	public AFComponentsTab(int par1, String par2Str) {
		super(par1, par2Str);
		
		
	}
	
	@Override
	public int getTabIconItemIndex() {
	return Items.meta.itemID;
	}

}
