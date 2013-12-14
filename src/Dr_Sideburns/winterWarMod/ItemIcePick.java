package Dr_Sideburns.winterWarMod;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemIcePick extends Item {

	public ItemIcePick(int par1) {
		super(par1);
	}
	
	@Override
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World
			, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
		if(par3World.getBlockId(par4, par5, par6) == Block.ice.blockID) {
			par3World.setBlock(par4, par5, par6, WinterWarMain.minableIceBlock.blockID);
		}
		return true;
	}

}
