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
public class Problem1660 
{   
    public TreeNode CorrectBinaryTree(TreeNode root)
    {
        HashSet<int> seen = new HashSet<int>();
        Stack<Tuple<TreeNode, TreeNode, string>> q = new();
        q.Push(new Tuple<TreeNode, TreeNode, string>(root, null, "") );
        
        while(q.Any())
        {
            Tuple<TreeNode, TreeNode, string> nd = q.Pop();
            TreeNode tn = nd.Item1;
            TreeNode parent = nd.Item2;
            string pa = nd.Item3;
            if(tn.right != null && seen.Contains(tn.right.val))
            {
                if(pa == "l")
                {
                    parent.left = null;
                }
                else
                {
                    parent.right = null;
                }
                break;
            }
            
            seen.Add(tn.val);
            
            if(tn.left != null)
            {
                q.Push(new Tuple<TreeNode, TreeNode, string>(tn.left, tn, "l"));    
            }
            
            if(tn.right != null)
            {
                q.Push(new Tuple<TreeNode, TreeNode, string>(tn.right, tn, "r"));    
            }
        }
        
        return root;
    }
}