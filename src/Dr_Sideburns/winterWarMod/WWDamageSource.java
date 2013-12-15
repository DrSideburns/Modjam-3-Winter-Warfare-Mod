package Dr_Sideburns.winterWarMod;

import Dr_Sideburns.winterWarMod.entity.EntityLaunchedExplodingSnowball;
import Dr_Sideburns.winterWarMod.entity.EntityLaunchedIceball;
import Dr_Sideburns.winterWarMod.entity.EntityLaunchedPotato;
import Dr_Sideburns.winterWarMod.entity.EntityLaunchedRockySnowball;
import Dr_Sideburns.winterWarMod.entity.EntityLaunchedSlimeball;
import Dr_Sideburns.winterWarMod.entity.EntityLaunchedSnowball;
import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;

public class WWDamageSource {
	
	public static DamageSource causeLaunchedSnowballDamage(EntityLaunchedSnowball par1EntityLaunchedSnowball, Entity par2Entity) {
		return (new EntityDamageSourceIndirect("launchedSnowball", par1EntityLaunchedSnowball, par2Entity)).setProjectile();
	}
	
	public static DamageSource causeLaunchedIceballDamage(EntityLaunchedIceball par1EntityLaunchedSnowball, Entity par2Entity) {
		return (new EntityDamageSourceIndirect("launchedIceball", par1EntityLaunchedSnowball, par2Entity)).setProjectile();
	}
	
	public static DamageSource causeLaunchedRockySnowballDamage(EntityLaunchedRockySnowball par1EntityLaunchedSnowball, Entity par2Entity) {
		return (new EntityDamageSourceIndirect("launchedRockySnowball", par1EntityLaunchedSnowball, par2Entity)).setProjectile();
	}
	
	public static DamageSource causeLaunchedExplodingSnowballDamage(EntityLaunchedExplodingSnowball par1EntityLaunchedSnowball, Entity par2Entity) {
		return (new EntityDamageSourceIndirect("launchedExplodingSnowball", par1EntityLaunchedSnowball, par2Entity)).setProjectile();
	}
	
	public static DamageSource causeLaunchedPotatoDamage(EntityLaunchedPotato par1EntityLaunchedSnowball, Entity par2Entity) {
		return (new EntityDamageSourceIndirect("launchedPotato", par1EntityLaunchedSnowball, par2Entity)).setProjectile();
	}
	
	public static DamageSource causeLaunchedSlimeballDamage(EntityLaunchedSlimeball par1EntityLaunchedSlimeball, Entity par2Entity) {
		return (new EntityDamageSourceIndirect("launchedSlimeball", par1EntityLaunchedSlimeball, par2Entity)).setProjectile();
	}
}
