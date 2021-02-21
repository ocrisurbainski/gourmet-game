package br.com.urbainski.gourmet.game.core.message;

/**
 * @author Cristian Urbainski
 * @since 20/02/2021
 */
public interface IMessage {

    String getValue(String message);

    MessageQuestionResponseType showYesOrNoQuestion(String message, String title);

    MessageQuestionResponseType showOkOrCancelQuestion(String message, String title);

    void showInformation(String message, String title);

}