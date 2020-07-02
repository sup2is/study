package me.sup2is;

public class RemoteController {

    private Command command;

    public RemoteController(Command command) {
        this.command = command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }


}
