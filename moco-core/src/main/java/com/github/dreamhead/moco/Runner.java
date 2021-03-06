package com.github.dreamhead.moco;

import com.github.dreamhead.moco.internal.*;

public abstract class Runner {
    public static void running(final HttpServer httpServer, final Runnable runnable) throws Exception {
        doRunning(runner(httpServer), runnable);
    }

    public static void running(final HttpsServer httpServer, final Runnable runnable) throws Exception {
        doRunning(runner(httpServer), runnable);
    }

    private static void doRunning(final Runner server, final Runnable runnable) throws Exception {
        try {
            server.start();
            runnable.run();
        } finally {
            server.stop();
        }
    }

    public static Runner runner(final HttpServer server) {
        return new MocoHttpServer((ActualHttpServer) server);
    }

    public abstract void start();
    public abstract void stop();
}
