package by.issoft.store.Commands;

public class ExitApp implements StoreCommand {

    public void StopApp(){

        System.out.println("Hope to see you again!");
        System.exit(0);
    }

    @Override
    public void execute() {
        StopApp();
    }
}
