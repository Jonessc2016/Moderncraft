package mods.moderncraft.common;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid="jonessc2016_moderncraft", name="Moderncraft", version="0.1.5.2.1")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class modern {
	
	@SidedProxy(clientSide="mods.moderncraft.client.clientProxy", serverSide="mods.moderncraft.common.commonProxy")
    public static commonProxy proxy;
	
	
	//Booleans
	public static boolean enableOres;
	public static boolean enableWeapons;
	
	//Machines and their IDs
	public static int WindMillID;
	public static int WaterMillID;
	public static int HighTechOvenID;
	public static int CoalGeneratorID;
	public static Block HighTechOven;
	public static Block CoalGenerator;
	public static Block WindMill;
	public static Block WaterMill;
	
	//Ores and their IDs
	public static int CopperOreID;
	public static int TinOreID;
	public static int SilverOreID;
	public static int LeadOreID;
	public static int TungstenOreID;
	public static int UraniumOreID;
	public static Block CopperOre;
	public static Block TinOre;
	public static Block SilverOre;
	public static Block LeadOre;
	public static Block TungstenOre;
	public static Block UraniumOre;
	
	//Ingots and their IDs
	public static int CopperIngotID;
	public static int TinIngotID;
	public static int SilverIngotID;
	public static int LeadIngotID;
	public static int TungstenIngotID;
	public static int UraniumIngotID;
	public static Item CopperIngot;
	public static Item TinIngot;
	public static Item SilverIngot;
	public static Item LeadIngot;
	public static Item TungstenIngot;
	public static Item UraniumIngot;
	
	//Missiles and their IDs
	public static Item MissileModel;
	public static Item NuclearMissile;
	
	//Benches and their IDs
	public static Block MissileAssemblyTable;
	public static Block SatelliteAssemblyTable;
	public static Block ShipAssemblyTable;
	public static Block SpacecraftAssemblyTable;
	public static Block MissileResearchTable;
	public static Block SatelliteResearchTable;
	public static Block ShipResearchTable;
	public static Block SpacecraftResearchTable;
	public static int MissileAssemblyTableID;
	public static int SatelliteAssemblyTableID;
	public static int ShipAssemblyTableID;
	public static int SpacecraftAssemblyTableID;
	public static int MissileResearchTableID;
	public static int SatelliteResearchTableID;
	public static int ShipResearchTableID;
	public static int SpacecraftResearchTableID;
	
	//Non-modern stuff
	public static Block DirtChest;
	public static int DirtChestID;
	public static Block StoneChest;
	public static int StoneChestID;
	public static Block IronChest;
	public static int IronChestID;
	public static Block DiamondChest;
	public static int DiamondChestID; 
	
	@PreInit
	public void load(FMLPreInitializationEvent event){
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		
		//Block IDs
		CopperOreID = config.get("Block IDs:", "Copper Ore", 3500).getInt();
		TinOreID = config.get("Block IDs", "Tin Ore", 3501).getInt();
		SilverOreID = config.get("Block IDs", "Silver Ore", 3502).getInt();
		LeadOreID = config.get("Block IDs", "Lead Ore", 3503).getInt();
		TungstenOreID = config.get("Block IDs", "Tungsten Ore", 3504).getInt();
		UraniumOreID = config.get("Block IDs", "Uranium Ore", 3505).getInt();
		MissileAssemblyTableID = config.get("Block IDs", "Missile Assembly Table", 3000).getInt();
		SatelliteAssemblyTableID = config.get("Block IDs", "Satellite Assembly Table", 3001).getInt();
		ShipAssemblyTableID = config.get("Block IDs", "Ship Assembly Table", 3002).getInt();
		
		//Item IDs
		CopperIngotID = config.get("Item IDs", "CopperIngot", 10000).getInt();
		TinIngotID = config.get("ItemIDs", "Tin Ingot", 10001).getInt();
		SilverIngotID = config.get("Item IDs", "Silver Ingot", 10002).getInt();
		LeadIngotID = config.get("Item IDs", "Lead Ingot", 10003).getInt();
		TungstenIngotID = config.get("Item IDs", "Tungsten Ingot", 10004).getInt();
		UraniumIngotID = config.get("Item IDs", "Uranium Ingot", 10005).getInt();
		
		config.save();
	}
	
	@Init
	public void load(FMLInitializationEvent event){
		
		CopperOre = (new BlockCopperOre(CopperOreID, Material.rock)).setUnlocalizedName("Copper Ore");
		TinOre = (new BlockTinOre(TinOreID, Material.rock)).setUnlocalizedName("Tin Ore");
		SilverOre = (new BlockSilverOre(SilverOreID, Material.rock)).setUnlocalizedName("Silver Ore");
		LeadOre = (new BlockLeadOre(LeadOreID, Material.rock)).setUnlocalizedName("Lead Ore");
		TungstenOre = (new BlockTungstenOre(TungstenOreID, Material.rock)).setUnlocalizedName("Tungsten Ore");
		UraniumOre = (new BlockUraniumOre(UraniumOreID, Material.rock)).setUnlocalizedName("Uranium Ore");
		
		CopperIngot = (new ItemCopperIngot(CopperIngotID)).setUnlocalizedName("Copper Ingot");
		TinIngot = (new ItemTinIngot(TinIngotID)).setUnlocalizedName("Tin Ingot");
		SilverIngot = (new ItemSilverIngot(SilverIngotID)).setUnlocalizedName("Silver Ingot");
		LeadIngot = (new ItemLeadIngot(LeadIngotID)).setUnlocalizedName("Lead Ingot");
		TungstenIngot = (new ItemTungstenIngot(TungstenIngotID)).setUnlocalizedName("Tungsten Ingot");
		UraniumIngot = (new ItemUraniumIngot(UraniumIngotID)).setUnlocalizedName("Uranium Ingot");
		
		LanguageRegistry.addName(TinOre, "Tin Ore");
		LanguageRegistry.addName(CopperOre, "Copper Ore");
		LanguageRegistry.addName(SilverOre, "Silver Ore");
		LanguageRegistry.addName(LeadOre, "Lead Ore");
		LanguageRegistry.addName(TungstenOre, "Tungsten Ore");
		LanguageRegistry.addName(UraniumOre, "Uranium Ore");
		
		LanguageRegistry.addName(CopperIngot, "Copper Ingot");
		LanguageRegistry.addName(TinIngot, "Tin Ingot");
		LanguageRegistry.addName(SilverIngot, "Silver Ingot");
		LanguageRegistry.addName(LeadIngot, "Lead Ingot");
		LanguageRegistry.addName(TungstenIngot, "Tungsten Ingot");
		LanguageRegistry.addName(UraniumIngot, "Uranium Ingot");
		
		GameRegistry.registerBlock(CopperOre, "Copper Ore" + CopperOre.getUnlocalizedName2());
		GameRegistry.registerBlock(TinOre, "Tin Ore" + TinOre.getUnlocalizedName2());
		GameRegistry.registerBlock(SilverOre, "Silver Ore" + SilverOre.getUnlocalizedName2());
		GameRegistry.registerBlock(LeadOre, "Lead Ore" + LeadOre.getUnlocalizedName2());
		GameRegistry.registerBlock(TungstenOre, "Tungsten Ore" + TungstenOre.getUnlocalizedName2());
		GameRegistry.registerBlock(UraniumOre, "Uranium Ore" + UraniumOre.getUnlocalizedName2());
		
		GameRegistry.addSmelting(CopperOreID, new ItemStack(CopperIngot, 1), 100);
		GameRegistry.addSmelting(TinOreID, new ItemStack(TinIngot, 1), 100);
		GameRegistry.addSmelting(SilverOreID, new ItemStack(SilverIngot, 1), 100);
		GameRegistry.addSmelting(LeadOreID, new ItemStack(LeadIngot, 1), 100);
		GameRegistry.addSmelting(TungstenOreID, new ItemStack(TungstenIngot, 1), 1000);
		GameRegistry.addSmelting(UraniumOreID, new ItemStack(UraniumIngot, 1), 100);
	
		// 0 wood, 1 stone, 2 iron, 3 diamond
        MinecraftForge.setBlockHarvestLevel(TungstenOre, "pickaxe", 2);
        MinecraftForge.setBlockHarvestLevel(UraniumOre, "pickaxe", 2);
        MinecraftForge.setBlockHarvestLevel(LeadOre, "pickaxe", 1);
        MinecraftForge.setBlockHarvestLevel(SilverOre, "pickaxe", 1);
        MinecraftForge.setBlockHarvestLevel(CopperOre, "pickaxe", 1);
        MinecraftForge.setBlockHarvestLevel(TinOre, "pickaxe", 1);
        
        GameRegistry.registerWorldGenerator(new WorldGeneratorModern());
		
	}	
}
