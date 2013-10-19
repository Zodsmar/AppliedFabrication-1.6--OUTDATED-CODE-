package afab.crafting;

import java.util.HashMap;
import java.util.Map.Entry;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.OreDictionary;
import afab.blocks.Blocks;
import afab.items.Items;


public class Recipes {
	public static HashMap<HammerRecipe, ItemStack> transformBlocks = new HashMap<HammerRecipe, ItemStack>(); 
	
	public static void init() {

		//Crafting Recipes
		CraftingManager.getInstance().addRecipe(new ItemStack(Items.meta, 1, 0),
				new Object[] {
				"000",
				"000",
				" 0 ",
				Character.valueOf('0'), new ItemStack(Block.cobblestone)});
		
		CraftingManager.getInstance().addRecipe(new ItemStack(Items.meta, 1, 10),
				new Object[] {
				"000",
				"000",
				" 0 ",
				Character.valueOf('0'), new ItemStack(Item.ingotIron)});
		
		CraftingManager.getInstance().addRecipe(new ItemStack(Items.meta, 1, 11),
				new Object[] {
				"000",
				"000",
				" 0 ",
				Character.valueOf('0'), new ItemStack(Item.diamond)});
		
		CraftingManager.getInstance().addRecipe(new ItemStack(Items.meta, 1, 1),
				new Object[] {
				" 1 ",
				" 1 ",
				" 0 ",
				Character.valueOf('1'), new ItemStack(Item.stick),
				Character.valueOf('0'), new ItemStack(Block.wood, 1, OreDictionary.WILDCARD_VALUE)});
		
		
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
		
		CraftingManager.getInstance().addRecipe(new ItemStack(Item.horseArmorDiamond, 1),
				new Object[] {
				"010",
				"020",
				"323",
				Character.valueOf('0'), new ItemStack(Item.diamond),
				Character.valueOf('1'), new ItemStack(Item.saddle),
				Character.valueOf('2'), new ItemStack(Items.meta, 1, 4),
				Character.valueOf('3'), new ItemStack(Item.ingotIron)});
		
		CraftingManager.getInstance().addRecipe(new ItemStack(Item.horseArmorGold, 1),
				new Object[] {
				"010",
				"020",
				"323",
				Character.valueOf('0'), new ItemStack(Item.ingotGold),
				Character.valueOf('1'), new ItemStack(Item.saddle),
				Character.valueOf('2'), new ItemStack(Items.meta, 1, 4),
				Character.valueOf('3'), new ItemStack(Item.ingotIron)});
		
		CraftingManager.getInstance().addRecipe(new ItemStack(Item.horseArmorIron, 1),
				new Object[] {
				"010",
				"020",
				"323",
				Character.valueOf('0'), new ItemStack(Item.ingotIron),
				Character.valueOf('1'), new ItemStack(Item.saddle),
				Character.valueOf('2'), new ItemStack(Items.meta, 1, 4),
				Character.valueOf('3'), new ItemStack(Item.ingotIron)});
		
		CraftingManager.getInstance().addRecipe(new ItemStack(Block.web),
				new Object[] {
				"000",
				"010",
				"000",
				Character.valueOf('0'), new ItemStack(Item.silk),
				Character.valueOf('1'), new ItemStack(Item.slimeBall)});
		
		CraftingManager.getInstance().addRecipe(new ItemStack(Item.slimeBall),
				new Object[] {
				"213",
				"203",
				"213",
				Character.valueOf('0'), new ItemStack(Item.bucketWater),
				Character.valueOf('1'), new ItemStack(Block.dirt),
				Character.valueOf('2'), new ItemStack(Block.sapling, 1, OreDictionary.WILDCARD_VALUE),
				Character.valueOf('3'), new ItemStack(Item.seeds)});
		
		CraftingManager.getInstance().addRecipe(new ItemStack(Block.endPortalFrame, 12),
				new Object[] {
				"010",
				"242",
				"353",
				Character.valueOf('0'), new ItemStack(Block.obsidian),
				Character.valueOf('1'), new ItemStack(Item.eyeOfEnder),
				Character.valueOf('2'), new ItemStack(Block.whiteStone),
				Character.valueOf('3'), new ItemStack(Item.netherStar),
				Character.valueOf('4'), new ItemStack(Block.dragonEgg),
				Character.valueOf('5'), new ItemStack(Items.mysticalHammer, 1, Short.MAX_VALUE)});
		
		CraftingManager.getInstance().addRecipe(new ItemStack(Block.dragonEgg),
				new Object[] {
				"010",
				"323",
				"010",
				Character.valueOf('0'), new ItemStack(Block.obsidian),
				Character.valueOf('2'), new ItemStack(Block.blockDiamond),
				Character.valueOf('3'), new ItemStack(Block.whiteStone)});
		
		CraftingManager.getInstance().addRecipe(new ItemStack(Blocks.fabTable, 1),
				new Object[] {
				"242",
				"131",
				"050",
				Character.valueOf('0'), new ItemStack(Block.cobblestone),
				Character.valueOf('1'), new ItemStack(Block.wood, 1, OreDictionary.WILDCARD_VALUE),
				Character.valueOf('2'), new ItemStack(Block.planks, 1, OreDictionary.WILDCARD_VALUE),
				Character.valueOf('3'), new ItemStack(Block.chest),
				Character.valueOf('4'), new ItemStack(Block.workbench),
				Character.valueOf('5'), new ItemStack(Items.hammer, 1, Short.MAX_VALUE)});
		
		CraftingManager.getInstance().addRecipe(new ItemStack(Blocks.fabTable, 1),
				new Object[] {
				"242",
				"131",
				"050",
				Character.valueOf('0'), new ItemStack(Block.cobblestone),
				Character.valueOf('1'), new ItemStack(Block.wood, 1, OreDictionary.WILDCARD_VALUE),
				Character.valueOf('2'), new ItemStack(Block.planks, 1, OreDictionary.WILDCARD_VALUE),
				Character.valueOf('3'), new ItemStack(Block.chest),
				Character.valueOf('4'), new ItemStack(Block.workbench),
				Character.valueOf('5'), new ItemStack(Items.mysticalHammer, 1, Short.MAX_VALUE)});
		
		CraftingManager.getInstance().addRecipe(new ItemStack(Item.feather, 1),
				new Object[] {
				"000",
				"010",
				"020",
				Character.valueOf('0'), new ItemStack(Item.silk),
				Character.valueOf('1'), new ItemStack(Block.cloth, 1, OreDictionary.WILDCARD_VALUE),
				Character.valueOf('2'), new ItemStack(Item.stick)});
		
		//Shapeless Recipes
		
		CraftingManager.getInstance().addShapelessRecipe(new ItemStack(Item.arrow, 8),
				new Object[] {new ItemStack(Items.hammer, 1, Short.MAX_VALUE), 
				new ItemStack(Item.flint),
				new ItemStack(Item.stick), 
				new ItemStack(Item.feather)});
			 
		CraftingManager.getInstance().addShapelessRecipe(new ItemStack(Item.arrow, 16),
				new Object[] {new ItemStack(Items.mysticalHammer, 1, Short.MAX_VALUE), 
				new ItemStack(Item.flint),
				new ItemStack(Item.stick), 
				new ItemStack(Item.feather)}); 
		
		CraftingManager.getInstance().addShapelessRecipe(new ItemStack(Items.meta, 1, 5),
				new Object[] {new ItemStack(Items.mysticalHammer, 1, Short.MAX_VALUE), 
				new ItemStack(Item.wheat)}); 
		
		CraftingManager.getInstance().addShapelessRecipe(new ItemStack(Items.meta, 1, 5),
				new Object[] {new ItemStack(Items.hammer, 1, Short.MAX_VALUE), 
				new ItemStack(Item.wheat)}); 
		
		CraftingManager.getInstance().addShapelessRecipe(new ItemStack(Items.meta, 1, 6),
				new Object[] {new ItemStack(Items.meta, 1, 5), 
				new ItemStack(Item.bucketMilk)}); 
		
		CraftingManager.getInstance().addShapelessRecipe(new ItemStack(Item.leather),
				new Object[] {new ItemStack(Item.rottenFlesh, 1), 
				new ItemStack(Item.silk, 1),
				new ItemStack(Items.hammer, 1, Short.MAX_VALUE)}); 
		
		CraftingManager.getInstance().addShapelessRecipe(new ItemStack(Item.leather),
				new Object[] {new ItemStack(Item.rottenFlesh, 1), 
				new ItemStack(Item.silk, 1),
				new ItemStack(Items.mysticalHammer, 1, Short.MAX_VALUE)}); 
		
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
		
		CraftingManager.getInstance().addShapelessRecipe(new ItemStack(Items.meta, 4, 4),
				new Object[] {new ItemStack(Items.hammer, 1, Short.MAX_VALUE), 
				new ItemStack(Item.ingotIron)});
				 
		CraftingManager.getInstance().addShapelessRecipe(new ItemStack(Items.meta, 8, 4),
				new Object[] {new ItemStack(Items.mysticalHammer, 1, Short.MAX_VALUE), 
				new ItemStack(Item.ingotIron)});
		
		CraftingManager.getInstance().addShapelessRecipe(new ItemStack(Block.grass, 1),
				new Object[] {new ItemStack(Item.dyePowder, 1, 15), 
				new ItemStack(Block.dirt)}); 
		
		CraftingManager.getInstance().addShapelessRecipe(new ItemStack(Items.hammer),
				new Object[] {new ItemStack(Items.meta, 1, 0),
				new ItemStack(Items.meta, 1, 1)});
				     
		
		//Shapeless Hammer Recipes
		addRecipe(new HammerRecipe(Block.cobblestone), 				new HammerRecipe(Block.stone));
		addRecipe(new HammerRecipe(Block.stone), 					new HammerRecipe(Block.stoneBrick));
		
		addRecipe(new HammerRecipe(Block.stoneBrick, 0), 			new HammerRecipe(Block.stoneBrick, 1));
		addRecipe(new HammerRecipe(Block.stoneBrick, 1), 			new HammerRecipe(Block.stoneBrick, 2));
		addRecipe(new HammerRecipe(Block.stoneBrick, 2), 			new HammerRecipe(Block.stoneBrick, 3));
		addRecipe(new HammerRecipe(Block.stoneBrick, 3), 			new HammerRecipe(Block.cobblestone));
		
		addRecipe(new HammerRecipe(Block.dirt), 					new HammerRecipe(Block.gravel));
		addRecipe(new HammerRecipe(Block.gravel), 					new HammerRecipe(Block.dirt));

		
		addRecipe(new HammerRecipe(Block.sand), 					new HammerRecipe(Block.sandStone, 0));
		addRecipe(new HammerRecipe(Block.sandStone, 0), 			new HammerRecipe(Block.sandStone, 1));
		addRecipe(new HammerRecipe(Block.sandStone, 1), 			new HammerRecipe(Block.sandStone, 2));
		addRecipe(new HammerRecipe(Block.sandStone, 2), 			new HammerRecipe(Block.sandStone, 0));
		
		addRecipe(new HammerRecipe(Block.cloth, 0), 				new HammerRecipe(Block.cloth, 1));
		addRecipe(new HammerRecipe(Block.cloth, 1), 				new HammerRecipe(Block.cloth, 2));
		addRecipe(new HammerRecipe(Block.cloth, 2), 				new HammerRecipe(Block.cloth, 3));
		addRecipe(new HammerRecipe(Block.cloth, 3), 				new HammerRecipe(Block.cloth, 4));
		addRecipe(new HammerRecipe(Block.cloth, 4), 				new HammerRecipe(Block.cloth, 5));
		addRecipe(new HammerRecipe(Block.cloth, 5), 				new HammerRecipe(Block.cloth, 6));
		addRecipe(new HammerRecipe(Block.cloth, 6), 				new HammerRecipe(Block.cloth, 7));
		addRecipe(new HammerRecipe(Block.cloth, 7), 				new HammerRecipe(Block.cloth, 8));
		addRecipe(new HammerRecipe(Block.cloth, 8), 				new HammerRecipe(Block.cloth, 9));
		addRecipe(new HammerRecipe(Block.cloth, 9), 				new HammerRecipe(Block.cloth, 10));
		addRecipe(new HammerRecipe(Block.cloth, 10), 				new HammerRecipe(Block.cloth, 11));
		addRecipe(new HammerRecipe(Block.cloth, 11), 				new HammerRecipe(Block.cloth, 12));
		addRecipe(new HammerRecipe(Block.cloth, 12), 				new HammerRecipe(Block.cloth, 13));
		addRecipe(new HammerRecipe(Block.cloth, 13), 				new HammerRecipe(Block.cloth, 14));
		addRecipe(new HammerRecipe(Block.cloth, 14), 				new HammerRecipe(Block.cloth, 15));
		addRecipe(new HammerRecipe(Block.cloth, 15), 				new HammerRecipe(Block.cloth, 0));

		addRecipe(new HammerRecipe(Block.wood, 0), 					new HammerRecipe(Block.wood, 1));
		addRecipe(new HammerRecipe(Block.wood, 1), 					new HammerRecipe(Block.wood, 2));
		addRecipe(new HammerRecipe(Block.wood, 2), 					new HammerRecipe(Block.wood, 3));
		addRecipe(new HammerRecipe(Block.wood, 3), 					new HammerRecipe(Block.wood, 0));
		addRecipe(new HammerRecipe(Block.wood, 4), 					new HammerRecipe(Block.wood, 5));
		addRecipe(new HammerRecipe(Block.wood, 5), 					new HammerRecipe(Block.wood, 6));
		addRecipe(new HammerRecipe(Block.wood, 6), 					new HammerRecipe(Block.wood, 7));
		addRecipe(new HammerRecipe(Block.wood, 7), 					new HammerRecipe(Block.wood, 4));
		addRecipe(new HammerRecipe(Block.wood, 8), 					new HammerRecipe(Block.wood, 9));
		addRecipe(new HammerRecipe(Block.wood, 9), 					new HammerRecipe(Block.wood, 10));
		addRecipe(new HammerRecipe(Block.wood, 10), 				new HammerRecipe(Block.wood, 11));
		addRecipe(new HammerRecipe(Block.wood, 11), 				new HammerRecipe(Block.wood, 8));
		addRecipe(new HammerRecipe(Block.wood, 12), 				new HammerRecipe(Block.wood, 13));
		addRecipe(new HammerRecipe(Block.wood, 13), 				new HammerRecipe(Block.wood, 14));
		addRecipe(new HammerRecipe(Block.wood, 14), 				new HammerRecipe(Block.wood, 15));
		addRecipe(new HammerRecipe(Block.wood, 15), 				new HammerRecipe(Block.wood, 12));
		
		addRecipe(new HammerRecipe(Block.planks, 0), 				new HammerRecipe(Block.planks, 1));
		addRecipe(new HammerRecipe(Block.planks, 1), 				new HammerRecipe(Block.planks, 2));
		addRecipe(new HammerRecipe(Block.planks, 2), 				new HammerRecipe(Block.planks, 3));
		addRecipe(new HammerRecipe(Block.planks, 3), 				new HammerRecipe(Block.planks, 0));
		
		addRecipe(new HammerRecipe(Block.stairsWoodOak).setIgroneMeta(), 		new HammerRecipe(Block.stairsWoodSpruce));
		addRecipe(new HammerRecipe(Block.stairsWoodSpruce).setIgroneMeta(), 	new HammerRecipe(Block.stairsWoodBirch));
		addRecipe(new HammerRecipe(Block.stairsWoodBirch).setIgroneMeta(), 		new HammerRecipe(Block.stairsWoodJungle));
		addRecipe(new HammerRecipe(Block.stairsWoodJungle).setIgroneMeta(), 	new HammerRecipe(Block.stairsWoodOak));
		
		addRecipe(new HammerRecipe(Block.woodSingleSlab, 0), 		new HammerRecipe(Block.woodSingleSlab, 1));
		addRecipe(new HammerRecipe(Block.woodSingleSlab, 1), 		new HammerRecipe(Block.woodSingleSlab, 2));
		addRecipe(new HammerRecipe(Block.woodSingleSlab, 2), 		new HammerRecipe(Block.woodSingleSlab, 3));
		addRecipe(new HammerRecipe(Block.woodSingleSlab, 3), 		new HammerRecipe(Block.woodSingleSlab, 0));
		
		addRecipe(new HammerRecipe(Block.carpet, 0), 				new HammerRecipe(Block.carpet, 1));
		addRecipe(new HammerRecipe(Block.carpet, 1), 				new HammerRecipe(Block.carpet, 2));
		addRecipe(new HammerRecipe(Block.carpet, 2), 				new HammerRecipe(Block.carpet, 3));
		addRecipe(new HammerRecipe(Block.carpet, 3), 				new HammerRecipe(Block.carpet, 4));
		addRecipe(new HammerRecipe(Block.carpet, 4), 				new HammerRecipe(Block.carpet, 5));
		addRecipe(new HammerRecipe(Block.carpet, 5), 				new HammerRecipe(Block.carpet, 6));
		addRecipe(new HammerRecipe(Block.carpet, 6), 				new HammerRecipe(Block.carpet, 7));
		addRecipe(new HammerRecipe(Block.carpet, 7), 				new HammerRecipe(Block.carpet, 8));
		addRecipe(new HammerRecipe(Block.carpet, 8), 				new HammerRecipe(Block.carpet, 9));
		addRecipe(new HammerRecipe(Block.carpet, 9), 				new HammerRecipe(Block.carpet, 10));
		addRecipe(new HammerRecipe(Block.carpet, 10), 				new HammerRecipe(Block.carpet, 11));
		addRecipe(new HammerRecipe(Block.carpet, 11), 				new HammerRecipe(Block.carpet, 12));
		addRecipe(new HammerRecipe(Block.carpet, 12), 				new HammerRecipe(Block.carpet, 13));
		addRecipe(new HammerRecipe(Block.carpet, 13), 				new HammerRecipe(Block.carpet, 14));
		addRecipe(new HammerRecipe(Block.carpet, 14), 				new HammerRecipe(Block.carpet, 15));
		addRecipe(new HammerRecipe(Block.carpet, 15), 				new HammerRecipe(Block.carpet, 0));
		
		addRecipe(new HammerRecipe(Block.stainedClay, 0), 			new HammerRecipe(Block.stainedClay, 1));
		addRecipe(new HammerRecipe(Block.stainedClay, 1), 			new HammerRecipe(Block.stainedClay, 2));
		addRecipe(new HammerRecipe(Block.stainedClay, 2), 			new HammerRecipe(Block.stainedClay, 3));
		addRecipe(new HammerRecipe(Block.stainedClay, 3), 			new HammerRecipe(Block.stainedClay, 4));
		addRecipe(new HammerRecipe(Block.stainedClay, 4), 			new HammerRecipe(Block.stainedClay, 5));
		addRecipe(new HammerRecipe(Block.stainedClay, 5), 			new HammerRecipe(Block.stainedClay, 6));
		addRecipe(new HammerRecipe(Block.stainedClay, 6), 			new HammerRecipe(Block.stainedClay, 7));
		addRecipe(new HammerRecipe(Block.stainedClay, 7), 			new HammerRecipe(Block.stainedClay, 8));
		addRecipe(new HammerRecipe(Block.stainedClay, 8), 			new HammerRecipe(Block.stainedClay, 9));
		addRecipe(new HammerRecipe(Block.stainedClay, 9), 			new HammerRecipe(Block.stainedClay, 10));
		addRecipe(new HammerRecipe(Block.stainedClay, 10), 			new HammerRecipe(Block.stainedClay, 11));
		addRecipe(new HammerRecipe(Block.stainedClay, 11), 			new HammerRecipe(Block.stainedClay, 12));
		addRecipe(new HammerRecipe(Block.stainedClay, 12), 			new HammerRecipe(Block.stainedClay, 13));
		addRecipe(new HammerRecipe(Block.stainedClay, 13), 			new HammerRecipe(Block.stainedClay, 14));
		addRecipe(new HammerRecipe(Block.stainedClay, 14), 			new HammerRecipe(Block.stainedClay, 15));
		addRecipe(new HammerRecipe(Block.stainedClay, 15), 			new HammerRecipe(Block.stainedClay, 0));	
		
		
		//Furnace Recipes
		FurnaceRecipes.smelting().addSmelting(Items.meta.itemID, 5, new ItemStack(Item.bread, 1), 0.1F);
		FurnaceRecipes.smelting().addSmelting(Items.meta.itemID, 6, new ItemStack(Item.bread, 3), 0.3F);	
	}
	
