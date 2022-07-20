package osakitsukiko.rezehack.command;

import net.minecraft.text.Text;
import osakitsukiko.rezehack.RezeHack;

public class Command {
    public static String prefix = ":";

    public String[] name;
    public Command(String[] name) {this.name = name;}
    public void onCommand(String[] args) {}

    public static void sendMessage(String message) {
        try {
            RezeHack.mc.player.sendMessage(Text.of(RezeHack.rezePrefix + message), false);
        } catch (Exception e) {}
    }

    public static void sendError(String error) {
        try {
            RezeHack.mc.player.sendMessage(Text.of(RezeHack.errorPrefix + error), false);
        } catch (Exception e) {}
    }
}
