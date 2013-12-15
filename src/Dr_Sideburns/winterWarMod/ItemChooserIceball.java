package Dr_Sideburns.winterWarMod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemChooserIceball extends Item {

	public ItemChooserIceball(int par1) {
		super(par1);
		this.setMaxStackSize(1);
		this.setCreativeTab(WinterWarMain.tabWWMod);
	}
	
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		if(par3EntityPlayer.inventory.hasItem(WinterWarMain.rockySnowBall.itemID)) {
			par3EntityPlayer.destroyCurrentEquippedItem();
			par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(WinterWarMain.chooserRockySnowball));
		}
		else if(par3EntityPlayer.inventory.hasItem(WinterWarMain.explodingSnowBall.itemID)) {
			par3EntityPlayer.destroyCurrentEquippedItem();
			par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(WinterWarMain.chooserExplodingSnowball));
		}
		else if(par3EntityPlayer.inventory.hasItem(Item.potato.itemID)) {
			par3EntityPlayer.destroyCurrentEquippedItem();
			par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(WinterWarMain.chooserPotato));
		}
		else if(par3EntityPlayer.inventory.hasItem(Item.slimeBall.itemID)) {
			par3EntityPlayer.destroyCurrentEquippedItem();
			par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(WinterWarMain.chooserSlimeball));
		}
		else if(par3EntityPlayer.inventory.hasItem(Item.snowball.itemID)) {
			par3EntityPlayer.destroyCurrentEquippedItem();
			par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(WinterWarMain.chooserSnowball));
		}
		return par1ItemStack;
	}

}
