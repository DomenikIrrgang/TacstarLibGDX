package de.syncup.tacstar.combat;

import de.syncup.tacstar.combat.abilities.Ability;
import de.syncup.tacstar.combat.units.Unit;

import java.util.ArrayList;
import java.util.List;

public class Combat {

    protected int round;

    protected List<Unit> playerGroup = new ArrayList<>();
    protected List<Unit> enemyGroup = new ArrayList<>();

    protected List<CombatAction> actions;
    protected CombatCalculator calculator;

    public void calculateRound() {
        while (this.actions.size() > 0) {
            CombatAction action = this.findFastestCombatAction();
            this.actions.remove(action);
            if (this.calculator.abilityCastable(action.ability, action.source)) {
                this.castAbility(action.ability, action.source, action.target);
            }
        }
        this.round += 1;
    }

    public void castAbility(Ability ability, Unit source, Unit target) {

    }

    private CombatAction findFastestCombatAction() {
        CombatAction result = this.actions.get(0);
        for (CombatAction combatAction : this.actions) {
            if (combatAction.source.statCalculator.getHaste(combatAction.source.getStats()) >result.source.statCalculator.getHaste(result.source.getStats()))
                result = combatAction;
        }
        return result;
    }

    public void init() {
        this.actions = new ArrayList<>();
        this.round = 1;
    }
}