	public static ItemStack getHammerRecipe(int id, int meta) {
		for (Entry<HammerRecipe, ItemStack> entry : transformBlocks.entrySet())
		    if(entry.getKey().id == id && (entry.getKey().meta == meta || entry.getKey().igroneData))
		    	return entry.getValue();
		return null;
	}
	
	public static boolean getIgroneMeta(int id, int meta) {
		for (HammerRecipe recipe : transformBlocks.keySet())
		    if(recipe.id == id && (recipe.meta == meta || recipe.igroneData))
		    	return recipe.igroneData;
		return false;
	}
	
	public static void addRecipe(HammerRecipe input, HammerRecipe output) {
		if(!input.isItem && !output.isItem)
			transformBlocks.put(input, new ItemStack(output.id, 1, output.meta));
		
		CraftingManager.getInstance().addShapelessRecipe(new ItemStack(output.id, 1, output.meta),
				new Object[] {new ItemStack(Items.hammer, 1, Short.MAX_VALUE), 
			new ItemStack(input.id, 1, input.meta)});
		
		CraftingManager.getInstance().addShapelessRecipe(new ItemStack(output.id, 1, output.meta),
				new Object[] {new ItemStack(Items.ironHammer, 1, Short.MAX_VALUE), 
			new ItemStack(input.id, 1, input.meta)});
		
		CraftingManager.getInstance().addShapelessRecipe(new ItemStack(output.id, 1, output.meta),
				new Object[] {new ItemStack(Items.diamondHammer, 1, Short.MAX_VALUE), 
			new ItemStack(input.id, 1, input.meta)});
		
		CraftingManager.getInstance().addShapelessRecipe(new ItemStack(output.id, 1, output.meta),
				new Object[] {new ItemStack(Items.mysticalHammer, 1, Short.MAX_VALUE), 
			new ItemStack(input.id, 1, input.meta)});	
	}
	
