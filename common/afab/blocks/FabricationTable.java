package afab.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import afab.AppliedFabrication;
import afab.gui.GuiIDs;
import afab.lib.ModInfo;
import afab.lib.Names;
import afab.tileentities.TileEntityFabTable;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class FabricationTable extends BlockContainer{

	public FabricationTable(int id) {
		super(id, Material.wood);
		this.setCreativeTab(AppliedFabrication.AFTab);
		this.setHardness(2F);
		this.setStepSound(soundWoodFootstep);
		this.setUnlocalizedName(Names.fabTable_unlocalizedname);
	}
	@SideOnly(Side.CLIENT)
	private Icon tableIconTop;
	@SideOnly(Side.CLIENT)
	private Icon tableIconFront;
	@SideOnly(Side.CLIENT)
	private Icon tableIconSide;
    private Random rand = new Random();
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{
	this.tableIconSide = iconRegister.registerIcon(ModInfo.MODID.toLowerCase() + ":table_side");
	this.tableIconTop = iconRegister.registerIcon(ModInfo.MODID.toLowerCase() + ":table_top");
	this.tableIconFront = iconRegister.registerIcon(ModInfo.MODID.toLowerCase() + ":table_front");
	}
	
	@Override
	public Icon getIcon(int side, int meta) {
	if(side == 0) {	
	return Block.planks.getBlockTextureFromSide(side);
	} else if(side == 1) {
	return tableIconTop;
	} else if(side == 5 || side == 3){
	return tableIconFront;
	} else{
		return tableIconSide;
	}
	}
	
	  @Override
	    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {

	        if (player.isSneaking())
	            return false;
	        else {
	            if (!world.isRemote) {
	                TileEntityFabTable tileFabTable = (TileEntityFabTable) world.getBlockTileEntity(x, y, z);

	                if (tileFabTable != null) {
	                    player.openGui(AppliedFabrication.instance, GuiIDs.FABTABGui, world, x, y, z);
	                }
	            }

	            return true;
	        }
	    }
	
    @Override
    public void breakBlock(World world, int x, int y, int z, int id, int meta) {

        dropInventory(world, x, y, z);
        super.breakBlock(world, x, y, z, id, meta);
    }

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityFabTable();
	}

    private void dropInventory(World world, int x, int y, int z) {

        TileEntity tileEntity = world.getBlockTileEntity(x, y, z);

        if (!(tileEntity instanceof IInventory))
            return;

        IInventory inventory = (IInventory) tileEntity;

        for (int i = 0; i < inventory.getSizeInventory(); i++) {

            ItemStack itemStack = inventory.getStackInSlot(i);

            if (itemStack != null && itemStack.stackSize > 0) {
                float dX = rand.nextFloat() * 0.8F + 0.1F;
                float dY = rand.nextFloat() * 0.8F + 0.1F;
                float dZ = rand.nextFloat() * 0.8F + 0.1F;

                EntityItem entityItem = new EntityItem(world, x + dX, y + dY, z + dZ, new ItemStack(itemStack.itemID, itemStack.stackSize, itemStack.getItemDamage()));

                if (itemStack.hasTagCompound()) {
                    entityItem.getEntityItem().setTagCompound((NBTTagCompound) itemStack.getTagCompound().copy());
                }

                float factor = 0.05F;
                entityItem.motionX = rand.nextGaussian() * factor;
                entityItem.motionY = rand.nextGaussian() * factor + 0.2F;
                entityItem.motionZ = rand.nextGaussian() * factor;
                world.spawnEntityInWorld(entityItem);
                itemStack.stackSize = 0;
            }
        }
    }
	

}
