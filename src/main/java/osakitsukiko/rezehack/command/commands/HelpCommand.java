package osakitsukiko.rezehack.command.commands;

import net.minecraft.util.Formatting;
import org.apache.commons.lang3.StringUtils;
import osakitsukiko.rezehack.RezeHack;
import osakitsukiko.rezehack.command.Command;
import osakitsukiko.rezehack.command.CommandManager;
import osakitsukiko.rezehack.modules.Module;
import osakitsukiko.rezehack.modules.ModuleManager;
import osakitsukiko.rezehack.utils.Setting;
import osakitsukiko.rezehack.utils.TextFormatting;

import java.util.ArrayList;

public class HelpCommand extends Command {
    public HelpCommand() { super(new String[]{"help", "h"}); }

    @Override
    public void onCommand(String[] args) {
        if ( args.length == 1 ) {
            String tmp = "Commands (" + CommandManager.commands.size() + "): ";
            sendMessage(RezeHack.clientVersionString + " by " + Formatting.RED + RezeHack.clientAuthor + Formatting.RESET);
            sendMessage(RezeHack.clientWebsite);
            for (Command command : CommandManager.commands) {
                tmp += StringUtils.capitalize(command.name[0]) +", ";
            }
            sendMessage(tmp.substring(0, tmp.length()-2));
        } else if ( args.length == 2 ) {
            // Try to find module
            Module module = ModuleManager.getModule(args[1]);
            if (module == null) {
                sendError("Module not found!");
                return;
            }

            // sendCleanMessage(TextFormatting.rezePrefixYellow + "Help for module: " + Formatting.YELLOW + module.getDisplayName() + Formatting.RESET);
            sendCleanMessage("┏━" + TextFormatting.rezePrefixYellow + Formatting.WHITE + "[" + Formatting.YELLOW + module.getDisplayName() + Formatting.WHITE + "]" + Formatting.RESET);
            sendCleanMessage("┃ Name: " + Formatting.YELLOW + module.getName() + Formatting.RESET);
            sendCleanMessage("┃ Display Name: " + Formatting.YELLOW + module.getDisplayName() + Formatting.RESET);
            sendCleanMessage("┃ Description: " + Formatting.YELLOW + module.getDescription() + Formatting.RESET);
            sendCleanMessage("┃ Category: " + Formatting.YELLOW + module.getCategory().toString() + Formatting.RESET);
            if (module.isEnabled()) sendCleanMessage("┃ Is Enabled: " + Formatting.GREEN + module.isEnabled() + Formatting.RESET);
            else sendCleanMessage("┃ Is Enabled: " + Formatting.RED + module.isEnabled() + Formatting.RESET);
            if ( module.settings.size() != 0 ) {
                sendCleanMessage("┃ " + Formatting.YELLOW + "List of Settings" + Formatting.RESET);
                for (Setting setting : module.settings) {
                    sendCleanMessage("┃ " + Formatting.GRAY + "┏[" + Formatting.GOLD + setting.getDisplayName() + Formatting.GRAY + "]" + Formatting.RESET);
                    sendCleanMessage("┃ " + Formatting.GRAY + "┇ Name: " + Formatting.GOLD + setting.getName() + Formatting.RESET);
                    sendCleanMessage("┃ " + Formatting.GRAY + "┇ Display Name: " + Formatting.GOLD + setting.getDisplayName() + Formatting.RESET);
                    sendCleanMessage("┃ " + Formatting.GRAY + "┇ Description: " + Formatting.GOLD + setting.getDescription() + Formatting.RESET);
                    String possible_values = "";
                    switch (setting.getType()) {
                        case BOOLEAN:
                            possible_values = "true, false";
                            break;
                        case INTEGER:
                            possible_values += "min: " + setting.getMin() + ", max: " + setting.getMax();
                            break;
                        case FLOAT:
                            possible_values += "min: " + setting.getMin() + ", max: " + setting.getMax();
                            break;
                        case STRING:
                            for ( String option : (ArrayList<String>) setting.getOptions() ) {
                                possible_values += option + ", ";
                            }
                            possible_values = possible_values.substring(0, possible_values.length()-2);
                            break;
                        default:
                            System.out.println("WARNING: Unknown or unsupported type found! Type: " + setting.getType());
                    }
                    sendCleanMessage("┃ " + Formatting.GRAY + "┇ Value: " + Formatting.GOLD + setting.getValue() + Formatting.WHITE + " | " + Formatting.GRAY + possible_values + Formatting.RESET);
                    sendCleanMessage("┃ " + Formatting.GRAY + "┇ Default Value: " + Formatting.GOLD + setting.getDefaultVal().toString() + Formatting.RESET);
                    sendCleanMessage("┃ " + Formatting.GRAY + "┇ Type: " + Formatting.GOLD + setting.getType().toString() + Formatting.RESET);
                    sendCleanMessage("┃ " + Formatting.GRAY + "┗┅# " + Formatting.RESET);
                }
            }
            sendCleanMessage("┗━#" + Formatting.RESET);
        }
    }
}
