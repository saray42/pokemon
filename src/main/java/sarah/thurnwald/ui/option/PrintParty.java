package sarah.thurnwald.ui.option;

import sarah.thurnwald.data.player.Player;

public class PrintParty implements OptionOutput {
    private final String command;

    public PrintParty() {
        command = "Party";
    }

    @Override
    public void print(Player player) {
        System.out.println(player.getParty());
    }

    @Override
    public String getCommand() {
        return command;
    }
}
