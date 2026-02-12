package com.takoito.ayatakablade.items;

import com.takoito.ayatakablade.SERegister;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import mods.flammpfeil.slashblade.ItemSlashBlade;
import mods.flammpfeil.slashblade.ItemSlashBladeNamed;
import mods.flammpfeil.slashblade.SlashBlade;
import mods.flammpfeil.slashblade.named.event.LoadEvent;
import mods.flammpfeil.slashblade.specialeffect.SpecialEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ItemAyatakaBlade {
    public static String ayataka_name = "flammpfeil.slashblade.named.ayataka";

    @SubscribeEvent
    public void init(LoadEvent.InitEvent event){
        ItemStack customblade = new ItemStack(SlashBlade.bladeNamed,1,0);
        NBTTagCompound tag = new NBTTagCompound();
        customblade.setTagCompound(tag);
        ItemSlashBladeNamed.CurrentItemName.set(tag, ayataka_name);
        ItemSlashBladeNamed.CustomMaxDamage.set(tag,64);
        ItemSlashBlade.setBaseAttackModifier(tag, 4.0F + Item.ToolMaterial.IRON.getDamageVsEntity());
        ItemSlashBlade.TextureName.set(tag, "named/ayataka/ayataka");
        ItemSlashBlade.ModelName.set(tag,"named/muramasa/muramasa");
        ItemSlashBlade.SpecialAttackType.set(tag,0);
        ItemSlashBlade.StandbyRenderType.set(tag, 2);
        ItemSlashBladeNamed.IsDefaultBewitched.set(tag,false);
        SpecialEffects.addEffect(customblade, SERegister.WaveAyataka);
        GameRegistry.registerCustomItemStack(ayataka_name, customblade);
        ItemSlashBladeNamed.NamedBlades.add("flammpfeil.slashblade:" + ayataka_name);
    }
}
