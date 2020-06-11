package de.syncup.tacstar.combat.stats;

public interface StatCalculator {

    public int getHealth(StatSet statSet);
    public float getDodgeChance(StatSet statSet);
    public float getParryChance(StatSet statSet);
    public float getMissChance(StatSet statSet);
    public float getHitChance(StatSet statSet);
    public int getHaste(StatSet statSet);
    public float getCriticalChance(StatSet statSet);
    public float getCriticalEffect(StatSet statSet);
    public int getSpellPower(SpellSchool spellSchool, StatSet statSet);
    public int getResistance(SpellSchool spellSchool, StatSet statSet);

}
