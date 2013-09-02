package afab.lib;

import afab.items.Items;
import net.minecraft.creativetab.CreativeTabs;

public class AFTab extends CreativeTabs{

	public AFTab(int id, String name) {
		super(id, name);
		}

		@Override
		public int getTabIconItemIndex() {
		return Items.hammer.itemID;
		}

}
