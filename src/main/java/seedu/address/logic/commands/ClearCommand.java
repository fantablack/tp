package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.ui.StatusBarFooter.isArchiveBook;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.AddressBook;
import seedu.address.model.Model;

/**
 * Clears the address book.
 */
public class ClearCommand extends RedoableCommand {

    public static final String COMMAND_WORD = "clear";
    public static final String MESSAGE_SUCCESS = "Address book has been cleared!";


    @Override
    public CommandResult executeUndoableCommand(Model model) throws CommandException {

        requireNonNull(model);
        if (isArchiveBook()) {
            model.setArchiveBook(new AddressBook());
        } else {
            model.setAddressBook(new AddressBook());
        }

        return new CommandResult(MESSAGE_SUCCESS);
    }
}
