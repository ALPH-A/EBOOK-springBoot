package tn.spring.bookStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.spring.bookStore.entity.Command;
import tn.spring.bookStore.repository.CommandRepository;
//Service annotation : to indicate that it's holding the business logic.
@Service
public class CommandService {
	// Autowired annotation : we can used it for now like a constructor to get all methods form CommandRepository
	@Autowired
    private CommandRepository repository;

    public Command saveCommand(Command command) {
        return repository.save(command);
    }
    public List<Command> saveCommands(List<Command> command) {
        return repository.saveAll(command);
    }
    public List<Command> getCommands() {
        return repository.findAll();
    }
    public Command getCommandById(int id) {
        return repository.findById((long) id).orElse(null);
    }
    public String deleteCommand(int id) {
        repository.deleteById((long) id);
        return "command removed !! " + id;
    }


}
