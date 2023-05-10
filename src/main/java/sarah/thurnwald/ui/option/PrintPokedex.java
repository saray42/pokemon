package sarah.thurnwald.ui.option;

import sarah.thurnwald.data.player.Player;

public class PrintPokedex implements OptionOutput {

    private final String command;

    public PrintPokedex() {
        command = "Pokedex";
    }

    @Override
    public void print(Player player) {
        System.out.println(player.getPokedex());
    }

    @Override
    public String getCommand() {
        return command;
    }
}
