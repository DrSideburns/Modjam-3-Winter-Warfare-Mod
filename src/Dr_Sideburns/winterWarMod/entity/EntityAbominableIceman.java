package Dr_Sideburns.winterWarMod.entity;

import Dr_Sideburns.winterWarMod.WinterWarMain;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIFleeSun;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIRestrictSun;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityAbominableIceman extends EntityMob implements IRangedAttackMob {

	public EntityAbominableIceman(World par1World) {
		super(par1World);
		this.experienceValue = 20;
		this.getNavigator().setAvoidsWater(true);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIArrowAttack(this, 1.25D, 20, 10.0F));
		this.tasks.addTask(2, new EntityAIRestrictSun(this));
        this.tasks.addTask(3, new EntityAIFleeSun(this, 0.3D));
        this.tasks.addTask(5, new EntityAIWander(this, 0.25D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
	}
	
	 public boolean isAIEnabled()
	    {
	        return true;
	    }
	 
	 public void applyEntityAttributes() {
		 super.applyEntityAttributes();
		 this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(35.0F);
		 this.getEntityAttribute(SharedMonsterAttributes.followRange).setAttribute(80.0F);
		 this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.3D);
	 }
	 
	 public void onLivingUpdate()
	    {
	        super.onLivingUpdate();
	        
	        if (this.worldObj.isDaytime() && !this.worldObj.isRemote)
	        {
	            float f = this.getBrightness(1.0F);

	            if (f > 0.5F && this.rand.nextFloat() * 30.0F < (f - 0.4F) * 2.0F && this.worldObj.canBlockSeeTheSky(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ)))
	            {
	              
	                    this.setFire(8);
	            }
	        }

	        if (this.isWet())
	        {
	            this.attackEntityFrom(DamageSource.drown, 1.0F);
	        }

	        int i = MathHelper.floor_double(this.posX);
	        int j = MathHelper.floor_double(this.posZ);

	        if (this.worldObj.getBiomeGenForCoords(i, j).getFloatTemperature() > 1.0F)
	        {
	            this.attackEntityFrom(DamageSource.onFire, 1.0F);
	        }
	    }
	 
	 protected int getDropItemId()
	    {
	        return WinterWarMain.iceBall.itemID;
	    }
	 
	 protected void dropFewItems(boolean par1, int par2)
	    {
	        int j = this.rand.nextInt(16);

	        for (int k = 0; k < j; ++k)
	        {
	            this.dropItem(WinterWarMain.iceBall.itemID, 1);
	        }
	    }
	 
	 public void attackEntityWithRangedAttack(EntityLivingBase par1EntityLivingBase, float par2)
	    {
	        EntityIceball entityiceball = new EntityIceball(this.worldObj, this);
	        double d0 = par1EntityLivingBase.posX - this.posX;
	        double d1 = par1EntityLivingBase.posY + (double)par1EntityLivingBase.getEyeHeight() - 1.100000023841858D - entityiceball.posY;
	        double d2 = par1EntityLivingBase.posZ - this.posZ;
	        float f1 = MathHelper.sqrt_double(d0 * d0 + d2 * d2) * 0.2F;
	        entityiceball.setThrowableHeading(d0, d1 + (double)f1, d2, 1.6F, 12.0F);
	        this.playSound("random.bow", 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
	        this.worldObj.spawnEntityInWorld(entityiceball);
	    }
}