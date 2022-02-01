/* The isBadVersion API is defined in the parent class VersionControl.
      bool IsBadVersion(int version); */

public class VersionControl
{
    private readonly int _version;
    public VersionControl(int version)
    {
        _version = version;
    }
    bool IsBadVersion(int version)
    {
        return _version == version;
    }
}

public class Problem278 : VersionControl {

    public Problem278(int version)
    :base(version)
    {
    }
    public int FirstBadVersion(int n) {
        int l = 1;
        int r = n;
        int lastFalseSeen = -1;
        while (l <= r)
        {
            int mid = (int)((double)l/2 + (double)r/ 2);
            if (r == l || lastFalseSeen == l)
            {
                return r;
            }

            if (IsBadVersion(mid))
            {
                if (mid == 1)
                {
                    return mid;
                }

                r = mid;
            }
            else
            {
                lastFalseSeen = l;
                l = mid;
            }

        }

        return 0;
    }
}
    
    