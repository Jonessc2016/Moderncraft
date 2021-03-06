package mods.moderncraft.common;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class BlockCopperOre extends Block{

	public BlockCopperOre(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	@Override
    public void registerIcons(IconRegister reg){
    this.blockIcon = reg.registerIcon("moderncraft:CopperOre");
	 }
   
    public int idDropped(int par1, Random rand, int par2) {
    return modern.CopperOre.blockID;
    }
}