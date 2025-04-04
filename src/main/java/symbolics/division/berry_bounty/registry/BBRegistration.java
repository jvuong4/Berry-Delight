package symbolics.division.berry_bounty.registry;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class BBRegistration {
    public static void init() {
        BBItems.init();
        BBEffects.init();
        BBBlocks.init();

        Registry.register(Registries.ITEM_GROUP, BBItems.ITEM_GROUP_KEY, BBItems.ITEM_GROUP);

        ItemGroupEvents.modifyEntriesEvent(BBItems.ITEM_GROUP_KEY).register(
                group -> {
                    BBItems.getAllItems().forEach(group::add);
                    BBBlocks.getAllBlockItems().forEach(group::add);
                }
        );
    }
}
