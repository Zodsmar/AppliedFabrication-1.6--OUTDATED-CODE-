package afab.crafting;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.oredict.OreDictionary;
import afab.items.Items;


public class Recipes {

	
	public static void init() {

		//Recipes
		CraftingManager.getInstance().addRecipe(new ItemStack(Items.meta, 1, 0),
				new Object[] {
				"000",
				"000",
				" 0 ",
				Character.valueOf('0'), new ItemStack(Block.cobblestone)});
		
		CraftingManager.getInstance().addRecipe(new ItemStack(Items.meta, 1, 1),
				new Object[] {
				" 1 ",
				" 1 ",
				" 0 ",
				Character.valueOf('1'), new ItemStack(Item.stick),
				Character.valueOf('0'), new ItemStack(Block.wood, 1, OreDictionary.WILDCARD_VALUE)});
		
		CraftingManager.getInstance().addRecipe(new ItemStack(Items.hammer),
				new Object[] {
				"   ",
				" 0 ",
				" 1 ",
				Character.valueOf('0'), new ItemStack(Items.meta, 1, 0),
				Character.valueOf('1'), new ItemStack(Items.meta, 1, 1)});
		
		CraftingManager.getInstance().addRecipe(new ItemStack(Block.cobblestoneMossy),
				new Object[] {
				"000",
				"010",
				"000",
				Character.valueOf('0'), new ItemStack(Block.vine),
				Character.valueOf('1'), new ItemStack(Block.cobblestone)});
		
		CraftingManager.getInstance().addRecipe(new ItemStack(Block.stoneBrick, 1, 1),
				new Object[] {
				"000",
				"010",
				"000",
				Character.valueOf('0'), new ItemStack(Block.vine),
				Character.valueOf('1'), new ItemStack(Block.stoneBrick)});
		
		CraftingManager.getInstance().addRecipe(new ItemStack(Block.stoneBrick, 8, 2),
				new Object[] {
				"000",
				"010",
				"000",
				Character.valueOf('0'), new ItemStack(Block.stoneBrick),
				Character.valueOf('1'), new ItemStack(Block.tnt)});
		
		CraftingManager.getInstance().addRecipe(new ItemStack(Item.helmetChain),
				new Object[] {
				"000",
				"0 0",
				"   ",
				Character.valueOf('0'), new ItemStack(Items.meta, 1, 4)});
		
		CraftingManager.getInstance().addRecipe(new ItemStack(Item.plateChain),
				new Object[] {
				"0 0",
				"000",
				"000",
				Character.valueOf('0'), new ItemStack(Items.meta, 1, 4)});
		
		CraftingManager.getInstance().addRecipe(new ItemStack(Item.legsChain),
				new Object[] {
				"000",
				"0 0",
				"0 0",
				Character.valueOf('0'), new ItemStack(Items.meta, 1, 4)});
		
		CraftingManager.getInstance().addRecipe(new ItemStack(Item.bootsChain),
				new Object[] {
				"   ",
				"0 0",
				"0 0",
				Character.valueOf('0'), new ItemStack(Items.meta, 1, 4)});
		
		CraftingManager.getInstance().addRecipe(new ItemStack(Block.mycelium, 1),
				new Object[] {
				"213",
				"203",
				"213",
				Character.valueOf('0'), new ItemStack(Block.grass),
				Character.valueOf('1'), new ItemStack(Item.dyePowder, 1, 15),
				Character.valueOf('2'), new ItemStack(Block.mushroomBrown),
				Character.valueOf('3'), new ItemStack(Block.mushroomRed)});
		
		CraftingManager.getInstance().addRecipe(new ItemStack(Item.saddle, 1),
				new Object[] {
				" 0 ",
				"020",
				"212",
				Character.valueOf('0'), new ItemStack(Item.leather),
				Character.valueOf('1'), new ItemStack(Item.silk),
				Character.valueOf('2'), new ItemStack(Item.ingotIron)});
		
		CraftingManager.getInstance().addRecipe(new ItemStack(Item.field_111213_cg, 1),
				new Object[] {
				"010",
				"020",
				"323",
				Character.valueOf('0'), new ItemStack(Item.diamond),
				Character.valueOf('1'), new ItemStack(Item.saddle),
				Character.valueOf('2'), new ItemStack(Items.meta, 1, 4),
				Character.valueOf('3'), new ItemStack(Item.ingotIron)});
		
		CraftingManager.getInstance().addRecipe(new ItemStack(Item.field_111216_cf, 1),
				new Object[] {
				"010",
				"020",
				"323",
				Character.valueOf('0'), new ItemStack(Item.ingotGold),
				Character.valueOf('1'), new ItemStack(Item.saddle),
				Character.valueOf('2'), new ItemStack(Items.meta, 1, 4),
				Character.valueOf('3'), new ItemStack(Item.ingotIron)});
		
		CraftingManager.getInstance().addRecipe(new ItemStack(Item.field_111215_ce, 1),
				new Object[] {
				"010",
				"020",
				"323",
				Character.valueOf('0'), new ItemStack(Item.ingotIron),
				Character.valueOf('1'), new ItemStack(Item.saddle),
				Character.valueOf('2'), new ItemStack(Items.meta, 1, 4),
				Character.valueOf('3'), new ItemStack(Item.ingotIron)});
		
		//Shapeless Recipes
		CraftingManager.getInstance().addShapelessRecipe(new ItemStack(Block.stoneBrick, 1),
				new Object[] {new ItemStack(Items.hammer, 1, Short.MAX_VALUE), 
			new ItemStack(Block.cobblestone)});
		
		CraftingManager.getInstance().addShapelessRecipe(new ItemStack(Block.stoneBrick, 1),
				new Object[] {new ItemStack(Items.mysticalHammer, 1, Short.MAX_VALUE), 
			new ItemStack(Block.cobblestone)});
		
		CraftingManager.getInstance().addShapelessRecipe(new ItemStack(Items.mysticalHammer),
				new Object[] {new ItemStack(Items.hammer, 1, Short.MAX_VALUE), 
			new ItemStack(Items.meta, 1, 2), 
			new ItemStack(Items.meta, 1, 3)});
		
		CraftingManager.getInstance().addShapelessRecipe(new ItemStack(Items.meta, 1, 2),
				new Object[] {new ItemStack(Items.hammer, 1, Short.MAX_VALUE), 
			new ItemStack(Block.blockLapis), 
			new ItemStack(Items.meta, 1, 1)});
		
		CraftingManager.getInstance().addShapelessRecipe(new ItemStack(Items.meta, 1, 3),
				new Object[] {new ItemStack(Items.hammer, 1, Short.MAX_VALUE), new ItemStack(Item.ingotGold),
			new ItemStack(Item.ingotGold), 
			new ItemStack(Item.ingotIron), 
			new ItemStack(Item.netherStar), 
			new ItemStack(Items.meta, 1, 0)});
		
		CraftingManager.getInstance().addShapelessRecipe(new ItemStack(Items.mysticalHammer),
				new Object[] {new ItemStack(Items.mysticalHammer, 1, Short.MAX_VALUE), 
			new ItemStack(Items.meta, 1, 2), 
			new ItemStack(Items.meta, 1, 3)});
		
		CraftingManager.getInstance().addShapelessRecipe(new ItemStack(Items.meta, 1, 2),
				new Object[] {new ItemStack(Items.mysticalHammer, 1, Short.MAX_VALUE), 
			new ItemStack(Block.blockLapis), 
			new ItemStack(Items.meta, 1, 1)});
		
		CraftingManager.getInstance().addShapelessRecipe(new ItemStack(Items.meta, 1, 3),
				new Object[] {new ItemStack(Items.mysticalHammer, 1, Short.MAX_VALUE), new ItemStack(Item.ingotGold),
			new ItemStack(Item.ingotGold), 
			new ItemStack(Item.ingotIron), 
			new ItemStack(Item.netherStar), 
			new ItemStack(Items.meta, 1, 0)});
		
		CraftingManager.getInstance().addShapelessRecipe(new ItemStack(Block.stoneBrick, 1, 3),
				new Object[] {new ItemStack(Items.hammer, 1, Short.MAX_VALUE), 
			new ItemStack(Block.stoneBrick, 1, 0)});
		
		CraftingManager.getInstance().addShapelessRecipe(new ItemStack(Block.stoneBrick, 1, 0),
				new Object[] {new ItemStack(Items.hammer, 1, Short.MAX_VALUE), 
			new ItemStack(Block.stoneBrick, 1, 3)});
		
		CraftingManager.getInstance().addShapelessRecipe(new ItemStack(Block.stoneBrick, 1, 3),
				new Object[] {new ItemStack(Items.mysticalHammer, 1, Short.MAX_VALUE), 
			new ItemStack(Block.stoneBrick, 1, 0)});
		
		CraftingManager.getInstance().addShapelessRecipe(new ItemStack(Block.stoneBrick, 1, 0),
				new Object[] {new ItemStack(Items.mysticalHammer, 1, Short.MAX_VALUE), 
			new ItemStack(Block.stoneBrick, 1, 3)});
		
		CraftingManager.getInstance().addShapelessRecipe(new ItemStack(Block.gravel, 1),
				new Object[] {new ItemStack(Items.hammer, 1, Short.MAX_VALUE), 
			new ItemStack(Block.dirt)});
		
		CraftingManager.getInstance().addShapelessRecipe(new ItemStack(Block.gravel, 1),
				new Object[] {new ItemStack(Items.mysticalHammer, 1, Short.MAX_VALUE), 
			new ItemStack(Block.dirt)});
		
		CraftingManager.getInstance().addShapelessRecipe(new ItemStack(Block.dirt, 1),
				new Object[] {new ItemStack(Items.hammer, 1, Short.MAX_VALUE), 
			new ItemStack(Block.gravel)});
		
		CraftingManager.getInstance().addShapelessRecipe(new ItemStack(Block.dirt, 1),
				new Object[] {new ItemStack(Items.mysticalHammer, 1, Short.MAX_VALUE), 
			new ItemStack(Block.gravel)});
		
		CraftingManager.getInstance().addShapelessRecipe(new ItemStack(Block.grass, 1),
				new Object[] {new ItemStack(Item.dyePowder, 1, 15), 
			new ItemStack(Block.dirt)});
		
		CraftingManager.getInstance().addShapelessRecipe(new ItemStack(Items.meta, 8, 4),
				new Object[] {new ItemStack(Items.hammer, 1, Short.MAX_VALUE), 
			new ItemStack(Item.ingotIron)});
		
		CraftingManager.getInstance().addShapelessRecipe(new ItemStack(Items.meta, 8, 4),
				new Object[] {new ItemStack(Items.mysticalHammer, 1, Short.MAX_VALUE), 
			new ItemStack(Item.ingotIron)});
		
		CraftingManager.getInstance().addShapelessRecipe(new ItemStack(Item.leather),
				new Object[] {new ItemStack(Items.hammer, 1, Short.MAX_VALUE), 
			new ItemStack(Item.rottenFlesh)});
		
		CraftingManager.getInstance().addShapelessRecipe(new ItemStack(Item.leather),
				new Object[] {new ItemStack(Items.mysticalHammer, 1, Short.MAX_VALUE), 
			new ItemStack(Item.rottenFlesh)});
		
	}
}
