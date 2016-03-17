package org.xuan;

import util.ListNode;

import java.util.*;

/**
 * Created by xuan on 2016/3/13.
 */
public class WordLadderII {
    int steps = 0;
    Map<String, List<List<String>>> cache = new HashMap<>();
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> result  = new ArrayList<>();
        if (wordList.isEmpty() || beginWord.length() == 0) {
            return result;
        }
        Queue<String> queue1 = new ArrayDeque<>(),
                queue2 = new ArrayDeque<>();
        Map<String, List<String>> to = new HashMap<>();
        wordList.remove(beginWord);
        wordList.add(endWord);
        queue1.add(beginWord);

        while(! queue1.isEmpty() || ! queue2.isEmpty()) {
            processQueue(queue1, queue2, wordList,to);
            if (! wordList.contains(endWord)) {
                break;
            }
            steps++;
            processQueue(queue2, queue1, wordList,to);
            if (!wordList.contains(endWord)) {
                break;
            }
            steps++;
        }
        if (!wordList.contains(endWord)) {
            steps++;
        }
        else {
            steps = 0;
        }
        if (steps == 0) {
            return result;
        }

        getPath(beginWord, endWord, to, 0, new String[steps + 1], result);
        return result;
    }

    private void processQueue(Queue<String> queue1, Queue<String> queue2, Set<String> wordList, Map<String, List<String>> to) {

        List<String> toBeRemoved = new ArrayList<>();
        while(! queue1.isEmpty()) {
            String str = queue1.remove();
            List<String> toList = new ArrayList<>();
            to.put(str, toList);
            char[] arr = str.toCharArray();
            for(int i = 0; i < arr.length; i++) {
                char curr = arr[i];
                for(char c = 'a'; c <= 'z'; c++) {
                    if (c != curr) {
                        arr[i] = (char)c;
                        String next = new String(arr);
                        if (wordList.contains(next)) {
                            toList.add(next);
                            queue2.add(next);
                            toBeRemoved.add(next);
                        }
                    }
                }
                arr[i] = curr;
            }
        }
        wordList.removeAll(toBeRemoved);
    }

    private List<List<String>> getPath(String beginWord, String endWord, Map<String, List<String>> to) {
        if (cache.containsKey(beginWord)) {
            return cache.get(beginWord);
        }
        if (beginWord.equals(endWord)) {
            List<String> list = Arrays.asList(beginWord);
            List<List<String>> result =  new ArrayList<>(Arrays.asList(list));
            cache.put(beginWord, result);
            return result;
        }

        List<List<String>> result = new ArrayList<>();
        if (to.containsKey(beginWord)) {
            for(String next : to.get(beginWord)) {
                List<List<String>> nextResult = getPath(next, endWord, to);
                for(List<String> list : nextResult) {
                    List<String> curr = new ArrayList<>(list.size() + 1);
                    curr.add(beginWord);
                    for(String s : list) {
                        curr.add(s);
                    }
                    result.add(curr);
                }
            }
            cache.put(beginWord, result);
        }
        return result;
    }

    private void getPath(String beginWord, String endWord, Map<String, List<String>> to, int currentStep, String[] currList, List<List<String>> result) {
        if (currentStep == steps && beginWord.equals(endWord)) {
            currList[currentStep] = endWord;
            result.add(new ArrayList<String>(Arrays.asList(currList)));
        }
        if (to.containsKey(beginWord)) {
            currList[currentStep] = beginWord;
            for(String next : to.get(beginWord)) {
                getPath(next, endWord, to, currentStep+1, currList, result);
            }
        }
    }
}
