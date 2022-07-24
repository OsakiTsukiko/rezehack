package osakitsukiko.rezehack;

import net.fabricmc.api.ModInitializer;
import me.zero.alpine.EventBus;
import me.zero.alpine.EventManager;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.minecraft.util.Formatting;
import net.minecraft.client.MinecraftClient;
import osakitsukiko.rezehack.command.CommandManager;
import osakitsukiko.rezehack.modules.ModuleManager;
import osakitsukiko.rezehack.utils.ConfigManager;
import osakitsukiko.rezehack.utils.SettingsManager;

import java.io.File;

public class RezeHack implements ModInitializer {
    public static MinecraftClient mc = MinecraftClient.getInstance();
	public static EventBus EVENT_BUS;
	// What even is an Event Bus ?!
	public static String clientName = "RezeHack";
	public static String clientVersion = "0.0.1";
	public static String clientAuthor = "OsakiTsukiko";
	public static String clientVersionString = clientName + " " + clientVersion;
	public static String clientWebsite = "https://osakitsukiko.github.io";
	public static String rezePrefix = Formatting.WHITE + "[" + Formatting.RED + "RezeHack" + Formatting.WHITE + "]" + Formatting.RESET + " ";
	public static String errorPrefix = Formatting.WHITE + "[" + Formatting.DARK_RED + "RHError" + Formatting.WHITE + "]" + Formatting.RESET + " ";
	public static String infoPrefix = Formatting.WHITE + "[" + Formatting.YELLOW + "RHInfo" + Formatting.WHITE + "]" + Formatting.RESET + " ";

    @Override
	public void onInitialize() {
		EVENT_BUS = new EventManager();

		SettingsManager.init();
		ModuleManager.init();
		CommandManager.init();

		if (new File(MinecraftClient.getInstance().runDirectory + File.separator + clientName + File.separator + "default.json").exists()) ConfigManager.load("default");
		ConfigManager.load("default");
		// TODO: GLOBAL SETTINGS: LOAD CONFIG

		// ██  .
		System.out.println("  ");
		System.out.println("                          ██                  ██    ");
		System.out.println("                          ██                  ██    ");
		System.out.println("                          ██                  ██    ");
		System.out.println("██████  ████████    ████  ██████████  ██████  ██  ██");
		System.out.println("██    ████    ██  ████    ██  ██  ██  ██      ████  ");
		System.out.println("██      ████  ████  ████████  ██████████████████  ██");
		System.out.println("RezeHack has been initialized!");
		System.out.println("https://osakitsukiko.github.io");

		ClientLifecycleEvents.CLIENT_STOPPING.register((minecraftClient) -> {
			ConfigManager.save("default");
			// TODO: GLOBAL SETTINGS: LOAD CONFIG
		});
	}
}
