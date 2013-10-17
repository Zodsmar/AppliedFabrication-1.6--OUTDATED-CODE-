package afab.gui;

import afab.interfaces.ISlotChanged;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotStartsWith extends Slot {
	private String startString;
	private ISlotChanged slotChanged;
	
	public SlotStartsWith(IInventory par1iInventory, String startString, int par2, int par3,
			int par4) {
		super(par1iInventory, par2, par3, par4);
		this.startString = startString;
	}
	
	public Slot setSlotChange(ISlotChanged slotChanged) {
		this.slotChanged = slotChanged;
		return this;
	}
	
	@Override
	public void onSlotChange(ItemStack par1ItemStack, ItemStack par2ItemStack) {
		super.onSlotChange(par1ItemStack, par2ItemStack);
		
		if(slotChanged != null)
			slotChanged.onSlotChange(this, this.slotNumber, par1ItemStack, par2ItemStack);
	}
	
	@Override
	public boolean isItemValid(ItemStack par1ItemStack)
	{
		return par1ItemStack.getUnlocalizedName().startsWith(startString);
	}
	
	@Override
	public int getSlotStackLimit() {
		return 1;
	}
	
}
