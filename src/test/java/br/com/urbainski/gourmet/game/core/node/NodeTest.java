package br.com.urbainski.gourmet.game.core.node;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Cristian Urbainski
 * @since 20/02/2021
 */
public class NodeTest {

    private Node subject;

    @Test
    public void testHasLeftNodeEqualsTrue() {
        subject = new Node("massa");
        subject.setLeftNode(new Node("Lasanha"));

        Assert.assertTrue(subject.hasLeftNode());
    }

    @Test
    public void testHasLeftNodeEqualsFalse() {
        subject = new Node("massa");
        subject.setLeftNode(null);

        Assert.assertFalse(subject.hasLeftNode());
    }

    @Test
    public void testHasRightNodeEqualsTrue() {
        subject = new Node("massa");
        subject.setRightNode(new Node("Bolo de Chocolate"));

        Assert.assertTrue(subject.hasRightNode());
    }

    @Test
    public void testHasRightNodeEqualsFalse() {
        subject = new Node("massa");
        subject.setRightNode(null);

        Assert.assertFalse(subject.hasRightNode());
    }

}