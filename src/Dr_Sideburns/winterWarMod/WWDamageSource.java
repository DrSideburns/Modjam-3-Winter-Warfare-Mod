package Dr_Sideburns.winterWarMod;

import Dr_Sideburns.winterWarMod.entity.EntityLaunchedSnowball;
import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;

public class WWDamageSource {
	
	public static DamageSource causeLaunchedSnowballDamage(EntityLaunchedSnowball par1EntityLaunchedSnowball, Entity par2Entity) {
		return (new EntityDamageSourceIndirect("launchedSnowball", par1EntityLaunchedSnowball, par2Entity)).setProjectile();
	}

}
