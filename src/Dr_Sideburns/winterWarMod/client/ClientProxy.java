package Dr_Sideburns.winterWarMod.client;

import Dr_Sideburns.winterWarMod.CommonProxy;
import Dr_Sideburns.winterWarMod.WinterWarMain;
import Dr_Sideburns.winterWarMod.entity.EntityExplodingSnowball;
import Dr_Sideburns.winterWarMod.entity.EntityIceball;
import Dr_Sideburns.winterWarMod.entity.EntityRockySnowBall;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void registerRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(EntityIceball.class, new RenderSnowball(WinterWarMain.iceBall));
		RenderingRegistry.registerEntityRenderingHandler(EntityRockySnowBall.class, new RenderSnowball(WinterWarMain.rockySnowBall));
		RenderingRegistry.registerEntityRenderingHandler(EntityExplodingSnowball.class, new RenderSnowball(WinterWarMain.explodingSnowBall));
	}
	
	@Override
	public int addArmor(String armor) {
		return RenderingRegistry.addNewArmourRendererPrefix(armor);
	}

}
