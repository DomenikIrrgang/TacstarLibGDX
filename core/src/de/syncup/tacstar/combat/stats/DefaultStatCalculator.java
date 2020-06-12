package de.syncup.tacstar.combat.stats;

public class DefaultStatCalculator extends StatCalculator {

    public DefaultStatCalculator(StatSet statSet) {
        super(statSet);
    }

    @Override
    public int getHealth() {
        return statSet.getStat(Stat.HEALTH) + statSet.getStat(Stat.STAMINA) * 10;
    }

    @Override
    public int getMana() {
        return statSet.getStat(Stat.MANA) + statSet.getStat(Stat.INTELLECT) * 10;
    }

    @Override
    public float getDodgeChance() {
        return (statSet.getStat(Stat.DODGE) + statSet.getStat(Stat.DEFENSE) * 0.25f + statSet.getStat(Stat.AGILITY) * 0.25f) / 20f;
    }

    @Override
    public float getParryChance() {
        return (statSet.getStat(Stat.PARRY) + statSet.getStat(Stat.DEFENSE) * 0.25f) / 20f;
    }

    @Override
    public float getMissChance() {
        return 5f + statSet.getStat(Stat.AVOIDANCE);
    }

    @Override
    public float getHitChance() {
        return (statSet.getStat(Stat.HIT) + statSet.getStat(Stat.INTELLECT) * 0.25f) / 20f;
    }

    @Override
    public int getHaste() {
        return statSet.getStat(Stat.HASTE) + statSet.getStat(Stat.AGILITY) / 2;
    }

    @Override
    public float getCriticalChance() {
        return (statSet.getStat(Stat.CRIT) + statSet.getStat(Stat.INTELLECT) * 0.25f) / 20f;
    }

    @Override
    public float getCriticalEffect() {
        return (statSet.getStat(Stat.CRITICAL_EFFECT) + statSet.getStat(Stat.AGILITY) * 0.1f) / 20f;
    }

    @Override
    public int getSpellPower(SpellSchool spellSchool) {
        return statSet.getStat(Stat.SPELL_POWER) + statSet.getStat(spellSchool.getScalingStat());
    }

    @Override
    public int getResistance(SpellSchool spellSchool) {
        return statSet.getStat(spellSchool.getResistanceStat());
    }

}
