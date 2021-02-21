package br.com.urbainski.gourmet.game;

import br.com.urbainski.gourmet.game.core.game.IGame;
import br.com.urbainski.gourmet.game.core.game.impl.GameImpl;
import br.com.urbainski.gourmet.game.core.message.impl.JOptionPaneMessageImpl;

import java.util.Locale;

/**
 * @author Cristian Urbainski
 * @since 20/02/2021
 */
public class Main {

    public static void main(String[] args) {

        Locale.setDefault(new Locale("pt", "BR"));

        IGame game = new GameImpl(new JOptionPaneMessageImpl());

        game.execute();
    }

}