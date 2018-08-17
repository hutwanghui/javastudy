package com.kk.javabasic.Map;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hutwanghui on 2018/8/11.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class Trie_demo {
    public static void main(String[] args) {
        Tries tries = new Tries();
        String strs[] = {"abc", "abd", "b", "abdc"};

        for (int i = 0; i < strs.length; i++)
            insertNode(strs[i], tries);

        while (tries.isTrie) {
            getNode(tries.children);
        }
    }

    public static void getNode(Map<Character, Tries> map) {
        if (!map.isEmpty()) {
            System.out.println(map.toString());
        }
        return;
    }

    public static boolean insertNode(String str, Tries head) {
        if (str == null || str.length() == 0)
            return false;
        char chs[] = str.toCharArray();
        int i = 0;
        Tries cur = head;
        while (i < chs.length) {
            if (!cur.children.containsKey(chs[i])) {
                cur.children.put(chs[i], new Tries());
            }
            cur = cur.children.get(chs[i]);
            if (cur.isTrie == true) {
                return true;
            }
            i++;
        }
        cur.isTrie = true;
        if (cur.children.size() > 0) {
            System.out.println(" trie tree");
            return true;
        }
        return false;
    }
}

class Tries {
    boolean isTrie;
    HashMap<Character, Tries> children = new HashMap<Character, Tries>();
}
