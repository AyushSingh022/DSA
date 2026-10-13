class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
       HashMap<String,List<String>>mp=new HashMap<>();
       for(String s:strs){
        char[] fq=new char[26];
        for(char ch:s.toCharArray()){
            fq[ch-'a']++;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<26;i++){
            sb.append('#').append(fq[i]);
        }
        mp.computeIfAbsent(sb.toString(),k->new ArrayList<>()).add(s);
       }
           return new ArrayList<>(mp.values());

    }
}