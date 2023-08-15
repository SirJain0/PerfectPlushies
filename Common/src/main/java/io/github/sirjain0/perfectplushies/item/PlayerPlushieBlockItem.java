package io.github.sirjain0.perfectplushies.item;

import com.mojang.blaze3d.platform.InputConstants;
import io.github.sirjain0.perfectplushies.block.PlayerPlushieBlock;
import io.github.sirjain0.perfectplushies.init.ItemInit;
import io.github.sirjain0.perfectplushies.platform.Services;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.glfw.GLFW;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class PlayerPlushieBlockItem extends BlockItem implements GeoItem, NeededForML {

    private final AnimatableInstanceCache animatableInstanceCache = GeckoLibUtil.createInstanceCache(this);
    public PlayerPlushieBlockItem(Block block, Rarity isRare){
        super(block, ItemInit.getItemProperties().rarity(isRare));
    }
    public PlayerPlushieBlockItem(Block block) {
        this(block, Rarity.COMMON);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {

    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, level, tooltip, flag);
        if(flag.isAdvanced() || InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), GLFW.GLFW_KEY_LEFT_SHIFT)) {
            Arrays.stream(Component.translatable("plushie.description." + BuiltInRegistries.ITEM.getKey(stack.getItem()).getPath()).getString().split("\n")).forEach(
                    s -> tooltip.add(Component.literal(s).withStyle(ChatFormatting.AQUA))
            );
        } else {
            tooltip.add(Component.translatable("tooltip.perfectplushies.advanced",Component.translatable("tooltip.perfectplushies.shift").withStyle(ChatFormatting.YELLOW)));
        }
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return animatableInstanceCache;
    }

    public Supplier<Object> getRenderProvider() {
        return Services.PLATFORM.getRenderProvider(this);
    }

    public void createRenderer(Consumer<Object> consumer) {
        Services.PLATFORM.registerFabricRenderer(consumer);
    }
}
