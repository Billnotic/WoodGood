package net.mehvahdjukaar.every_compat.modules.forge.tetra_tables;

import moonfather.tetra_tables.blocks.TetraTable;
import moonfather.tetra_tables.initialization.Registration;
import net.mehvahdjukaar.every_compat.EveryCompat;
import net.mehvahdjukaar.every_compat.api.SimpleEntrySet;
import net.mehvahdjukaar.every_compat.api.SimpleModule;
import net.mehvahdjukaar.moonlight.api.set.wood.WoodType;
import net.mehvahdjukaar.moonlight.api.set.wood.WoodTypeRegistry;
import net.mehvahdjukaar.moonlight.api.util.Utils;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;

import static moonfather.tetra_tables.initialization.Registration.TETRA_TABLE_BE;

public class TetraTablesModule extends SimpleModule{

    public final SimpleEntrySet<WoodType, Block> tetra_table;

    public TetraTablesModule(String modId) {
        super(modId, "ttln"); // <- add an shortened ID for the name of mod

        tetra_table = SimpleEntrySet.builder(WoodType.class, "", "tetra_table", // Need to have ID of the blockTYPE
                        getModBlock("tetra_table_oak"),
                        () -> WoodTypeRegistry.OAK_TYPE, // "blankBlock" need to be the full ID of the block like "oak_chair"
                        w -> new TetraTable(Utils.copyPropertySafe(w.planks))
                )
                // Add .addTexture() or .addTextureM() <- one for image and one for mask texture
                .setTabKey(modRes("default"))// must be included
                .addTile(getModTile("tetra_table_be"))
                .addTexture(modRes("block/oak_crafting_table_top"))
                .addTexture(modRes("block/oak_crafting_table_side"))
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .defaultRecipe()
                .build();
        this.addEntry(tetra_table);


    }
}