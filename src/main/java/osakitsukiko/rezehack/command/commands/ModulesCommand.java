package osakitsukiko.rezehack.command.commands;

import net.minecraft.util.Formatting;
import osakitsukiko.rezehack.RezeHack;
import osakitsukiko.rezehack.command.Command;
import osakitsukiko.rezehack.modules.Module;
import osakitsukiko.rezehack.modules.ModuleManager;

public class ModulesCommand extends Command {
    public ModulesCommand() { super(new String[]{"modules", "mods"}); }

    @Override
    public void onCommand(String[] args) {
        String message = "Modules (" + ModuleManager.modules.size() + "): ";
        for (Module module : ModuleManager.modules) {
            if (module.isEnabled()) message += Formatting.GREEN + module.getName() + Formatting.WHITE + ", ";
            else message += Formatting.RED + module.getName() + Formatting.WHITE + ", ";
        }
        sendMessage(message.substring(0, message.length()-2));
    }
}