	public static void addRecipe(HammerRecipe output, HammerRecipe ... input) {
		Object[] objInput = new Object[input.length + 1];
		for(int i = 0; i < input.length; i++) {
			objInput[i] = new ItemStack(input[i].id, 1, input[i].meta);
		}
		
		objInput[input.length] = new ItemStack(Items.mysticalHammer, 1, Short.MAX_VALUE);
		CraftingManager.getInstance().addShapelessRecipe(new ItemStack(output.id, 1, output.meta),
				objInput);
		
		objInput[input.length] = new ItemStack(Items.hammer, 1, Short.MAX_VALUE);
		CraftingManager.getInstance().addShapelessRecipe(new ItemStack(output.id, 1, output.meta),
				objInput);	
	}
	
	public static class HammerRecipe {
		public boolean isItem, igroneData;
		public int id, meta;
		
		public HammerRecipe(Block block, int meta) {
			this.id = block.blockID;
			this.meta = meta;
			this.isItem = false;
		}
		
		public HammerRecipe(Block block) {
			this.id = block.blockID;
			this.meta = 0;
			this.isItem = false;
		}
		
		public HammerRecipe(Item item) {
			this.id = item.itemID;
			this.meta = 0;
			this.isItem = true;
		}
		
		public HammerRecipe(Item item, int meta) {
			this.id = item.itemID;
			this.meta = meta;
			this.isItem = true;
		}
		
		public HammerRecipe setIgroneMeta() {
			this.igroneData = true;
			return this;
		}
	}
}
