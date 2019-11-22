package study.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author:hxd
 * @date:2019/11/8
 */
public class TrieTest {

    @Test
    public void trieTest() {
        Trie trie = new Trie();
        trie.insert("how".toCharArray());
        trie.insert("hi".toCharArray());
        trie.insert("her".toCharArray());
        trie.insert("hello".toCharArray());
        trie.insert("so".toCharArray());
        trie.insert("see".toCharArray());

        Assert.assertTrue(trie.find("hello".toCharArray()));
        Assert.assertFalse(trie.find("his".toCharArray()));
    }
}
