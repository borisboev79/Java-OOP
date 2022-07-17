package word;

public abstract class Initialization {
    public static CommandInterface buildCommandInterface(StringBuilder text) {
        CommandInterface impl = new CommandImpl(text);
        impl.init();
        return impl;
    }
}
