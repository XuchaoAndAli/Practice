package leetcode;

import java.util.ArrayList;

public class Version {
	public int compareVersion(String version1, String version2) {
//		version1+=".1";
//        version2+=".1";
		ArrayList<String> s1=new ArrayList<String>();
		ArrayList<String> s2=new ArrayList<String>();
		int pre=0;
        for (int i=0;i<=version1.length();i++){
        	if (i==version1.length() || version1.charAt(i)=='.'){
        		s1.add(version1.substring(pre,i));
        		pre=i+1;
        	}
        }
        
        pre=0;
        for (int i=0;i<=version2.length();i++){
        	if (i==version2.length() || version2.charAt(i)=='.'){
        		s2.add(version2.substring(pre,i));
        		pre=i+1;
        	}
        }
        
        
        
        for (int i=0;i<s1.size();i++){
        	String s=s1.get(i);
        	int y=0;
        	while(y<s.length() && s.charAt(y)=='0')y++;
        	if (y==s.length())s1.set(i, "0");
        	else s1.set(i, s.substring(y));
        	
        }
        for (int i=0;i<s2.size();i++){
        	String s=s2.get(i);
        	int y=0;
        	while(y<s.length() && s.charAt(y)=='0')y++;
        	if (y==s.length())s2.set(i, "0");
        	else s2.set(i, s.substring(y));
        	
        }
        
        for (int i=0;i<Math.min(s1.size(),s2.size());i++){
        	if (s1.get(i).compareTo(s2.get(i))<0)return -1;
        	else if (s1.get(i).compareTo(s2.get(i))>0){
        		return 1;
        	}
        }
        if (s1.size()>s2.size())return 1;
        else if (s1.size()<s2.size()) return -1;
        return 0;
    }
	public static void main(String[] args) {
		Version p=new Version();
		p.compareVersion("1.1.1.1", "0");
	}
}
