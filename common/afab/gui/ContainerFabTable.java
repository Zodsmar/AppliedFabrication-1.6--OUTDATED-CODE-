package afab.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.world.World;
import afab.tileentities.TileEntityFabTable;

@SuppressWarnings("unused")
public class ContainerFabTable extends Container{

	
	
	/** The crafting matrix inventory (3x3). */
	public InventoryCrafting craftMatrix = new InventoryCrafting(this, 3, 3);
	public IInventory craftResult = new InventoryCraftResult();
	private World worldObj;
	
	public TileEntityFabTable tileEntity;
	FabTabSlot FabSlot;
	private int posX;
	private int posY;
	private int posZ;


	
	
	public ContainerFabTable(TileEntityFabTable tileFabTable, InventoryPlayer playerInv, World world, int x, int y, int z)
	{
	         worldObj = world;
	         posX = x;
	         posY = y;
	         posZ = z;
	         addSlotToContainer(new FabTabSlot(playerInv.player, this.craftMatrix, this.craftResult, 0, 143, 36));
	         int row;
	         int col;
	         tileEntity = tileFabTable;
	         

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
	
	public void onContainerClosed(EntityPlayer par1EntityPlayer)
	{
	         super.onContainerClosed(par1EntityPlayer);
	        // TileEntity.SaveContainer(this);
	}
	
	public void onCraftMatrixChanged(IInventory IInv)
	{	
	         this.craftResult.setInventorySlotContents(0, CraftingManager.getInstance().findMatchingRecipe(this.craftMatrix, this.worldObj));
	}
	


	public boolean canInteractWith(EntityPlayer entityPlayer)	
	{
	         return tileEntity.isUseableByPlayer(entityPlayer);
	        		
	}

	

}
