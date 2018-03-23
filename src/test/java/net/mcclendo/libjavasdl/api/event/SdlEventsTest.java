package net.mcclendo.libjavasdl.api.event;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Assert;
import org.junit.Test;

import net.mcclendo.libjavasdl.api.Sdl;
import net.mcclendo.libjavasdl.api.event.events.SDL_Event;
import net.mcclendo.libjavasdl.api.event.events.SDL_QuitEvent;

import com.sun.jna.Function;
import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.Union;
import com.sun.jna.ptr.PointerByReference;

@SuppressWarnings("checkstyle:MultipleStringLiterals")
public final class SdlEventsTest {

    @Test
    public void peepEvents() {
        Sdl.SDL_Init(Sdl.SDL_INIT_EVENTS);

        final SDL_Event event = (SDL_Event) Union.newInstance(SDL_Event.class);
        final SDL_QuitEvent quitEvent = new SDL_QuitEvent();
        quitEvent.type = SDL_EventType.SDL_QUIT;
        quitEvent.timestamp = (int) TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        event.writeField("quit", quitEvent);

        final Pointer events = new Memory(2 * new SDL_Event().size());

        Assert.assertEquals(0, SdlEvents.SDL_PeepEvents(
                events,
                2,
                SDL_eventaction.SDL_PEEKEVENT,
                SDL_EventType.SDL_FIRSTEVENT,
                SDL_EventType.SDL_LASTEVENT));

        SdlEvents.SDL_PushEvent(event);
        SdlEvents.SDL_PushEvent(event);

        Assert.assertEquals(2, SdlEvents.SDL_PeepEvents(
                events,
                2,
                SDL_eventaction.SDL_PEEKEVENT,
                SDL_EventType.SDL_FIRSTEVENT,
                SDL_EventType.SDL_LASTEVENT));

        Assert.assertEquals(
                SDL_EventType.SDL_QUIT,
                Union.newInstance(
                        SDL_Event.class,
                        events.share(0)).readField("type"));
        Assert.assertEquals(
                SDL_EventType.SDL_QUIT,
                Union.newInstance(
                        SDL_Event.class,
                        events.share(new SDL_Event().size())).readField("type"));

        Sdl.SDL_Quit();
    }

    @Test
    public void hasEvent() {
        Sdl.SDL_Init(Sdl.SDL_INIT_EVENTS);

        final SDL_Event event = (SDL_Event) Union.newInstance(SDL_Event.class);
        final SDL_QuitEvent quitEvent = (SDL_QuitEvent) Structure.newInstance(SDL_QuitEvent.class);
        quitEvent.type = SDL_EventType.SDL_QUIT;
        quitEvent.timestamp = (int) TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        event.writeField("quit", quitEvent);
        event.setType("quit");

        Assert.assertEquals(false, SdlEvents.SDL_HasEvent(SDL_EventType.SDL_QUIT));
        Assert.assertEquals(1, SdlEvents.SDL_PushEvent(event));
        Assert.assertEquals(true, SdlEvents.SDL_HasEvent(SDL_EventType.SDL_QUIT));

        Sdl.SDL_Quit();
    }

    @Test
    public void hasEvents() {
        Sdl.SDL_Init(Sdl.SDL_INIT_EVENTS);

        final SDL_Event event = (SDL_Event) Union.newInstance(SDL_Event.class);

        final SDL_QuitEvent lowMemEvent = (SDL_QuitEvent) Structure.newInstance(SDL_QuitEvent.class);
        lowMemEvent.type = SDL_EventType.SDL_APP_LOWMEMORY;
        lowMemEvent.timestamp = (int) TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        event.writeField("quit", lowMemEvent);
        event.setType("quit");
        Assert.assertEquals(1, SdlEvents.SDL_PushEvent(event));

        Assert.assertEquals(false, SdlEvents.SDL_HasEvents(SDL_EventType.SDL_FIRSTEVENT, SDL_EventType.SDL_QUIT));

        final SDL_QuitEvent quitEvent = (SDL_QuitEvent) Structure.newInstance(SDL_QuitEvent.class);
        quitEvent.type = SDL_EventType.SDL_QUIT;
        quitEvent.timestamp = (int) TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        event.writeField("quit", quitEvent);
        event.setType("quit");
        Assert.assertEquals(1, SdlEvents.SDL_PushEvent(event));

        Assert.assertEquals(true, SdlEvents.SDL_HasEvents(SDL_EventType.SDL_FIRSTEVENT, SDL_EventType.SDL_QUIT));

        Sdl.SDL_Quit();
    }

    @Test
    public void flushEvent() {
        Sdl.SDL_Init(Sdl.SDL_INIT_EVENTS);

        final SDL_Event event = (SDL_Event) Union.newInstance(SDL_Event.class);
        final SDL_QuitEvent quitEvent = (SDL_QuitEvent) Structure.newInstance(SDL_QuitEvent.class);
        quitEvent.type = SDL_EventType.SDL_QUIT;
        quitEvent.timestamp = (int) TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        event.writeField("quit", quitEvent);
        event.setType("quit");
        Assert.assertEquals(1, SdlEvents.SDL_PushEvent(event));

        Assert.assertEquals(true, SdlEvents.SDL_HasEvent(SDL_EventType.SDL_QUIT));
        SdlEvents.SDL_FlushEvent(SDL_EventType.SDL_QUIT);
        Assert.assertEquals(false, SdlEvents.SDL_HasEvent(SDL_EventType.SDL_QUIT));

        Sdl.SDL_Quit();
    }

