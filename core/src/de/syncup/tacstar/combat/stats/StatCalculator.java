package de.syncup.tacstar.combat.stats;

public abstract class StatCalculator {

    protected StatSet statSet;

    public StatCalculator(StatSet statSet) {
        this.statSet = statSet;
    }

    public abstract int getHealth();
    public abstract int getMana();
    public abstract float getDodgeChance();
    public abstract float getParryChance();
    public abstract float getMissChance();
    public abstract float getHitChance();
    public abstract int getHaste();
    public abstract float getCriticalChance();
    public abstract float getCriticalEffect();
    public abstract int getSpellPower(SpellSchool spellSchool);
    public abstract int getResistance(SpellSchool spellSchool);

}
