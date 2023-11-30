package TestingTasksFromInternet.yandex.autumn2023.task4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


class Tree<T>
{
    private T data;
    private Tree<T> parent;
    private List<Tree<T>> children;

    public Tree(T data)
    {
        this.data = data;
        children = new ArrayList<Tree<T>>();
    }

    /**
     * Adds a new child node to the parent node returns the added Child
     */
    public Tree<T> addChild(T childData)
    {
        Tree<T> childNode = new Tree<T>(childData);
        childNode.parent = this;
        this.children.add(childNode);
        return childNode;
    }



    /**
     * Returns the parent
     */
    public Tree<T> getRoot()
    {
        if (this == null)
        {
            return this;
        }

        Tree<T> parentTmp = this.parent;
        Tree<T> root = this;

        //iteration
        while (parentTmp != null)
        {
            parentTmp = root.parent;
            if (parentTmp != null)
            {
                root = parentTmp;
            }

        }

        return root;
    }


    @Override
    public String toString()
    {
        StringBuilder output = new StringBuilder("[");
        helpToString(this, output, 0);
        output.append("]");
        return output.toString();
    }

    private void helpToString(Tree<T> tree, StringBuilder output, int level)
    {
        if (tree == null)
            return; // Tree is empty, so leave.

        output.append(getSpaces(level) + tree.data);

        List<Tree<T>> children2 = tree.children;
        ++level; //increment the level

        Iterator<Tree<T>> iterator = children2.iterator();
        while (children2 != null && iterator.hasNext())
        {
            Tree<T> next = iterator.next();
            if (next != null)
            {
                helpToString(next, output, level); //recursion
            }

        }

    }

    private String getSpaces(int level)
    {
        StringBuilder sb = new StringBuilder("\n");
        for (int i = 0; i < level; i++)
        {
            sb.append("--");
        }

        return sb.toString();
    }

}

public class TreeTest {
    public static void main(String[] args) {
        Tree<String> root = new Tree<String>("A");
        root.addChild("B");
        Tree<String> childC = root.addChild("C");
        root.addChild("D");

        Tree<String> childC1 = childC.addChild("C1");

        System.out.println("root = " + childC.getRoot());                 // toString() method is invoked
        // toString() method is invoked

    }
}
