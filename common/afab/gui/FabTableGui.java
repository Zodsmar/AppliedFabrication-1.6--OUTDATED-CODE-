package afab.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import afab.lib.ModInfo;
import afab.tileentities.TileEntityFabTable;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class FabTableGui extends GuiContainer{

	
	private static final ResourceLocation field_110422_t = new ResourceLocation(ModInfo.MODID.toLowerCase() + ":textures/gui/fabTableGui.png");

	public FabTableGui(InventoryPlayer playerInv, TileEntityFabTable tileFabTable, World world, int x, int y, int z)
	{
	         super(new ContainerFabTable(tileFabTable, playerInv, world, x, y, z));
	         xSize = 176;
	         ySize = 222;
	}

	/**
	         * Draw the foreground layer for the GuiContainer (everything in front of the items)
	         */
	protected void drawGuiContainerForegroundLayer(int x, int z)	
	{
	         this.fontRenderer.drawString(StatCollector.translateToLocal("\u00a71Fabrication Table"), 48, 6, 4210752);
	         this.fontRenderer.drawString(StatCollector.translateToLocal("Inventory"), 8, this.ySize - 96 + 2, 4210752);
	}
	/**
	         * Draw the background layer for the GuiContainer (everything behind the items)
	         */
	protected void drawGuiContainerBackgroundLayer(float f, int x, int y)
	{
	         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	         this.mc.getTextureManager().bindTexture(field_110422_t);
	         int k = (this.width - this.xSize) / 2;
	         int l = (this.height - this.ySize) / 2;
	         this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
	}
	
	 @Override
	    public void onGuiClosed() {
	        super.onGuiClosed();
	    }

}
