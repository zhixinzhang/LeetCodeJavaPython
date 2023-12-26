package src.main;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

// O(N) time, O(N) space
public class _1249_MinimumRemovetoMakeValidParentheses_Stack {
    public String minRemoveToMakeValid(String s) { 
        Set<Integer> indexesToRemove = new HashSet<>();
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '(') {
                deque.push(i);
            } else if (s.charAt(i) == ')'){
                if (deque.isEmpty()) {
                    indexesToRemove.add(i);
                } else {
                    deque.pop();
                }
            }
        }

        while (!deque.isEmpty()) {
            indexesToRemove.add(deque.pop());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            if (!indexesToRemove.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
    
}
