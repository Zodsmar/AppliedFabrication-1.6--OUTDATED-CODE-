package afab.lib;

import net.minecraft.creativetab.CreativeTabs;
import afab.items.Items;

public class AFTab extends CreativeTabs{

	public AFTab(int id, String name) {
		super(id, name);
		}

		@Override
		public int getTabIconItemIndex() {
		return Items.hammer.itemID;
		}

}
