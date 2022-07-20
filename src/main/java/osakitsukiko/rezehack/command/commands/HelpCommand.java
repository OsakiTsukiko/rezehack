package osakitsukiko.rezehack.command.commands;

import net.minecraft.util.Formatting;
import org.apache.commons.lang3.StringUtils;
import osakitsukiko.rezehack.RezeHack;
import osakitsukiko.rezehack.command.Command;
import osakitsukiko.rezehack.command.CommandManager;

public class HelpCommand extends Command {
    public HelpCommand() {super(new String[]{"help"});}

    @Override
    public void onCommand(String[] args) {
        String tmp = "Commands (" + CommandManager.commands.size() + "): ";
        sendMessage(RezeHack.clientVersionString + " by " + Formatting.RED + "OsakiTsukiko" + Formatting.RESET);
        sendMessage(RezeHack.clientWebsite);
        for (Command command : CommandManager.commands) {
            tmp += StringUtils.capitalize(command.name[0]) +", ";
        }
        sendMessage(tmp.substring(0, tmp.length()-2));
    }
}
