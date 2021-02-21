package br.com.urbainski.gourmet.game.core.node;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Cristian Urbainski
 * @since 20/02/2021
 */
@Getter
@Setter
public class Node implements Cloneable {

    private String value;
    private Node leftNode;
    private Node rightNode;

    public Node(String value) {

        this.value = value;
    }

    public Node(String value, Node leftNode, Node rightNode) {

        this.value = value;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public boolean hasLeftNode() {

        return leftNode != null;
    }

    public boolean hasRightNode() {

        return rightNode != null;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {

        Node node = new Node(value);
        node.setLeftNode(new Node(leftNode.getValue()));
        node.setRightNode(new Node(rightNode.getValue()));
        return node;
    }

}