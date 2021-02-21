package br.com.urbainski.gourmet.game.core.game.impl;

import br.com.urbainski.gourmet.game.core.game.IGame;
import br.com.urbainski.gourmet.game.core.message.IMessage;
import br.com.urbainski.gourmet.game.core.message.MessageQuestionResponseType;
import br.com.urbainski.gourmet.game.core.node.Node;

import static java.lang.String.format;

/**
 * @author Cristian Urbainski
 * @since 20/02/2021
 */
public class GameImpl implements IGame {

    private static final String GAME_TITLE = "Jogo Gourmet";
    private final IMessage message;
    private final Node rootNode;

    public GameImpl(IMessage message) {

        this.message = message;

        this.rootNode = new Node("massa", new Node("Lasanha"), new Node("Bolo de Chocolate"));
    }

    @Override
    public void execute() {

        boolean finishGame;

        do {

            var option = message.showOkOrCancelQuestion("Pense em um prato que gosta", GAME_TITLE);

            finishGame = MessageQuestionResponseType.CANCEL.equals(option);

            if (!finishGame) {

                var messageQuestionResponseType = showQuestion(rootNode);

                var node = rootNode.getLeftNode();

                if (MessageQuestionResponseType.NO.equals(messageQuestionResponseType)) {

                    node = rootNode.getRightNode();
                }

                achoQueOPrato(node);
            }
        } while (!finishGame);
    }

    private void achoQueOPrato(Node node) {

        var messageQuestionResponseType = showQuestion(node);

        if (MessageQuestionResponseType.YES.equals(messageQuestionResponseType)) {

            if (node.hasLeftNode()) {

                achoQueOPrato(node.getLeftNode());
            } else {

                message.showInformation("Acertei de novo!", GAME_TITLE);
            }
        } else {

            if (node.hasRightNode()) {

                achoQueOPrato(node.getRightNode());
            } else {

                var prato = message.getValue("Qual prato você pensou?");

                var tipo = message.getValue(format("%s é ______ mas %s não", prato, node.getValue()));

                insertNode(node, prato, tipo);
            }
        }
    }

    private void insertNode(Node node, String prato, String tipo) {

        var oldValue = node.getValue();

        node.setValue(tipo);
        node.setRightNode(new Node(oldValue));
        node.setLeftNode(new Node(prato));
    }

    private MessageQuestionResponseType showQuestion(Node node) {

        return message.showYesOrNoQuestion(format("O prato que você pensou é %s?", node.getValue()), "Confirm");
    }

    public Node getRootNode() {

        try {

            return (Node) rootNode.clone();

        } catch (CloneNotSupportedException ex) {

            System.out.println(ex.getMessage());

            return null;
        }
    }

}