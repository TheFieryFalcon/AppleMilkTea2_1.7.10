package mods.defeatedcrow.common.item.magic;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.defeatedcrow.api.charm.EffectType;
import mods.defeatedcrow.api.charm.IIncenseEffect;
import mods.defeatedcrow.client.particle.EntityDCCloudFX;
import mods.defeatedcrow.client.particle.ParticleTex;
import mods.defeatedcrow.common.AMTLogger;
import mods.defeatedcrow.common.config.DCsConfig;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

// 採掘速度上昇のインセンス
public class ItemIncenseMint extends Item implements IIncenseEffect {

	public ItemIncenseMint() {
		super();
		this.setMaxStackSize(64);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {

		this.itemIcon = par1IconRegister.registerIcon("defeatedcrow:incense_mint");
	}

	/*
	 * 以下はIncenseの効果を定義する部分。
	 * Item側に実装したほうが追加が容易だと思う。
	 */

	@Override
	public int effectAreaRange() {
		return 5;
	}

	@Override
	public EffectType getEffectType() {
		return EffectType.Player;
	}

	@Override
	public boolean formEffect(World world, int x, int y, int z, EntityLivingBase entity, IIncenseEffect incense) {

		if (incense.getEffectType() == this.getEffectType() && entity != null) {
			if (!entity.isPotionActive(Potion.digSpeed.id)) {
				entity.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 200, 0));
				return true;
			}
		}
		return false;
	}

	@Override
	public String particleIcon() {
		return "blink";
	}

	@Override
	public float particleColorR() {
		return 0.0F;
	}

	@Override
	public float particleColorG() {
		return 1.0F;
	}

	@Override
	public float particleColorB() {
		return 0.8F;
	}

}
