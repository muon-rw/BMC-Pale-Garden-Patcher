package dev.muon.bmcpalegardenpatcher;

import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

@Mod(BMCPaleGardenPatcher.MODID)
public class BMCPaleGardenPatcher {
    public static final String MODID = "bmcpalegardenpatcher";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

    private static final Map<String, String> REMAP_BIOMES = new HashMap<>();
    private static final Map<String, String> REMAP_BLOCKS = new HashMap<>();

    static {
        REMAP_BIOMES.put("dtkupd:pale_garden", "palegarden:pale_garden");
        REMAP_BIOMES.put("dtkupd:super_birch_biom", "minecraft:birch_forest");

        REMAP_BLOCKS.put("dtkupd:pale_oak_log", "palegarden:pale_log");
        REMAP_BLOCKS.put("dtkupd:syruped_pale_oak_log", "palegarden:pale_log");
        REMAP_BLOCKS.put("dtkupd:stripped_oak_wood_log", "palegarden:pale_log");
        REMAP_BLOCKS.put("dtkupd:pale_oak_wood", "palegarden:pale_wood");
        REMAP_BLOCKS.put("dtkupd:stripped_pale_oak_wood", "palegarden:pale_wood");

        REMAP_BLOCKS.put("dtkupd:pale_oak_leaves", "palegarden:pale_leaves");

        REMAP_BLOCKS.put("dtkupd:pale_heart", "palegarden:creaking_heart");
        REMAP_BLOCKS.put("dtkupd:pale_heart_active", "palegarden:creaking_heart");

        REMAP_BLOCKS.put("dtkupd:pale_oak_planks", "palegarden:pale_plank");

        REMAP_BLOCKS.put("dtkupd:pale_oak_button", "palegarden:pale_oak_button");
        REMAP_BLOCKS.put("dtkupd:pale_wood_door", "palegarden:pale_oak_door");
        REMAP_BLOCKS.put("dtkupd:pale_oak_fence", "palegarden:pale_oak_fence");
        REMAP_BLOCKS.put("dtkupd:pale_oak_fence_gate", "palegarden:pale_oak_fence_gate");
        REMAP_BLOCKS.put("dtkupd:pale_wood_trapdoor", "palegarden:pale_oak_trapdoor");
        REMAP_BLOCKS.put("dtkupd:pale_oak_stairs", "palegarden:pale_oak_stairs");
        REMAP_BLOCKS.put("dtkupd:pale_oak_slab", "palegarden:pale_oak_slab");

        REMAP_BLOCKS.put("dtkupd:pale_vine", "palegarden:pale_vine");
        REMAP_BLOCKS.put("dtkupd:pale_moss_carpet", "palegarden:pale_moss_carpet");
        REMAP_BLOCKS.put("dtkupd:pale_moss", "palegarden:pale_moss_block");

        REMAP_BLOCKS.put("dtkupd:green_birch_leaves", "minecraft:birch_leaves");
    }

    public BMCPaleGardenPatcher() {
        LOGGER.info("BMC Pale Garden Patcher initialized");
    }

    public static String remapIdentifier(String id) {
        String[] parts = id.split(":", 2);
        if (parts.length != 2) return id;

        String namespace = parts[0];
        String path = parts[1];

        if ("dtkupd".equals(namespace)) {
            if (REMAP_BIOMES.containsKey(id)) {
                return REMAP_BIOMES.get(id);
            } else if (REMAP_BLOCKS.containsKey(id)) {
                return REMAP_BLOCKS.get(id);
            }
        }

        return id;
    }
}