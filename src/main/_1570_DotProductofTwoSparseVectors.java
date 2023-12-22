package src.main;

import java.util.HashMap;
import java.util.Map;
// https://leetcode.com/problems/dot-product-of-two-sparse-vectors/editorial/
public class _1570_DotProductofTwoSparseVectors {
    class SparseVector {
        Map<Integer, Integer> mapping;

        SparseVector(int[] nums) {
            mapping = new HashMap<>();
            for (int i = 0; i < nums.length; i++){
                if (nums[i] != 0) {
                    mapping.put(i, nums[i]);
                }
            }
        }

        public int dotProduct(SparseVector vec) {        
            int result = 0;
            if (vec == null || vec.mapping.size() == 0)
                return 0;
            
            for (Integer i : mapping.keySet()){
                if (vec.mapping.containsKey(i)) {
                    result += mapping.get(i) * vec.mapping.get(i);
                }
            }
            return result;
        }
    }


    public static void main(String[] args) {
        _1570_DotProductofTwoSparseVectors v1 = new _1570_DotProductofTwoSparseVectors();
        _1570_DotProductofTwoSparseVectors.SparseVector s1 = v1.new SparseVector(new int[] {1,0,0,2,3});
        _1570_DotProductofTwoSparseVectors v2 = new _1570_DotProductofTwoSparseVectors();
        _1570_DotProductofTwoSparseVectors.SparseVector s2 = v2.new SparseVector(new int[] {0,3,0,4,0});

        System.err.println(s1.dotProduct(s2));
    }
}
