package afab.lib;

import net.minecraft.creativetab.CreativeTabs;
import afab.items.Items;

public class AFComponentsTab extends CreativeTabs{

	public AFComponentsTab(int par1, String par2Str) {
		super(par1, par2Str);
		
		
	}
	
	@Override
	public int getTabIconItemIndex() {
	return Items.meta.itemID;
	}

}
