package afab.tileentities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileEntityFabTable extends TileEntity implements IInventory{

		private ItemStack[] inventory;

		public TileEntityFabTable() {
		inventory = new ItemStack[45];
		}
	
		@Override
		public int getSizeInventory() {
		return inventory.length;
		}

		@Override
		public ItemStack getStackInSlot(int i) {
		return inventory[i];
		}

		@Override
		public ItemStack decrStackSize(int slot, int count) {
		ItemStack itemstack = getStackInSlot(slot);

		if(itemstack != null) {
		if(itemstack.stackSize <= count) {
		setInventorySlotContents(slot, null);
		} else {
		itemstack = itemstack.splitStack(count);
		onInventoryChanged();
		}
		}
		return itemstack;
		}

		@Override
		public ItemStack getStackInSlotOnClosing(int slot) {
		ItemStack itemstack = getStackInSlot(slot);
		setInventorySlotContents(slot, null);
		return itemstack;
		}

		@Override
		public void setInventorySlotContents(int slot, ItemStack itemstack) {
		inventory[slot] = itemstack;

		if(itemstack != null && itemstack.stackSize > getInventoryStackLimit()) {
		itemstack.stackSize = getInventoryStackLimit();
		}
		onInventoryChanged();
		}

		@Override
		public String getInvName() {
		return "Fabrication Table";
		}

		@Override
		public boolean isInvNameLocalized() {
		return true;
		}

		@Override
		public int getInventoryStackLimit() {
		return 64;
		}

		@Override
		public boolean isUseableByPlayer(EntityPlayer player) {
			if(player.getDistanceSq(xCoord + 0.5D, yCoord + 0.5D, zCoord + 0.5D) <= 64) {
				return true;
				} else {
				return false;
				}
		}

		@Override
		public void openChest() {}

		@Override
		public void closeChest() {}

		@Override
		public boolean isItemValidForSlot(int slot, ItemStack itemstack) {
		return true;
		}


}
