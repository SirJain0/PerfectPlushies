package io.github.sirjain0.perfectplushies.block.entity;

import io.github.sirjain0.perfectplushies.init.BlockInit;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

public class TestPlushieBlockEntity extends BlockEntity implements GeoBlockEntity {

    private int red1;
    private int green1;
    private int blue1;
    private int red2;
    private int green2;
    private int blue2;
    private AnimatableInstanceCache animatableManager = GeckoLibUtil.createInstanceCache(this);

    public TestPlushieBlockEntity(BlockPos pos, BlockState state) {
        super(BlockInit.TEST_PLUSHIE_BLOCK_ENTITY.get(), pos, state);
        if(level!=null){
            red1 = level.random.nextInt(255);
            green1 = level.random.nextInt(255);
            blue1 = level.random.nextInt(255);
            red2 = level.random.nextInt(255);
            green2 = level.random.nextInt(255);
            blue2 = level.random.nextInt(255);
        }
    }

    @Override
    public void load(CompoundTag tag) {
        loadData(tag);
        super.load(tag);
    }

    private void loadData(CompoundTag tag) {
        red1 = tag.getInt("red1");
        green1 = tag.getInt("green1");
        blue1 = tag.getInt("blue1");
        red2 = tag.getInt("red2");
        green2 = tag.getInt("green2");
        blue2 = tag.getInt("blue2");
    }

    public int getRed1() {
        return red1;
    }

    public int getGreen1() {
        return green1;
    }

    public int getBlue1() {
        return blue1;
    }

    public int getRed2() {
        return red2;
    }

    public int getGreen2() {
        return green2;
    }

    public int getBlue2() {
        return blue2;
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);
        saveData(pTag);
    }

    private void saveData(CompoundTag pTag) {
        pTag.putInt("red1", red1);
        pTag.putInt("green1", green1);
        pTag.putInt("blue1", blue1);
        pTag.putInt("red2", red2);
        pTag.putInt("green2", green2);
        pTag.putInt("blue2", blue2);
    }

    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag tag = new CompoundTag();
        saveData(tag);
        return tag;
    }

    public void setRandomColor(){
        red1 = level.random.nextInt(255);
        green1 = level.random.nextInt(255);
        blue1 = level.random.nextInt(255);
        red2 = level.random.nextInt(255);
        green2 = level.random.nextInt(255);
        blue2 = level.random.nextInt(255);
        updateBlock();
    }
    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    public void updateBlock() {
        BlockState blockState = level.getBlockState(this.getBlockPos());
        this.level.sendBlockUpdated(this.getBlockPos(), blockState, blockState, 3);
        this.setChanged();
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {

    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return animatableManager;
    }
}
