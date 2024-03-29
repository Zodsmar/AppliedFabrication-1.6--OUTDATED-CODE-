package afab.tileentities;

import afab.interfaces.ISlotChanged;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;



public class TileEntityFabTable extends TileEntity implements IInventory, ISlotChanged
{
	private ItemStack[] inventory;
    public IInventory craftResult = new InventoryCraftResult();
	public ItemStack[] craftMatrixInventory;
    
    public TileEntityFabTable() {

        super();
        inventory = new ItemStack[32];
        craftMatrixInventory = new ItemStack[9]; //TODO: magic number
    }
	
	@Override
	public int getSizeInventory() {
		return inventory.length;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		
		return this.inventory[i];
	}
	
	@Override
	public void onSlotChange(Slot slot, int id, ItemStack itemStack) {
		System.out.println("Upgrade changed");
	}

    @Override
    public ItemStack decrStackSize(int slot, int amount) {

        ItemStack itemStack = getStackInSlot(slot);
        if (itemStack != null) {
            if (itemStack.stackSize <= amount) {
                setInventorySlotContents(slot, null);
            }
            else {
                itemStack = itemStack.splitStack(amount);
                if (itemStack.stackSize == 0) {
                    setInventorySlotContents(slot, null);
                }
            }
        }

        return itemStack;
    }


    @Override
    public ItemStack getStackInSlotOnClosing(int slot) {

        if (inventory[slot] != null) {
            ItemStack itemStack = inventory[slot];
            inventory[slot] = null;
            return itemStack;
        }
        else
            return null;
    }

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		inventory[i] = itemstack;
		
		if (itemstack != null && itemstack.stackSize > getInventoryStackLimit()) {
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
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		return entityplayer.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) <= 64;
	}

	@Override
	public void openChest() {}

	@Override
	public void closeChest() {}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return true;
	}
	
    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {

        super.readFromNBT(nbtTagCompound);

        // Read in the ItemStacks in the inventory from NBT
        NBTTagList tagList = nbtTagCompound.getTagList("Items");
        inventory = new ItemStack[this.getSizeInventory()];
        for (int i = 0; i < tagList.tagCount(); ++i) {
            NBTTagCompound tagCompound = (NBTTagCompound) tagList.tagAt(i);
            byte slot = tagCompound.getByte("Slot");
            if (slot >= 0 && slot < inventory.length) {
                inventory[slot] = ItemStack.loadItemStackFromNBT(tagCompound);
            }
        }
        
     // Read in the Crafting Matrix from NBT
        NBTTagList craftingTag = nbtTagCompound.getTagList("CraftingMatrix");
        craftMatrixInventory = new ItemStack[9]; //TODO: magic number
        for (int i = 0; i < craftingTag.tagCount(); ++i) {
            NBTTagCompound tagCompound = (NBTTagCompound) craftingTag.tagAt(i);
            byte slot = tagCompound.getByte("Slot");
            if (slot >= 0 && slot < craftMatrixInventory.length) {
                craftMatrixInventory[slot] = ItemStack.loadItemStackFromNBT(tagCompound);
            }
        }

        // Read craftingResult from NBT
        NBTTagCompound tagCraftResult = nbtTagCompound.getCompoundTag("CraftingResult");
        craftResult.setInventorySlotContents(0, ItemStack.loadItemStackFromNBT(tagCraftResult));
    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound) {

        super.writeToNBT(nbtTagCompound);

        // Write the ItemStacks in the inventory to NBT
        NBTTagList tagList = new NBTTagList();
        for (int currentIndex = 0; currentIndex < inventory.length; ++currentIndex) {
            if (inventory[currentIndex] != null) {
                NBTTagCompound tagCompound = new NBTTagCompound();
                tagCompound.setByte("Slot", (byte) currentIndex);
                inventory[currentIndex].writeToNBT(tagCompound);
                tagList.appendTag(tagCompound);
            }
        }
        nbtTagCompound.setTag("Items", tagList);
        
        // Write Crafting Matrix to NBT
        NBTTagList craftingTag = new NBTTagList();
        for (int currentIndex = 0; currentIndex < craftMatrixInventory.length; ++currentIndex) {
            if (craftMatrixInventory[currentIndex] != null) {
                NBTTagCompound tagCompound = new NBTTagCompound();
                tagCompound.setByte("Slot", (byte) currentIndex);
                craftMatrixInventory[currentIndex].writeToNBT(tagCompound);
                craftingTag.appendTag(tagCompound);
            }
        }
        nbtTagCompound.setTag("CraftingMatrix", craftingTag);
        
        // Write craftingResult to NBT
        if (craftResult.getStackInSlot(0) != null)
            nbtTagCompound.setTag("CraftingResult", craftResult.getStackInSlot(0).writeToNBT(new NBTTagCompound()));

    }
    
}

