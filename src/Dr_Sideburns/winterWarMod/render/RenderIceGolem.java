package Dr_Sideburns.winterWarMod.render;

import Dr_Sideburns.winterWarMod.WinterWarMain;
import Dr_Sideburns.winterWarMod.entity.EntityIceGolem;
import Dr_Sideburns.winterWarMod.model.ModelIceGolem;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.model.ModelSnowMan;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import net.minecraftforge.client.IItemRenderer;
import static net.minecraftforge.client.IItemRenderer.ItemRenderType.*;
import static net.minecraftforge.client.IItemRenderer.ItemRendererHelper.*;
import net.minecraftforge.client.MinecraftForgeClient;

@SideOnly(Side.CLIENT)
public class RenderIceGolem extends RenderLiving
{
    private static final ResourceLocation iceManTextures = new ResourceLocation("winterwarfare:textures/mobs/iceman.png");

    /** A reference to the Snowman model in RenderSnowMan. */
    private ModelIceGolem iceGolemModel;

    public RenderIceGolem()
    {
        super(new ModelIceGolem(), 0.5F);
        this.iceGolemModel = (ModelIceGolem)super.mainModel;
        this.setRenderPassModel(this.iceGolemModel);
    }

    /**
     * Renders this snowman's pumpkin.
     */
    protected void renderSnowmanPumpkin(EntityIceGolem par1EntityIceGolem, float par2)
    {
        super.renderEquippedItems(par1EntityIceGolem, par2);
        ItemStack itemstack = new ItemStack(WinterWarMain.frozenPumpkin, 1);

        if (itemstack != null && itemstack.getItem() instanceof ItemBlock)
        {
            GL11.glPushMatrix();
            this.iceGolemModel.head.postRender(0.0625F);

            IItemRenderer customRenderer = MinecraftForgeClient.getItemRenderer(itemstack, EQUIPPED);
            boolean is3D = (customRenderer != null && customRenderer.shouldUseRenderHelper(EQUIPPED, itemstack, BLOCK_3D));

            if (is3D || RenderBlocks.renderItemIn3d(Block.blocksList[itemstack.itemID].getRenderType()))
            {
                float f1 = 0.625F;
                GL11.glTranslatef(0.0F, -0.34375F, 0.0F);
                GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
                GL11.glScalef(f1, -f1, f1);
            }

            this.renderManager.itemRenderer.renderItem(par1EntityIceGolem, itemstack, 0);
            GL11.glPopMatrix();
        }
    }

    protected ResourceLocation getSnowManTextures(EntityIceGolem par1EntitySnowman)
    {
        return iceManTextures;
    }

    protected void renderEquippedItems(EntityLivingBase par1EntityLivingBase, float par2)
    {
        this.renderSnowmanPumpkin((EntityIceGolem)par1EntityLivingBase, par2);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity par1Entity)
    {
        return this.getSnowManTextures((EntityIceGolem)par1Entity);
    }
}
