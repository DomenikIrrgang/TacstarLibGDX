package de.syncup.tacstar.combat;

import de.syncup.tacstar.combat.abilities.Ability;
import de.syncup.tacstar.combat.resources.ResourceType;
import de.syncup.tacstar.combat.units.Unit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combat {

    protected List<Unit> playerGroup;
    protected List<Unit> enemyGroup;
    protected CombatCalculator calculator;

    protected int round;
    protected List<CombatAction> actions;

    public Combat(CombatCalculator calculator, List<Unit> playerGroup, List<Unit> enemyGroup) {
        this.playerGroup = playerGroup;
        this.enemyGroup = enemyGroup;
        this.calculator = calculator;
        this.init();
    }

    public List<AbilityCastResult> calculateRound() {
        List<AbilityCastResult> results = new ArrayList<>();
        while (this.actions.size() > 0) {
            CombatAction action = this.findFastestCombatAction();
            this.actions.remove(action);
            results.addAll(this.castAbility(action.ability, action.source, action.target));
        }
        this.round += 1;
        return results;
    }

    public void addCombatAction(Ability ability, Unit source, Unit target) {
        this.actions.add(new CombatAction(ability, source, target));
    }

    public List<AbilityCastResult> castAbility(Ability ability, Unit source, Unit target) {
        List<AbilityCastResult> results = new ArrayList<>();
        if (this.calculator.abilityCastable(ability, source)) {
            source.reduceResource(ability.getResourceType(), this.calculator.getAbilityCost(ability, source));
            for (Unit unit : this.getAbilityTargets(ability, source, target)) {
                AbilityCastResult result = new AbilityCastResult(ability, source, unit);
                if (this.calculator.abilityReflect(result.ability, result.source, result.target)) {
                    result.target = result.source;
                }
                result.abilityHitType = this.abilityHit(result.ability, result.source, result.target);
                if (result.abilityHitType.equals(AbilityHitType.LANDED) || result.abilityHitType.equals(AbilityHitType.CRITICAL)) {
                    result.abilityValue = this.calculator.getAbilityValue(result.ability, result.source, result.target, result.abilityHitType.equals(AbilityHitType.CRITICAL));
                    result.resistAmount = this.calculator.getResistAmount(result.abilityValue, result.source, result.target);
                    result.target.reduceResource(ResourceType.HEALTH, result.getActualAbilityValue());
                    result.ability.execute(this, result.source, result.target);
                }
                results.add(result);
            }
        }
        return results;
    }

    private AbilityHitType abilityHit(Ability ability, Unit source, Unit target) {
        if (this.calculator.abilityHit(ability, source, target))
            return AbilityHitType.MISSED;
        if (this.calculator.abilityDodge(ability, source, target))
            return AbilityHitType.DODGED;
        if (this.calculator.abilityParry(ability, source, target))
            return AbilityHitType.PARRIED;
        if (this.calculator.abilityCrit(ability, source, target))
            return AbilityHitType.CRITICAL;
        return AbilityHitType.LANDED;
    }

    private List<Unit> getAbilityTargets(Ability ability, Unit source, Unit target) {
        switch(ability.getTargetType()) {
            case SINGLE:
                return Arrays.asList(target);
            case GROUP:
                return this.getUnitsGroup(target);
            case AOE:
                List<Unit> result = new ArrayList<>(this.playerGroup);
                result.addAll(this.enemyGroup);
                return result;
            default:
                return new ArrayList<>();
        }
    }

    private List<Unit> getUnitsGroup(Unit unit) {
        return (this.playerGroup.contains(unit)) ? this.playerGroup : this.enemyGroup;
    }

    private CombatAction findFastestCombatAction() {
        CombatAction result = this.actions.get(0);
        for (CombatAction combatAction : this.actions) {
            if (combatAction.source.statCalculator.getHaste() > result.source.statCalculator.getHaste())
                result = combatAction;
        }
        return result;
    }

    public int getRound() {
        return this.round;
    }

    public List<Unit> getPlayerGroup() {
        return this.playerGroup;
    }

    public List<Unit> getEnemyGroup() {
        return this.enemyGroup;
    }

    public void setCalculator(CombatCalculator calculator) {
        this.calculator = calculator;
    }

    public void init() {
        this.actions = new ArrayList<>();
        this.round = 1;
    }
}
