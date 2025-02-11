public class ServerWOFacade {
    // Facade class inside ServerWOFacade
    static class ScheduleServerFacade {
        private ScheduleServer scheduleServer;

        public ScheduleServerFacade(ScheduleServer scheduleServer) {
            this.scheduleServer = scheduleServer;
        }

        // Method to start the server
        public void startServer() {
            scheduleServer.startBooting();
            scheduleServer.readSystemConfigFile();
            scheduleServer.init();
            scheduleServer.initializeContext();
            scheduleServer.initializeListeners();
            scheduleServer.createSystemObjects();
        }

        // Method to stop the server
        public void stopServer() {
            scheduleServer.releaseProcesses();
            scheduleServer.destory();
            scheduleServer.destroySystemObjects();
            scheduleServer.destoryListeners();
            scheduleServer.destoryContext();
            scheduleServer.shutdown();
        }
    }

    // Main program
    public static void main(String[] args) {
        ScheduleServer scheduleServer = new ScheduleServer();
        ScheduleServerFacade serverFacade = new ScheduleServerFacade(scheduleServer);

        // Start the server using the facade
        serverFacade.startServer();
        System.out.println("Start working......");

        // Perform work here

        System.out.println("After work done.........");
        // Stop the server using the facade
        serverFacade.stopServer();
    }
}
