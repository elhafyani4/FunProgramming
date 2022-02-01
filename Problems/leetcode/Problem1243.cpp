#include <vector>

using namespace std;

class Problem1243 {
public:
    vector<int> transformArray(vector<int>& arr) {
        if (arr.size() <= 2)
        {
            return arr;
        }

        bool changed = true;
        int prev;

        while (changed)
        {
            prev = arr[0];
            changed = false;

            for (int i = 1; i < arr.size() - 1; i++)
            {
                int temp = arr[i];
                int current = arr[i];
                int after = arr[i + 1];
                if (current < prev && current < after)
                {
                    arr[i] = arr[i] + 1;
                    changed = true;    
                }
                else if (current > prev && current > after)
                {
                    arr[i] = arr[i] - 1;
                    changed = true;
                    prev = temp;
                }

                prev = temp;
            }
        }
        return arr;
    }
};