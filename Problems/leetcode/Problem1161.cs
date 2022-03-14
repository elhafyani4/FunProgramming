/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Problem1161 {
    public int MaxLevelSum(TreeNode root) {
        
        Queue<Tuple<int, TreeNode>> q = new Queue<Tuple<int, TreeNode>>();
        Dictionary<int, int> d = new();
        
        q.Enqueue(new Tuple<int, TreeNode>(1, root));
        while(q.Count > 0)
        {
            Tuple<int, TreeNode> current = q.Dequeue();
            
            if(d.ContainsKey(current.Item1))
            {
                d[current.Item1] += current.Item2.val;
            }
            else
            {
                d.Add(current.Item1, current.Item2.val);
            }
            
            if(current.Item2.left != null)
            {
                q.Enqueue(new Tuple<int, TreeNode>(current.Item1 + 1, current.Item2.left ));
            }
            
            if(current.Item2.right != null)
            {
                q.Enqueue(new Tuple<int, TreeNode>(current.Item1 + 1, current.Item2.right ));
            }
        }
        
        int max = int.MinValue;
        int maxIndex = 0;
        foreach(int key in d.Keys)
        {
            if(d[key] > max)
            {
                max = d[key];
                maxIndex = key;
            }
        }
        
        return maxIndex;
    }
}