    @Test
    public void flushEvents() {
        Sdl.SDL_Init(Sdl.SDL_INIT_EVENTS);

        final SDL_Event event = (SDL_Event) Union.newInstance(SDL_Event.class);
        final SDL_QuitEvent quitEvent = (SDL_QuitEvent) Structure.newInstance(SDL_QuitEvent.class);
        quitEvent.type = SDL_EventType.SDL_QUIT;
        quitEvent.timestamp = (int) TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        event.writeField("quit", quitEvent);
        event.setType("quit");
        Assert.assertEquals(1, SdlEvents.SDL_PushEvent(event));

        Assert.assertEquals(true, SdlEvents.SDL_HasEvent(SDL_EventType.SDL_QUIT));
        SdlEvents.SDL_FlushEvents(SDL_EventType.SDL_FIRSTEVENT, SDL_EventType.SDL_LASTEVENT);
        Assert.assertEquals(false, SdlEvents.SDL_HasEvent(SDL_EventType.SDL_QUIT));

        Sdl.SDL_Quit();
    }

    @Test
    public void pollEvent() {
        Sdl.SDL_Init(Sdl.SDL_INIT_EVENTS);

        final SDL_Event event = (SDL_Event) Union.newInstance(SDL_Event.class);
        final SDL_QuitEvent quitEvent = (SDL_QuitEvent) Structure.newInstance(SDL_QuitEvent.class);
        quitEvent.type = SDL_EventType.SDL_QUIT;
        quitEvent.timestamp = (int) TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        event.writeField("quit", quitEvent);
        event.setType("quit");
        Assert.assertEquals(1, SdlEvents.SDL_PushEvent(event));

        Assert.assertEquals(1, SdlEvents.SDL_PollEvent(event));

        Sdl.SDL_Quit();
    }

    @Test
    public void waitEvent() {
        Sdl.SDL_Init(Sdl.SDL_INIT_EVENTS);

        final SDL_Event event = (SDL_Event) Union.newInstance(SDL_Event.class);
        final SDL_QuitEvent quitEvent = (SDL_QuitEvent) Structure.newInstance(SDL_QuitEvent.class);
        quitEvent.type = SDL_EventType.SDL_QUIT;
        quitEvent.timestamp = (int) TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        event.writeField("quit", quitEvent);
        event.setType("quit");
        Assert.assertEquals(1, SdlEvents.SDL_PushEvent(event));

        Assert.assertEquals(1, SdlEvents.SDL_WaitEvent(event));

        Sdl.SDL_Quit();
    }

    @Test
    public void waitEventTimeout() {
        Sdl.SDL_Init(Sdl.SDL_INIT_EVENTS);

        final SDL_Event event = (SDL_Event) Union.newInstance(SDL_Event.class);
        final SDL_QuitEvent quitEvent = (SDL_QuitEvent) Structure.newInstance(SDL_QuitEvent.class);
        quitEvent.type = SDL_EventType.SDL_QUIT;
        quitEvent.timestamp = (int) TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        event.writeField("quit", quitEvent);
        event.setType("quit");

        Assert.assertEquals(0, SdlEvents.SDL_WaitEventTimeout(event, 1));
        Assert.assertEquals(1, SdlEvents.SDL_PushEvent(event));
        Assert.assertEquals(1, SdlEvents.SDL_WaitEventTimeout(event, 1));

        Sdl.SDL_Quit();
    }

    @Test
    public void pushEvent() {
        Sdl.SDL_Init(Sdl.SDL_INIT_EVENTS);

        final SDL_Event event = (SDL_Event) Union.newInstance(SDL_Event.class);
        final SDL_QuitEvent quitEvent = (SDL_QuitEvent) Structure.newInstance(SDL_QuitEvent.class);
        quitEvent.type = SDL_EventType.SDL_QUIT;
        quitEvent.timestamp = (int) TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        event.writeField("quit", quitEvent);
        event.setType("quit");

        Assert.assertEquals(false, SdlEvents.SDL_HasEvent(SDL_EventType.SDL_QUIT));
        Assert.assertEquals(1, SdlEvents.SDL_PushEvent(event));
        Assert.assertEquals(true, SdlEvents.SDL_HasEvent(SDL_EventType.SDL_QUIT));

        Sdl.SDL_Quit();
    }

