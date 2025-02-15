package com.copycatsplus.copycats;

import com.simibubi.create.content.decoration.copycat.CopycatBlockEntity;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.BlockEntityEntry;

public class CCBlockEntityTypes {
    private static final CreateRegistrate REGISTRATE = Copycats.getRegistrate();

    public static final BlockEntityEntry<CopycatBlockEntity> COPYCAT =
            REGISTRATE.blockEntity("copycat", CopycatBlockEntity::new)
                    .validBlocks(
                            CCBlocks.COPYCAT_BLOCK,
                            CCBlocks.COPYCAT_SLAB,
                            CCBlocks.COPYCAT_BEAM,
                            CCBlocks.COPYCAT_VERTICAL_STEP,
                            CCBlocks.COPYCAT_STAIRS,
                            CCBlocks.COPYCAT_FENCE,
                            CCBlocks.COPYCAT_FENCE_GATE,
                            CCBlocks.COPYCAT_TRAPDOOR,
                            CCBlocks.COPYCAT_WALL,
                            CCBlocks.COPYCAT_BOARD,
                            CCBlocks.COPYCAT_BYTE,
                            CCBlocks.COPYCAT_LAYER
                    )
                    .register();


    public static void register() {
    }
}
