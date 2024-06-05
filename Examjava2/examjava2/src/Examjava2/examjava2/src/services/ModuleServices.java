package services;

import java.util.List;
import entities.Module;
import repository.ModuleRepository;

public class ModuleServices {
    ModuleRepository moduleRepository = new ModuleRepository();
   
    public List<Module> listerModules() {
        return moduleRepository.selectAll();
    }

    public void ajouterModule(Module module) {
        moduleRepository.insert(module);
    }
}
