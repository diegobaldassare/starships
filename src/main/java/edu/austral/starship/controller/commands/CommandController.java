package edu.austral.starship.controller.commands;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Invoker from the Command Pattern.
 * Asks the command to carry out the request.
 *
 * Created by Diego Baldassare on 2018-10-28.
 */
public class CommandController {

    private Map<Integer, Command> commands = new HashMap<>();

    public void invoke(Integer keyCode) {
        final Command command = commands.get(keyCode);
        if (command != null) command.execute();
        //else make sound or something
    }

    public void addCommand(Integer keyCode, Command command) {
        commands.put(keyCode, command);
    }
}
