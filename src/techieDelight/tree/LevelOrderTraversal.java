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

    /*-----------------------------------------------------------
    Height balanced Red Black tree

    We are doing here a postOrder traversal of the tree.
    This is taking O(n)
    -----------------------------------------------------------*/

    boolean heightBalancedRBt(TechieDelightNode root, int max) {
        if (root == null)
            return true;
        int lmax = 0;
        int rmax = 0;
        if (heightBalancedRBt(root.left, lmax) && heightBalancedRBt(root.right, rmax)){
            int min = Math.min(lmax, rmax) + 1;
            max = Math.max(lmax, rmax) + 1;
            return max <= 2*min;
        }
        return false;
    }

    /*-----------------------------------------------------------
    Construct binary tree given inorder and postorder
    We are doing O(n) time with O(n) space
    -----------------------------------------------------------*/

    TechieDelightNode construct(int inorder[], int postOrder[]){
        int n = inorder.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        Integer pIndex = 0;
        return createNodefromInPo(0, n - 1, pIndex, map, postOrder);
    }

    private TechieDelightNode createNodefromInPo(int start, int end, Integer pIndex, Map<Integer, Integer> map, int[] postOrder) {
        if (start > end)
            return null;
        TechieDelightNode root = new TechieDelightNode(postOrder[pIndex--]);
        int index = map.get(root.value);
        root.right = createNodefromInPo(index + 1, end, pIndex, map, postOrder);
        root.left = createNodefromInPo(start, index - 1, pIndex, map, postOrder);
        return root;
    }

    /*-----------------------------------------------------------
    Covert a BST to Min heap
    Do a inorder traversal and add to the queue
    Do a preorder tracversal and change values reading from the queue
    -----------------------------------------------------------*/

    void convert(TechieDelightNode root) {
        Queue<TechieDelightNode> queue = new ArrayDeque<TechieDelightNode>();
        inorder(root, queue);
        preOrder(root, queue);
    }

    void inorder(TechieDelightNode root, Queue<TechieDelightNode> q){
        if (root == null)
            return;
        inorder(root.left, q);
        q.add(root.value);
        inorder(root.right, q);
    }

    void preOrder(TechieDelightNode root, Queue<TechieDelightNode> q){
        if (root == null)
            return;
        root.value = q.poll();
        preOrder(root.left, q);
        preOrder(root.right, q);
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