    @Test
    public void setEventFilter() {
        Sdl.SDL_Init(Sdl.SDL_INIT_EVENTS);

        final SDL_Event event = (SDL_Event) Union.newInstance(SDL_Event.class);
        final SDL_QuitEvent quitEvent = (SDL_QuitEvent) Structure.newInstance(SDL_QuitEvent.class);
        quitEvent.type = SDL_EventType.SDL_QUIT;
        quitEvent.timestamp = (int) TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        event.writeField("quit", quitEvent);
        event.setType("quit");

        final AtomicInteger count = new AtomicInteger();

        SdlEvents.SDL_SetEventFilter(
                (u, e) -> count.incrementAndGet(),
                event.getPointer());

        Assert.assertEquals(0, count.get());
        Assert.assertEquals(1, SdlEvents.SDL_PushEvent(event));
        Assert.assertEquals(1, count.get());

        Sdl.SDL_Quit();
    }

    @Test
    public void getEventFilter() {
        Sdl.SDL_Init(Sdl.SDL_INIT_EVENTS);

        final AtomicInteger count = new AtomicInteger();
        SdlEvents.SDL_SetEventFilter(
                (u, e) -> count.incrementAndGet(),
                Pointer.NULL);

        final PointerByReference f = new PointerByReference();
        SdlEvents.SDL_GetEventFilter(
                f,
                new PointerByReference());

        Assert.assertEquals(0, count.get());
        Function.getFunction(f.getValue()).invoke(Integer.class, new Object[]{Pointer.NULL, Pointer.NULL});
        Assert.assertEquals(1, count.get());

        Sdl.SDL_Quit();
    }

    @Test
    public void addEventWatch() {
        Sdl.SDL_Init(Sdl.SDL_INIT_EVENTS);

        final SDL_Event event = (SDL_Event) Union.newInstance(SDL_Event.class);
        final SDL_QuitEvent quitEvent = (SDL_QuitEvent) Structure.newInstance(SDL_QuitEvent.class);
        quitEvent.type = SDL_EventType.SDL_QUIT;
        quitEvent.timestamp = (int) TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        event.writeField("quit", quitEvent);
        event.setType("quit");

        final AtomicInteger count = new AtomicInteger();

        SdlEvents.SDL_AddEventWatch(
                (u, e) -> count.incrementAndGet(),
                event.getPointer());

        Assert.assertEquals(0, count.get());
        Assert.assertEquals(1, SdlEvents.SDL_PushEvent(event));
        Assert.assertEquals(1, count.get());

        Sdl.SDL_Quit();
    }

    @Test
    public void delEventWatch() {
        Sdl.SDL_Init(Sdl.SDL_INIT_EVENTS);

        final SDL_Event event = (SDL_Event) Union.newInstance(SDL_Event.class);
        final SDL_QuitEvent quitEvent = (SDL_QuitEvent) Structure.newInstance(SDL_QuitEvent.class);
        quitEvent.type = SDL_EventType.SDL_QUIT;
        quitEvent.timestamp = (int) TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        event.writeField("quit", quitEvent);
        event.setType("quit");

        final AtomicInteger count = new AtomicInteger();

        final SDL_EventFilter filter = (u, e) -> count.incrementAndGet();

        SdlEvents.SDL_AddEventWatch(
                filter,
                event.getPointer());

        Assert.assertEquals(0, count.get());
        Assert.assertEquals(1, SdlEvents.SDL_PushEvent(event));
        Assert.assertEquals(1, count.get());

        SdlEvents.SDL_DelEventWatch(
                filter,
                event.getPointer());

        Assert.assertEquals(1, SdlEvents.SDL_PushEvent(event));
        Assert.assertEquals(1, count.get());

        Sdl.SDL_Quit();
    }

    @Test
    public void filterEvents() {
        Sdl.SDL_Init(Sdl.SDL_INIT_EVENTS);

        final SDL_Event event = (SDL_Event) Union.newInstance(SDL_Event.class);
        final SDL_QuitEvent quitEvent = new SDL_QuitEvent();
        quitEvent.type = SDL_EventType.SDL_QUIT;
        quitEvent.timestamp = (int) TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        event.writeField("quit", quitEvent);

        SdlEvents.SDL_PushEvent(event);

        SdlEvents.SDL_FilterEvents(
                (u, e) -> {
                    Assert.assertTrue(event.getPointer().equals(u));

                    return 1;
                },
                event.getPointer());

        Assert.assertEquals(1, SdlEvents.SDL_PollEvent(event));

        Sdl.SDL_Quit();
    }

    @Test
    public void eventState() {
        Sdl.SDL_Init(Sdl.SDL_INIT_EVENTS);

        Assert.assertEquals(SdlEvents.SDL_ENABLE, SdlEvents.SDL_GetEventState(
                SDL_EventType.SDL_QUIT));

        SdlEvents.SDL_EventState(
                SDL_EventType.SDL_QUIT,
                SdlEvents.SDL_DISABLE);

        Assert.assertEquals(SdlEvents.SDL_DISABLE, SdlEvents.SDL_GetEventState(
                SDL_EventType.SDL_QUIT));

        Sdl.SDL_Quit();
    }

    @Test
    public void registerEvents() {
        Sdl.SDL_Init(Sdl.SDL_INIT_EVENTS);

        Assert.assertTrue(SdlEvents.SDL_RegisterEvents(1) >= 0);

        Sdl.SDL_Quit();
    }
}
