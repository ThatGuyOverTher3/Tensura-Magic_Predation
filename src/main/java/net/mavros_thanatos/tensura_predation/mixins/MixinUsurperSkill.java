package net.mavros_thanatos.tensura_predation.mixins;

import com.github.manasmods.manascore.api.skills.ManasSkill;
import com.github.manasmods.manascore.api.skills.ManasSkillInstance;
import com.github.manasmods.tensura.ability.magic.spiritual.SpiritualMagic;
import com.github.manasmods.tensura.ability.skill.Skill;
import com.github.manasmods.tensura.ability.skill.unique.UsurperSkill;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(UsurperSkill.class)
public class MixinUsurperSkill {
    /**
     * @author
     * @reason
     */
    @Overwrite(remap = false)
    public boolean canCopy(ManasSkillInstance instance) {
        if (!instance.isTemporarySkill() && instance.getMastery() >= 0) {
            ManasSkill var3 = instance.getSkill();
            if (!(var3 instanceof Skill)) {
                return !(instance.getSkill() instanceof SpiritualMagic);
            } else {
                Skill skill = (Skill)var3;
                return skill.getType().equals(Skill.SkillType.COMMON) || skill.getType().equals(Skill.SkillType.EXTRA) || skill.getType().equals(Skill.SkillType.INTRINSIC) || skill.getType().equals(Skill.SkillType.UNIQUE);
            }
        } else {
            return false;
        }
    }
}
