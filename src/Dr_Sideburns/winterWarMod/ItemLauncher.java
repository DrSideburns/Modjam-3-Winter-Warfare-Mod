package Dr_Sideburns.winterWarMod;

import Dr_Sideburns.winterWarMod.entity.EntityLaunchedExplodingSnowball;
import Dr_Sideburns.winterWarMod.entity.EntityLaunchedIceball;
import Dr_Sideburns.winterWarMod.entity.EntityLaunchedPotato;
import Dr_Sideburns.winterWarMod.entity.EntityLaunchedRockySnowball;
import Dr_Sideburns.winterWarMod.entity.EntityLaunchedSnowball;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;

public class ItemLauncher extends Item
{
    @SideOnly(Side.CLIENT)
    private Icon[] iconArray;

    public ItemLauncher(int par1)
    {
        super(par1);
        this.maxStackSize = 1;
        this.setMaxDamage(500);
        this.setCreativeTab(WinterWarMain.tabWWMod);
    }

    /**
     * called when the player releases the use item button. Args: itemstack, world, entityplayer, itemInUseCount
     */
    public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4)
    {
        int j = this.getMaxItemUseDuration(par1ItemStack) - par4;

        ArrowLooseEvent event = new ArrowLooseEvent(par3EntityPlayer, par1ItemStack, j);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled())
        {
            return;
        }
        j = event.charge;

        boolean flag11 = par3EntityPlayer.capabilities.isCreativeMode && par3EntityPlayer.inventory.hasItem(WinterWarMain.chooserSnowball.itemID);
        boolean flag1 = par3EntityPlayer.inventory.hasItem(Item.snowball.itemID) && par3EntityPlayer.inventory.hasItem(WinterWarMain.chooserSnowball.itemID);
        boolean flag12 = par3EntityPlayer.capabilities.isCreativeMode && par3EntityPlayer.inventory.hasItem(WinterWarMain.chooserIceball.itemID);
        boolean flag2 = par3EntityPlayer.inventory.hasItem(WinterWarMain.iceBall.itemID) && par3EntityPlayer.inventory.hasItem(WinterWarMain.chooserIceball.itemID);
        boolean flag13 = par3EntityPlayer.capabilities.isCreativeMode && par3EntityPlayer.inventory.hasItem(WinterWarMain.chooserRockySnowball.itemID);
        boolean flag3 = par3EntityPlayer.inventory.hasItem(WinterWarMain.rockySnowBall.itemID) && par3EntityPlayer.inventory.hasItem(WinterWarMain.chooserRockySnowball.itemID);
        boolean flag14 = par3EntityPlayer.capabilities.isCreativeMode && par3EntityPlayer.inventory.hasItem(WinterWarMain.chooserExplodingSnowball.itemID);
        boolean flag4 = par3EntityPlayer.inventory.hasItem(WinterWarMain.explodingSnowBall.itemID) && par3EntityPlayer.inventory.hasItem(WinterWarMain.chooserExplodingSnowball.itemID);
        boolean flag15 = par3EntityPlayer.capabilities.isCreativeMode && par3EntityPlayer.inventory.hasItem(WinterWarMain.chooserPotato.itemID);
        boolean flag5 = par3EntityPlayer.inventory.hasItem(Item.potato.itemID) && par3EntityPlayer.inventory.hasItem(WinterWarMain.chooserPotato.itemID);

        if (flag11 || flag1)
        {
            float f = (float)j / 20.0F;
            f = (f * f + f * 2.0F) / 3.0F;

            if ((double)f < 0.1D)
            {
                return;
            }

            if (f > 1.0F)
            {
                f = 1.0F;
            }

            EntityLaunchedSnowball entitysnowball = new EntityLaunchedSnowball(par2World, par3EntityPlayer, f * 2.0F);

            if (f == 1.0F)
            {
                entitysnowball.setIsCritical(true);
            }

            int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, par1ItemStack);

            if (k > 0)
            {
                entitysnowball.setDamage(entitysnowball.getDamage() + (double)k * 0.5D + 0.5D);
            }

            int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, par1ItemStack);

            if (l > 0)
            {
                entitysnowball.setKnockbackStrength(l);
            }

            par1ItemStack.damageItem(1, par3EntityPlayer);
            par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

            if (!flag11)
            {
                par3EntityPlayer.inventory.consumeInventoryItem(Item.snowball.itemID);
            }

            if (!par2World.isRemote)
            {
                par2World.spawnEntityInWorld(entitysnowball);
            }
        }
        
        if (flag12 || flag2)
        {
            float f = (float)j / 20.0F;
            f = (f * f + f * 2.0F) / 3.0F;

            if ((double)f < 0.1D)
            {
                return;
            }

            if (f > 1.0F)
            {
                f = 1.0F;
            }

            EntityLaunchedIceball entityiceball = new EntityLaunchedIceball(par2World, par3EntityPlayer, f * 2.0F);

            if (f == 1.0F)
            {
                entityiceball.setIsCritical(true);
            }

            int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, par1ItemStack);

            if (k > 0)
            {
                entityiceball.setDamage(entityiceball.getDamage() + (double)k * 0.5D + 0.5D);
            }

            int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, par1ItemStack);

            if (l > 0)
            {
                entityiceball.setKnockbackStrength(l);
            }

            par1ItemStack.damageItem(1, par3EntityPlayer);
            par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

            if (!flag12)
            {
                par3EntityPlayer.inventory.consumeInventoryItem(WinterWarMain.iceBall.itemID);
            }

            if (!par2World.isRemote)
            {
                par2World.spawnEntityInWorld(entityiceball);
            }
        }
        
        if (flag13 || flag3)
        {
            float f = (float)j / 20.0F;
            f = (f * f + f * 2.0F) / 3.0F;

            if ((double)f < 0.1D)
            {
                return;
            }

            if (f > 1.0F)
            {
                f = 1.0F;
            }

            EntityLaunchedRockySnowball entityrockysnowball = new EntityLaunchedRockySnowball(par2World, par3EntityPlayer, f * 2.0F);

            if (f == 1.0F)
            {
                entityrockysnowball.setIsCritical(true);
            }

            int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, par1ItemStack);

            if (k > 0)
            {
                entityrockysnowball.setDamage(entityrockysnowball.getDamage() + (double)k * 0.5D + 0.5D);
            }

            int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, par1ItemStack);

            if (l > 0)
            {
                entityrockysnowball.setKnockbackStrength(l);
            }

            par1ItemStack.damageItem(2, par3EntityPlayer);
            par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

            if (!flag13)
            {
                par3EntityPlayer.inventory.consumeInventoryItem(WinterWarMain.rockySnowBall.itemID);
            }

            if (!par2World.isRemote)
            {
                par2World.spawnEntityInWorld(entityrockysnowball);
            }
        }
        
        if (flag14 || flag4)
        {
            float f = (float)j / 20.0F;
            f = (f * f + f * 2.0F) / 3.0F;

            if ((double)f < 0.1D)
            {
                return;
            }

            if (f > 1.0F)
            {
                f = 1.0F;
            }

            EntityLaunchedExplodingSnowball entityexplodingsnowball = new EntityLaunchedExplodingSnowball(par2World, par3EntityPlayer, f * 2.0F);

            if (f == 1.0F)
            {
                entityexplodingsnowball.setIsCritical(true);
            }

            int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, par1ItemStack);

            if (k > 0)
            {
                entityexplodingsnowball.setDamage(entityexplodingsnowball.getDamage() + (double)k * 0.5D + 0.5D);
            }

            int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, par1ItemStack);

            if (l > 0)
            {
                entityexplodingsnowball.setKnockbackStrength(l);
            }

            par1ItemStack.damageItem(1, par3EntityPlayer);
            par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
            par2World.playSoundAtEntity(par3EntityPlayer, "random.fizz", 1.0F, 1.0F);

            if (!flag14)
            {
                par3EntityPlayer.inventory.consumeInventoryItem(WinterWarMain.explodingSnowBall.itemID);
            }

            if (!par2World.isRemote)
            {
                par2World.spawnEntityInWorld(entityexplodingsnowball);
            }
        }
        
        if (flag15 || flag5)
        {
            float f = (float)j / 20.0F;
            f = (f * f + f * 2.0F) / 3.0F;

            if ((double)f < 0.1D)
            {
                return;
            }

            if (f > 1.0F)
            {
                f = 1.0F;
            }

            EntityLaunchedPotato entitypotato = new EntityLaunchedPotato(par2World, par3EntityPlayer, f * 2.0F);

            if (f == 1.0F)
            {
                entitypotato.setIsCritical(true);
            }

            int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, par1ItemStack);

            if (k > 0)
            {
                entitypotato.setDamage(entitypotato.getDamage() + (double)k * 0.5D + 0.5D);
            }

            int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, par1ItemStack);

            if (l > 0)
            {
                entitypotato.setKnockbackStrength(l);
            }

            par1ItemStack.damageItem(1, par3EntityPlayer);
            par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

            if (!flag15)
            {
                par3EntityPlayer.inventory.consumeInventoryItem(Item.potato.itemID);
            }

            if (!par2World.isRemote)
            {
                par2World.spawnEntityInWorld(entitypotato);
            }
        }
    }

    public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        return par1ItemStack;
    }

    /**
     * How long it takes to use or consume an item
     */
    public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 72000;
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.bow;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        ArrowNockEvent event = new ArrowNockEvent(par3EntityPlayer, par1ItemStack);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled())
        {
            return event.result;
        }
        
        boolean flag1 = par3EntityPlayer.inventory.hasItem(Item.snowball.itemID) && par3EntityPlayer.inventory.hasItem(WinterWarMain.chooserSnowball.itemID);
        boolean flag2 = par3EntityPlayer.inventory.hasItem(WinterWarMain.iceBall.itemID) && par3EntityPlayer.inventory.hasItem(WinterWarMain.chooserIceball.itemID);
        boolean flag3 = par3EntityPlayer.inventory.hasItem(WinterWarMain.rockySnowBall.itemID) && par3EntityPlayer.inventory.hasItem(WinterWarMain.chooserRockySnowball.itemID);
        boolean flag4 = par3EntityPlayer.inventory.hasItem(WinterWarMain.explodingSnowBall.itemID) && par3EntityPlayer.inventory.hasItem(WinterWarMain.chooserExplodingSnowball.itemID);
        boolean flag5 = par3EntityPlayer.inventory.hasItem(Item.potato.itemID) && par3EntityPlayer.inventory.hasItem(WinterWarMain.chooserPotato.itemID);

        if (par3EntityPlayer.capabilities.isCreativeMode || flag1 || flag2 || flag3 || flag4 || flag5);
        {
            par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
        }

        return par1ItemStack;
    }

    /**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
    public int getItemEnchantability()
    {
        return 1;
    }


    @SideOnly(Side.CLIENT)

    /**
     * used to cycle through icons based on their used duration, i.e. for the bow
     */
    public Icon getItemIconForUseDuration(int par1)
    {
        return this.iconArray[par1];
    }
}
