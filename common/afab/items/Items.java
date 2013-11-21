package afab.items;



import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import afab.lib.IDs;
import afab.lib.Names;
import cpw.mods.fml.common.registry.LanguageRegistry;


public class Items{

	public static Item meta;
	public static Item hammer;
	public static Item ironHammer;
	public static Item diamondHammer;
	public static Item mysticalHammer;

	
	/*Register ID's*/
	public static void init() {

		meta = new MetaItems(IDs.metaItems_default);
		hammer = new Hammer(IDs.hammer_actual);
		ironHammer = new IronHammer(IDs.ironHammer_actual);
		diamondHammer = new DiamondHammer(IDs.diamondHammer_actual);
		mysticalHammer = new MysticalHammer(IDs.mysticalHammer_actual);

	}
	
	
	/*Register Names*/
	public static void addNames() {

		for(int i = 0; i < Names.metaItems_name.length; i++) {
			LanguageRegistry.addName(new ItemStack(meta, 1, i), Names.metaItems_name[i]);

			LanguageRegistry.addName(hammer, Names.hammer_name);
			LanguageRegistry.addName(ironHammer, Names.ironHammer_name);
			LanguageRegistry.addName(diamondHammer, Names.diamondHammer_name);
			LanguageRegistry.addName(mysticalHammer, Names.mysticalHammer_name);
		}
	}
}
