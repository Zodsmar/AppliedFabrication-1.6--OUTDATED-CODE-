package afab.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.world.World;
import afab.interfaces.ISlotChanged;
import afab.tileentities.TileEntityFabTable;

@SuppressWarnings("unused")
public class ContainerFabTable extends Container implements ISlotChanged {
	private World worldObj;
	public TileEntityFabTable tileEntity;
	
	FabTabSlot FabSlot;
	private int posX;
	private int posY;
	private int posZ;

    /** The crafting matrix inventory (3x3). */          //container, width, length
    public InventoryCrafting craftMatrix = new InventoryCrafting(this, 3, 3);
    private FabTabSlot fabTabSlot;
	
	public ContainerFabTable(TileEntityFabTable tileFabTable, InventoryPlayer playerInv, World world, int x, int y, int z)
	{
	         worldObj = world;
	         posX = x;
	         posY = y;
	         posZ = z;
	         fabTabSlot = new FabTabSlot(playerInv.player, this.craftMatrix, tileFabTable.craftResult, 0, 143, 36);
	         addSlotToContainer(fabTabSlot);
	         int row;
	         int col;
	         tileEntity = tileFabTable;
	         
	         updateCraftingMatrix();
	         

	         for (row = 0; row < 3; ++row)
	         {
	                 for (col = 0; col < 3; ++col)
	                 {
	                         this.addSlotToContainer(new Slot(this.craftMatrix, col + row * 3, 48 + col * 18, 18 + row * 18));
	                 }
	         }
	         
	         for(int row1 = 0; row1 < 2; row1++)		
	         {
	             for(int col1 = 0; col1 < 9; col1++)
	            	 this.addSlotToContainer(new Slot(tileFabTable, col1 + row1 * 9, 8 + col1 * 18, 90 + row1 * 18));

	         }
	         
	         this.addSlotToContainer(new SlotStartsWith(tileFabTable, "fabUpgrade", 28, 16, 10).setSlotChange(tileFabTable));
	         this.addSlotToContainer(new SlotStartsWith(tileFabTable, "fabUpgrade", 29, 16, 36).setSlotChange(tileFabTable));
	         this.addSlotToContainer(new SlotStartsWith(tileFabTable, "fabUpgrade", 30, 16, 62).setSlotChange(tileFabTable));
	         
	         this.addSlotToContainer(new SlotStartsWith(tileFabTable, "fabPlan", 31, 143, 10).setSlotChange(this));

	         
	         for(int row2 = 0; row2 < 3; row2++)
	         {
	             for(int col2 = 0; col2 < 9; col2++)
	            	 this.addSlotToContainer(new Slot(playerInv, col2 + row2 * 9 + 9, 8 + col2 * 18, 140 + row2 * 18));
	         }

	         for (row = 0; row < 9; ++row)
	         {
	                 this.addSlotToContainer(new Slot(playerInv, row, 8 + row * 18, 198));
	         }
	         
	         this.onCraftMatrixChanged(this.craftMatrix);
	         
	         //addSlotToContainer(new Slot(par1InventoryPlayer, 36, 17, 36));


	}
	

    private void updateCraftingMatrix() {
        for (int i = 0; i < craftMatrix.getSizeInventory(); i++) {
            craftMatrix.setInventorySlotContents(i, tileEntity.craftMatrixInventory[i]);
        }
    }
	

    @Override
	public void onContainerClosed(EntityPlayer par1EntityPlayer)
	{
	         super.onContainerClosed(par1EntityPlayer);
	         saveCraftingMatrix();
	}
	
	private void saveCraftingMatrix() {
	    for (int i = 0; i < craftMatrix.getSizeInventory(); i++) {
	        tileEntity.craftMatrixInventory[i] = craftMatrix.getStackInSlot(i);
        }
    }


    @Override
	public void onCraftMatrixChanged(IInventory IInv)
	{	
	    tileEntity.craftResult.setInventorySlotContents(0, CraftingManager.getInstance().findMatchingRecipe(this.craftMatrix, this.worldObj));
	}
	


	@Override
	public boolean canInteractWith(EntityPlayer entityPlayer)	
	{
	         return tileEntity.isUseableByPlayer(entityPlayer);
	        		
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int par2)
	{
		System.out.println(par2);
		
		ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(par2);
        
        if (slot != null && slot.getHasStack())
        {
        	ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if(par2 == 0) {
                if (!this.mergeItemStack(itemstack1, 32, 67, false))
                {
                    
                    if (itemstack1.stackSize == 0)
                    {
                        slot.putStack((ItemStack)null);
                    }
                    else
                    {
                        slot.onSlotChanged();
                    }
                    
                    return null;
                }else{
                	slot.putStack((ItemStack)null);
                }
                
                fabTabSlot.onPickupFromSlot(entityPlayer, itemstack);
            	this.onCraftMatrixChanged(this.craftMatrix);
            	
            	return itemstack;
            }else if(par2 >= 32 && par2 <= 67) {
            	if (itemstack1.getUnlocalizedName().startsWith("fabUpgrade")) {
            		return null;
            	}
            	else if (!this.mergeItemStack(itemstack1, 10, 27, false))
                {
            		if (itemstack1.stackSize == 0)
                    {
                        slot.putStack((ItemStack)null);
                    }
                    else
                    {
                        slot.onSlotChanged();
                    }
            		
                    return null;
                }
            }else if(par2 >= 10 && par2 <= 27 || par2 <= 9 || par2 >= 28 && par2 <= 31) {
            	if (!this.mergeItemStack(itemstack1, 32, 67, false))
                {
                    if (itemstack1.stackSize == 0)
                    {
                        slot.putStack((ItemStack)null);
                    }
                    else
                    {
                        slot.onSlotChanged();
                    }
                    
                    return null;
                }
            }
        }

        return itemstack;
	}


	@Override
	public void onSlotChange(Slot slot, int id, ItemStack par1ItemStack,
			ItemStack par2ItemStack) {
		// TODO Plans
	}
}
