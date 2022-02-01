public class Problem2138 {
    public string[] DivideString(string s, int k, char fill) {
        int i = 0;
        List<string> result = new List<string>();
      
        int l = s.Length;
        while(l >= k)
        {
            result.Add(s.Substring(i, k));
            i = i+k;
            l = l-k;
        }
        
        if(l > 0)
        {
            result.Add(s.Substring(i) + string.Join("", Enumerable.Repeat(fill, k - l)));    
        }
        
        return result.ToArray();
    }
}