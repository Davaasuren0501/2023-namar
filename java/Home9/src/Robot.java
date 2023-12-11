class Robot {
    private boolean itsTurn = false;

    public synchronized void speak(String message) {
        while (itsTurn) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Robot " + Thread.currentThread().getId() + ": " + message);
        itsTurn = true;
        notify();
    }

    public synchronized void listen(String message) {
        while (!itsTurn) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Robot " + Thread.currentThread().getId() + ": " + message);
        itsTurn = false;
        notify();
    }
}