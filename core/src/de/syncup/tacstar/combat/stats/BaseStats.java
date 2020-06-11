package de.syncup.tacstar.combat.stats;

public class BaseStats extends StatSet {

    public BaseStats(int level) {
        this.setStat(Stat.HEALTH, 20 * level);
        this.setStat(Stat.AGILITY, level);
        this.setStat(Stat.INTELLECT, level);
        this.setStat(Stat.STAMINA, level);
        this.setStat(Stat.DEFENSE, level);
    }

}
