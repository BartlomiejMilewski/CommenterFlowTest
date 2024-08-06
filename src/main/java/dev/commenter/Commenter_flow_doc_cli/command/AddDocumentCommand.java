package dev.commenter.Commenter_flow_doc_cli.command;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ShellComponent
public class AddDocumentCommand {

    @ShellMethod(key = "add", value = "Add selected document")
    public void recent() {

    }

    @ShellMethod(key = "show-all", value = "Show all documents currently in storage")
    public void recent() {

    }

    @ShellMethod(key = "filter-by-date", value = "Show documents added via selected date")
    public void recent(@ShellOption(defaultValue = ShellOption.NULL) String date) {
        if (date == null) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            date = dtf.format(now);
        }
    }

}
