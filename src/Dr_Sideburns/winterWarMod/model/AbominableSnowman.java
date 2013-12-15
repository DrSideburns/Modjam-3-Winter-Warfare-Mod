package Dr_Sideburns.winterWarMod.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class AbominableSnowman extends ModelBase
{
  //fields
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape6;
    ModelRenderer Shape5;
    ModelRenderer Shape7;
    ModelRenderer Shape8;
  
  public AbominableSnowman()
  {
    textureWidth = 128;
    textureHeight = 256;
    
      Shape1 = new ModelRenderer(this, 0, 0);
      Shape1.addBox(-8F, 0F, -8F, 16, 16, 16);
      Shape1.setRotationPoint(0F, 8F, 0F);
      Shape1.setTextureSize(128, 256);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 0, 34);
      Shape2.addBox(-7F, -6F, -7F, 14, 14, 14);
      Shape2.setRotationPoint(0F, 0F, 0F);
      Shape2.setTextureSize(128, 256);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 0, 63);
      Shape3.addBox(-6F, -12F, -6F, 12, 12, 12);
      Shape3.setRotationPoint(0F, -6F, 0F);
      Shape3.setTextureSize(128, 256);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0F, 0F);
      Shape4 = new ModelRenderer(this, 49, 63);
      Shape4.addBox(-0.5F, -7F, -13F, 1, 1, 7);
      Shape4.setRotationPoint(0F, -6F, 0F);
      Shape4.setTextureSize(128, 256);
      Shape4.mirror = true;
      setRotation(Shape4, 0F, 0F, 0F);
      Shape6 = new ModelRenderer(this, 57, 34);
      Shape6.addBox(-4F, 0F, 0F, 4, 1, 1);
      Shape6.setRotationPoint(-7F, 0F, 0F);
      Shape6.setTextureSize(128, 256);
      Shape6.mirror = true;
      setRotation(Shape6, 0F, 0F, 0F);
      Shape5 = new ModelRenderer(this, 68, 33);
      Shape5.addBox(-4F, -11F, 0F, 1, 12, 1);
      Shape5.setRotationPoint(-7F, 0F, 0F);
      Shape5.setTextureSize(128, 256);
      Shape5.mirror = true;
      setRotation(Shape5, 0F, 0F, 0F);
      Shape7 = new ModelRenderer(this, 57, 59);
      Shape7.addBox(0F, 0F, 0F, 4, 1, 1);
      Shape7.setRotationPoint(7F, 0F, 0F);
      Shape7.setTextureSize(128, 256);
      Shape7.mirror = true;
      setRotation(Shape7, 0F, 0F, 0F);
      Shape8 = new ModelRenderer(this, 68, 48);
      Shape8.addBox(3F, 0F, -10F, 1, 1, 11);
      Shape8.setRotationPoint(7F, 0F, 0F);
      Shape8.setTextureSize(128, 256);
      Shape8.mirror = true;
      setRotation(Shape8, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shape1.render(f5);
    Shape2.render(f5);
    Shape3.render(f5);
    Shape4.render(f5);
    Shape6.render(f5);
    Shape5.render(f5);
    Shape7.render(f5);
    Shape8.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity par6Entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, par6Entity);
    
    this.Shape3.rotateAngleY = f3 / (180F / (float)Math.PI);
    this.Shape3.rotateAngleX = f4 / (170F / (float)Math.PI);
    
    this.Shape4.rotateAngleY = f3 / (180F / (float)Math.PI);
    this.Shape4.rotateAngleX = f4 / (170F / (float)Math.PI);
    
    this.Shape6.rotateAngleX = MathHelper.cos(f * 0.6663F + (float)Math.PI) * 2.0F * f1 * 0.5F;
    this.Shape6.rotateAngleZ = 0.0F;
    
    this.Shape5.rotateAngleX = MathHelper.cos(f * 0.6663F + (float)Math.PI) * 2.0F * f1 * 0.5F;
    this.Shape5.rotateAngleZ = 0.0F;
    
    this.Shape7.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
    this.Shape7.rotateAngleZ = 0.0F;
    
    this.Shape8.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
    this.Shape8.rotateAngleZ = 0.0F;
  }

}
