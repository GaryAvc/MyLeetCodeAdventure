import java.util.*;

class Solution {

    String targetWord;
    List<String> list;
    Queue<String> words;
    int answer;


/*
    Invariance:
    1. it is a problem about the shortest path, thus use bfs
    2. also store the word been used into a set, check every time if the new word is prev in the set
        it can avoid extra calculations and endless loop.
    3. use a queue to store the word need to be examined
 */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        targetWord = endWord;
        list = wordList;
        words = new ArrayDeque<>();
        answer=0;

        words.add(beginWord);

        bfs();

        return answer;
    }

    private void bfs(){

        // poll out all the possible words at the same level
        int size = words.size();


        if(size ==0){
            answer =0;
            return;
        }

        answer++;

        for ( int i=0;i<size;++i){
            String word = words.poll();
            if( word.equals( targetWord)){
                return;
            }
            checkWordValid(word);
        }

        bfs();

    }

    /*
        1. add all possible solution into queue
        2. remove the word from the list if added
    */

    private void checkWordValid(String word) {

        char [] wordList = word.toCharArray();
        List<String> needToRemove = new LinkedList<>();
        for( String everyWord : list){
            int sameChar=0;
            char[] listWordList = everyWord.toCharArray();

            // check how many same character do this 2 words have
            for( int j=0;j<wordList.length;j++){
                if(wordList[j]==listWordList[j]){
                    sameChar++;
                }

                // add the word into queue only if the same char is 2
                if( j== wordList.length-1 &&  everyWord.length()-sameChar ==1){
                    words.add( everyWord);
                    needToRemove.add(everyWord);
                }
            }
        }

        for( String toRemove : needToRemove){
            list.remove(toRemove);
        }

    }
}