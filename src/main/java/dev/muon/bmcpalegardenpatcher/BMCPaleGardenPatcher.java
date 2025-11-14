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

    private static final Map<String, String> DTKUPD_REMAP = new HashMap<>();
    private static final Map<String, String> PALEGARDEN_REMAP = new HashMap<>();
    private static final Map<String, String> BIOMESWEVEGONE_REMAP = new HashMap<>();

    public static String remapIdentifier(String id) {
        int colonIndex = id.indexOf(':');
        if (colonIndex == -1) return id;

        String namespace = id.substring(0, colonIndex);

        return switch (namespace) {
            case "dtkupd" -> DTKUPD_REMAP.getOrDefault(id, id);
            case "palegarden" -> PALEGARDEN_REMAP.getOrDefault(id, id);
            case "biomeswevegone" -> BIOMESWEVEGONE_REMAP.getOrDefault(id, id);
            default -> id;
        };
    }

    static {
        // DTKUPD -> PALE GARDEN AND CREAKING, LEGACY
        DTKUPD_REMAP.put("dtkupd:pale_garden", "palegarden:pale_garden");
        DTKUPD_REMAP.put("dtkupd:super_birch_biom", "minecraft:birch_forest");

        DTKUPD_REMAP.put("dtkupd:pale_oak_log", "palegarden:pale_log");
        DTKUPD_REMAP.put("dtkupd:syruped_pale_oak_log", "palegarden:pale_log");
        DTKUPD_REMAP.put("dtkupd:stripped_oak_wood_log", "palegarden:pale_log");
        DTKUPD_REMAP.put("dtkupd:pale_oak_wood", "palegarden:pale_wood");
        DTKUPD_REMAP.put("dtkupd:stripped_pale_oak_wood", "palegarden:pale_wood");

        DTKUPD_REMAP.put("dtkupd:pale_oak_leaves", "palegarden:pale_leaves");

        DTKUPD_REMAP.put("dtkupd:pale_heart", "palegarden:creaking_heart");
        DTKUPD_REMAP.put("dtkupd:pale_heart_active", "palegarden:creaking_heart");

        DTKUPD_REMAP.put("dtkupd:pale_oak_planks", "palegarden:pale_plank");

        DTKUPD_REMAP.put("dtkupd:pale_oak_button", "palegarden:pale_oak_button");
        DTKUPD_REMAP.put("dtkupd:pale_wood_door", "palegarden:pale_oak_door");
        DTKUPD_REMAP.put("dtkupd:pale_oak_fence", "palegarden:pale_oak_fence");
        DTKUPD_REMAP.put("dtkupd:pale_oak_fence_gate", "palegarden:pale_oak_fence_gate");
        DTKUPD_REMAP.put("dtkupd:pale_wood_trapdoor", "palegarden:pale_oak_trapdoor");
        DTKUPD_REMAP.put("dtkupd:pale_oak_stairs", "palegarden:pale_oak_stairs");
        DTKUPD_REMAP.put("dtkupd:pale_oak_slab", "palegarden:pale_oak_slab");

        DTKUPD_REMAP.put("dtkupd:pale_vine", "palegarden:pale_vine");
        DTKUPD_REMAP.put("dtkupd:pale_moss_carpet", "palegarden:pale_moss_carpet");
        DTKUPD_REMAP.put("dtkupd:pale_moss", "palegarden:pale_moss_block");


        DTKUPD_REMAP.put("dtkupd:green_birch_leaves", "minecraft:birch_leaves");

        // PALE GARDEN AND CREAKING -> VANILLA BACKPORT
        PALEGARDEN_REMAP.put("palegarden:pale_garden", "vanillabackport:pale_garden");

        PALEGARDEN_REMAP.put("palegarden:pale_log", "vanillabackport:pale_oak_log");
        PALEGARDEN_REMAP.put("palegarden:stripped_pale_log", "vanillabackport:stripped_pale_oak_log");
        PALEGARDEN_REMAP.put("palegarden:pale_wood", "vanillabackport:pale_oak_wood");

        PALEGARDEN_REMAP.put("palegarden:pale_leaves", "vanillabackport:pale_oak_leaves");
        PALEGARDEN_REMAP.put("palegarden:creaking_heart", "vanillabackport:creaking_heart");
        PALEGARDEN_REMAP.put("palegarden:pale_plank", "vanillabackport:pale_oak_planks");

        PALEGARDEN_REMAP.put("palegarden:pale_oak_button", "vanillabackport:pale_oak_button");
        PALEGARDEN_REMAP.put("palegarden:pale_oak_door", "vanillabackport:pale_oak_door");
        PALEGARDEN_REMAP.put("palegarden:pale_oak_fence", "vanillabackport:pale_oak_fence");
        PALEGARDEN_REMAP.put("palegarden:pale_oak_fence_gate", "vanillabackport:pale_oak_fence_gate");
        PALEGARDEN_REMAP.put("palegarden:pale_wood_trapdoor", "vanillabackport:pale_oak_trapdoor");
        PALEGARDEN_REMAP.put("palegarden:pale_oak_stairs", "vanillabackport:pale_oak_stairs");
        PALEGARDEN_REMAP.put("palegarden:pale_oak_slab", "vanillabackport:pale_oak_slab");

        PALEGARDEN_REMAP.put("palegarden:pale_vine", "vanillabackport:pale_hanging_moss");
        PALEGARDEN_REMAP.put("palegarden:pale_moss_carpet", "vanillabackport:pale_moss_carpet");
        PALEGARDEN_REMAP.put("palegarden:pale_moss_block", "vanillabackport:pale_moss_block");


        PALEGARDEN_REMAP.put("palegarden:resin_block", "vanillabackport:resin_block");
        PALEGARDEN_REMAP.put("palegarden:resin_bricks", "vanillabackport:resin_bricks");
        PALEGARDEN_REMAP.put("palegarden:resin_bricks_slab", "vanillabackport:resin_brick_slab");
        PALEGARDEN_REMAP.put("palegarden:resin_brick_stairs", "vanillabackport:resin_brick_stairs");
        PALEGARDEN_REMAP.put("palegarden:resin_brick_wall", "vanillabackport:resin_brick_wall");
        PALEGARDEN_REMAP.put("palegarden:chiseled_resin_brick", "vanillabackport:chiseled_resin_bricks");
        PALEGARDEN_REMAP.put("palegarden:eye_blossom", "vanillabackport:closed_eyeblossom");

        PALEGARDEN_REMAP.put("palegarden:resin_clump", "vanillabackport:resin_clump");
        PALEGARDEN_REMAP.put("palegarden:resin_brick", "vanillabackport:resin_brick");
        PALEGARDEN_REMAP.put("palegarden:creaking_spawn_egg", "vanillabackport:creaking_spawn_egg");

        // BIOMES WEVE GONE PATCH
        BIOMESWEVEGONE_REMAP.put("biomeswevegone:skyrise_vale", "biomeswevegone:skyris_vale");
    }

    public BMCPaleGardenPatcher() {
        LOGGER.info("BMC Pale Garden Patcher initialized");
    }
}