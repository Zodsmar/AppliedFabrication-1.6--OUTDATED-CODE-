package afab.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import afab.lib.ModInfo;
import afab.tileentities.TileEntityFabTable;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class FabTableGui extends GuiContainer{

	
	private static final ResourceLocation field_110422_t = new ResourceLocation(ModInfo.MODID.toLowerCase() + ":textures/gui/fabTableGui.png");

	public FabTableGui(InventoryPlayer par1InventoryPlayer, TileEntityFabTable tileFabTable, World par2World, int par3, int par4, int par5)
	{
	         super(new ContainerFabTable(tileFabTable, par1InventoryPlayer, par2World, par3, par4, par5));
	         xSize = 176;
	         ySize = 222;
	}

	/**
	         * Draw the foreground layer for the GuiContainer (everything in front of the items)
	         */
	protected void drawGuiContainerForegroundLayer(int par1, int par2)
	{
	         this.fontRenderer.drawString(StatCollector.translateToLocal("\u00a71Fabrication Table"), 48, 6, 4210752);
	         this.fontRenderer.drawString(StatCollector.translateToLocal("Inventory"), 8, this.ySize - 96 + 2, 4210752);
	}
	/**
	         * Draw the background layer for the GuiContainer (everything behind the items)
	         */
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
	{
	         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	         this.mc.func_110434_K().func_110577_a(field_110422_t);
	         int k = (this.width - this.xSize) / 2;
	         int l = (this.height - this.ySize) / 2;
	         this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
	}

}
