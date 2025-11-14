package dev.muon.bmcpalegardenpatcher;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLLoader;
import net.minecraftforge.fml.loading.LoadingModList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Mod(BMCPaleGardenPatcher.MODID)
public class BMCPaleGardenPatcher {
    public static final String MODID = "bmcpalegardenpatcher";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

    private static final Map<String, Map<String, String>> NAMESPACE_REMAPS = new HashMap<>();
    public static final Set<String> ACTIVE_NAMESPACES;

    static {
        LoadingModList modList = FMLLoader.getLoadingModList();

        // DTKUPD -> PALE GARDEN (only if dtkupd is NOT loaded)
        if (modList.getModFileById("dtkupd") == null) {
            Map<String, String> dtkupdRemap = new HashMap<>();
            dtkupdRemap.put("dtkupd:pale_garden", "palegarden:pale_garden");
            dtkupdRemap.put("dtkupd:super_birch_biom", "minecraft:birch_forest");
            dtkupdRemap.put("dtkupd:pale_oak_log", "palegarden:pale_log");
            dtkupdRemap.put("dtkupd:syruped_pale_oak_log", "palegarden:pale_log");
            dtkupdRemap.put("dtkupd:stripped_oak_wood_log", "palegarden:pale_log");
            dtkupdRemap.put("dtkupd:pale_oak_wood", "palegarden:pale_wood");
            dtkupdRemap.put("dtkupd:stripped_pale_oak_wood", "palegarden:pale_wood");
            dtkupdRemap.put("dtkupd:pale_oak_leaves", "palegarden:pale_leaves");
            dtkupdRemap.put("dtkupd:pale_heart", "palegarden:creaking_heart");
            dtkupdRemap.put("dtkupd:pale_heart_active", "palegarden:creaking_heart");
            dtkupdRemap.put("dtkupd:pale_oak_planks", "palegarden:pale_plank");
            dtkupdRemap.put("dtkupd:pale_oak_button", "palegarden:pale_oak_button");
            dtkupdRemap.put("dtkupd:pale_wood_door", "palegarden:pale_oak_door");
            dtkupdRemap.put("dtkupd:pale_oak_fence", "palegarden:pale_oak_fence");
            dtkupdRemap.put("dtkupd:pale_oak_fence_gate", "palegarden:pale_oak_fence_gate");
            dtkupdRemap.put("dtkupd:pale_wood_trapdoor", "palegarden:pale_oak_trapdoor");
            dtkupdRemap.put("dtkupd:pale_oak_stairs", "palegarden:pale_oak_stairs");
            dtkupdRemap.put("dtkupd:pale_oak_slab", "palegarden:pale_oak_slab");
            dtkupdRemap.put("dtkupd:pale_vine", "palegarden:pale_vine");
            dtkupdRemap.put("dtkupd:pale_moss_carpet", "palegarden:pale_moss_carpet");
            dtkupdRemap.put("dtkupd:pale_moss", "palegarden:pale_moss_block");
            dtkupdRemap.put("dtkupd:green_birch_leaves", "minecraft:birch_leaves");

            NAMESPACE_REMAPS.put("dtkupd", dtkupdRemap);
            LOGGER.info("Loaded dtkupd remapping (dtkupd mod not present)");
        }

        // PALE GARDEN -> VANILLA BACKPORT (only if palegarden is NOT loaded)
        if (modList.getModFileById("palegarden") == null) {
            Map<String, String> palegardenRemap = new HashMap<>();
            palegardenRemap.put("palegarden:pale_garden", "vanillabackport:pale_garden");
            palegardenRemap.put("palegarden:pale_log", "vanillabackport:pale_oak_log");
            palegardenRemap.put("palegarden:stripped_pale_log", "vanillabackport:stripped_pale_oak_log");
            palegardenRemap.put("palegarden:pale_wood", "vanillabackport:pale_oak_wood");
            palegardenRemap.put("palegarden:pale_leaves", "vanillabackport:pale_oak_leaves");
            palegardenRemap.put("palegarden:creaking_heart", "vanillabackport:creaking_heart");
            palegardenRemap.put("palegarden:pale_plank", "vanillabackport:pale_oak_planks");
            palegardenRemap.put("palegarden:pale_oak_button", "vanillabackport:pale_oak_button");
            palegardenRemap.put("palegarden:pale_oak_door", "vanillabackport:pale_oak_door");
            palegardenRemap.put("palegarden:pale_oak_fence", "vanillabackport:pale_oak_fence");
            palegardenRemap.put("palegarden:pale_oak_fence_gate", "vanillabackport:pale_oak_fence_gate");
            palegardenRemap.put("palegarden:pale_wood_trapdoor", "vanillabackport:pale_oak_trapdoor");
            palegardenRemap.put("palegarden:pale_oak_stairs", "vanillabackport:pale_oak_stairs");
            palegardenRemap.put("palegarden:pale_oak_slab", "vanillabackport:pale_oak_slab");
            palegardenRemap.put("palegarden:pale_vine", "vanillabackport:pale_hanging_moss");
            palegardenRemap.put("palegarden:pale_moss_carpet", "vanillabackport:pale_moss_carpet");
            palegardenRemap.put("palegarden:pale_moss_block", "vanillabackport:pale_moss_block");
            palegardenRemap.put("palegarden:resin_block", "vanillabackport:resin_block");
            palegardenRemap.put("palegarden:resin_bricks", "vanillabackport:resin_brick");
            palegardenRemap.put("palegarden:resin_bricks_slab", "vanillabackport:resin_brick_slab");
            palegardenRemap.put("palegarden:resin_brick_stairs", "vanillabackport:resin_brick_stairs");
            palegardenRemap.put("palegarden:resin_brick_wall", "vanillabackport:resin_brick_wall");
            palegardenRemap.put("palegarden:chiseled_resin_brick", "vanillabackport:chiseled_resin_bricks");
            palegardenRemap.put("palegarden:eye_blossom", "vanillabackport:closed_eyeblossom");
            palegardenRemap.put("palegarden:resin_clump", "vanillabackport:resin_clump");
            palegardenRemap.put("palegarden:resin_brick", "vanillabackport:resin_bricks");
            palegardenRemap.put("palegarden:creaking_spawn_egg", "vanillabackport:creaking_spawn_egg");
            palegardenRemap.put("palegarden:creaking", "vanillabackport:creaking");

            NAMESPACE_REMAPS.put("palegarden", palegardenRemap);
            LOGGER.info("Loaded palegarden remapping (palegarden mod not present)");
        }

        // BIOMES WE'VE GONE (typo fix - only if mod IS loaded)
        if (modList.getModFileById("biomeswevegone") != null) {
            Map<String, String> bwgRemap = new HashMap<>();
            bwgRemap.put("biomeswevegone:skyrise_vale", "biomeswevegone:skyris_vale");

            NAMESPACE_REMAPS.put("biomeswevegone", bwgRemap);
            LOGGER.info("Loaded biomeswevegone remapping (fixing typo)");
        }

        // Store active namespaces as unmodifiable set for fast lookup
        ACTIVE_NAMESPACES = Set.copyOf(NAMESPACE_REMAPS.keySet());
    }

    public BMCPaleGardenPatcher() {
        LOGGER.info("BMC Pale Garden Patcher initialized with {} active namespace(s)", ACTIVE_NAMESPACES.size());
    }

    public static String remapIdentifier(String id) {
        int colonIndex = id.indexOf(':');
        if (colonIndex == -1) return id;

        String namespace = id.substring(0, colonIndex);

        // Fast set lookup - O(1) vs multiple equals() checks
        if (!ACTIVE_NAMESPACES.contains(namespace)) {
            return id;
        }

        // Get the appropriate map and return remapped value or original
        Map<String, String> remapTable = NAMESPACE_REMAPS.get(namespace);
        return remapTable.getOrDefault(id, id);
    }
}