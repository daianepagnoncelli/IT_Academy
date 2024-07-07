package cat.itacademy.barcelonactiva.pagnoncelli.daiane.s05.t01.n01.model.services;

import cat.itacademy.barcelonactiva.pagnoncelli.daiane.s05.t01.n01.model.domain.Branch;
import cat.itacademy.barcelonactiva.pagnoncelli.daiane.s05.t01.n01.model.dto.BranchDTO;
import cat.itacademy.barcelonactiva.pagnoncelli.daiane.s05.t01.n01.model.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BranchServiceImpl implements BranchService {

    @Autowired
    private BranchRepository branchRepository;

    @Override
    public void saveBranch(BranchDTO branchDto) {
        Branch branch = convertToEntity(branchDto);
        branchRepository.save(branch);
    }

    @Override
    public BranchDTO updateBranch(int id, BranchDTO branchDto) {
        Branch branch = branchRepository.findById(id).orElseThrow(() -> new RuntimeException("Branch not found"));
        branch.setNameBranch(branchDto.getNameBranch());
        branch.setCountryBranch(branchDto.getCountryBranch());
        branchRepository.save(branch);
        return convertToDTO(branch);
    }

    @Override
    public void deleteBranch(int id) {
        branchRepository.deleteById(id);
    }

    @Override
    public BranchDTO getOneBranch(int id) {
        Branch branch = branchRepository.findById(id).orElseThrow(() -> new RuntimeException("Branch not found"));
        return convertToDTO(branch);
    }

    @Override
    public List<BranchDTO> getAllBranches() {
        return branchRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private Branch convertToEntity(BranchDTO branchDto) {
        Branch branch = new Branch();
        branch.setPk_BranchID(branchDto.getPk_BranchID());
        branch.setNameBranch(branchDto.getNameBranch());
        branch.setCountryBranch(branchDto.getCountryBranch());
        return branch;
    }

    private BranchDTO convertToDTO(Branch branch) {
        BranchDTO branchDto = new BranchDTO();
        branchDto.setPk_BranchID(branch.getPk_BranchID());
        branchDto.setNameBranch(branch.getNameBranch());
        branchDto.setCountryBranch(branch.getCountryBranch());
        branchDto.setTypeBranch(getTypeBranch(branch.getCountryBranch()));
        return branchDto;
    }

    private String getTypeBranch(String country) {
        List<String> euCountries = Arrays.asList("Austria", "Belgium", "Bulgaria", "Croatia", "Republic of Cyprus", "Czech Republic", "Denmark", "Estonia", "Finland", "France", "Germany", "Greece", "Hungary", "Ireland", "Italy", "Latvia", "Lithuania", "Luxembourg", "Malta", "Netherlands", "Poland", "Portugal", "Romania", "Slovakia", "Slovenia", "Spain", "Sweden");
        return euCountries.contains(country) ? "EU" : "Non-EU";
    }
}


