package br.com.urbainski.gourmet.game.core.message.impl;

import br.com.urbainski.gourmet.game.core.message.IMessage;
import br.com.urbainski.gourmet.game.core.message.MessageQuestionResponseType;

import javax.swing.*;

/**
 * @author Cristian Urbainski
 * @since 20/02/2021
 */
public class JOptionPaneMessageImpl implements IMessage {

    public String getValue(String message) {

        return JOptionPane.showInputDialog(message);
    }

    public MessageQuestionResponseType showYesOrNoQuestion(String message, String title) {

        int result = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);

        if (JOptionPane.YES_OPTION == result) {

            return MessageQuestionResponseType.YES;
        }

        return MessageQuestionResponseType.NO;
    }

    public MessageQuestionResponseType showOkOrCancelQuestion(String message, String title) {

        int result = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.DEFAULT_OPTION);

        if (JOptionPane.OK_OPTION == result) {

            return MessageQuestionResponseType.OK;
        }

        return MessageQuestionResponseType.CANCEL;
    }

    public void showInformation(String message, String title) {

        JOptionPane.showMessageDialog(null, message, title, JOptionPane.DEFAULT_OPTION);
    }

}