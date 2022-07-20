package osakitsukiko.rezehack;

import net.fabricmc.api.ModInitializer;
import me.zero.alpine.EventBus;
import me.zero.alpine.EventManager;
import net.minecraft.util.Formatting;
import net.minecraft.client.MinecraftClient;
import osakitsukiko.rezehack.command.CommandManager;

import java.io.File;

public class RezeHack implements ModInitializer {
    public static MinecraftClient mc = MinecraftClient.getInstance();
	public static EventBus EVENT_BUS;
	public static String clientVersionString = "RezeHack 0.0.1";
	public static String clientVersion = "0.0.1";
	public static String clientWebsite = "https://osakitsukiko.github.io";
	public static String rezePrefix = Formatting.WHITE + "[" + Formatting.RED + "RezeHack" + Formatting.WHITE + "]" + Formatting.RESET + " ";
	public static String errorPrefix = Formatting.WHITE + "[" + Formatting.RED + "RHError" + Formatting.WHITE + "]" + Formatting.RESET + " ";

    @Override
	public void onInitialize() {
		EVENT_BUS = new EventManager();

		CommandManager.init();

		// ██  .
		System.out.println("                        ██                  ██    ");
		System.out.println("                        ██                  ██    ");
		System.out.println("                        ██                  ██    ");
		System.out.println("██████  ████████    ██████████████  ██████  ██  ██");
		System.out.println("██    ████    ██  ████  ██  ██  ██  ██      ████  ");
		System.out.println("██      ████  ████  ██████  ██████████████████  ██");
		System.out.println("RezeHack has been initialized!");
		System.out.println("https://osakitsukiko.github.io");
	}
}
