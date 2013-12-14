package Dr_Sideburns.winterWarMod;

import Dr_Sideburns.winterWarMod.entity.EntityExplodingSnowball;
import Dr_Sideburns.winterWarMod.entity.EntityIceball;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemExplodingSnowball extends Item
{
    public ItemExplodingSnowball(int par1)
    {
        super(par1);
        this.maxStackSize = 16;
        this.setCreativeTab(WinterWarMain.tabWWMod);
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        if (!par3EntityPlayer.capabilities.isCreativeMode)
        {
            --par1ItemStack.stackSize;
        }

        par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
        par2World.playSoundAtEntity(par3EntityPlayer, "random.fizz", 1.0F, 1.0F);

        if (!par2World.isRemote)
        {
            par2World.spawnEntityInWorld(new EntityExplodingSnowball(par2World, par3EntityPlayer));
        }

        return par1ItemStack;
    }
}