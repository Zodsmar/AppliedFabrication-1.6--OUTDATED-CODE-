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
		public ItemStack decrStackSize(int slot, int amount)
			{
				ItemStack stack = getStackInSlot(slot);
				if(stack != null)
				{
					if(stack.stackSize <= amount)
					{
						setInventorySlotContents(slot, null);
					} else
					{
						stack = stack.splitStack(amount);
						if(stack.stackSize == 0) 
						{
							setInventorySlotContents(slot, null);
						}else
							onInventoryChanged();
					}
				}
				return stack;
			}

		@Override
		public ItemStack getStackInSlotOnClosing(int slot) {
			{
				 if (inventory[slot] != null)
				 {
					 ItemStack itemstack = inventory[slot];
					 inventory[slot] = null;
					 return itemstack;
				 }
				 else
				 {
					 return null;
				 }
			}
		}

		
		@Override
		public void setInventorySlotContents(int slot, ItemStack itemstack) {
			{
				inventory[slot] = itemstack;
				if(itemstack != null && itemstack.stackSize > getInventoryStackLimit())
				{
					itemstack.stackSize = getInventoryStackLimit();
				}
				onInventoryChanged();
			}
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
