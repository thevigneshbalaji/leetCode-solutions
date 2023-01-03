//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] H = new int[N];
            
            for(int i=0; i<N; i++)
                H[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            out.println(ob.removeStudents(H,N));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    private int lowerBound(int x, ArrayList<Integer> mem)
    {
        int l = 0, h = mem.size()-1;
        
        while(l<=h)
        {
            int m = (l+h)/2;
            
            if(mem.get(m)>=x)
            {
                h = m - 1;
            }
            else
            {
                l = m + 1;
            }
        }
        
        return l;
        
    }
    
    public int removeStudents(int[] H, int N) {
        ArrayList<Integer> mem = new ArrayList<>();
        int ans = 0;
        for(int x : H)
        {
            int pos = lowerBound(x, mem);
            if(pos == mem.size()) mem.add(x);
            else mem.set(pos, x);
            ans = Math.max(ans, mem.size());
            
        }
        
        return N-ans;
        
    }
};