package afab;


import java.util.logging.Level;

import net.minecraft.creativetab.CreativeTabs;
import afab.blocks.Blocks;
import afab.config.ConfigHandler;
import afab.core.proxies.CommonProxy;
import afab.crafting.Recipes;
import afab.gui.GuiHandler;
import afab.items.Items;
import afab.lib.AFComponentsTab;
import afab.lib.AFTab;
import afab.lib.LogHelper;
import afab.lib.ModInfo;
import afab.network.PacketHandler;
import afab.tileentities.TileEntityFabTable;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;


@Mod( modid = ModInfo.MODID, name = ModInfo.MODNAME, version = ModInfo.VERSION, dependencies = ModInfo.DEPENDENCIES)
@NetworkMod (channels = {ModInfo.CHANNEL}, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)

public class AppliedFabrication {

	@Instance(ModInfo.MODID)
	public static AppliedFabrication instance;
	
	@SidedProxy(clientSide = ModInfo.CLIENT_PROXY, serverSide = ModInfo.SERVER_PROXY)
	public static CommonProxy proxy;
	
	public static CreativeTabs AFTab = new AFTab(CreativeTabs.getNextID(), ModInfo.MODNAME);
	public static CreativeTabs AFComponents = new AFComponentsTab(CreativeTabs.getNextID(), "AFComponents");
	private static GuiHandler guiHandler = new GuiHandler();
	
	@EventHandler
	public static void preInit( FMLPreInitializationEvent event ) {
		LogHelper.init();
		ConfigHandler.init(event.getSuggestedConfigurationFile());
		
		proxy.initRenderers();
		proxy.initSounds();
		//AppliedFabrication.RemoveRecipe(new ItemStack(Block.stoneBrick));
	}

	@EventHandler
	public static void init( FMLInitializationEvent event ) {
		LanguageRegistry.instance().addStringLocalization("itemGroup." + ModInfo.MODNAME, "en_US", ModInfo.MODNAME);
		LanguageRegistry.instance().addStringLocalization("itemGroup." + "AFComponents", "en_US", "AFComponents");
		
		LogHelper.log(Level.INFO, "Preparing blocks");
		Blocks.init();
		Blocks.addNames();
		LogHelper.log(Level.INFO, "Blocks loaded");
		
		LogHelper.log(Level.INFO, "Preparing items");
		Items.init();
		Items.addNames();
		LogHelper.log(Level.INFO, "Items loaded");


		LogHelper.log(Level.INFO, "Preparing recipes");
		Recipes.init();
		LogHelper.log(Level.INFO, "Recipes loaded");

		NetworkRegistry.instance().registerGuiHandler(ModInfo.MODNAME, guiHandler);
		GameRegistry.registerTileEntity(TileEntityFabTable.class, "Fabrication Table");

	}

	@EventHandler
	public static void postInit( FMLPostInitializationEvent event ) {
		
	}
	/**
	private static void RemoveRecipe(ItemStack resultItem) {
		ItemStack recipeResult = null;
		ArrayList<?> recipes = (ArrayList<?>) CraftingManager.getInstance()
		.getRecipeList();
		for (int scan = 0; scan < recipes.size(); scan++) {
		IRecipe tmpRecipe = (IRecipe) recipes.get(scan);
		recipeResult = tmpRecipe.getRecipeOutput();
		if (recipeResult != null) {
		if (recipeResult.itemID == resultItem.itemID
		&& recipeResult.getItemDamage() == resultItem
		.getItemDamage()) {
		System.out.println("Removed Recipe: " + recipes.get(scan)
		+ " -> " + recipeResult);
		recipes.remove(scan);
		scan--;
		}
		}
		}
		}
		**/
}
