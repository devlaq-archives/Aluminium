package aluminium.util;

import aluminium.func.*;

public interface Eachable<T>{
    void each(Cons<? super T> cons);
}