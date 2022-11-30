package com.gempukku.swccgo.cards.set601.light;

import com.gempukku.swccgo.cards.AbstractRepublic;
import com.gempukku.swccgo.common.ExpansionSet;
import com.gempukku.swccgo.common.Icon;
import com.gempukku.swccgo.common.Rarity;
import com.gempukku.swccgo.common.Side;
import com.gempukku.swccgo.common.Title;
import com.gempukku.swccgo.common.Uniqueness;
import com.gempukku.swccgo.filters.Filters;
import com.gempukku.swccgo.game.PhysicalCard;
import com.gempukku.swccgo.game.SwccgGame;
import com.gempukku.swccgo.logic.modifiers.AddsPowerToPilotedBySelfModifier;
import com.gempukku.swccgo.logic.modifiers.ImmuneToAttritionLessThanModifier;
import com.gempukku.swccgo.logic.modifiers.ImmuneToTitleModifier;
import com.gempukku.swccgo.logic.modifiers.ManeuverModifier;
import com.gempukku.swccgo.logic.modifiers.MayMoveOtherCardsAsReactToLocationForFreeModifier;
import com.gempukku.swccgo.logic.modifiers.Modifier;

import java.util.LinkedList;
import java.util.List;


/**
 * Set: Block 6
 * Type: Character
 * Subtype: Republic
 * Title: Jedi Pilot
 */
public class Card601_171 extends AbstractRepublic {
    public Card601_171() {
        super(Side.LIGHT, 1, 4, 2, 6, 6, "Jedi Pilot", Uniqueness.RESTRICTED_3, ExpansionSet.LEGACY, Rarity.V);
        setLore("");
        setGameText("Adds 2 to power of anything he pilots.  Matching pilot for Republic Starfighter.  [Republic] starships he pilots are maneuver +2, may move as a 'react' for free, and are immune to Lateral Damage and attrition < 5.");
        addIcons(Icon.DEATH_STAR_II, Icon.EPISODE_I, Icon.PILOT, Icon.WARRIOR, Icon.LEGACY_BLOCK_6);
        setMatchingStarshipFilter(Filters.title("Republic Starfighter"));
        setAsLegacy(true);
    }

    @Override
    protected List<Modifier> getGameTextWhileActiveInPlayModifiers(SwccgGame game, final PhysicalCard self) {
        List<Modifier> modifiers = new LinkedList<>();
        modifiers.add(new AddsPowerToPilotedBySelfModifier(self, 2));
        modifiers.add(new ManeuverModifier(self, Filters.and(Filters.Republic_starship, Filters.hasPiloting(self)), 2));
        modifiers.add(new MayMoveOtherCardsAsReactToLocationForFreeModifier(self, "Move as a 'react' for free", self.getOwner(), Filters.and(Filters.Republic_starship, Filters.hasPiloting(self)), Filters.any));
        modifiers.add(new ImmuneToTitleModifier(self, Filters.and(Filters.Republic_starship, Filters.hasPiloting(self)), Title.Lateral_Damage));
        modifiers.add(new ImmuneToAttritionLessThanModifier(self, Filters.and(Filters.Republic_starship, Filters.hasPiloting(self)), 5));
        return modifiers;
    }
}
