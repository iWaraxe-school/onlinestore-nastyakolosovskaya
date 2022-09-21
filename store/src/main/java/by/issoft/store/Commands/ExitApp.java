package by.issoft.store.Commands;

public class ExitApp implements StoreCommand {
    @Override
    public void execute() {
        System.out.println("Hope to see you again!");
        System.exit(0);
    }
}
