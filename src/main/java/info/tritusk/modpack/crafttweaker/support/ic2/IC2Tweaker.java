package info.tritusk.modpack.crafttweaker.support.ic2;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

@Mod(modid = "ic2_tweaker", name = "IC2Tweaker", useMetadata = true)
public class IC2Tweaker {

    @Mod.EventHandler
    public void initStage4(FMLPostInitializationEvent event) {
        ScrapBoxSupport.Impl.rebuildScrapBoxPool();
    }
}
