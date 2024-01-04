import java.util.*;
public class miniwindow{
    public static String solution(String s,String t)
    {
        int mct=0;
        String ans="";
        int dmct=t.length();
        HashMap<Character,Integer> hash2=new HashMap<>();
        for(int i=0;i<t.length();i++)
        {
            char ch=t.charAt(i);
            hash2.put(ch,hash2.getOrDefault(ch,0)+1);
        }
        HashMap<Character,Integer> hash1=new HashMap<>();
        int i=-1;
        int j=-1;
        while(true)
        {
            boolean f1=false;
            boolean f2=false;
            while(i<s.length()-1 && mct<dmct)
            {
                i++;
                char ch=s.charAt(i);
                hash1.put(ch,hash1.getOrDefault(ch,0)+1);
                if(hash1.getOrDefault(ch,0)<=hash2.getOrDefault(ch,0))
                {
                    mct++;
                }
                f1=true;
            }
            while(j<i && mct==dmct)
            {
                String pans=s.substring(j+1,i+1);
                if(ans.length()==0 || pans.length()<ans.length())
                {
                    ans=pans;
                }
                j++;
                char ch =s.charAt(j);
                if(hash1.get(ch)==1)
                {
                    hash1.remove(ch);
                }
                else
                {
                    hash1.put(ch,hash1.get(ch)-1);
                }
                if(hash1.getOrDefault(ch,0)<hash2.getOrDefault(ch,0))
                {
                    mct--;
                }
                f2=true;
            }
            if(f1==false && f2==false)
            {
                break;
            }
        }
        return ans;

    }
    public static void main(String args[])
    {
        String s="ADOBECODEBANC";
        String t="ABC";
        System.out.println(solution(s,t));

    }
}