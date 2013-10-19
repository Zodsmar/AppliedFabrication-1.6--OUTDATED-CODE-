package afab.config;

import java.io.File;

import net.minecraftforge.common.Configuration;
import afab.lib.IDs;
import afab.lib.Names;

public class ConfigHandler {

	public static void init(File configFile) {
		Configuration config = new Configuration(configFile);

		config.load();
		
		IDs.hammer_actual = config.getItem(Names.hammer_name, IDs.hammer_default).getInt() - 257;
		IDs.ironHammer_actual = config.getItem(Names.ironHammer_name, IDs.ironHammer_default).getInt() - 256;
		IDs.diamondHammer_actual = config.getItem(Names.diamondHammer_name, IDs.diamondHammer_default).getInt() - 256;
		IDs.metaItems_actual = config.get("Components", "ComponentsID", 4000).getInt() - 256;
		IDs.mysticalHammer_actual = config.getItem(Names.mysticalHammer_name, IDs.mysticalHammer_default).getInt() - 256;
		IDs.fabTable_actual = config.getBlock(Names.fabTable_name, IDs.fabTable_default).getInt();
 
		config.save();
		}

}
