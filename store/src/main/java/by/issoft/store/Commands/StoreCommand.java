package by.issoft.store.Commands;

import javax.xml.parsers.ParserConfigurationException;

public interface StoreCommand {
    void execute() throws ParserConfigurationException;
}