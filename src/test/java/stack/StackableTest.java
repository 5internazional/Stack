package stack;

import data.Student;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackableTest {

    public Stack<Student> stackObject(){
        Stack<Student> ob = new Stack<>();
        Student s1 = new Student("Vern", "Col", 1, 111);
        Student s2 = new Student("Kgn", "Kdgdr", 3, 34523);
        Student s3 = new Student("skgh", "hsvk", 3, 13452);
        ob.push(s1);
        ob.push(s2);
        ob.push(s3);
        return ob;
    }
    private Stack<Student> nS;
    @Before
    public void theStack(){
        nS = stackObject();
    }
    @Test
    public void test(){ //peek
        Student s4 = new Student("last", "last", 1, 123);
        nS.push(s4);
        Assert.assertEquals(s4, nS.peek());
    }
    @Test
    public void test2() { //popandsize
        Student s4 = new Student("last", "last", 1, 123);
        nS.push(s4);
        nS.pop();
        Assert.assertEquals(3, nS.size());
    }

    @Test
    public void test3(){ //empty
        assertFalse(nS.empty() == true);
        nS.clear();
        assertTrue(nS.empty()==true);
    }
}