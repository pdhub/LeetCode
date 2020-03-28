package techieDelight.tree;

import java.util.*;

public class LevelOrderTraversal {

    public boolean printLevel(TechieDelightNode root, int level){
        if (root == null)
            return false;
        if (level == 1){
            System.out.println(root.value);
            return true;
        }
        boolean left = printLevel(root.left, level - 1);
        boolean right = printLevel(root.right, level - 1);
        return left || right;
    }

    public void levelOrderTraversal(TechieDelightNode root){
        int level = 1;
        while (printLevel(root, level)){
            level++;
        }
    }

    void lotWq(TechieDelightNode node){
        Queue<TechieDelightNode> q = new ArrayDeque();
        q.add(node);
        while (!q.isEmpty()){
            TechieDelightNode n = q.poll();
            System.out.print(n.value + " -> ");
            if (n.left !=null)
                q.add(n.left);
            if (n.right !=null)
                q.add(n.right);
        }
    }

    void lotusingmap(TechieDelightNode root){
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        preOrderForMap(root, 1, map);
    }

    void preOrderForMap(TechieDelightNode root, int level, Map<Integer, List<Integer>> map) {
        if (root == null)
            return;
        if (!map.containsKey(level))
            map.put(level, new ArrayList<Integer>());
        map.get(level).add(root.value);
        preOrderForMap(root.left, level+1, map);
        preOrderForMap(root.right, level+1, map);
    }

    /*-----------------------------------------------------------
    Inverting alternate nodes of tree
    -----------------------------------------------------------*/

    void inverAlternateNodes(TechieDelightNode root){

        Queue<TechieDelightNode> q = new ArrayDeque<TechieDelightNode>();
        q.add(root);

        Queue<TechieDelightNode> levelNodes = new ArrayDeque<TechieDelightNode>();
        boolean level = false;
        Stack<Integer> levelData = new Stack<Integer>();
        while (!q.isEmpty()){
            int n = q.size();
            while (n-- > 0){
                TechieDelightNode node = q.poll();
                if (level){
                    levelNodes.add(node);
                    levelData.push(node.value);
                }
                if (n == 0){
                    level = !level;
                    while (!levelNodes.isEmpty()){
                        TechieDelightNode front = levelNodes.poll();
                        front.value = levelData.pop();
                    }
                }
                if (node.right != null)
                    q.add(node.right);
                if (node.left != null)
                    q.add(node.left);
            }
        }
    }


    public static void main(String[] args)
    {
        TechieDelightNode root = new TechieDelightNode(15);
        root.left = new TechieDelightNode(10);
        root.right = new TechieDelightNode(20);
        root.left.left = new TechieDelightNode(8);
        root.left.right = new TechieDelightNode(12);
        root.right.left = new TechieDelightNode(16);
        root.right.right = new TechieDelightNode(25);
        LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();
        levelOrderTraversal.levelOrderTraversal(root);
        System.out.println("+++++++++++++++++++++++++++");
        levelOrderTraversal.lotWq(root);
    }
}
