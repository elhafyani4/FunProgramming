class Solution {
    public boolean canPermutePalindrome(String str) {
        HashSet<Character> chars = new HashSet<>(str.length());

        for(int i = 0; i < str.length(); i++)
        {
            if(chars.contains(str.charAt(i)))
            {
                chars.remove(str.charAt(i));
            } else {
                chars.add(str.charAt(i));
            }
        }

        return chars.size() <= 1;
    }
}