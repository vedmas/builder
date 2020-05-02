package observer;

import java.util.List;

public interface Observer {

    void subscribe(Subscriber ub);

    void unsubscribe(Subscriber ub);

    void notifySubscribers(List<Subscriber> ub);
}
