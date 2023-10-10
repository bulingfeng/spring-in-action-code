package org.example.entity;


import java.util.ArrayList;
import java.util.List;
// https://www.cnblogs.com/Marydon20170307/p/16308129.html

/// https://blog.csdn.net/a18505947362/article/details/122458089
public class Node {

    private int parentId;


    private int code;

    private String name;

    private List<Node> childList;

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Node> getChildList() {
        return childList;
    }

    public void setChildList(List<Node> childList) {
        this.childList = childList;
    }

    public static void main(String[] args) {

        List<Node> nodeList = new ArrayList<>();
        Node node1 = new Node();
        node1.setParentId(-1);
        node1.setCode(100);
        node1.setName("父类");


        Node node2 = new Node();
        node2.setParentId(100);
        node2.setCode(100001);
        node2.setName("子类1");

        Node node3 = new Node();
        node3.setParentId(100);
        node3.setCode(100002);
        node3.setName("子类2");


        Node node4 = new Node();
        node4.setParentId(100002);
        node4.setCode(100002001);
        node4.setName("孙子类");

        nodeList.add(node1);
        nodeList.add(node2);
        nodeList.add(node3);
        nodeList.add(node4);

        buildChildTree(node1,nodeList);

        System.out.println(node1);
    }

    private static Node buildChildTree(Node nodeParent, List<Node> nodeList) {
        // 找到noteParent节点的子节点
        List<Node> childrenList=new ArrayList<>();
        for (Node node : nodeList) {
            if (node.getParentId()==nodeParent.getCode()){
                // node 节点为子节点，假如到childrenList中，但是也要把node节点中的子类节点给找到
                childrenList.add(buildChildTree(node,nodeList));
            }
        }
        // 找到所有的子节点，然后添加到父类的节点中
        nodeParent.setChildList(childrenList);
        return nodeParent;
    }

}

