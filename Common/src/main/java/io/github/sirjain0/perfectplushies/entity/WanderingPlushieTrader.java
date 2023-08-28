package io.github.sirjain0.perfectplushies.entity;

import com.google.common.collect.ImmutableMap;
import io.github.sirjain0.perfectplushies.init.BlockInit;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.npc.WanderingTrader;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

public class WanderingPlushieTrader extends WanderingTrader implements GeoEntity {
    public static final Int2ObjectMap<VillagerTrades.ItemListing[]> TRADES = toIntMap(
            ImmutableMap.of(1, BlockInit.plushieBlocks.stream().map(blockRegistryObject -> new VillagerTrades.ItemsForEmeralds(blockRegistryObject.get(), 5, 1, 1, 1)).toArray(VillagerTrades.ItemListing[]::new),
                    2, BlockInit.playerBlocksCommon.stream().map(blockRegistryObject -> new VillagerTrades.ItemsForEmeralds(blockRegistryObject.get(), 10, 1, 1, 1)).toArray(VillagerTrades.ItemListing[]::new),
                    3, BlockInit.playerBlocksRare.stream().map(blockRegistryObject -> new VillagerTrades.ItemsForEmeralds(blockRegistryObject.get(), 15, 1, 1, 1)).toArray(VillagerTrades.ItemListing[]::new),
                    4, BlockInit.playerBlocksEpic.stream().map(blockRegistryObject -> new VillagerTrades.ItemsForEmeralds(blockRegistryObject.get(), 20, 1, 1, 1)).toArray(VillagerTrades.ItemListing[]::new)
            )
    );
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public WanderingPlushieTrader(EntityType<? extends WanderingTrader> $$0, Level $$1) {
        super($$0, $$1);
    }

    private static Int2ObjectMap<VillagerTrades.ItemListing[]> toIntMap(ImmutableMap<Integer, VillagerTrades.ItemListing[]> pMap) {

        return new Int2ObjectOpenHashMap<>(pMap);
    }

    @Override
    protected void updateTrades() {
        VillagerTrades.ItemListing[] commonTrades = TRADES.get(1);
        VillagerTrades.ItemListing[] playerPlushieTrades = TRADES.get(2);
        VillagerTrades.ItemListing[] playerPlushieTradesRare = TRADES.get(3);
        VillagerTrades.ItemListing[] playerPlushieTradesEpic = TRADES.get(4);
        if (commonTrades != null && playerPlushieTrades != null && playerPlushieTradesRare != null && playerPlushieTradesEpic != null) {
            MerchantOffers offers = this.getOffers();
            this.addOffersFromItemListings(offers, commonTrades, 5);
            this.addOffersFromItemListings(offers, playerPlushieTrades, 1);
            this.addOffersFromItemListings(offers, playerPlushieTradesRare, random.nextInt(2));
            if (random.nextFloat() <= 0.1f && playerPlushieTradesEpic.length > 0) {
                int nextInt = this.random.nextInt(playerPlushieTradesEpic.length);
                VillagerTrades.ItemListing itemListing = playerPlushieTradesEpic[nextInt];
                MerchantOffer offer = itemListing.getOffer(this, this.random);
                if (offer != null) {
                    offers.add(offer);
                }
            }
        }
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {

    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
