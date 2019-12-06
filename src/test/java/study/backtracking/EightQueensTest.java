package study.backtracking;

import org.junit.Test;

/**
 * @author:hxd
 * @date:2019/11/16
 */
public class EightQueensTest {

    @Test
    public void eigntQueens() {
        EightQueens eightQueens = new EightQueens(8);
        eightQueens.cal8Queens(0);
    }
}
