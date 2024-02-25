class Trie {
    
    static class Node{
        Node[] children=new Node[26];
        boolean endOfWord=false;
    }
    public static Node root;

    public Trie() {
    for(int i=0;i<26;i++){
        root=new Node();
       root.children[i]=null;
    }
    }
    
    public void insert(String word) {
        Node curr=root;
        //inserting the word
        for(int level=0;level<word.length();level++){
            //finding the index 
            int idx=word.charAt(level)-'a';
            //if the word is not present in children array
            //at specified index
            if(curr.children[idx]==null){
            curr.children[idx]=new Node();
            }
            //moving to the children
            curr=curr.children[idx];
        }

        //setting the endOfWord to true, after inserting 
        //the whole word
        curr.endOfWord=true;
    }
    
    public boolean search(String word) {
        Node curr=root;
        for(int level=0;level<word.length();level++){
            int idx=word.charAt(level)-'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr=curr.children[idx];
        }
        return curr.endOfWord==true;
    }
    
    public boolean startsWith(String prefix) {
         Node curr=root;

        for(int level=0;level<prefix.length();level++){
            int idx=prefix.charAt(level)-'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr=curr.children[idx];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */