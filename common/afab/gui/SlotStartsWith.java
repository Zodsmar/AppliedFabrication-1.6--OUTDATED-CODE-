package afab.gui;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotStartsWith extends Slot {
	private String startString;
	
	public SlotStartsWith(IInventory par1iInventory, String startString, int par2, int par3,
			int par4) {
		super(par1iInventory, par2, par3, par4);
		this.startString = startString;
	}
	
	@Override
	public boolean isItemValid(ItemStack par1ItemStack)
	{
		return par1ItemStack.getUnlocalizedName().startsWith(startString);
	}
	
}
