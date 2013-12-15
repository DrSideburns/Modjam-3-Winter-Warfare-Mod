package Dr_Sideburns.winterWarMod.render;

import Dr_Sideburns.winterWarMod.entity.EntityAbominableIceman;
import Dr_Sideburns.winterWarMod.entity.EntityAbominableSnowman;
import Dr_Sideburns.winterWarMod.model.AbominableSnowman;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderAbominableIceman extends RenderLiving {
	
	protected AbominableSnowman model;

	public RenderAbominableIceman(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		model = ((AbominableSnowman)mainModel);
	}
	
	public void renderAbominableIceman(EntityAbominableIceman par1Entity, double par2, double par4, double par6, float par8, float par9) {
		super.doRenderLiving(par1Entity, par2, par4, par6, par8, par9);
	}
	
	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
		renderAbominableIceman((EntityAbominableIceman)par1EntityLiving, par2, par4, par6, par8, par9);
	}
	
	@Override
	public void doRender(Entity entity, double d0, double d1, double d2, float f, float f1) {
		renderAbominableIceman((EntityAbominableIceman)entity, d0, d1, d2, f, f1);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation ("winterwarfare:textures/mobs/abominableiceman.png");
	}

}