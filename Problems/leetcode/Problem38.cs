public class Problem38 {
    public string CountAndSay(int n) {
        if (n == 1)
        {
            return "1";
        }

        int count = 1;
        string w = "1";

        while (count < n)
        {
            char[] chars = w.ToCharArray();

            int lc = 1;
            char previous = chars[0];
            StringBuilder st = new StringBuilder();
            for (int i = 1; i < chars.Length; i++)
            {
                if (previous == chars[i])
                {
                    lc++;
                    continue;
                }

                st.Append($"{lc}{previous}");
                lc = 1;
                previous = chars[i];
            }

            st.Append($"{lc}{previous}");
            count++;
            w = st.ToString();
        }

        return w;
    }
}