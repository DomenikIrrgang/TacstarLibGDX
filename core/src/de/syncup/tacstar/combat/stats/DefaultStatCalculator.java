package de.syncup.tacstar.combat.stats;

public class DefaultStatCalculator implements StatCalculator {

    @Override
    public int getHealth(StatSet statSet) {
        return 100 + statSet.getStat(Stat.HEALTH) + statSet.getStat(Stat.STAMINA) * 10;
    }

    @Override
    public float getDodgeChance(StatSet statSet) {
        return 5f + (statSet.getStat(Stat.DODGE) + statSet.getStat(Stat.DEFENSE) * 0.25f + statSet.getStat(Stat.AGILITY) * 0.25f) / 20f;
    }

    @Override
    public float getParryChance(StatSet statSet) {
        return 5f + (statSet.getStat(Stat.PARRY) + statSet.getStat(Stat.DEFENSE) * 0.25f) / 20f;
    }

    @Override
    public float getMissChance(StatSet statSet) {
        return 5f + statSet.getStat(Stat.AVOIDANCE);
    }

    @Override
    public float getHitChance(StatSet statSet) {
        return (statSet.getStat(Stat.HIT) + statSet.getStat(Stat.INTELLECT) * 0.25f) / 20f;
    }

    @Override
    public int getHaste(StatSet statSet) {
        return statSet.getStat(Stat.HASTE) + statSet.getStat(Stat.AGILITY) / 2;
    }

    @Override
    public float getCriticalChance(StatSet statSet) {
        return 5f + (statSet.getStat(Stat.CRIT) + statSet.getStat(Stat.INTELLECT) * 0.25f) / 20f;
    }

    @Override
    public float getCriticalEffect(StatSet statSet) {
        return 100f + (statSet.getStat(Stat.CRITICAL_EFFECT) + statSet.getStat(Stat.AGILITY) * 0.1f) / 20f;
    }

    @Override
    public int getSpellPower(SpellSchool spellSchool, StatSet statSet) {
        return statSet.getStat(Stat.SPELL_POWER) + statSet.getStat(spellSchool.getScalingStat());
    }

    @Override
    public int getResistance(SpellSchool spellSchool, StatSet statSet) {
        return statSet.getStat(spellSchool.getResistanceStat());
    }

}
