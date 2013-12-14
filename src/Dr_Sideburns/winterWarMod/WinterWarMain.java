package Dr_Sideburns.winterWarMod;

//Imports
import Dr_Sideburns.winterWarMod.entity.EntityExplodingSnowball;
import Dr_Sideburns.winterWarMod.entity.EntityIceball;
import Dr_Sideburns.winterWarMod.entity.EntityRockySnowBall;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockColored;
import net.minecraft.block.StepSound;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MapColor;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.potion.Potion;
import net.minecraft.src.ModLoader;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;

//Mod Name and Stuff
@Mod (modid="DrSideburnsWWMod", name="Winter Warfare", version="1.0.0")
@NetworkMod (clientSideRequired=true, serverSideRequired=false)

public class WinterWarMain {
	
	@Instance ("DrSideburnsWWMod")
	public static WinterWarMain instance;
	
	//Create Things
	
	//Blocks
	public static Block minableIceBlock;
	
	//Tools
	public static ItemIcePick icePick;
	
	//Balls
	public static Item iceBall;
	public static Item rockySnowBall;
	public static Item explodingSnowBall;
	
	//Choosers
	public static ItemChooser chooser;
	public static ItemChooserSnowball chooserSnowball;
	public static ItemChooserIceball chooserIceball;
	public static ItemChooserRockySnowball chooserRockySnowball;
	public static ItemChooserExplodingSnowball chooserExplodingSnowball;
	public static ItemChooserPotato chooserPotato;
	
	//Creative Tabs
	public static CreativeTabs tabWWMod = new CreativeTabs("tabWWMod") {
		public ItemStack getIconItemStack() {
			return new ItemStack(WinterWarMain.icePick.itemID, 1, 0);
		}
	};
	
	//Entity Ids
	private static int iceBallEntityId = 0;
	private static int rockySnowBallEntityId = 1;
	private static int explodingSnowBallEntityId = 2;

	
	@SidedProxy (clientSide="Dr_Sideburns.winterWarMod.client.ClientProxy", serverSide="Dr_Sideburns.winterWarMod.CommonProxy")
	public static CommonProxy proxy;
	//Nothing

	@EventHandler
	public void PreInit (FMLPreInitializationEvent event) {
		proxy.registerRenderers();
		proxy.registerServerTickHandler();
		
		//Define Things
		
		//Define Blocks
		minableIceBlock = new BlockMinableIce(2320).setHardness(0.5F).setLightOpacity(3).setStepSound(Block.soundGlassFootstep).setUnlocalizedName("minableIce").setTextureName("winterwarfare:pickedice");
		
		//Define Tools
		icePick = (ItemIcePick) new ItemIcePick(23220).setUnlocalizedName("icePick").setCreativeTab(this.tabWWMod).setTextureName("winterwarfare:icepick");
		
		//Define Balls
		iceBall = new ItemIceball(23221).setUnlocalizedName("iceBall").setTextureName("winterwarfare:iceball");
		rockySnowBall = new ItemRockySnowBall(23222).setUnlocalizedName("rockySnowBall").setTextureName("winterwarfare:rockysnowball");
		explodingSnowBall = new ItemExplodingSnowball(23223).setUnlocalizedName("explodingSnowball").setTextureName("winterwarfare:explodingsnowball");
		
		//Define Choosers
		chooser = (ItemChooser) new ItemChooser(23224).setUnlocalizedName("chooser").setTextureName("winterwarfare:chooser");
		chooserSnowball = (ItemChooserSnowball) new ItemChooserSnowball(23225).setUnlocalizedName("chooserSnowball").setTextureName("winterwarfare:choosersnowball");
		chooserIceball = (ItemChooserIceball) new ItemChooserIceball(23226).setUnlocalizedName("chooserIceball").setTextureName("winterwarfare:choosericeball");
		chooserRockySnowball = (ItemChooserRockySnowball) new ItemChooserRockySnowball(23227).setUnlocalizedName("chooserRockySnowball").setTextureName("winterwarfare.chooserrockysnowball");
		chooserExplodingSnowball = (ItemChooserExplodingSnowball) new ItemChooserExplodingSnowball(23228).setUnlocalizedName("chooserExplodingSnowball").setTextureName("winterwarfare.chooserexplodingsnowball");
		chooserPotato = (ItemChooserPotato) new ItemChooserPotato(23229).setUnlocalizedName("chooserPotato").setTextureName("winterwarfare:chooserpotato");
	}
	
	@EventHandler
	public void load (FMLInitializationEvent event) {
			
		//Name and Register Things. And Recipes.
		
		//Register Blocks
		GameRegistry.registerBlock(minableIceBlock, "minableIceBlock");
		
		//Name Blocks
		LanguageRegistry.addName(minableIceBlock, "Picked Ice");
		
		//Name Tools
		LanguageRegistry.addName(icePick, "Ice Pick");
		
		//Name Balls
		LanguageRegistry.addName(iceBall, "Ice Ball");
		LanguageRegistry.addName(rockySnowBall, "Rocky Snowball");
		LanguageRegistry.addName(explodingSnowBall, "Exploding Snowball");
		
		//Name Choosers
		LanguageRegistry.addName(chooser, "Projectile Chooser");
		LanguageRegistry.addName(chooserSnowball, "Projectile Chooser: Snowball");
		LanguageRegistry.addName(chooserIceball, "Projectile Chooser: Iceball");
		LanguageRegistry.addName(chooserRockySnowball, "Projectile Chooser: Rocky Snowball");
		LanguageRegistry.addName(chooserExplodingSnowball, "Projectile Chooser: Exploding Snowball");
		LanguageRegistry.addName(chooserPotato, "Projectile Chooser: Potato");
		
		//Name Creative Tabs
		LanguageRegistry.instance().addStringLocalization("itemGroup.tabWWMod", "en_US", "Winter Warfare");
		
		//Crafting Recipes
		GameRegistry.addRecipe(new ItemStack(Block.ice), "xxx", "xxx", "xxx", 'x', new ItemStack(iceBall));
		GameRegistry.addShapelessRecipe(new ItemStack(iceBall, 9), new ItemStack(Block.ice));
		GameRegistry.addRecipe(new ItemStack(icePick), "x", "y", 'x', new ItemStack(Item.ingotIron), 'y', new ItemStack(Item.stick));
		GameRegistry.addRecipe(new ItemStack(rockySnowBall), "x", "xyx", "x", 'x', new ItemStack(Item.snowball), 'y', new ItemStack(Block.cobblestone));
		GameRegistry.addRecipe(new ItemStack(explodingSnowBall), "x", "xyx", "x", 'x', new ItemStack(Item.snowball), 'y', new ItemStack(Block.tnt));
		
		//Register Entities
		EntityRegistry.registerModEntity(EntityIceball.class, "Iceball", ++iceBallEntityId, this, 64, 10, true);
		EntityRegistry.registerModEntity(EntityRockySnowBall.class, "Rocky Snowball", ++rockySnowBallEntityId, this, 64, 10, true);
		EntityRegistry.registerModEntity(EntityExplodingSnowball.class, "Exploding Snowball", ++explodingSnowBallEntityId, this, 64, 10, true);
		
		//Register Renderers
		proxy.registerRenderers();
	}
	
	@EventHandler
	public void postInit (FMLPostInitializationEvent event) {
		//Nothing
	}
}
