package osakitsukiko.rezehack.command.commands;

import osakitsukiko.rezehack.command.Command;
import osakitsukiko.rezehack.modules.Module;
import osakitsukiko.rezehack.modules.ModuleManager;
import osakitsukiko.rezehack.utils.Setting;
import osakitsukiko.rezehack.utils.SettingsManager;

public class SettingCommand extends Command {
    public SettingCommand() { super(new String[]{"setting", "set"}); }

    @Override
    public void onCommand(String[] args) {
        int cmd_type = -1;

        if ( args.length == 1 ) {
            sendError("Usage: setting <set/get> <Module> <Setting> [Value]");
            return;
        }

        if (args[1].equalsIgnoreCase("set")) {
            if ( args.length != 5 ) {
                sendError("Usage: setting <set> <Module> <Setting> <Value>");
                return;
            } else {
                cmd_type = 0;
            }
        } else if (args[1].equalsIgnoreCase("get")) {
            if ( args.length != 4 ) {
                sendError("Usage: setting <get> <Module> <Setting>");
                return;
            } else {
                cmd_type = 1;
            }
        } else {
            sendError("Usage: setting <set/get> <Module> <Setting> [Value]");
            return;
        }

        // Try to find module
        Module module = ModuleManager.getModule(args[2]);
        if (module == null) {
            sendError("Module not found!");
            return;
        }

        // Try to find the setting on the module
        Setting setting = SettingsManager.getSetting(module, args[3]);
        if (setting == null) {
            sendError("Setting not found!");
            return;
        } else {
            if (cmd_type == 1) {
                sendMessage(module.getName() + " -> " + setting.getName() + ": " + setting.getValue());
            } else if (cmd_type == 0) {
                switch (setting.getType()) {
                    case BOOLEAN:
                        setting.setValue(Boolean.parseBoolean(args[4]));
                        sendMessage("Set " + module.getName() + " -> " + setting.getName() + " to " + args[4]);
                        break;
                    case FLOAT:
                        if ((float)setting.getMin() > Float.parseFloat(args[4]) || (float)setting.getMax() < Float.parseFloat(args[4])) {
                            sendError("Min: " + setting.getMin() + ", Max: " + setting.getMax());
                            break;
                        }
                        setting.setValue(Float.valueOf(args[4]));
                        sendMessage("Set " + module.getName() + " -> " + setting.getName() + " to " + args[4]);
                        break;
                    case INTEGER:
                        if ((int)setting.getMin() > Integer.parseInt(args[4]) || (int)setting.getMax() < Integer.parseInt(args[4])) {
                            sendError("Min: " + setting.getMin() + ", Max: " + setting.getMax());
                            break;
                        }
                        setting.setValue(Integer.parseInt(args[4]));
                        sendMessage("Set " + module.getName() + " -> " + setting.getName() + " to " + args[4]);
                        break;
                    case STRING:
                        System.out.println("STRING " + args[4]);
                        // If it is string type, then we will check if it is a valid option
                        // If the options list is empty, we also allow the setting of the value
                        if (setting.getOptions().contains(args[4]) || setting.getOptions().isEmpty()) {
                            setting.setValue(args[4]);
                            sendMessage("Set " + module.getName() + " -> " + setting.getName() + " to " + args[4]);
                        } else {
                            sendError(args[4] + " not found in options of module " + module.getName() + "!");
                            return;
                        }
                        break;
                    default:
                        System.out.println("WARNING: Unknown or unsupported type found! Type: " + setting.getType());
                }
            }
        }
    }
}
