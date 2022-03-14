public class Problem1165 {
    public int CalculateTime(string keyboard, string word) {
        Dictionary<char, int> charIndex = new();
        char[] keyboardChars = keyboard.ToCharArray();
        char[] wordChars = word.ToCharArray();
        
        for(int i = 0; i < keyboardChars.Length; i++)
        {
            charIndex.Add(keyboardChars[i], i);
        }
        
        int k = 0;
        int sum = 0;
        for(int i = 0; i < wordChars.Length; i++)
        {
            int p = charIndex[wordChars[i]];
            
            sum += Math.Abs(p - k);
            k = p;
        }
        
        return sum;
    }
}