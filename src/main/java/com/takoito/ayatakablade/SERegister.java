package com.takoito.ayatakablade;

import mods.flammpfeil.slashblade.specialeffect.ISpecialEffect;
import mods.flammpfeil.slashblade.specialeffect.SpecialEffects;

public class SERegister {
    public static ISpecialEffect WaveAyataka = SpecialEffects.register(new SEAyataka());
}
