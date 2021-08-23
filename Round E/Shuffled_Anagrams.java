import java.util.*;
class Solution{
    static void anagm(String str, int start, int end,List<String> arr) 
    { 
        if (start == end) 
            arr.add(str); 
        else { 
            for (int i = start; i <= end; i++) { 
                str = swap(str, start, i); 
                anagm(str, start + 1, end, arr); 
                str = swap(str, start, i); 
            } 
        }
    }
    static String swap(String a, int i, int j) 
    { 
        char temp; 
        char[] charArray = a.toCharArray(); 
        temp = charArray[i]; 
        charArray[i] = charArray[j]; 
        charArray[j] = temp; 
        return String.valueOf(charArray); 
    } 
    static String isUnique(List<String> arr,String s){
        int n=arr.size();
        int x=s.length()-1;
        for(int i=x-1;i>=1;i--)
            x=x*i;
        for(int i=x;i<n;i++){
            String str=arr.get(i);
            int n1=str.length(),flag=0;
            for(int j=0;j<n1;j++){
                if(str.charAt(j)==s.charAt(j)){
                    flag=1;
                    break;
                }
            }
            if(flag==0)
                return arr.get(i);
        }
        return "IMPOSSIBLE";
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int x=1;
        for(int i=1;i<=t;i++){
            String str=sc.next();
            List<String> arr=new ArrayList<>();
            anagm(str,0,str.length()-1,arr);
            String sol=isUnique(arr,str);
            System.out.println("Case #"+i+": "+sol);

        }
    }
}
