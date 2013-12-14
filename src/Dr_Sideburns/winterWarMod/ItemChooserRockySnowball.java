package Dr_Sideburns.winterWarMod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemChooserRockySnowball extends Item {

	public ItemChooserRockySnowball(int par1) {
		super(par1);
		this.setMaxStackSize(1);
		this.setCreativeTab(WinterWarMain.tabWWMod);
	}
	
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		if(par3EntityPlayer.inventory.hasItem(WinterWarMain.explodingSnowBall.itemID)) {
			par3EntityPlayer.destroyCurrentEquippedItem();
			par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(WinterWarMain.chooserExplodingSnowball));
		}
		else if(par3EntityPlayer.inventory.hasItem(Item.potato.itemID)) {
			par3EntityPlayer.destroyCurrentEquippedItem();
			par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(WinterWarMain.chooserPotato));
		}
		else if(par3EntityPlayer.inventory.hasItem(Item.snowball.itemID)) {
			par3EntityPlayer.destroyCurrentEquippedItem();
			par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(WinterWarMain.chooserSnowball));
		}
		else if(par3EntityPlayer.inventory.hasItem(WinterWarMain.iceBall.itemID)) {
			par3EntityPlayer.destroyCurrentEquippedItem();
			par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(WinterWarMain.chooserIceball));
		}
		return par1ItemStack;
	}

}
