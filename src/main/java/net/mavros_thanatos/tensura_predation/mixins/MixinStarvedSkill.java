package net.mavros_thanatos.tensura_predation.mixins;
import com.github.manasmods.manascore.api.skills.ManasSkill;
import com.github.manasmods.tensura.ability.ISpatialStorage;
import com.github.manasmods.tensura.ability.skill.Skill;
import com.github.manasmods.tensura.ability.skill.unique.StarvedSkill;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(StarvedSkill.class)
public abstract class MixinStarvedSkill extends Skill
{
    public MixinStarvedSkill(SkillType type) {
        super(type);
    }
    /**
     * @author
     * @reason
     */
    @Overwrite(remap = false)
    public static boolean canGain(ManasSkill manasSkill) {
        if (!(manasSkill instanceof Skill skill)) {
            return false;
        } else {
            return !skill.getType().equals(SkillType.ULTIMATE);
        }
    }
}
