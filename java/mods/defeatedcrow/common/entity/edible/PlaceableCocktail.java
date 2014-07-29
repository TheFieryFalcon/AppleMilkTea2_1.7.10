package mods.defeatedcrow.common.entity.edible;

import mods.defeatedcrow.common.DCsAppleMilk;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class PlaceableCocktail extends PlaceableFoods{
	
	public PlaceableCocktail(World world){
    	super(world);
    }

	public PlaceableCocktail(World world, ItemStack item) {
		super(world, true, item);
	}

	public PlaceableCocktail(World world, ItemStack item,
			double x, double y, double z) {
		super(world, true, item, x, y, z);
	}

	@Override
	protected ItemStack returnItem() {
		return new ItemStack(DCsAppleMilk.cocktail, 1, this.getItemMetadata());
	}

}
