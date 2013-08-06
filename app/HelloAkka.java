package sample;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class HelloAkka {
    public static ActorSystem system = ActorSystem.create("HelloAkka");
    public static ActorRef hello = system.actorOf(new Props(Hello.class), "hello");

    public static class Hello extends UntypedActor {
        LoggingAdapter log = Logging.getLogger(getContext().system(), this);

        public void onReceive(Object message) throws Exception {
            if (message instanceof String)
                log.info("Hello {}!", message);
            else
                unhandled(message);
        }
    }
}
