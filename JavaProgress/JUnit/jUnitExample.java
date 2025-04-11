package JavaProgress.JUnit;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.junit.Ignore;

import static org.junit.Assert.fail;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class jUnitExample {
    int a;
    int b;
    int c;

    @Before
    public void beforeTest() {
        a = 10;
        b = 11;
        c = 12;
    }

    @Test
    public void test() {

        assertThat(a, equalTo(10));
        assertThat(b, equalTo(10));
        assertThat(c, equalTo(10));
    }

    @Ignore
    public void ignoredTest() {
        assertThat(a, equalTo(50));
    }

    @After
    public void afterTest() {
        a = 0;
    }
}
//input number ->
// start x = 0, y = 1; xresult = x + y, print xresult; x = y, y = xresult; xresult = x + y,
