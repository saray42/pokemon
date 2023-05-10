package sarah.thurnwald.logic.generator;

import sarah.thurnwald.ui.option.OptionOutput;
import sarah.thurnwald.ui.option.PrintBag;
import sarah.thurnwald.ui.option.PrintParty;
import sarah.thurnwald.ui.option.PrintPokedex;

import java.util.ArrayList;
import java.util.List;

public class OptionGenerator {
    public List<OptionOutput> generate() {
        return new ArrayList<>(
                List.of(
                        new PrintParty(),
                        new PrintBag(),
                        new PrintPokedex()
                )
        );
    }
}
