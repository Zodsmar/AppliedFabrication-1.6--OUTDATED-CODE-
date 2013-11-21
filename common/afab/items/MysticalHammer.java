package afab.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import afab.AppliedFabrication;
import afab.crafting.Recipes;
import afab.lib.ModInfo;
import afab.lib.Names;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MysticalHammer extends ItemCraftingDamage{
protected MysticalHammer(int par1) {
		
		super(par1);
		this.setCreativeTab(AppliedFabrication.AFTab);
         this.setUnlocalizedName(Names.mysticalHammer_unlocalizedname);
		maxStackSize = 1;
		setMaxDamage(-1);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {

		itemIcon = icon.registerIcon(ModInfo.MODID.toLowerCase() + ":" + Names.mysticalHammer_unlocalizedname);
	}
	
	@Override
	public boolean hasEffect(ItemStack par1ItemStack) {
		return true;
	}
	
	@Override
	public boolean onItemUse(ItemStack par1ItemStack,
			EntityPlayer par2EntityPlayer, World par3World, int par4, int par5,
			int par6, int par7, float par8, float par9, float par10) {
		int id = par3World.getBlockId(par4, par5, par6);
		int meta = par3World.getBlockMetadata(par4, par5, par6);
		ItemStack output = Recipes.getHammerRecipe(id, meta);
		
		if(output != null) {
			String paricle = "explode";
			par3World.spawnParticle(paricle, par4, par5 + 1D, par6, 0D, 0D, 0D);
			par3World.spawnParticle(paricle, par4 + 1, par5 + 1D, par6, 0D, 0D, 0D);
			par3World.spawnParticle(paricle, par4 + 1, par5 + 1D, par6 + 1, 0D, 0D, 0D);
			par3World.spawnParticle(paricle, par4, par5 + 1D, par6 + 1, 0D, 0D, 0D);
			
			par3World.setBlock(par4, par5, par6, output.itemID, Recipes.getIgroneMeta(id, meta) ? meta : output.getItemDamage(), 2);
			
			return true;
		}
		
		return false;
	}
	
	@Override
	@SuppressWarnings({"unchecked", "rawtypes"})
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean i)
	{
	list.add("\u00A76An UNBREAKABLE Hammer!");
	}

	 @Override
	public boolean isFull3D()
    {
        return true;
    }
	 
	 public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
	 {
	 if(itemstack.getItemDamage() >= 0){
		 float f = 1.0F;
		 float f1 = entityplayer.prevRotationPitch + (entityplayer.rotationPitch - entityplayer.prevRotationPitch) * f;
		 float f2 = entityplayer.prevRotationYaw + (entityplayer.rotationYaw - entityplayer.prevRotationYaw) * f;
		 double d = entityplayer.prevPosX + (entityplayer.posX - entityplayer.prevPosX) * (double)f;
		 double d1 = (entityplayer.prevPosY + (entityplayer.posY - entityplayer.prevPosY) * (double)f + 1.6200000000000001D) - (double)entityplayer.yOffset;
	 	double d2 = entityplayer.prevPosZ + (entityplayer.posZ - entityplayer.prevPosZ) * (double)f;
	 Vec3 vec3d = Vec3.createVectorHelper(d, d1, d2);
	 	float f3 = MathHelper.cos(-f2 * 0.01745329F - 3.141593F);
	 	float f4 = MathHelper.sin(-f2 * 0.01745329F - 3.141593F);
	 	float f5 = -MathHelper.cos(-f1 * 0.01745329F);
	 	float f6 = MathHelper.sin(-f1 * 0.01745329F);
	 	float f7 = f4 * f5;
	 	float f8 = f6;
	 	float f9 = f3 * f5;
	 	double d3 = 5000D;
	 Vec3 vec3d1 = vec3d.addVector((double)f7 * d3, (double)f8 * d3 + 1, (double)f9 * d3);
	 MovingObjectPosition movingobjectposition = world.rayTraceBlocks_do_do(vec3d, vec3d1, false, true);
	 if (movingobjectposition == null)
	 	{
		 return itemstack;
	 	}
	 if (movingobjectposition.typeOfHit == EnumMovingObjectType.TILE)
	 {
		 int i = movingobjectposition.blockX;
		 int j = movingobjectposition.blockY;
		 int k = movingobjectposition.blockZ;
		 world.spawnEntityInWorld(new EntityLightningBolt(world, i, j, k));
	 }
	 	itemstack.setItemDamage(0);
	 }
	 	return itemstack;
	 }
}
