package decorator;

import java.util.Comparator;

public interface CountingComparator<T> extends Comparator<T> {
    int getCount();
}
