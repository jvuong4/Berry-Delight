package symbolics.division.berry_bounty.registry;

import net.fabricmc.api.ModInitializer;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import symbolics.division.berry_bounty.BerryBounty;
import symbolics.division.berry_bounty.pie.PieBlock;

public final class BBBlocks {
    public static final Block PIE_BLOCK = register(new PieBlock(AbstractBlock.Settings.copy(Blocks.CAKE), BBItems.CONVECTION_PIE_SLICE), "convection_pie", true);

    public static Block register(Block block, String name, boolean shouldRegisterItem) {
        // Register the block and its item.
        Identifier id = Identifier.of(BerryBounty.MOD_ID, name);

        // Sometimes, you may not want to register an item for the block.
        // Eg: if it's a technical block like `minecraft:air` or `minecraft:end_gateway`
        if (shouldRegisterItem) {
            BlockItem blockItem = new BlockItem(block, new Item.Settings());
            Registry.register(Registries.ITEM, id, blockItem);
        }

        return Registry.register(Registries.BLOCK, id, block);
    }

    //@Override
    public void onInitialize() {
        //init();
    }

    public static void init() {}
}
