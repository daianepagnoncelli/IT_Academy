package cat.itacademy.barcelonactiva.pagnoncelli.daiane.s05.t01.n02.model.services;

import cat.itacademy.barcelonactiva.pagnoncelli.daiane.s05.t01.n02.model.domain.FlorEntity;
import cat.itacademy.barcelonactiva.pagnoncelli.daiane.s05.t01.n02.model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.pagnoncelli.daiane.s05.t01.n02.model.repository.FlorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlorService {

    @Autowired
    private FlorRepository florRepository;

    public FlorDTO saveFlor(FlorDTO florDTO) {
        FlorEntity florEntity = new FlorEntity();
        florEntity.setNameFlower(florDTO.getNameFlower());
        florEntity.setPaisFlor(florDTO.getPaisFlor());

        florEntity = florRepository.save(florEntity);

        return new FlorDTO(florEntity.getPk_FlorID(), florEntity.getNameFlower(), florEntity.getPaisFlor());
    }

    public FlorDTO updateFlor(FlorDTO florDTO) {
        FlorEntity florEntity = florRepository.findById(florDTO.getPk_FlorID())
                .orElseThrow(() -> new RuntimeException("Flower not found"));
        florEntity.setNameFlower(florDTO.getNameFlower());
        florEntity.setPaisFlor(florDTO.getPaisFlor());

        florEntity = florRepository.save(florEntity);

        return new FlorDTO(florEntity.getPk_FlorID(), florEntity.getNameFlower(), florEntity.getPaisFlor());
    }

    public void deleteFlor(Integer id) {
        florRepository.deleteById(id);
    }

    public FlorDTO getFlor(Integer id) {
        FlorEntity florEntity = florRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Flower not found"));
        return new FlorDTO(florEntity.getPk_FlorID(), florEntity.getNameFlower(), florEntity.getPaisFlor());
    }

    public List<FlorDTO> getAllFlor() {
        return florRepository.findAll().stream()
                .map(florEntity -> new FlorDTO(florEntity.getPk_FlorID(), florEntity.getNameFlower(), florEntity.getPaisFlor()))
                .collect(Collectors.toList());
    }
}

