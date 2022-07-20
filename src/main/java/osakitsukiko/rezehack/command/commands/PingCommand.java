package osakitsukiko.rezehack.command.commands;

import osakitsukiko.rezehack.command.Command;

public class PingCommand extends Command {

    public PingCommand() {super(new String[]{"ping"});}

    @Override
    public void onCommand(String[] args) {
        sendMessage("Pong!");
    }

}
