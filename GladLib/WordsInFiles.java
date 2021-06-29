
/**
 * Write a description of WordsInFiles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.util.*;
import java.io.*;
public class WordsInFiles {
    private HashMap<String,ArrayList<String>> map ;
    
    public WordsInFiles(){
        map = new HashMap<String,ArrayList<String>>();
    }
    
    public void addWordsFromFile(File f){
       
        FileResource fr = new FileResource(f);
        
        ArrayList<String> list1;
        
        for(String word: fr.words()){
            word=word.toLowerCase();
            // or if(!(map.containsKey(s)))
            if(!map.keySet().contains(word)){
                // if word is not in the hashmap, create a new arraylist 
                list1 = new ArrayList<String>();
                map.put(word,list1);
                // put current filename in the arraylist
                map.get(word).add(f.getName());
            
            }else{
                // otherwise, put the filename into the arraylist-> map.get(word) 
                map.get(word).add(f.getName());
            }
        
        }
        
    }

    // write all the words into hashmap

    public void buildWordFileMap(){
        map.clear();
        DirectoryResource dr = new DirectoryResource();
        
        for(File f: dr.selectedFiles()){
            //FileResource fr = new FileResource();
            addWordsFromFile(f);

        }
        

    }
    
    // count max number of files appear in a word
    public int maxNumber(){
        int max =0;
        int current=0;
        
        for(String w:map.keySet()){
            current=map.get(w).size();
            if(current>max){
                max=current;
            
            }

        }
        
        return max;

    }
    
    // This method returns an ArrayList of words that appear in exactly number files.
    //eg,. cats and dogs appear in 3 files. call wordsInnumberFiles(3) will return
    // ["cat","and"]
    
    public ArrayList<String> wordsInNumFiles(int number){
        int nFilesIn=0;
        ArrayList<String> words = new ArrayList<String>();
        
        for(String w: map.keySet()){
            
            nFilesIn = map.get(w).size();
            if (nFilesIn == number){
                words.add(w);
            }
        }
        return words;
    }
    
    //call printFilesIn(“cats”) would print the three filenames: brief1.txt, brief3.txt, and brief4.txt, each on a separate line.
    public void printFilesIn(String word){
        for(String w:map.keySet()){
            if(w.equals(word)){
                //print the contenst of arraylist corresponds to word
                for(String arraylistfile: map.get(w)){
                    System.out.println(map.get(arraylistfile));
                
                }
                
            
            }

        }

    }
    
    public void tester(){
        buildWordFileMap ();
        int greatest=maxNumber();
        //System.out.println(greatest);
        ArrayList<String> fileNames = this.wordsInNumFiles(greatest);
        System.out.println("The greatest number of files a word appears in is " +  greatest + ", and there are " + fileNames.size() + " such words: " );
        for(String s: fileNames)
        {
            System.out.println('"' + s + '"' + " ");
        }
        
        for(String s: fileNames)
         {
             System.out.println('"' + s + '"' + " appears in the files: ");
             
             for(String word: map.get(s))
             {
                 System.out.println(word + " " );
             }
             
             System.out.println();
        }
    
    }

}