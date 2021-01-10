package tn.spring.bookStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.spring.bookStore.entity.Command;

import tn.spring.bookStore.entity.Livre;
import tn.spring.bookStore.entity.User;


import tn.spring.bookStore.service.CommandService;
//It's a convenience annotation that combines @Controller and @ResponseBody – which eliminates the need to annotate every request handling method
//This annotation is applied to a class to mark it as a request handler.
//RestController takes care of mapping request data to the defined request handler method. Once response body is generated from the handler method, it converts it to JSON or XML response.
@RestController
@CrossOrigin("*")
public class CommandController {
	@Autowired
    private CommandService service;
	

    
    @PostMapping(value="addCommand")
    public Command addCommand(@RequestBody Command command) {
    	service.saveCommand(command);
    	
         return command;
    }
    @PostMapping(value="addCommands")
    public List<Command> addCommands(@RequestBody List<Command> commands) {
        return service.saveCommands(commands);
    }
    @GetMapping(value="Commands")
    public List<Command> findAllProducts() {
        return service.getCommands();
    }
    @GetMapping(value="commandById/{id}")
    public Command findCommandById(@PathVariable int id) {
        return service.getCommandById(id);
    }
    @DeleteMapping(value="commadDelete/{id}")
    public String deleteCommand(@PathVariable int id) {
        return service.deleteCommand(id);
    }
    @PutMapping("/update/{id}")
    public Command updateCommand(@PathVariable int id,@RequestBody Command newCommand ) {
        Command oldCommand = service.getCommandById(id);
        oldCommand.setCreatedAt(newCommand.getCreatedAt());
        oldCommand.setLivres(newCommand.getLivres());
        oldCommand.setUser(newCommand.getUser());
        
        
        service.saveCommand(oldCommand);
        return oldCommand;

}
}
