class Solution {
    List<String> lst;
    public int numTilePossibilities(String tiles) {
        boolean[] visited=new boolean[tiles.length()];
        lst=new ArrayList<String>();
        backtrack(tiles,0,"",visited);
        return lst.size()-1;
    }
    public void backtrack(String tiles,int start,String s,boolean[] visited) {
        if (s.length()>tiles.length()) return;
        if (!lst.contains(s)) {lst.add(s);}
        for (int i=0;i<tiles.length();i++) {
            if (visited[i]) continue;
            if(i - 1 >= 0 && tiles.charAt(i) == tiles.charAt(i - 1) && !visited[i - 1]) continue;
            s+=tiles.substring(i,i+1);
            visited[i]=true;
            backtrack(tiles,i+1,s,visited);
            visited[i]=false;
            s=s.substring(0,s.length()-1);
        }
    }
}

***************

class Solution {
    public int numTilePossibilities(String tiles) {
        boolean[] visited=new boolean[tiles.length()];
        char[] chars = tiles.toCharArray();
        Arrays.sort(chars);
        return backtrack(chars,0,visited)-1;
    }
    public int backtrack(char[] chars,int start,boolean[] visited) {
        if (start>chars.length) return 0;
        int count=1;
        for (int i=0;i<chars.length;i++) {
            if(visited[i] || i> 0 && chars[i] == chars[i - 1] && !visited[i - 1]) continue;
            visited[i]=true;
            count+=backtrack(chars,i+1,visited);
            visited[i]=false;
        }
        return count;
    }
}
