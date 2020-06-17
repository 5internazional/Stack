package find;

import stack.Stack;
import stack.Stackable;

public interface Finder<T> {
    Stackable<T> stack (String line, Stackable<T> stack);
}
