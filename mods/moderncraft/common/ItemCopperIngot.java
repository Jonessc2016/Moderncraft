package mods.moderncraft.common;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemCopperIngot extends Item{

	public ItemCopperIngot(int par1) {
		super(par1);
		// TODO Auto-generated constructor stub
	}
	
	@Override
    public void registerIcons(IconRegister reg){
    this.itemIcon = reg.registerIcon("moderncraft:CopperIngot");
	 }

}
