package io.github.sirjain0.perfectplushies.client.renderer;

import io.github.sirjain0.perfectplushies.Constants;
import io.github.sirjain0.perfectplushies.entity.WanderingPlushieTrader;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.npc.AbstractVillager;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class WanderingPlushieTraderRenderer extends GeoEntityRenderer<WanderingPlushieTrader> {
    public WanderingPlushieTraderRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DefaultedEntityGeoModel<>(new ResourceLocation(Constants.MODID, "wandering_plushie_trader"), true){
            @Override
            public void setCustomAnimations(WanderingPlushieTrader animatable, long instanceId, AnimationState<WanderingPlushieTrader> animationState) {
                CoreGeoBone head = getAnimationProcessor().getBone("head");
                CoreGeoBone rightLeg = getAnimationProcessor().getBone("right_leg");
                CoreGeoBone leftLeg = getAnimationProcessor().getBone("left_leg");
                EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
                float pLimbSwing = animationState.getLimbSwing();
                float pLimbSwingAmount = animationState.getLimbSwingAmount();
                float pAgeInTicks = animatable.getAge();

                boolean flag = false;
                if (animatable != null) {
                    flag = animatable.getUnhappyCounter() > 0;
                }
                head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
                head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
                if (flag) {
                    head.setRotZ(0.3F * Mth.sin(0.45F * pAgeInTicks));
                    head.setRotX(0.4F);
                } else {
                    head.setRotZ(0.0F);
                }

                rightLeg.setRotX(Mth.cos(pLimbSwing * 0.6662F) * 1.4F * pLimbSwingAmount * 0.5F);
                leftLeg.setRotX(Mth.cos(pLimbSwing * 0.6662F + (float)Math.PI) * 1.4F * pLimbSwingAmount * 0.5F);
                rightLeg.setRotY(0.0F);
                leftLeg.setRotY(0.0F);
            }
        });
    }
}
