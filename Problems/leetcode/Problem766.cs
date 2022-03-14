public class Problem766 
{
    public bool IsToeplitzMatrix(int[][] matrix) {
        
        int m = matrix.Length;
        int n = matrix[0].Length;
        
        int i = 0;
        for(int k = 0; k < n; k++)
        {
            for(int l = 0; l < n ; l++)
            {
                if( i+l < m && k+l < n && matrix[i][k] != matrix[i+l][k+l])
                {
                    return false;
                }
            }
        }
        
        int j = 0;
        for(int k = 1; k < m; k++)
        {
            for(int l = 0; l < n; l++)
            {
                if( k+l < m && j+l < n && matrix[k][j] != matrix[k+l][j+l])
                {
                    return false;
                }
            }
        }
        
        return true;
    }
}