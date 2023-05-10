package sarah.thurnwald.ui.option;

import sarah.thurnwald.data.player.Player;

public class PrintBag implements OptionOutput {
    private final String command;

    public PrintBag() {
        command = "Bag";
    }

    @Override
    public void print(Player player) {
        System.out.println(player.getBag());
    }

    @Override
    public String getCommand() {
        return command;
    }
}
