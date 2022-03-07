package is.sly.dungeonmodpack;

import is.sly.dungeonmodpack.blocks.BlockBarrierVisible;
import net.minecraft.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;


@Mod(
        modid = DungeonMods.MOD_ID,
        name = DungeonMods.MOD_NAME,
        version = DungeonMods.VERSION
)

@Mod.EventBusSubscriber(modid = DungeonMods.MOD_ID)
public class DungeonMods {

    public static final String MOD_ID = "DungeonMods";
    public static final String MOD_NAME = "DungeonMods";
    public static final String VERSION = "1.0-SNAPSHOT";
    public static Block visibleBarrier = new BlockBarrierVisible().setRegistryName("dungeonmods:visible_barrier");

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        final Block[] blocks = {
                visibleBarrier
        };
        event.getRegistry().registerAll(blocks);
    }

    @SubscribeEvent
    public static void onConnect(FMLNetworkEvent.ClientConnectedToServerEvent event) {

    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Mod.EventHandler
    public void postInit(FMLPreInitializationEvent event) {

    }
}