package com.cosmicgelatin.seasonals.core.data.server.tags;

import com.cosmicgelatin.seasonals.core.Seasonals;
import com.cosmicgelatin.seasonals.core.registry.SeasonalsItems;
import com.teamabnormals.neapolitan.core.other.tags.NeapolitanItemTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class SeasonalsItemTagsProvider extends ItemTagsProvider {

    public SeasonalsItemTagsProvider(DataGenerator pGenerator, BlockTagsProvider pBlockTagsProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(pGenerator, pBlockTagsProvider, Seasonals.MODID, existingFileHelper);
    }

    protected void addTags() {
        tag(NeapolitanItemTags.ICE_CREAM).add(
                SeasonalsItems.PUMPKIN_ICE_CREAM.get(),
                SeasonalsItems.SWEET_BERRY_ICE_CREAM.get(),
                SeasonalsItems.BEETROOT_ICE_CREAM.get()
        );
    }
}
