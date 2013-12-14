package Dr_Sideburns.winterWarMod.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityExplodingSnowball extends EntityThrowable
{
    public EntityExplodingSnowball(World par1World)
    {
        super(par1World);
    }

    public EntityExplodingSnowball(World par1World, EntityLivingBase par2EntityLivingBase)
    {
        super(par1World, par2EntityLivingBase);
    }

    public EntityExplodingSnowball(World par1World, double par2, double par4, double par6)
    {
        super(par1World, par2, par4, par6);
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    protected void onImpact(MovingObjectPosition par1MovingObjectPosition)
    {
        if (par1MovingObjectPosition.entityHit != null)
        {
            byte b0 = 1;

            if (par1MovingObjectPosition.entityHit instanceof EntityBlaze)
            {
                b0 = 3;
            }

            par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), (float)b0);
            par1MovingObjectPosition.entityHit.worldObj.createExplosion(null, par1MovingObjectPosition.entityHit.posX, par1MovingObjectPosition.entityHit.posY, par1MovingObjectPosition.entityHit.posZ, 1.2F, true);
            par1MovingObjectPosition.entityHit.playSound("random.explode", 1.0F, 1.0F);
        }

        for (int i = 0; i < 8; ++i)
        {
            this.worldObj.spawnParticle("snowballpoof", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
        }

        if (!this.worldObj.isRemote)
        {
            this.setDead();
        }
    }
}