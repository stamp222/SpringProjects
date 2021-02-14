package petclinic.pl.phlodx.spring.nauka.services.map;

import org.springframework.stereotype.Service;
import petclinic.pl.phlodx.spring.nauka.model.Speciality;
import petclinic.pl.phlodx.spring.nauka.model.Vet;
import petclinic.pl.phlodx.spring.nauka.services.SpecialtiesService;
import petclinic.pl.phlodx.spring.nauka.services.VetService;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
    private final SpecialtiesService specialtiesService;

    public VetServiceMap(SpecialtiesService specialtiesService) {
        this.specialtiesService = specialtiesService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        if(object.getSpecialities().size() > 0) {
             object.getSpecialities().forEach(specialty -> {
                 if(specialty.getId() == null) {
                     Speciality savedSpeciality = specialtiesService.save(specialty);
                     specialty.setId(savedSpeciality.getId());
                 }
             });
        }
        return super.save(object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
