package de.syncup.tacstar.combat.abilities;

import de.syncup.tacstar.combat.Combat;
import de.syncup.tacstar.combat.resources.ResourceType;
import de.syncup.tacstar.combat.units.Unit;

import java.lang.annotation.Target;

public class Fireball extends Ability {

    public Fireball() {
        super("Fireball", 0);
    }

    @Override
    public String getTooltip() {
        return "Sends a fireball to the target that will inflict fire damage.";
    }

    @Override
    public boolean canCrit() {
        return true;
    }

    @Override
    public float getCriticalChance() {
        return 0;
    }

    @Override
    public float getCriticalEffect() {
        return 0;
    }

    @Override
    public boolean canMiss() {
        return true;
    }

    @Override
    public float getMissChance() {
        return 0;
    }

    @Override
    public boolean isReflectable() {
        return true;
    }

    @Override
    public boolean canBeDodged() {
        return true;
    }

    @Override
    public boolean canBeParried() {
        return false;
    }

    @Override
    public boolean canBeResisted() {
        return true;
    }

    @Override
    public ResourceType getResourceType() {
        return ResourceType.MANA;
    }

    @Override
    public int getResourceCost() {
        return 10;
    }

    @Override
    public TargetType getTargetType() {
        return TargetType.SINGLE;
    }

    @Override
    public int getAbilityValue(Unit source, Unit target) {
        return 10;
    }

    @Override
    public void execute(Combat combat, Unit source, Unit target) {
        System.out.println("Fireball executed!");
    }
}
