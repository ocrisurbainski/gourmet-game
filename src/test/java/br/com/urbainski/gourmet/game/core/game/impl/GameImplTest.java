package br.com.urbainski.gourmet.game.core.game.impl;

import br.com.urbainski.gourmet.game.core.message.impl.JOptionPaneMessageImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Cristian Urbainski
 * @since 21/02/2021
 */
public class GameImplTest {

    private GameImpl subject;

    @Before
    public void before() {

        subject = new GameImpl(new JOptionPaneMessageImpl());
    }

    @Test
    public void testInitValueRootNodeEqualsMassa() {

        Assert.assertEquals("massa", subject.getRootNode().getValue());
    }

    @Test
    public void testInitValueRootLeftNodeEqualsLasanha() {

        Assert.assertEquals("Lasanha", subject.getRootNode().getLeftNode().getValue());
    }

    @Test
    public void testInitValueRootRightNodeEqualsBoloDeChocolate() {

        Assert.assertEquals("Bolo de Chocolate", subject.getRootNode().getRightNode().getValue());
    }

}