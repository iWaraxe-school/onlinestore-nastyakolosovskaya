package by.issoft.store.Commands;

import javax.xml.parsers.ParserConfigurationException;
import java.sql.SQLException;

public interface StoreCommand {
    void execute() throws ParserConfigurationException, SQLException;
}