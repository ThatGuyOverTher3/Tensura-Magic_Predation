package net.mavros_thanatos.tensura_predation.mixins;

import com.github.manasmods.manascore.api.skills.ManasSkill;
import com.github.manasmods.tensura.ability.skill.Skill;
import com.github.manasmods.tensura.entity.magic.breath.PredatorMistProjectile;
import com.github.manasmods.manascore.api.skills.ManasSkillInstance;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(PredatorMistProjectile.class)
public class MixinPredatorMistProjectile
{
    /*public MixinPredatorMistProjectile(EntityType<? extends MixinPredatorMistProjectile> entityType, Level level) {
        super(entityType, level);
        this.setNoGravity(true);
    }

    public MixinPredatorMistProjectile(Level level, LivingEntity entity) {
        this((EntityType)TensuraEntityTypes.PREDATOR_MIST.get(), level);
        this.setOwner(entity);
    }*/


    //method = "canDevour", at = @At(value = "INVOKE", target = "Lcom/github/manasmods/tensura/entity/magic/breath/PredatorMistProjectile;canDevour(Lcom/github/manasmods/manascore/api/skills/ManasSkillInstance;)Z")
    //@Redirect(method = "canDevour", at = @At(value = "INVOKE", target = "Lcom/github/manasmods/tensura/entity/magic/breath/PredatorMistProjectile;canDevour(Lcom/github/manasmods/manascore/api/skills/ManasSkillInstance;)Z"))
    @Inject(method = {"canDevour"}, at = {@At("RETURN")}, cancellable = true, remap = false)
    public void DevorUnique(ManasSkillInstance instance, CallbackInfoReturnable<Boolean> cir)
    {
        ManasSkill var3 = instance.getSkill();
        if (var3 instanceof Skill devouredSkill) {
            if (!devouredSkill.getType().equals(Skill.SkillType.INTRINSIC) && !devouredSkill.getType().equals(Skill.SkillType.COMMON) && !devouredSkill.getType().equals(Skill.SkillType.EXTRA) && !devouredSkill.getType().equals(Skill.SkillType.RESISTANCE) && !devouredSkill.getType().equals(Skill.SkillType.UNIQUE)) {
                cir.setReturnValue(false);
            } else {
                cir.setReturnValue(true);
            }
        }else
        {
            cir.setReturnValue(false);
        }
    }

    /*@Overwrite(remap = false)
    protected boolean canDevour(ManasSkillInstance instance) {
        if (!instance.isTemporarySkill() && instance.getMastery() >= 0) {
            if (instance.getSkill() == this.getSkill().getSkill()) {
                return false;
            } else if (instance.getSkill() == UniqueSkills.STARVED.get()) {
                return true;
            } else {
                ManasSkill var3 = instance.getSkill();
                if (!(var3 instanceof Skill)) {
                    return false;
                } else {
                    Skill devouredSkill = (Skill)var3;
                    return devouredSkill.getType().equals(Skill.SkillType.INTRINSIC) || devouredSkill.getType().equals(Skill.SkillType.COMMON) || devouredSkill.getType().equals(Skill.SkillType.EXTRA) || devouredSkill.getType().equals(Skill.SkillType.RESISTANCE) || devouredSkill.getType().equals(Skill.SkillType.UNIQUE);
                }
            }
        } else {
            return false;
        }
    }

    */



}
