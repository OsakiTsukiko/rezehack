package osakitsukiko.rezehack.command.commands;

import osakitsukiko.rezehack.command.Command;
import osakitsukiko.rezehack.modules.Module;
import osakitsukiko.rezehack.modules.ModuleManager;

public class ToggleModuleCommand extends Command {
    public ToggleModuleCommand() { super(new String[]{"toggle", "t"}); }

    @Override
    public void onCommand(String[] args) {
        if (args.length == 1) {
            sendError("Usage: toggle <Module>");
            return;
        }

        Module module = ModuleManager.getModule(args[1]);
        if(module != null) {
            module.toggle();
        } else sendError("Module not found!");
    }

}
