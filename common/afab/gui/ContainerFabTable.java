package afab.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.world.World;
import afab.lib.IDs;
import afab.tileentities.TileEntityFabTable;

public class ContainerFabTable extends Container{

	/** The crafting matrix inventory (3x3). */
	public InventoryCrafting craftMatrix = new InventoryCrafting(this, 3, 3);
	public IInventory craftResult = new InventoryCraftResult();
	private World worldObj;
	private int posX;
	private int posY;
	private int posZ;
	
	TileEntityFabTable tileFabTable;


	
	
	public ContainerFabTable(TileEntityFabTable tileFabTable, InventoryPlayer par1InventoryPlayer, World par2World, int par3, int par4, int par5)
	{
	         this.worldObj = par2World;
	         this.posX = par3;
	         this.posY = par4;
	         this.posZ = par5;
	         this.addSlotToContainer(new SlotCrafting(par1InventoryPlayer.player, this.craftMatrix, this.craftResult, 0, 143, 36));
	         int l;
	         int i1;
	         this.tileFabTable = tileFabTable;
	         

	         for (l = 0; l < 3; ++l)
	         {
	                 for (i1 = 0; i1 < 3; ++i1)
	                 {
	                         this.addSlotToContainer(new Slot(this.craftMatrix, i1 + l * 3, 48 + i1 * 18, 18 + l * 18));
	                 }
	         }
	         
	         for(int i = 0; i < 2; i++)
	         {
	             for(int j = 0; j < 9; j++)
	            	 this.addSlotToContainer(new Slot(tileFabTable, j + i * 9, 8 + j * 18, 90 + i * 18));

	         }

	         
	         for(int i = 0; i < 3; i++)
	         {
	             for(int j = 0; j < 9; j++)
	            	 this.addSlotToContainer(new Slot(par1InventoryPlayer, j + i * 9 + 9, 8 + j * 18, 140 + i * 18));

	         }

	         for (l = 0; l < 9; ++l)
	         {
	                 this.addSlotToContainer(new Slot(par1InventoryPlayer, l, 8 + l * 18, 198));
	         }

	         this.onCraftMatrixChanged(this.craftMatrix);
	         
	         //addSlotToContainer(new Slot(par1InventoryPlayer, 36, 17, 36));


	}

	/**
	         * Callback for when the crafting matrix is changed.
	         */
	public void onCraftMatrixChanged(IInventory par1IInventory)
	{
	         this.craftResult.setInventorySlotContents(0, CraftingManager.getInstance().findMatchingRecipe(this.craftMatrix, this.worldObj));
	}


	public boolean canInteractWith(EntityPlayer par1EntityPlayer)
	{
	         return this.worldObj.getBlockId(this.posX, this.posY, this.posZ) != IDs.fabTable_actual ? false : par1EntityPlayer.getDistanceSq((double)this.posX + 0.5D, (double)this.posY + 0.5D, (double)this.posZ + 0.5D) <= 64.0D;
	}

	/**
	         * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
	         */
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int numSlot)
    {
        ItemStack stack = null;
        Slot slot = (Slot)this.inventorySlots.get(numSlot);

        if (slot != null && slot.getHasStack())
        {
            ItemStack stack2 = slot.getStack();
            stack = stack2.copy();
            
            if (numSlot == 0)
            {
                if (!this.mergeItemStack(stack2, 10, 55, true))
                {
                    return null;
                }
                
            }
            //Merge crafting matrix item with supply matrix inventory
            else if(numSlot > 0 && numSlot <= 9)
            {
            	if(!this.mergeItemStack(stack2, 10, 28, false))
            	{
            		if(!this.mergeItemStack(stack2, 28, 64, false))
            		{
                		return null;
            		}
            	}
            }
            //Merge Supply matrix item with player inventory
            else if (numSlot >= 10 && numSlot <= 27)
            {
                if (!this.mergeItemStack(stack2, 28, 64, false))
                {
                    return null;
                }
            }
            //Merge player inventory item with supply matrix
            else if (numSlot >= 28 && numSlot < 64)
            {
                if (!this.mergeItemStack(stack2, 10, 28, false))
                {
                    return null;
                }
            }

            if (stack2.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (stack2.stackSize == stack.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(player, stack2);
        }

        return stack;
    }

	

}
