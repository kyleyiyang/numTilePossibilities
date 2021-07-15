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
