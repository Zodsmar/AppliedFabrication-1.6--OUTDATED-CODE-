package afab.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.world.World;
import afab.tileentities.TileEntityFabTable;

public class ContainerFabTable extends Container{

	
	
	/** The crafting matrix inventory (3x3). */
	public InventoryCrafting craftMatrix = new InventoryCrafting(this, 3, 3);
	public IInventory craftResult = new InventoryCraftResult();
	private World worldObj;

	public TileEntityFabTable tileEntity;
	FabTabSlot FabSlot;
	@SuppressWarnings("unused")
	private int posX;
	@SuppressWarnings("unused")
	private int posY;
	@SuppressWarnings("unused")
	private int posZ;


	
	
	public ContainerFabTable(TileEntityFabTable tileFabTable, InventoryPlayer playerInv, World world, int x, int y, int z)
	{
	         this.worldObj = world;
	         this.posX = x;
	         this.posY = y;
	         this.posZ = z;
	         this.addSlotToContainer(new FabTabSlot(playerInv.player, this.craftMatrix, this.craftResult, 0, 143, 36));
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
	         
	         for(int i = 0; i < 2; i++)
	         {
	             for(int j = 0; j < 9; j++)
	            	 this.addSlotToContainer(new Slot(tileFabTable, j + i * 9, 8 + j * 18, 90 + i * 18));

	         }

	         
	         for(int i = 0; i < 3; i++)
	         {
	             for(int j = 0; j < 9; j++)
	            	 this.addSlotToContainer(new Slot(playerInv, j + i * 9 + 9, 8 + j * 18, 140 + i * 18));

	         }

	         for (row = 0; row < 9; ++row)
	         {
	                 this.addSlotToContainer(new Slot(playerInv, row, 8 + row * 18, 198));
	         }

	         this.onCraftMatrixChanged(this.craftMatrix);
	         
	         //addSlotToContainer(new Slot(par1InventoryPlayer, 36, 17, 36));


	}
	
	public void onCraftMatrixChanged(IInventory IInv)
	{	
	         this.craftResult.setInventorySlotContents(0, CraftingManager.getInstance().findMatchingRecipe(this.craftMatrix, this.worldObj));
	}
	


	public boolean canInteractWith(EntityPlayer par1EntityPlayer)
	{
	         return tileEntity.isUseableByPlayer(par1EntityPlayer);
	        		
	}

	

}
