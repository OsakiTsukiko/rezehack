package osakitsukiko.rezehack.command;

import osakitsukiko.rezehack.command.commands.*;

import java.util.ArrayList;
import java.util.Comparator;

public class CommandManager {
    public static ArrayList<Command> commands;

    public static void init() {
        commands = new ArrayList<>();

        commands.add(new HelpCommand());
        commands.add(new PingCommand());
        commands.add(new ModulesCommand());
        commands.add(new ToggleModuleCommand());
        commands.add(new SettingCommand());

        commands.sort(Comparator.comparing(object -> object.name[0]));
    }
}
