public class TestTV {
    @FunctionalInterface
    interface MethodRef{
        void call();
    }

    @FunctionalInterface
    interface MethodOneArg{
        void withOneArg(int t);
    }
    @FunctionalInterface
    interface MyInterface {
        TV zuragt();
    }

    public static void main(String[] args) {
        MyInterface tv=TV::new;

        MethodRef turnOn= tv.zuragt()::turnOn;
        turnOn.call();

        MethodOneArg oneArg1=tv.zuragt()::setChannel;
        oneArg1.withOneArg(30);
    }
}