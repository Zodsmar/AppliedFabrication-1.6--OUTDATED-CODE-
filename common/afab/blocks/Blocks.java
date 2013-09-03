package afab.blocks;

import net.minecraft.block.Block;
import afab.lib.IDs;
import afab.lib.Names;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;


public class Blocks{
	
	public static Block fabTable;
	
	public static void init() {
	
		fabTable = new FabricationTable(IDs.fabTable_actual);
		GameRegistry.registerBlock(fabTable, Names.fabTable_name);
		}

		public static void addNames() {
			
			LanguageRegistry.addName(fabTable, Names.fabTable_name);
		}
}
