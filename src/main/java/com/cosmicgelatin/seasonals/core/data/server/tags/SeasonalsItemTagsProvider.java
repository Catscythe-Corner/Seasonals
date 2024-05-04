package com.cosmicgelatin.seasonals.core.data.server.tags;

import com.cosmicgelatin.seasonals.core.Seasonals;
import com.cosmicgelatin.seasonals.core.registry.SeasonalsItems;
import com.teamabnormals.neapolitan.core.other.tags.NeapolitanItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class SeasonalsItemTagsProvider extends ItemTagsProvider {

    public SeasonalsItemTagsProvider(PackOutput pGenerator, CompletableFuture<HolderLookup.Provider> pLookupProvider, CompletableFuture<TagsProvider.TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(pGenerator, pLookupProvider, pBlockTags, Seasonals.MODID, existingFileHelper);
    }

    protected void addTags(HolderLookup.Provider provider) {
        tag(NeapolitanItemTags.ICE_CREAM).add(
                SeasonalsItems.PUMPKIN_ICE_CREAM.get(),
                SeasonalsItems.SWEET_BERRY_ICE_CREAM.get(),
                SeasonalsItems.BEETROOT_ICE_CREAM.get()
        );
    }
}
