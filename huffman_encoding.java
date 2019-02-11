import java.util.*;
class Huffnode implements Comparable<Huffnode>
{
    int data;
    char c;
    Huffnode left;
    Huffnode right;
    public int compareTo(Huffnode x)
    {
        return this.data-x.data;
    }
}
public class Main
{
    public static void print(Huffnode root,String s)
    {
        if(root.left==null && root.right==null)
        {
            System.out.println(root.c+" "+s);
            return;
        }
        print(root.left,s+"0");
        print(root.right,s+"1");
    }
    public static void main(String[] args)
    {
        char chararr[]={'a','b','c','d','e','f'};
        int data[]={5,9,12,13,16,45};
        int n=6;
        PriorityQueue<Huffnode>q=new PriorityQueue<Huffnode>();
        for(int i=0;i<n;i++)
        {
            Huffnode hn=new Huffnode();
            hn.data=data[i];
            hn.c=chararr[i];
            q.add(hn);
        }
        Huffnode root=null;
        while(q.size()>1)
        {
            Huffnode x=q.poll();
            Huffnode y=q.poll();
            Huffnode h=new Huffnode();
            h.data=x.data+y.data;
            h.c='%';
            h.left=x;
            h.right=y;
            root=h;
            q.add(h);
        }
        print(root,"");
    }
}
