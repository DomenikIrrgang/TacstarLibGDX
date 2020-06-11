package de.syncup.tacstar.combat.stats;

public enum SpellSchool {
    PHYSICAL(Stat.ATTACK_POWER, Stat.ARMOR),
    FIRE(Stat.FIRE_SPELL_POWER, Stat.FIRE_RESISTANCE),
    FROST(Stat.FROST_SPELL_POWER, Stat.FROST_RESISTANCE),
    WIND(Stat.WIND_SPELL_POWER, Stat.WIND_RESISTANCE),
    EARTH(Stat.EARTH_SPELL_POWER, Stat.EARTH_RESISTANCE),
    LIGHT(Stat.LIGHT_SPELL_POWER, Stat.LIGHT_RESISTANCE),
    SHADOW(Stat.SHADOW_SPELL_POWER, Stat.SHADOW_RESISTANCE),
    NATURE(Stat.NATURE_SPELL_POWER, Stat.NATURE_RESISTANCE),
    WATER(Stat.WATER_SPELL_POWER, Stat.WATER_RESISTANCE),
    THUNDER(Stat.THUNDER_SPELL_POWER, Stat.THUNDER_RESISTANCE),
    GRAVITY(Stat.GRAVITY_SPELL_POWER, Stat.GRAVITY_RESISTANCE);

    private Stat scalingStat;
    private Stat resistanceStat;

    private SpellSchool(Stat scalingStat, Stat resistanceStat) {
        this.scalingStat = scalingStat;
        this.resistanceStat = resistanceStat;
    }

    public Stat getResistanceStat() {
        return this.resistanceStat;
    }

    public Stat getScalingStat() {
        return this.scalingStat;
    }
}
