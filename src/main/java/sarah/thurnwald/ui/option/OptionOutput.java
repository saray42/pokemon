package sarah.thurnwald.ui.option;

import sarah.thurnwald.data.player.Player;

public interface OptionOutput {

    void print(Player player);

    String getCommand();
}
