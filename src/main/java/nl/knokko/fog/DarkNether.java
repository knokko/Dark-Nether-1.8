package nl.knokko.fog;

import net.minecraft.init.Blocks;
import net.minecraftforge.client.event.EntityViewRenderEvent.FogColors;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = "darknether", name = "Dark Nether", version = "1.8")
public class DarkNether {
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	@SubscribeEvent
	public void changeFogColor(FogColors event){
		if(event.block == Blocks.lava){
			event.red = 0.25f;
			event.green = 0f;
			event.blue = 0.5f;
		}
		if(event.block == Blocks.air && event.entity.worldObj.provider.getDimensionId() == -1){
			event.red = 0.05f;
			event.green = 0f;
			event.blue = 0.1f;
		}
	}
}
