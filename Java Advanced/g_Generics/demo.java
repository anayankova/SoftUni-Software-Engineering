package g_Generics;

import java.util.ArrayDeque;
import java.util.Deque;

public class demo<T> {

    private Deque<T> content;

    public demo() {
        this.content = new ArrayDeque<>();
    }

    public void add(T entity) {
        this.content.push(entity);
    }

    public T remove() {
        return this.content.pop(); 
    }


}
